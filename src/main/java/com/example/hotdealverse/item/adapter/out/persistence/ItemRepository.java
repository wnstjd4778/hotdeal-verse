package com.example.hotdealverse.item.adapter.out.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ItemRepository extends JpaRepository<ItemJpaEntity, Long> {

    Page<ItemJpaEntity> findAllByTitleContaining(String keyword, Pageable pageable);

    Long countAllByTitleContaining(String keyword);

    @Modifying
    @Query("UPDATE ItemJpaEntity i SET i.isSend = true")
    void updateAllItemsToSent();
}
