package com.example.hotdealverse.item.adapter.out.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<ItemJpaEntity, Long> {

    public Page<ItemJpaEntity> findAllByTitleContaining(String keyword, Pageable pageable);
}
