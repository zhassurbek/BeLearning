package com.zhassurbek.belearning.service.security;

import com.zhassurbek.belearning.dto.request.SignInRequestDto;
import com.zhassurbek.belearning.dto.request.SignUpRequestDto;
import com.zhassurbek.belearning.dto.response.JwtAuthenticationResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

    JwtAuthenticationResponseDto signin(SignInRequestDto signInRequestDto);

    JwtAuthenticationResponseDto signup(SignUpRequestDto signUpRequestDto);

}
