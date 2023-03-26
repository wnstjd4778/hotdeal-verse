package com.example.hotdealverse.post.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class GetPostResDto {

    private Long id;

    private String title;

    private Long price;

    private String href;

    private long viewCnt;
}
