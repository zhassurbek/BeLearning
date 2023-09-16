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

    private Long views;
    private Boolean isActive;
    // время чтения
    private Long readingTime;
    // уровень сложности статьи
    private String postLevel;


    // todo
    private String author;
    private List<String> themes;


}
