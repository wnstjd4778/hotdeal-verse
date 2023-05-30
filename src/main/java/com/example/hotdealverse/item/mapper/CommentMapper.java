package com.example.hotdealverse.item.mapper;

import com.example.hotdealverse.item.adapter.out.persistence.CommentJpaEntity;
import com.example.hotdealverse.item.domain.Comment;
import com.example.hotdealverse.user.mapper.UserMapper;

public class CommentMapper {

    public static Comment convertEntityToComment(CommentJpaEntity commentJpaEntity) {

        return Comment.builder()
                .id(commentJpaEntity.getId())
                .content(commentJpaEntity.getContent())
                .parent(commentJpaEntity.getParent() ==null? null : convertEntityToComment(commentJpaEntity.getParent()))
                .user(UserMapper.convertEntityToUser(commentJpaEntity.getUser()))
                .createdAt(commentJpaEntity.getCreatedAt())
                .updatedAt(commentJpaEntity.getUpdatedAt())
                .build();
    }

    public static CommentJpaEntity convertCommentToEntity(Comment comment) {
        return CommentJpaEntity.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .parent(convertCommentToEntity(comment.getParent()))
                .user(UserMapper.convertUserToEntity(comment.getUser()))
                .build();
    }
}
