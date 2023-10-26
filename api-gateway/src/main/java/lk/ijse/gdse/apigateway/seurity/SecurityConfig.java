package lk.ijse.gdse.apigateway.seurity;



/*
@Configuration
@EnableWebSecurity
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
                .authorizeHttpRequests(request -> {
                    request
                            .requestMatchers("/api/v1/**").permitAll();

                    //   .requestMatchers("/api/v1/user/register").permitAll();

                });
       httpSecurity.httpBasic(Customizer.withDefaults()).formLogin(Customizer.withDefaults());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
*/
