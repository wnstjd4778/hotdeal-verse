package com.example.hotdealverse.item.application.port.out;

public interface LikePort {

    public void enrollLike(Long userId, Long itemId);

    public void unenrollLike(Long userId, Long itemId);
}
