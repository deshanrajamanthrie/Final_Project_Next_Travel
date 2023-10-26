package lk.ijse.gdse.apigateway.filter;


/*
public class JwtGenerateFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
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
*/
