package com.zhassurbek.belearning.service.impl;

import com.zhassurbek.belearning.dto.request.SignInRequestDto;
import com.zhassurbek.belearning.dto.request.SignUpRequestDto;
import com.zhassurbek.belearning.dto.response.JwtAuthenticationResponseDto;
import com.zhassurbek.belearning.model.security.Role;
import com.zhassurbek.belearning.model.security.User;
import com.zhassurbek.belearning.repository.UserRepository;
import com.zhassurbek.belearning.service.UserService;
import com.zhassurbek.belearning.service.security.AuthenticationService;
import com.zhassurbek.belearning.service.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponseDto signin(SignInRequestDto signInRequestDto) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInRequestDto.getUsername(), signInRequestDto.getPassword()));
        var user = userRepository.findByEmail(signInRequestDto.getUsername());
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponseDto.builder().token(jwt).build();
    }

    @Override
    public JwtAuthenticationResponseDto signup(SignUpRequestDto signUpRequestDto) {
        var user = User.builder().firstName(signUpRequestDto.getFirstName()).lastName(signUpRequestDto.getLastName())
                .email(signUpRequestDto.getUsername()).password(passwordEncoder.encode(signUpRequestDto.getPassword()))
                .role(Role.USER).build();
        userRepository.save(user);
        var jwt = jwtService.generateToken(user);
        return JwtAuthenticationResponseDto.builder().token(jwt).build();
    }
}
