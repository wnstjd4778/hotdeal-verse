package com.example.hotdealverse.alarm.adapter.out.persistance;

import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KeywordRepository extends JpaRepository<KeywordJpaEntity, Long> {

    void deleteByUserAndKeyword(UserJpaEntity userJpaEntity, String keyword);
}
