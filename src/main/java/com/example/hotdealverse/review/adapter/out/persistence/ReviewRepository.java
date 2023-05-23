package com.example.hotdealverse.review.adapter.out.persistence;

import com.example.hotdealverse.item.adapter.out.persistence.ItemJpaEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewJpaEntity, Long> {

    Page<ReviewJpaEntity> findAll(Pageable pageable);

    Page<ReviewJpaEntity> findAllByItem(ItemJpaEntity itemJpaEntity, Pageable pageable);

    long count();

    Long countAllByItem(ItemJpaEntity itemJpaEntity);

}
