package com.zhassurbek.belearning.controller;

import com.zhassurbek.belearning.BeLearningApplication;
import com.zhassurbek.belearning.dao.request.SignInRequestDto;
import com.zhassurbek.belearning.dao.request.SignUpRequestDto;
import com.zhassurbek.belearning.dao.response.JwtAuthenticationResponseDto;
import com.zhassurbek.belearning.service.security.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
@CrossOrigin
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final Logger logger = LoggerFactory.getLogger(BeLearningApplication.class);

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponseDto> signup(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
        return ResponseEntity.ok(authenticationService.signup(signUpRequestDto));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponseDto> signin(@Valid @RequestBody SignInRequestDto signInRequestDto) {
        logger.info("Received request with username: " + signInRequestDto.getUsername() + " and password: " + signInRequestDto.getPassword());
        return ResponseEntity.ok(authenticationService.signin(signInRequestDto));
    }

}
