package com.example.hotdealverse.review.adapter.dto.req;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetReviewsReqDto {

    private int page = 0;

    private int size = 10;

    private Long itemId;
}
