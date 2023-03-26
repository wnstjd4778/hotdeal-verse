package com.example.hotdealverse.post.application.port.in;

import com.example.hotdealverse.post.dto.req.GetPostsReqDto;
import com.example.hotdealverse.post.dto.res.GetPostResDto;

import java.util.List;

public interface PostUseCase {

    public List<GetPostResDto> getPosts(GetPostsReqDto getPostsReqDto);

}
