package com.example.hotdealverse.alarm.application.service;

import com.example.hotdealverse.alarm.application.port.in.KeywordUseCase;
import com.example.hotdealverse.alarm.application.port.out.KeywordPort;
import com.example.hotdealverse.alarm.dto.req.RegisterKeywordReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KeywordService implements KeywordUseCase {

    private final KeywordPort keywordPort;

    @Override
    public void registerKeyword(long userId, RegisterKeywordReqDto registerKeywordReqDto) {
        this.keywordPort.registerKeyword(userId, registerKeywordReqDto);
    }

    @Override
    public void deleteKeyword(long userId, Long keywordId) {
        this.keywordPort.deleteKeyword(userId, keywordId);
    }

}
