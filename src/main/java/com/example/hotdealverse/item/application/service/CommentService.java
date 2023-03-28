package com.example.hotdealverse.item.application.service;

import com.example.hotdealverse.item.application.port.in.CommentUseCase;
import com.example.hotdealverse.item.application.port.out.CommentPort;
import com.example.hotdealverse.item.application.port.out.ItemPort;
import com.example.hotdealverse.item.adapter.in.web.dto.req.CreateCommentReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService implements CommentUseCase {

    private final CommentPort commentPort;
    private final ItemPort itemPort;

    @Override
    public void createComment(Long userId, Long itemId, CreateCommentReqDto createCommentReqDto) {
        this.commentPort.createComment(userId, itemId, createCommentReqDto);
    }
}
