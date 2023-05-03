package com.example.hotdealverse.alarm.application.port.out;

import com.example.hotdealverse.alarm.domain.Keyword;
import com.example.hotdealverse.alarm.dto.req.RegisterKeywordReqDto;

import java.util.List;

public interface KeywordPort {

    void registerKeyword(long userId, RegisterKeywordReqDto registerKeywordReqDto);

    void deleteKeyword(long userId, Long keywordId);

    List<Keyword> getKeywords(long userId);
}
