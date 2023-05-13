package com.example.hotdealverse.item.adapter.out.persistence;

import com.example.hotdealverse.common.exception.CustomException;
import com.example.hotdealverse.common.exception.ErrorCode;
import com.example.hotdealverse.item.application.port.out.LikePort;
import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import com.example.hotdealverse.user.adapter.out.persistence.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LikePersistenceAdapter implements LikePort {

    private final LikeRepository likeRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Override
    public void enrollLike(Long userId, Long itemId) {

        UserJpaEntity user = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        ItemJpaEntity itemJpaEntity = itemRepository.findById(itemId).orElseThrow(
                () -> new CustomException(ErrorCode.ITEM_NOT_FOUND)
        );
        LikeJpaEntity likeJpaEntity = LikeJpaEntity.builder()
                .user(user)
                .item(itemJpaEntity)
                .build();
        likeRepository.save(likeJpaEntity);

        itemJpaEntity.addLike(likeJpaEntity);
        this.itemRepository.save(itemJpaEntity);
    }

    @Override
    public void unenrollLike(Long userId, Long itemId) {

        UserJpaEntity user = userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        ItemJpaEntity itemJpaEntity = itemRepository.findById(itemId).orElseThrow(
                () -> new CustomException(ErrorCode.ITEM_NOT_FOUND)
        );

        likeRepository.deleteByUserAndItem(user, itemJpaEntity);
    }
}
