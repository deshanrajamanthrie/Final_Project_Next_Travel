package lk.ijse.gdse.apigateway.filter;


import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.apigateway.constant.SecurityConstant;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class JwtGenerateFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException, IOException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication !=null) {

            SecretKey secretKey = Keys.hmacShaKeyFor(SecurityConstant.SECRET_KEY.getBytes(StandardCharsets.UTF_8));


            String newToken = Jwts.builder()
                    .setIssuer("Deshan")
                    .setSubject("Next-Travel")
                    .claim("username", authentication.getName())
                    .claim("authorities", populateGrantedAuthorities(authentication.getAuthorities()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date(new Date().getTime() + 604800000))
                    .signWith(secretKey).compact();
            response.setHeader(HttpHeaders.AUTHORIZATION, newToken);
        }
        filterChain.doFilter(request,response);

    }
    private String populateGrantedAuthorities(Collection<? extends GrantedAuthority> collection){
        Set<String> authorities = new HashSet<>();
        for (GrantedAuthority grantedAuthority : collection) {
            authorities.add(grantedAuthority.getAuthority());
        }
        return String.join(",",authorities);
    }

}
