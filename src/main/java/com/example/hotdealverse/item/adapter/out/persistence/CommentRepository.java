package com.example.hotdealverse.item.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CommentRepository extends JpaRepository<CommentJpaEntity, Long> {

    @Modifying
    @Transactional
    @Query("UPDATE CommentJpaEntity c SET c.content = :content WHERE c.user.id = :userId ")
    void patchComment(Long userId, String content);
}
