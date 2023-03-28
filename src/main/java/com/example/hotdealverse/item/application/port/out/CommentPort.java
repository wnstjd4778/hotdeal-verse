package com.example.hotdealverse.item.application.port.out;

import com.example.hotdealverse.item.adapter.in.web.dto.req.CreateCommentReqDto;

public interface CommentPort {
    void createComment(Long userId, Long itemId, CreateCommentReqDto createCommentReqDto);
}
