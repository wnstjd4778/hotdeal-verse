package com.example.hotdealverse.post.application.port.out;

public interface LikePort {

    public void enrollLike(Long userId, Long postId);

    public void unenrollLike(Long userId, Long postId);
}
