package com.example.hotdealverse.item.mapper;

import com.example.hotdealverse.item.adapter.dto.res.GetCommentResDto;
import com.example.hotdealverse.item.adapter.dto.res.GetItemResDto;
import com.example.hotdealverse.item.adapter.out.persistence.ItemJpaEntity;
import com.example.hotdealverse.item.domain.Item;
import com.example.hotdealverse.user.adapter.dto.res.GetUserResDto;

public class ItemMapper {

    public static Item convertEntityToItem(ItemJpaEntity itemJpaEntity) {
        return Item.builder()
                .id(itemJpaEntity.getId())
                .nickname(itemJpaEntity.getNickname())
                .commentList(itemJpaEntity.getCommentList().stream().map(commentJpaEntity -> CommentMapper.convertEntityToComment(commentJpaEntity)).toList())
                .likeList(itemJpaEntity.getLikeList().stream().map(likeJpaEntity -> LikeMapper.convertEntityToLike(likeJpaEntity)).toList())
                .title(itemJpaEntity.getTitle())
                .href(itemJpaEntity.getHref())
                .createdAt(itemJpaEntity.getCreatedAt())
                .imgName(itemJpaEntity.getImgName())
                .viewCnt(itemJpaEntity.getViewCnt())
                .build();
    }

    public static ItemJpaEntity convertItemToEntity(Item item) {
        return ItemJpaEntity.builder()
                .id(item.getId())
                .nickname(item.getNickname())
                .likeList(item.getLikeList().stream().map(like -> LikeMapper.convertLikeToEntity(like)).toList())
                .commentList(item.getCommentList().stream().map(comment -> CommentMapper.convertCommentToEntity(comment)).toList())
                .title(item.getTitle())
                .href(item.getHref())
                .createdAt(item.getCreatedAt())
                .imgName(item.getImgName())
                .viewCnt(item.getViewCnt())
                .build();
    }

    public static GetItemResDto convertItemToGetItemResDto(Item item) {
        return GetItemResDto.builder()
                .id(item.getId())
                .nickname(item.getNickname())
                .recommendNum((long) item.getLikeList().size())
                .commentList(item.getCommentList().stream().map((comment ->
                                GetCommentResDto.builder()
                                        .id(comment.getId())
                                        .user(GetUserResDto.builder()
                                                .name(comment.getUser().getName())
                                                .id(comment.getUser().getId())
                                                .build())
                                        .content(comment.getContent())
                                        .createdAt(comment.getCreatedAt())
                                        .updatedAt(comment.getUpdatedAt())
                                        .build()
                        )
                ).toList())
                .title(item.getTitle())
                .createdAt(item.getCreatedAt())
                .href(item.getHref())
                .check(false)
                .imgName(item.getImgName())
                .viewCnt(item.getViewCnt())
                .build();
    }

    public static GetItemResDto convertItemToGetItemResDtoWithUserId(Item item, Long userId) {
        return GetItemResDto.builder()
                .id(item.getId())
                .nickname(item.getNickname())
                .recommendNum((long) item.getLikeList().size())
                .commentList(item.getCommentList().stream().map((comment ->
                                GetCommentResDto.builder()
                                        .id(comment.getId())
                                        .user(GetUserResDto.builder()
                                                .name(comment.getUser().getName())
                                                .id(comment.getUser().getId())
                                                .build())
                                        .content(comment.getContent())
                                        .createdAt(comment.getCreatedAt())
                                        .updatedAt(comment.getUpdatedAt())
                                        .build()
                        )
                ).toList())
                .title(item.getTitle())
                .createdAt(item.getCreatedAt())
                .href(item.getHref())
                .imgName(item.getImgName())
                .viewCnt(item.getViewCnt())
                .check(item.getLikeList().stream().anyMatch(like -> like.getUser().getId() == userId))
                .build();
    }
}
