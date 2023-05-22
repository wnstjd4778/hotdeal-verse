package com.example.hotdealverse.review.adapter.dto.res;

import com.example.hotdealverse.item.adapter.dto.res.GetItemResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GetReviewResDto {

    private Long id;

    private String content;

    private GetItemResDto item;

    private String name;

}
