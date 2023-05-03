package com.example.hotdealverse.alarm.adapter.out.persistance;

import com.example.hotdealverse.alarm.application.port.out.KeywordPort;
import com.example.hotdealverse.alarm.domain.Keyword;
import com.example.hotdealverse.alarm.dto.req.RegisterKeywordReqDto;
import com.example.hotdealverse.alarm.mapper.KeywordMapper;
import com.example.hotdealverse.common.exception.CustomException;
import com.example.hotdealverse.common.exception.ErrorCode;
import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import com.example.hotdealverse.user.adapter.out.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class KeywordPersistenceAdapter implements KeywordPort {

    private final KeywordRepository keywordRepository;
    private final UserRepository userRepository;

    @Override
    public void registerKeyword(long userId, RegisterKeywordReqDto registerKeywordReqDto) {
        UserJpaEntity user = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        this.keywordRepository.save(KeywordJpaEntity.createKeyword(user, registerKeywordReqDto.getKeyword()));
    }

    @Override
    public void deleteKeyword(long userId, Long keywordId) {
        UserJpaEntity user = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        KeywordJpaEntity keywordJpaEntity = this.keywordRepository.findById(keywordId).orElseThrow(
                () -> new CustomException(ErrorCode.ITEM_NOT_FOUND)
        );
        boolean isGranted = keywordJpaEntity.isGranted(user);
        if (!isGranted) throw new CustomException(ErrorCode.KEYWORD_NOT_ACCESS);

        this.keywordRepository.delete(keywordJpaEntity);
    }

    @Override
    public List<Keyword> getKeywords(long userId) {
        UserJpaEntity user = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        List<KeywordJpaEntity> keywordJpaEntityList = this.keywordRepository.findByUser(user);
        return keywordJpaEntityList.stream().map(KeywordMapper::convertEntityToKeyword).toList();
    }
}
