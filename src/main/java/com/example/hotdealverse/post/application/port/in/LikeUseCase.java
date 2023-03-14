package com.example.hotdealverse.post.application.port.in;

import org.springframework.stereotype.Component;

public interface LikeUseCase {

    public void enrollLike(Long userId, Long postId);

    public void unenrollLike(Long userId, Long postId);
}
