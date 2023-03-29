package com.example.hotdealverse.item.adapter.in.web.controller;

import com.example.hotdealverse.common.security.CurrentUser;
import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import com.example.hotdealverse.item.adapter.in.web.dto.req.PatchCommentReqDto;
import com.example.hotdealverse.item.application.port.in.CommentUseCase;
import com.example.hotdealverse.item.adapter.in.web.dto.req.CreateCommentReqDto;
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

    @PostMapping("items/{itemId}/comments")
    public ResponseEntity createComment(
            @PathVariable("itemId") Long itemId,
            @CurrentUser() UserPrincipal userPrincipal,
            @RequestBody() CreateCommentReqDto createCommentReqDto
    ) {
        this.commentUseCase.createComment(userPrincipal.getId(), itemId, createCommentReqDto);

        return ResponseEntity.status(201).build();
    }

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
}
