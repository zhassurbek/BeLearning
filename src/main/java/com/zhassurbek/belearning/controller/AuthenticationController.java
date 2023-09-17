package com.zhassurbek.belearning.controller;

import com.zhassurbek.belearning.dto.request.SignUpRequestDto;
import com.zhassurbek.belearning.dto.response.JwtAuthenticationResponseDto;
import com.zhassurbek.belearning.service.UserService;
import com.zhassurbek.belearning.service.security.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/signup")
    public ResponseEntity<JwtAuthenticationResponseDto> signup(@RequestBody SignUpRequestDto signUpRequestDto) {
        try {
            return ResponseEntity.ok(authenticationService.signup(signUpRequestDto));
        } catch (Exception e) {
            e.printStackTrace();
            return (ResponseEntity<JwtAuthenticationResponseDto>) ResponseEntity.badRequest();
        }
    }

}
