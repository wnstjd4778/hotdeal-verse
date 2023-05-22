package com.example.hotdealverse.review.adapter.dto.req;

import lombok.Getter;

@Getter
public class CreateReviewReqDto {

    private String content;

    private Long itemId;

    private float rate;
}
