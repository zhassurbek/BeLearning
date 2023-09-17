package com.zhassurbek.belearning.service.impl;

import com.zhassurbek.belearning.BeLearningApplication;
import com.zhassurbek.belearning.repository.UserRepository;
import com.zhassurbek.belearning.model.security.User;
import com.zhassurbek.belearning.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Logger logger = LoggerFactory.getLogger(BeLearningApplication.class);

    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) {
                User user = userRepository.findByUsername(username);
                return user;
            }
        };
    }

    @Override
    public User findByUsername(String username) {
        User user = userRepository.findByUsername(username);
        return user;
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        logger.info("Вызвано метод по созданию юзера(username): " + user.getUsername());
        userRepository.save(user);
        logger.info("Id: " + user.getId() + ", name: " + user.getFirstName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deleteByUsername(String username) {
        userRepository.deleteByUsername(username);
    }

    @Override
    public User updateUserByUsername(User user, String username) {
//        String currentUsername = username;
        User beforeUpdateUser = userRepository.findByUsername(username);
        if (user.getFirstName() != null) {
            beforeUpdateUser.setFirstName(user.getFirstName());
        } else if (user.getLastName() != null) {
            beforeUpdateUser.setLastName(user.getLastName());
        } else if (user.getEmail() != null) {
            beforeUpdateUser.setEmail(user.getEmail());
        } else if (user.getPassword() != null) {
            beforeUpdateUser.setPassword(user.getPassword());
        }


        userRepository.save(beforeUpdateUser);
        return beforeUpdateUser;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
