package com.zhassurbek.belearning.controller;

import com.zhassurbek.belearning.model.Posts;
import com.zhassurbek.belearning.service.PostsService;
import com.zhassurbek.belearning.service.security.JwtService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;
    private final JwtService jwtService;

    @GetMapping("/all")
    public ResponseEntity getAllPostsByCreatedAtDesc() {
        List<Posts> resListPosts = new ArrayList<>();
        try {
            resListPosts = postsService.getAllPostsByCreatedAtDesc();
            return new ResponseEntity(resListPosts, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity(resListPosts, HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/create-post")
    public ResponseEntity<Posts> createPost(@RequestBody Posts posts) {
        try {
            return ResponseEntity.ok(postsService.createPost(posts));
        } catch (Exception e) {
            e.printStackTrace();
            return (ResponseEntity<Posts>) ResponseEntity.badRequest();
        }
    }

    @PostMapping("/post-increment-view")
    public ResponseEntity incrementView(@RequestParam Long postId) {
        try {
            return new ResponseEntity(postsService.incrementViews(postId), HttpStatus.OK);
        } catch (EntityNotFoundException e) {
            e.printStackTrace();
            return new ResponseEntity(0, HttpStatus.NOT_FOUND);
        }
    }

}
