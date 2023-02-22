package com.example.hotdealverse.post.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;


@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {

    private long id;

    private String title;

    private String url;

    private long price;

    private long viewCnt;

    private long product;

}
