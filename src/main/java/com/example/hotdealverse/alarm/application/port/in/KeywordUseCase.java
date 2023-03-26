package com.example.hotdealverse.alarm.application.port.in;

import com.example.hotdealverse.alarm.dto.req.RegisterKeywordReqDto;

public interface KeywordUseCase {

    public void registerKeyword(long userId, RegisterKeywordReqDto registerKeywordReqDto);

    public void deleteKeyword(long userId, Long keywordId);
}
