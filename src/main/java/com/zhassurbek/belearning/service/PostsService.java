package com.zhassurbek.belearning.service;

import com.zhassurbek.belearning.model.Posts;
import com.zhassurbek.belearning.repository.PostsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public List<Posts> getAllPostsByCreatedAtDesc() {
        return postsRepository.findAllByIsActiveTrueOrderByCreatedAtDesc();
    }

    public Posts createPost(Posts posts) {
        return postsRepository.save(posts);
    }

    public void deletePost(Long postId) {
        postsRepository.deleteById(postId);
    }



}
