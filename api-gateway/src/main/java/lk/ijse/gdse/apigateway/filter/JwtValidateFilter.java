package lk.ijse.gdse.apigateway.filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lk.ijse.gdse.apigateway.constant.SecurityConstant;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.crypto.SecretKey;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JwtValidateFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println(header);

        if(header !=null && !header.startsWith("Basic")) {
            header = header.startsWith("Bearer ") ? header.substring(7) : header;
            SecretKey secretKey = null;
            if (request.getServletPath().startsWith("/api/v1/consume/user") ) {
                System.out.println("fffffffffffffffffffffffffffffffffffffffffffffffff");
                secretKey = Keys.hmacShaKeyFor(SecurityConstant.JWT_SECRET_KEY_USER.getBytes(StandardCharsets.UTF_8));
            } else {
                secretKey = Keys.hmacShaKeyFor(SecurityConstant.JWT_SECRET_KEY_ADMIN.getBytes(StandardCharsets.UTF_8));
            }
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(header)
                    .getBody();
            Authentication usernameAuthToken = new UsernamePasswordAuthenticationToken(claims.get("username").toString(), null, AuthorityUtils.commaSeparatedStringToAuthorityList(claims.get("authorities").toString()));
            SecurityContextHolder.getContext().setAuthentication(usernameAuthToken);
        }
        filterChain.doFilter(request,response);

    }
}
