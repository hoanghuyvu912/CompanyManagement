package com.example.demo.authenticate;

import com.example.demo.security.jwt.JwtRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/auth")
public interface AuthController {
    @PostMapping("/signin")
    ResponseEntity<?> authenticateUser(@Validated @RequestBody JwtRequest loginRequest);
}
