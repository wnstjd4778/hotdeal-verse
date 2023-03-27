package com.example.hotdealverse.item.adapter.out.persistence;

import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LikeRepository extends JpaRepository<LikeJpaEntity, Long> {

    void deleteByUserAndItem(UserJpaEntity user, ItemJpaEntity itemJpaEntity);
}
