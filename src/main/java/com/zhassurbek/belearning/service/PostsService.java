package com.zhassurbek.belearning.service;

import com.zhassurbek.belearning.BeLearningApplication;
import com.zhassurbek.belearning.model.Posts;
import com.zhassurbek.belearning.repository.PostsRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;
    private final Logger logger = LoggerFactory.getLogger(BeLearningApplication.class);

    public Long incrementViews(Long postId) {
//        Optional<Posts> post = postsRepository.findById(postId);
//        Long currentViews = post.get().getViews();
//        try {
//            currentViews = currentViews + 1L;
//            post.get().setViews(currentViews);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return post.get().getViews();
        logger.info("вызвано метод incrementView");
        Optional<Posts> currentPost = postsRepository.findById(postId);
        if (currentPost.isPresent()) {
            Posts post = currentPost.get();
            Long views = post.getViews();

            if (views == null) {
                views = 1L;
            } else {
                views += 1L;
            }

            post.setViews(views); // Увеличиваем значение views
            postsRepository.save(post); // Сохраняем обновленный пост в базу данных

            logger.info("post id: " + postId, ", view: " + views);
            return views;
        } else {
            // Обработка случая, если пост с заданным postId не найден
            throw new EntityNotFoundException("Post with id: " + postId + " not found!");
        }


//        Long views = currentPost.get().getViews();
//        logger.info("post id: " + postId, ", view: " + views);
//        if (views == null) {
//            views = 1L;
//            postsRepository.save(currentPost.get().setViews(views));
//            return views;
//        } else {
//            views = currentPost.get().getViews() + 1L;
//            return views;
//        }
    }

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
