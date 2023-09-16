package com.zhassurbek.belearning.service.impl;

import com.zhassurbek.belearning.model.security.User;
import com.zhassurbek.belearning.repository.UserRepository;
import com.zhassurbek.belearning.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return null;
    }

    @Override
    public User findByUser(String username) {
        return userRepository.findByEmail(username);
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        return ResponseEntity.ok(userRepository.save(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public void deleteByUsername(String username) {
        userRepository.deleteByEmail(username);
    }

    @Override
    public User updateUserByUsername(User user, String username) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
