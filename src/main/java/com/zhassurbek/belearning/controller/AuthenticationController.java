package com.zhassurbek.belearning.controller;

import com.zhassurbek.belearning.dao.request.SignInRequestDto;
import com.zhassurbek.belearning.dao.request.SignUpRequestDto;
import com.zhassurbek.belearning.dao.response.JwtAuthenticationResponseDto;
import com.zhassurbek.belearning.service.security.AuthenticationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponseDto> signup(@Valid @RequestBody SignUpRequestDto signUpRequestDto) {
        return ResponseEntity.ok(authenticationService.signup(signUpRequestDto));
    }

    @PostMapping("/signin")
    public ResponseEntity<JwtAuthenticationResponseDto> signin(@Valid @RequestBody SignInRequestDto signInRequestDto) {
        return ResponseEntity.ok(authenticationService.signin(signInRequestDto));
    }

}
