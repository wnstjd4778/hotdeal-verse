package com.example.hotdealverse.item.application.port.in;

import com.example.hotdealverse.item.adapter.in.web.dto.req.CreateCommentReqDto;
import com.example.hotdealverse.item.adapter.in.web.dto.req.PatchCommentReqDto;

public interface CommentUseCase {
    void createComment(Long userId, Long itemId, CreateCommentReqDto createCommentReqDto);

    void patchComment(Long userId, Long itemId, Long commentId, PatchCommentReqDto patchCommentReqDto);
}
