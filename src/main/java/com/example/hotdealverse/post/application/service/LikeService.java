package com.example.hotdealverse.post.application.service;

import com.example.hotdealverse.post.application.port.in.LikeUseCase;
import com.example.hotdealverse.post.application.port.out.LikePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class LikeService implements LikeUseCase {

    private final LikePort likePort;

    @Override
    public void enrollLike(Long userId, Long postId) {
        likePort.enrollLike(userId, postId);
    }

    @Override
    public void unenrollLike(Long userId, Long postId) {
        likePort.unenrollLike(userId, postId);
    }
}
