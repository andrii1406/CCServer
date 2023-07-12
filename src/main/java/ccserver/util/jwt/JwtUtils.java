package ccserver.util.jwt;

import ccserver.dto.jwt.UserDTO;
import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    private String jwtSecret;

    private final int jwtExpirationMs;


    public JwtUtils() {
        generateSecretKey();
        jwtExpirationMs = 6 * 3600 * 1000;
    }

    public void generateSecretKey() {
        jwtSecret = RandomStringUtils.randomAlphanumeric(512);
    }

    public String generateJwtToken(Authentication authentication) {

        UserDTO userPrincipal = (UserDTO) authentication.getPrincipal();
        Date now = new Date();

        return Jwts
                .builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + jwtExpirationMs))
                .signWith(
                        Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret)),
                        SignatureAlgorithm.HS512)
                .compact();
    }

    public boolean validateJwtToken(String token) {
        try {
            parseJwsClaims(token);

            return true;
        } catch (MalformedJwtException | IllegalArgumentException e) {
            System.err.println(e.getMessage());
        }

        return false;
    }

    public String getUserNameFromJwtToken(String token) {
        return parseJwsClaims(token).getBody().getSubject();
    }

    private Jws<Claims> parseJwsClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret)))
                .build().parseClaimsJws(token);
    }

}
