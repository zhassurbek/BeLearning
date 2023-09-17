package com.zhassurbek.belearning.controller;

import com.zhassurbek.belearning.model.Posts;
import com.zhassurbek.belearning.model.security.User;
import com.zhassurbek.belearning.service.PostsService;
import com.zhassurbek.belearning.service.security.JwtService;
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

//    @PostMapping("/create-post")
//    public ResponseEntity<Posts> createPost(@RequestBody Posts posts, @RequestHeader("Authorization") String authorizationHeader) {
//        // извлекаем токен из заголовки Authorization
//        String token = authorizationHeader.replace("Bearer", "");
//
//        // Расшифровываем и проверяем токен, чтобы получить информацию о текущем пользователе
//        User user = jwtService.
//
//    }

}
