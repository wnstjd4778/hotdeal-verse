package com.example.hotdealverse.alarm.adapter.in.web;

import com.example.hotdealverse.alarm.application.port.in.KeywordUseCase;
import com.example.hotdealverse.alarm.dto.req.RegisterKeywordReqDto;
import com.example.hotdealverse.common.security.CurrentUser;
import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "keyword")
@RestController("/keywords")
@RequiredArgsConstructor
public class KeywordController {

    private final KeywordUseCase keywordUseCase;

    @Operation(summary = "keyword 등록")
    @PostMapping()
    public ResponseEntity registerKeyword(
            @CurrentUser UserPrincipal userPrincipal,
            @RequestBody() RegisterKeywordReqDto registerKeywordReqDto
    ) {
        this.keywordUseCase.registerKeyword(userPrincipal.getId(), registerKeywordReqDto);
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "keyword 삭제")
    @DeleteMapping("/{keywordId}")
    public ResponseEntity deleteKeyword(
            @CurrentUser UserPrincipal userPrincipal,
            @PathVariable("keywordId") Long keywordId
    ) {
        this.keywordUseCase.deleteKeyword(userPrincipal.getId(), keywordId);
        return ResponseEntity.status(200).build();
    }

    // 메일 regex 보기
//    @Operation(summary = "keyword들 보기")
//    public ResponseEntity getKeywords(
//            @CurrentUser UserPrincipal userPrincipal
//    ) {
//
//    }
}
