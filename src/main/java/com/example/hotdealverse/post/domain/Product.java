package com.example.hotdealverse.post.domain;

import com.example.hotdealverse.post.adapter.out.persistence.CategoryJpaEntity;
import com.example.hotdealverse.post.adapter.out.persistence.PostJpaEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Product {

    private long id;

    private String name;

    private PostJpaEntity post;

    private CategoryJpaEntity category;

}