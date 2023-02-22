package com.example.hotdealverse.post.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Category {

    private long id;

    private CategoryType type;

    private Long productId;
}