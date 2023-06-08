package com.ics.fastmial.modules.Auth;

import com.ics.fastmial.modules.Auth.Dto.LoginRequest;
import com.ics.fastmial.modules.Auth.Dto.LoginResponse;
import com.ics.fastmial.modules.Auth.Dto.SignupRequest;
import com.ics.fastmial.modules.Auth.security.AuthTokenFilter;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthTokenFilter.class);
    @Autowired
    AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody SignupRequest signupRequest){
        return this.authService.signup(signupRequest);

    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@Validated @RequestBody LoginRequest loginRequest){
//        return ResponseEntity.ok("ok");
        return this.authService.login(loginRequest);
    }

    @GetMapping("/api")
    public int getmethod(){

        return 4;
    }

    @GetMapping("api/auth/hello")
    public int getResponse(){

        return 4;
    }
    @GetMapping("/refresh")
    public ResponseEntity<LoginResponse> refresh(HttpServletRequest req) {
        return authService.refresh( req.getRemoteUser());
    }


}
