package com.example.hotdealverse.product.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

import java.util.Date;


@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Post {

    private String title;

    private Date time;

    private String href;

    private long viewCnt;
}
