package com.example.youtube.demo.controller;

import com.example.youtube.demo.dto.RegisterRequest;
import com.example.youtube.demo.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("v1/youtube/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterRequest registerRequest){
        authService.register(registerRequest);
        return new ResponseEntity<>("Registration successfull", HttpStatus.OK);
    }

    @GetMapping("/accountVerification/{token}")
    public ResponseEntity<String> verify(@PathVariable String token){
        authService.verify(token);
        return new ResponseEntity<>("Account activated!",HttpStatus.OK);
    }
}
