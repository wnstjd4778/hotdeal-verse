package com.example.hotdealverse.item.mapper;

import com.example.hotdealverse.item.adapter.dto.res.GetItemResDto;
import com.example.hotdealverse.item.adapter.out.persistence.ItemJpaEntity;
import com.example.hotdealverse.item.domain.Item;

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
                .build();
    }

    public static GetItemResDto convertItemToGetItemResDto(Item item) {
        return GetItemResDto.builder()
                .id(item.getId())
                .nickname(item.getNickname())
                .recommendNum((long) item.getLikeList().size())
                .replyNum((long) item.getCommentList().size())
                .title(item.getTitle())
                .createdAt(item.getCreatedAt())
                .href(item.getHref())
                .imgName(item.getImgName())
                .build();
    }
}
