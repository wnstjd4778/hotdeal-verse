package com.example.hotdealverse.item.adapter.out.persistence;

import com.example.hotdealverse.common.exception.CustomException;
import com.example.hotdealverse.common.exception.ErrorCode;
import com.example.hotdealverse.item.adapter.in.web.dto.req.PatchCommentReqDto;
import com.example.hotdealverse.item.application.port.out.CommentPort;
import com.example.hotdealverse.item.adapter.in.web.dto.req.CreateCommentReqDto;
import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import com.example.hotdealverse.user.adapter.out.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class CommentPersistenceAdapter implements CommentPort {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    @Override
    public void createComment(Long userId, Long itemId, CreateCommentReqDto createCommentReqDto) {
        UserJpaEntity userJpaEntity = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        ItemJpaEntity itemJpaEntity = itemRepository.findById(itemId).orElseThrow(
                () -> new CustomException(ErrorCode.ITEM_NOT_FOUND)
        );

        CommentJpaEntity commentJpaEntity = CommentJpaEntity.builder()
                .content(createCommentReqDto.getContent())
                .item(itemJpaEntity)
                .user(userJpaEntity)
                .build();

        if(createCommentReqDto.getParent() != null) {
            commentJpaEntity.setParent(this.commentRepository.findById(createCommentReqDto.getParent()).orElseThrow(
                    () -> new CustomException(ErrorCode.COMMENT_NOT_FOUND)
            ));
        }
        this.commentRepository.save(
            commentJpaEntity
        );

        itemJpaEntity.addComment(commentJpaEntity);
        this.itemRepository.save(itemJpaEntity);
    }

    @Override
    public void patchComment(Long userId, Long itemId, Long commentId, PatchCommentReqDto patchCommentReqDto) {
        UserJpaEntity userJpaEntity = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        ItemJpaEntity itemJpaEntity = itemRepository.findById(itemId).orElseThrow(
                () -> new CustomException(ErrorCode.ITEM_NOT_FOUND)
        );

        CommentJpaEntity commentJpaEntity = this.commentRepository.findById(commentId).orElseThrow(
                () -> new CustomException(ErrorCode.COMMENT_NOT_FOUND)
        );

        if(userJpaEntity.getId() != commentJpaEntity.getUser().getId()) {
            throw new CustomException(ErrorCode.COMMENT_NOT_ACCESS);
        }

        if(patchCommentReqDto.getContent().length() > 0) {
            this.commentRepository.patchComment(commentJpaEntity.getId(), patchCommentReqDto.getContent());
        }
    }

    @Override
    public void deleteComment(Long userId, Long itemId, Long commentId) {
        UserJpaEntity userJpaEntity = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        ItemJpaEntity itemJpaEntity = itemRepository.findById(itemId).orElseThrow(
                () -> new CustomException(ErrorCode.ITEM_NOT_FOUND)
        );

        CommentJpaEntity commentJpaEntity = this.commentRepository.findById(commentId).orElseThrow(
                () -> new CustomException(ErrorCode.COMMENT_NOT_FOUND)
        );

        if(userJpaEntity.getId() != commentJpaEntity.getUser().getId()) {
            throw new CustomException(ErrorCode.COMMENT_NOT_ACCESS);
        }

        this.commentRepository.delete(commentJpaEntity);
    }
}
