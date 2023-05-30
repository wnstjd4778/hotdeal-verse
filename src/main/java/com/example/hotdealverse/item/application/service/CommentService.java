package com.example.hotdealverse.item.application.service;

import com.example.hotdealverse.item.adapter.dto.req.CreateCommentReqDto;
import com.example.hotdealverse.item.adapter.dto.req.PatchCommentReqDto;
import com.example.hotdealverse.item.application.port.in.CommentUseCase;
import com.example.hotdealverse.item.application.port.out.CommentPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService implements CommentUseCase {

    private final CommentPort commentPort;

    @Override
    public void createComment(Long userId, Long itemId, CreateCommentReqDto createCommentReqDto) {
        this.commentPort.createComment(userId, itemId, createCommentReqDto);
    }

    @Override
    public void patchComment(Long userId, Long itemId, Long commentId, PatchCommentReqDto patchCommentReqDto) {
        commentPort.patchComment(userId, itemId, commentId, patchCommentReqDto);
    }

    @Override
    public void deleteComment(Long userId, Long itemId, Long commentId) {
        commentPort.deleteComment(userId, itemId, commentId);
    }
}
