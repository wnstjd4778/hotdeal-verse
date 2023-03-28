package com.example.hotdealverse.item.application.port.in;

import com.example.hotdealverse.item.adapter.in.web.dto.req.CreateCommentReqDto;

public interface CommentUseCase {
    void createComment(Long userId, Long itemId, CreateCommentReqDto createCommentReqDto);
}
