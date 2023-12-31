package com.zhassurbek.belearning.model;

import com.zhassurbek.belearning.model.common.abstractentities.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@RequiredArgsConstructor
@Entity
@Table(name = "posts", schema = "content")
public class Posts extends BaseEntity {

    private String title;
    private String subtitle;

    private Long views;
//    private Boolean isActive;
    // время чтения
    private Long readingTime;
    // уровень сложности статьи
    private String postLevel;


    // todo
//    @ManyToOne
//    @JoinColumn(name = "author_id", referencedColumnName = "id")
//    private User author;
    private Long authorId;


    private List<String> themes;

}
