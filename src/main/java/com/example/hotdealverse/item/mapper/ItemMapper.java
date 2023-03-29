package com.example.hotdealverse.item.mapper;

import com.example.hotdealverse.item.adapter.out.persistence.ItemJpaEntity;
import com.example.hotdealverse.item.domain.Item;
import com.example.hotdealverse.item.adapter.in.web.dto.res.GetItemResDto;

public class ItemMapper {

    public static Item convertEntityToItem(ItemJpaEntity itemJpaEntity) {
        return Item.builder()
                .id(itemJpaEntity.getId())
                .nickname(itemJpaEntity.getNickname())
                .recommendNum(itemJpaEntity.getRecommendNum())
                .replyNum(itemJpaEntity.getReplyNum())
                .title(itemJpaEntity.getTitle())
                .href(itemJpaEntity.getHref())
                .createdAt(itemJpaEntity.getCreatedAt())
                .build();
    }

    public static GetItemResDto convertItemToGetItemResDto(Item item) {
        return GetItemResDto.builder()
                .id(item.getId())
                .nickname(item.getNickname())
                .recommendNum(item.getRecommendNum())
                .replyNum(item.getReplyNum())
                .title(item.getTitle())
                .createdAt(item.getCreatedAt())
                .href(item.getHref())
                .build();
    }
}