package com.example.hotdealverse.alarm.application.port.in;

import com.example.hotdealverse.alarm.adapter.dto.req.RegisterKeywordReqDto;
import com.example.hotdealverse.alarm.adapter.dto.res.GetKeywordResDto;

import java.util.List;

public interface KeywordUseCase {

    void registerKeyword(long userId, RegisterKeywordReqDto registerKeywordReqDto);

    void deleteKeyword(long userId, Long keywordId);

    List<GetKeywordResDto> getKeywords(long userId);
}
