package com.example.hotdealverse.post.adapter.out.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<PostJpaEntity, Long> {

    public Page<PostJpaEntity> findAllByTitleContaining(String keyword, Pageable pageable);
}
