package com.example.hotdealverse.item.application.port.out;

import com.example.hotdealverse.item.adapter.dto.req.CreateCommentReqDto;
import com.example.hotdealverse.item.adapter.dto.req.PatchCommentReqDto;

public interface CommentPort {
    void createComment(Long userId, Long itemId, CreateCommentReqDto createCommentReqDto);

    void patchComment(Long userId, Long itemId, Long commentId, PatchCommentReqDto patchCommentReqDto);

    void deleteComment(Long userId, Long itemId, Long commentId);
}
