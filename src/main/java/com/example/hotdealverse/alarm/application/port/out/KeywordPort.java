package com.example.hotdealverse.alarm.application.port.out;

import com.example.hotdealverse.alarm.dto.req.RegisterKeywordReqDto;

public interface KeywordPort {

    public void registerKeyword(long userId, RegisterKeywordReqDto registerKeywordReqDto);

    public void deleteKeyword(long userId, Long keywordId);
}
