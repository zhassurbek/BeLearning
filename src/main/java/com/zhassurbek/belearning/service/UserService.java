package com.zhassurbek.belearning.service;

import com.zhassurbek.belearning.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    UserDetailsService userDetailsService();

    User findByUsername(String username);

    ResponseEntity<User> createUser(User user);

    void deleteUser(Long id);

    void deleteByUsername(String username);
    User updateUserByUsername(User user, String username);
    List<User> getAllUsers();

}
