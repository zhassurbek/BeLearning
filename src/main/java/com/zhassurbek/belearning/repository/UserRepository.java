package com.zhassurbek.belearning.repository;

import com.zhassurbek.belearning.model.security.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

    // Since email is unique, we'll find users by email
    Optional<User> findByEmail(String email);

    void deleteByUsername(String username);


}
