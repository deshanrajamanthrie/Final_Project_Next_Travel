package lk.ijse.gdse.apigateway.seurity;


import jakarta.servlet.http.HttpServletRequest;
import lk.ijse.gdse.apigateway.filter.JwtGenerateFilter;
import lk.ijse.gdse.apigateway.filter.JwtValidateFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.Arrays;
import java.util.Collections;

@Configuration

public class SecurityConfig {
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.cors(httpCors -> {
                    httpCors.configurationSource(new CorsConfigurationSource() {
                        @Override
                        public CorsConfiguration getCorsConfiguration(HttpServletRequest request) {
                            CorsConfiguration corsConfiguration = new CorsConfiguration();
                            corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:63342"));
                            corsConfiguration.setAllowedHeaders(Collections.singletonList("*"));
                            corsConfiguration.setAllowedMethods(Collections.singletonList("*"));
                            corsConfiguration.setAllowCredentials(true);
                            corsConfiguration.setExposedHeaders(Arrays.asList(HttpHeaders.AUTHORIZATION));
                            corsConfiguration.setMaxAge(3600L);
                            return corsConfiguration;

                        }
                    });
                }).sessionManagement(session -> {
                    session.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
                }).csrf(AbstractHttpConfigurer::disable)
                .addFilterBefore(new JwtValidateFilter(), BasicAuthenticationFilter.class)
                .addFilterAfter(new JwtGenerateFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests(request -> {
                    request   /*user/register*/
                            .requestMatchers("/api/v1/consume/**").permitAll();
                        /*    .requestMatchers("/api/v1/consume/admin/**")
                            .hasRole("MANAGER").requestMatchers("/api/v1/consume/**").authenticated();*/

                });
       httpSecurity.httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
