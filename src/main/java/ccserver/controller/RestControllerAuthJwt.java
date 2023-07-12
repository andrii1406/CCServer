package ccserver.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import ccserver.controller.config.ControllerUser;
import ccserver.dto.jwt.UserDTO;
import ccserver.pojo_jwt.JwtResponse;
import ccserver.pojo_jwt.LoginRequest;
import ccserver.pojo_jwt.MessageResponse;
import ccserver.pojo_jwt.SignupRequest;
import ccserver.util.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RestControllerAuthJwt {

    private final AuthenticationManager authenticationManager;

    private final PasswordEncoder passwordEncoder;

    private final ControllerUser userController;

    private final JwtUtils jwtUtils;


    @Autowired
    public RestControllerAuthJwt(AuthenticationManager authenticationManager,
                                 PasswordEncoder passwordEncoder,
                                 ControllerUser userController,
                                 JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userController = userController;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/signin")
    public ResponseEntity<?> authUser(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtUtils.generateJwtToken(authentication);

        UserDTO userDetails = (UserDTO) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(
                token,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignupRequest signupRequest) throws InstantiationException, IllegalAccessException {

        if (userController.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Введённое имя пользователя существует"));
        }

        if (userController.existsByEmail(signupRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Введённая почта существует"));
        }

        Set<String> reqRoles = signupRequest.getRoles();
        List<GrantedAuthority> authorities = new ArrayList<>();
        String baseRole = "_";

        if (reqRoles == null || reqRoles.isEmpty()) {
            authorities.add(new SimpleGrantedAuthority(baseRole));
        } else {
            authorities = reqRoles.stream()
                    .map(a -> {
                        if (a == null || a.equals("")) a = baseRole;
                        return new SimpleGrantedAuthority(a);
                    })
                    .collect(Collectors.toList());
        }

        userController.create(new UserDTO(
                null,
                signupRequest.getUsername(),
                signupRequest.getEmail(),
                passwordEncoder.encode(signupRequest.getPassword()),
                authorities
        ));

        return ResponseEntity.ok(new MessageResponse("Пользователь успешно создан"));
    }

}
