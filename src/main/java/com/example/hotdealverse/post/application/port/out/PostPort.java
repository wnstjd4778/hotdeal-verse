package com.example.hotdealverse.post.application.port.out;

import com.example.hotdealverse.post.domain.Post;
import com.example.hotdealverse.post.dto.req.GetPostsReqDto;

import java.util.List;

public interface PostPort {

    public List<Post> getPosts(GetPostsReqDto getPostsReqDto);
}
