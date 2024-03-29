package com.example.hotdealverse.item.adapter.in.web.controller;

import com.example.hotdealverse.common.aop.Authenticated;
import com.example.hotdealverse.common.aop.CurrentUser;
import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import com.example.hotdealverse.item.application.port.in.LikeUseCase;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "Like")
@RestController("/likes")
@RequiredArgsConstructor
public class LikeController {

    private final LikeUseCase likeUseCase;

    @Operation(summary = "게시글 좋아요 등록")
    @Authenticated
    @PostMapping("/items/{itemId}/likes")
    public ResponseEntity enrollLike(
            @CurrentUser UserPrincipal userPrincipal,
            @PathVariable("itemId") Long itemId
    ) {
        likeUseCase.enrollLike(userPrincipal.getId(), itemId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(summary = "게시글 좋아요 취소")
    @Authenticated
    @DeleteMapping("/items/{itemId}/likes")
    public ResponseEntity unenrollLike(
            @CurrentUser UserPrincipal userPrincipal,
            @PathVariable("itemId") Long itemId
    ) {
        likeUseCase.unenrollLike(userPrincipal.getId(), itemId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }


}
