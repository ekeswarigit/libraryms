package com.library.LMS.Controller;
import java.time.LocalDateTime;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.LMS.Dto.AuthRequest;
import com.library.LMS.Dto.AuthResponse;
import com.library.LMS.Dto.UserRequest;
import com.library.LMS.Entity.User;
import com.library.LMS.Service.AuthService;
import com.library.LMS.config.JwtUtil;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final AuthService authService;

    @GetMapping("/test")
public String test() {
    return "Working";
}
 @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserRequest request) {

        User savedUser = authService.register(request);

        String token = jwtUtil.generateToken(savedUser.getUsername());

        AuthResponse response = new AuthResponse(
                savedUser.getId(),
                savedUser.getUsername(),
                savedUser.getEmail(),
                token
        );
      
         return ResponseEntity.ok(response);
    }

    //LOGIN
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()));

        User user = authService.findByUsername(request.getUsername());

       String token = jwtUtil.generateToken(user.getUsername());

       AuthResponse authResponse = new AuthResponse(
               user.getId(),
               user.getUsername(),
               user.getEmail(),
               token  );
        
              return ResponseEntity.ok(authResponse);
      }

}