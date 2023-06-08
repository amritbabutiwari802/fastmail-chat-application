package com.ics.fastmial.modules.Auth;

import com.ics.fastmial.entity.Auth;
import com.ics.fastmial.entity.User;
import com.ics.fastmial.modules.Auth.Dto.LoginRequest;
import com.ics.fastmial.modules.Auth.Dto.LoginResponse;
import com.ics.fastmial.modules.Auth.Dto.SignupRequest;
import com.ics.fastmial.modules.Auth.security.JwtUtils;
import com.ics.fastmial.repositories.AuthRepository;
import com.ics.fastmial.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class AuthService {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtUtils jwtUtils;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthRepository authRepository;

    @Autowired
    UserRepository userRepository;



    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        System.out.println(loginRequest.toString());
        Authentication authentication = authenticationManager.
                authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
      if(! authentication.isAuthenticated()){
          throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"bad credentials");
      }
        String jwtToken = jwtUtils.generateJwtToken(authentication);

        return ResponseEntity.ok(new LoginResponse(jwtToken));
    }

    public ResponseEntity<?> signup(SignupRequest signupRequest) {
        if (authRepository.existsByUsername(signupRequest.getUsername())) {
            return ResponseEntity
                    .badRequest()
                    .body("Error: Username is already taken!");
        }
        User user = new User(signupRequest.getName(), signupRequest.getUsername());
        Auth auth = new Auth(signupRequest.getUsername(),passwordEncoder.encode(signupRequest.getPassword()));
        userRepository.save(user);
        authRepository.save(auth);
        String jwtToken = jwtUtils.generateJwtToken(signupRequest.getUsername());

        return ResponseEntity.ok(new LoginResponse(jwtToken));
    }

    public ResponseEntity<LoginResponse> refresh(String username) {
        return ResponseEntity.ok(new LoginResponse(jwtUtils.generateJwtToken(username)));
    }
}
