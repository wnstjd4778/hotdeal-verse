package com.example.hotdealverse.alarm.mapper;

import com.example.hotdealverse.alarm.adapter.out.persistance.KeywordJpaEntity;
import com.example.hotdealverse.alarm.domain.Keyword;
import com.example.hotdealverse.user.adapter.out.persistence.UserMapper;

public class KeywordMapper {

    public static Keyword convertEntityToKeyword(KeywordJpaEntity keywordJpaEntity) {
        return Keyword.builder()
                .id(keywordJpaEntity.getId())
                .user(UserMapper.converEntityToUser(keywordJpaEntity.getUser()))
                .keyword(keywordJpaEntity.getKeyword())
                .build();
    }

    public static KeywordJpaEntity convertKeywordToEntity(Keyword keyword) {
        return KeywordJpaEntity.builder()
                .id(keyword.getId())
                .user(UserMapper.convertUserToEntity(keyword.getUser()))
                .keyword(keyword.getKeyword())
                .build();
    }
}
