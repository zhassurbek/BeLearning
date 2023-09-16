package com.zhassurbek.belearning.repository;

import com.zhassurbek.belearning.model.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostsRepository extends JpaRepository<Posts, Long> {

    List<Posts> findAllByIsActiveTrueOrderByCreatedAtDesc();

}
