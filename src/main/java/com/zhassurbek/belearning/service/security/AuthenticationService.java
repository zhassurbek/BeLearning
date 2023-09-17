package com.zhassurbek.belearning.service.security;

import com.zhassurbek.belearning.dao.request.SignInRequestDto;
import com.zhassurbek.belearning.dao.request.SignUpRequestDto;
import com.zhassurbek.belearning.dao.response.JwtAuthenticationResponseDto;

public interface AuthenticationService {

    JwtAuthenticationResponseDto signin(SignInRequestDto signInRequestDto);

    JwtAuthenticationResponseDto signup(SignUpRequestDto signUpRequestDto);

}
