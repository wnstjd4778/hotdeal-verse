package com.example.hotdealverse.item.application.service;

import com.example.hotdealverse.item.application.port.in.LikeUseCase;
import com.example.hotdealverse.item.application.port.out.LikePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@Transactional
@RequiredArgsConstructor
public class LikeService implements LikeUseCase {

    private final LikePort likePort;

    @Override
    public void enrollLike(Long userId, Long itemId) {
        likePort.enrollLike(userId, itemId);
    }

    @Override
    public void unenrollLike(Long userId, Long itemId) {
        likePort.unenrollLike(userId, itemId);
    }
}
