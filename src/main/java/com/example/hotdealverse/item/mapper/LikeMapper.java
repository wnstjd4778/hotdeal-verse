package com.example.hotdealverse.item.mapper;

import com.example.hotdealverse.item.adapter.out.persistence.CommentJpaEntity;
import com.example.hotdealverse.item.adapter.out.persistence.LikeJpaEntity;
import com.example.hotdealverse.item.domain.Comment;
import com.example.hotdealverse.item.domain.Like;
import com.example.hotdealverse.user.mapper.UserMapper;

public class LikeMapper {

    public static Like convertEntityToLike(LikeJpaEntity likeJpaEntity) {
        return Like.builder()
                .id(likeJpaEntity.getId())
                .user(UserMapper.convertEntityToUser(likeJpaEntity.getUser()))
                .build();
    }

    public static LikeJpaEntity convertLikeToEntity(Like like) {
        return LikeJpaEntity.builder()
                .id(like.getId())
                .user(UserMapper.convertUserToEntity(like.getUser()))
                .build();
    }
}
