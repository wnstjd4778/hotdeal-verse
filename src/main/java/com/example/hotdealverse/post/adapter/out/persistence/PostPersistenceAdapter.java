package com.example.hotdealverse.post.adapter.out.persistence;

import com.example.hotdealverse.post.application.port.out.PostPort;
import com.example.hotdealverse.post.domain.Post;
import com.example.hotdealverse.post.dto.req.GetPostsReqDto;
import com.example.hotdealverse.post.mapper.PostMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PostPersistenceAdapter implements PostPort {

    private final PostRepository postRepository;

    @Override
    public List<Post> getPosts(GetPostsReqDto getPostsReqDto) {
        Pageable pageable = PageRequest.of(getPostsReqDto.getPage(), getPostsReqDto.getSize());
        List<PostJpaEntity> postJpaEntityList = this.postRepository.findAllByTitleContaining(getPostsReqDto.getKeyword(), pageable).stream().toList();
        return postJpaEntityList.stream().map(PostMapper::convertEntityToPost).toList();
    }
}
