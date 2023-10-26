package lk.ijse.gdse.apigateway.filter;

/*
public class JwtValidateFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String header = request.getHeader(HttpHeaders.AUTHORIZATION);
        if(header !=null && !header.startsWith("Basic")){
            header=header.startsWith("Bearer ") ? header.substring(7):header;
            SecretKey secretKey = Keys.hmacShaKeyFor(SecurityConstant.SECRET_KEY.getBytes(StandardCharsets.UTF_8));
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(secretKey)
                    .build()
                    .parseClaimsJws(header)
                    .getBody();
            Authentication authentication = new UsernamePasswordAuthenticationToken(claims.get("username").toString(), null, AuthorityUtils.commaSeparatedStringToAuthorityList(claims.get("authorities").toString()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);
    }
}
*/
