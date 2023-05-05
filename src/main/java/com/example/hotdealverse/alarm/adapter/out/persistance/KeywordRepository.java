package com.example.hotdealverse.alarm.adapter.out.persistance;

import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface KeywordRepository extends JpaRepository<KeywordJpaEntity, Long> {

    void deleteByUserAndKeyword(UserJpaEntity userJpaEntity, String keyword);

    List<KeywordJpaEntity> findByUser(UserJpaEntity userJpaEntity);

    @Query("SELECT k, i FROM KeywordJpaEntity k " +
            "JOIN ItemJpaEntity i ON i.title LIKE CONCAT('%', k.keyword, '%') " +
            "JOIN k.user u " +
            "WHERE i.isSend = false")
    List<Object[]> findAllKeywordsAndItemsNotSent();
}
