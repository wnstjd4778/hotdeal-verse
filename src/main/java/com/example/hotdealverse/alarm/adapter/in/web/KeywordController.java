package com.example.hotdealverse.alarm.adapter.in.web;

import com.example.hotdealverse.alarm.application.port.in.KeywordUseCase;
import com.example.hotdealverse.alarm.adapter.dto.req.RegisterKeywordReqDto;
import com.example.hotdealverse.alarm.adapter.dto.res.GetKeywordResDto;
import com.example.hotdealverse.common.aop.Authenticated;
import com.example.hotdealverse.common.aop.CurrentUser;
import com.example.hotdealverse.common.payload.ApiBaseResponse;
import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(value = "keyword")
@RestController()
@RequiredArgsConstructor
public class KeywordController {

    private final KeywordUseCase keywordUseCase;

    @Operation(summary = "keyword 등록")
    @Authenticated
    @PostMapping("/keywords")
    public ResponseEntity registerKeyword(
            @CurrentUser UserPrincipal userPrincipal,
            @RequestBody() RegisterKeywordReqDto registerKeywordReqDto
    ) {
        this.keywordUseCase.registerKeyword(userPrincipal.getId(), registerKeywordReqDto);
        return ResponseEntity.status(201).build();
    }

    @Operation(summary = "keyword 삭제")
    @Authenticated
    @DeleteMapping("/keywords/{keywordId}")
    public ResponseEntity deleteKeyword(
            @CurrentUser UserPrincipal userPrincipal,
            @PathVariable("keywordId") Long keywordId
    ) {
        this.keywordUseCase.deleteKeyword(userPrincipal.getId(), keywordId);
        return ResponseEntity.status(200).build();
    }

    @Operation(summary = "keyword들 보기")
    @Authenticated
    @GetMapping("/keywords")
    public ResponseEntity<ApiBaseResponse> getKeywords(
            @CurrentUser UserPrincipal userPrincipal
    ) {
        List<GetKeywordResDto> getKeywordResDtoList = keywordUseCase.getKeywords(userPrincipal.getId());
        ApiBaseResponse apiBaseResponse = new ApiBaseResponse(getKeywordResDtoList);
        return new ResponseEntity<>(apiBaseResponse, HttpStatus.OK);
    }
}
