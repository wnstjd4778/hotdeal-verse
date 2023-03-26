package com.example.hotdealverse.post.application.service;

import com.example.hotdealverse.post.application.port.in.PostUseCase;
import com.example.hotdealverse.post.application.port.out.PostPort;
import com.example.hotdealverse.post.domain.Post;
import com.example.hotdealverse.post.dto.req.GetPostsReqDto;
import com.example.hotdealverse.post.dto.res.GetPostResDto;
import com.example.hotdealverse.post.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService implements PostUseCase {

    private final PostPort postPort;

    @Override
    public List<GetPostResDto> getPosts(GetPostsReqDto getPostsReqDto) {
        List<Post> postList = this.postPort.getPosts(getPostsReqDto);

        return postList.stream().map((post) -> PostMapper.convertPostToGetPostResDto(post)).toList();
    }
}
