package com.example.hotdealverse.post.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {

    private Long id;

    private String title;

    private Long price;

    private String href;

    private long viewCnt;
}
