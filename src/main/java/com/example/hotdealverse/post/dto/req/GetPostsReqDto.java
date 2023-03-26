package com.example.hotdealverse.post.dto.req;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GetPostsReqDto {

    private int page;

    private int size;

    private String keyword = "";
}
