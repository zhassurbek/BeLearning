package com.zhassurbek.belearning.controller;

import com.zhassurbek.belearning.model.Posts;
import com.zhassurbek.belearning.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articles")
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;

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

}
