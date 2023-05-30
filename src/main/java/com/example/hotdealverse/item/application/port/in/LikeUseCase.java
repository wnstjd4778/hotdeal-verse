package com.example.hotdealverse.item.application.port.in;

public interface LikeUseCase {

    public void enrollLike(Long userId, Long itemId);

    public void unenrollLike(Long userId, Long itemId);
}
