package com.example.hotdealverse.item.adapter.in.web.controller;

import com.example.hotdealverse.common.aop.Authenticated;
import com.example.hotdealverse.common.aop.CurrentUser;
import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import com.example.hotdealverse.item.adapter.dto.req.PatchCommentReqDto;
import com.example.hotdealverse.item.application.port.in.CommentUseCase;
import com.example.hotdealverse.item.adapter.dto.req.CreateCommentReqDto;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Api(value = "comment")
@Slf4j
@RequiredArgsConstructor
@RestController()
public class CommentController {

    private final CommentUseCase commentUseCase;

    @Authenticated
    @PostMapping("items/{itemId}/comments")
    public ResponseEntity createComment(
            @PathVariable("itemId") Long itemId,
            @CurrentUser() UserPrincipal userPrincipal,
            @RequestBody() CreateCommentReqDto createCommentReqDto
    ) {
        this.commentUseCase.createComment(userPrincipal.getId(), itemId, createCommentReqDto);

        return ResponseEntity.status(201).build();
    }

    @Authenticated
    @PatchMapping("items/{itemId}/comments/{commentId}")
    public ResponseEntity patchComment(
            @PathVariable("commentId") Long commentId,
            @PathVariable("itemId") Long itemId,
            @CurrentUser() UserPrincipal userPrincipal,
            @RequestBody() PatchCommentReqDto patchCommentReqDto
    ) {
        this.commentUseCase.patchComment(userPrincipal.getId(), itemId, commentId, patchCommentReqDto);

        return ResponseEntity.status(200).build();
    }

    @Authenticated
    @DeleteMapping("items/{itemId}/comments/{commentId}")
    public ResponseEntity deleteComment(
            @PathVariable("commentId") Long commentId,
            @PathVariable("itemId") Long itemId,
            @CurrentUser() UserPrincipal userPrincipal
    ) {
        this.commentUseCase.deleteComment(userPrincipal.getId(), itemId, commentId);

        return ResponseEntity.status(200).build();
    }
}
