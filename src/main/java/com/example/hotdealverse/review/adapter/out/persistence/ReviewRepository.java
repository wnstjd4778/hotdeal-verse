package com.example.hotdealverse.review.adapter.out.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<ReviewJpaEntity, Long> {

    Page<ReviewJpaEntity> findAll(Pageable pageable);

    Page<ReviewJpaEntity> findAllByItem(Long itemId, Pageable pageable);

    long count();

    Long countAllByItem(Long itemId);

}
