package com.example.hotdealverse.alarm.application.service;

import com.example.hotdealverse.alarm.application.port.in.KeywordUseCase;
import com.example.hotdealverse.alarm.application.port.out.KeywordPort;
import com.example.hotdealverse.alarm.domain.Keyword;
import com.example.hotdealverse.alarm.dto.req.RegisterKeywordReqDto;
import com.example.hotdealverse.alarm.dto.res.GetKeywordResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<GetKeywordResDto> getKeywords(long userId) {
        List<Keyword> keywordList = this.keywordPort.getKeywords(userId);

        return keywordList.stream()
                .map((keyword ->
                        GetKeywordResDto.builder()
                                .keyword(keyword.getKeyword())
                                .id(keyword.getId())
                                .build()))
                .toList();
    }

}
