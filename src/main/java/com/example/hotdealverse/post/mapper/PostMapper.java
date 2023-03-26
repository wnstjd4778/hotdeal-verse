package com.example.hotdealverse.post.mapper;

import com.example.hotdealverse.post.adapter.out.persistence.PostJpaEntity;
import com.example.hotdealverse.post.domain.Post;
import com.example.hotdealverse.post.dto.res.GetPostResDto;

public class PostMapper {

    public static Post convertEntityToPost(PostJpaEntity postJpaEntity) {
        return Post.builder().
                id(postJpaEntity.getId())
                .price(postJpaEntity.getPrice())
                .viewCnt(postJpaEntity.getViewCnt())
                .title(postJpaEntity.getTitle())
                .href(postJpaEntity.getHref())
                .build();
    }

    public static PostJpaEntity convertPostToEntity(Post post) {
        return PostJpaEntity.builder()
                .id(post.getId())
                .price(post.getPrice())
                .viewCnt(post.getViewCnt())
                .title(post.getTitle())
                .href(post.getHref())
                .build();
    }

    public static GetPostResDto convertPostToGetPostResDto(Post post) {
        return GetPostResDto.builder()
                .price(post.getPrice())
                .viewCnt(post.getViewCnt())
                .id(post.getId())
                .href(post.getHref())
                .title(post.getTitle())
                .build();
    }
}
