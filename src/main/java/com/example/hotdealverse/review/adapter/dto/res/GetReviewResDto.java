package com.example.hotdealverse.review.adapter.dto.res;

import com.example.hotdealverse.item.adapter.dto.res.GetItemResDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class GetReviewResDto {

    private Long id;

    private String content;

    private GetItemResDto item;

    private String name;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
