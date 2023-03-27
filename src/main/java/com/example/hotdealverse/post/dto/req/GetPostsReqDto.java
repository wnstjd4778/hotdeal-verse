package com.example.hotdealverse.post.dto.req;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetPostsReqDto {

    private int page = 0;

    private int size = 10;

    private String keyword = "";
}
