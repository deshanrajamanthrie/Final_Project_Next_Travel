package lk.ijse.gdse.apigateway.seurity;


import jakarta.servlet.http.HttpServletRequest;
import lk.ijse.gdse.apigateway.constant.SecurityConstant;
import lk.ijse.gdse.apigateway.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class AuthenticationConfig implements AuthenticationProvider {
        @Autowired
        PasswordEncoder passwordEncoder;
        @Autowired
        RestTemplate restTemplate;
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

            String userName = authentication.getName();
            String pwd = authentication.getCredentials().toString();

            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpHeaders httpHeaders = new HttpHeaders();
            HttpServletRequest request = requestAttributes.getRequest();
            httpHeaders.set(HttpHeaders.AUTHORIZATION, request.getHeader(HttpHeaders.AUTHORIZATION));
            String userEmail = null;
            String hashPwd = "";
            String role = "";
            if (request.getServletPath().startsWith("/api/v1/gateway/customer")|| (request.getServletPath().startsWith("/api/v1/gateway/booking"))) {

                UserDTO customerDTO =
                hashPwd = customerDTO.getPwd();
                userEmail = customerDTO.getEmail();
                role = "USER";
            } else {
                UserDTO userDTO = restTemplate.getForObject("http://deshanz-vivobook:8084/api/v1/user/search?id="+userEmail,UserDTO.class);

                hashPwd = userDTO.getPwd();
                userEmail = userDTO.getEmail();
                role = userDTO.getRole().name();
            }
            if (userEmail != null) {
                if (passwordEncoder.matches(pwd, hashPwd)) {
                    return new UsernamePasswordAuthenticationToken(userName, pwd, getGrantedAuthority(role));
                } else {
                    throw new BadCredentialsException("Invalid Password");
                }
            } else {
                throw new BadCredentialsException("Invalid User Name");
            }
        }

        private Collection<GrantedAuthority> getGrantedAuthority(String role) {
            List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
            grantedAuthorityList.add(new SimpleGrantedAuthority("ROLE_" + role));
            return grantedAuthorityList;
        }
    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
