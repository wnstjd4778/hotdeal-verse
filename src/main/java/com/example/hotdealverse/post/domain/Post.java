package com.example.hotdealverse.post.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;


@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {

    private Long id;
    
    private String title;

    private Date time;

    private String href;

    private long viewCnt;
}
