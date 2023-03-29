package com.example.hotdealverse.item.application.port.out;

import com.example.hotdealverse.item.adapter.in.web.dto.req.CreateCommentReqDto;
import com.example.hotdealverse.item.adapter.in.web.dto.req.PatchCommentReqDto;

public interface CommentPort {
    void createComment(Long userId, Long itemId, CreateCommentReqDto createCommentReqDto);

    void patchComment(Long userId, Long itemId, Long commentId, PatchCommentReqDto patchCommentReqDto);
}
