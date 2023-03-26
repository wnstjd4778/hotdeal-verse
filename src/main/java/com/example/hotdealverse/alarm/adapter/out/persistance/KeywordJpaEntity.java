package com.example.hotdealverse.alarm.adapter.out.persistance;

import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "keyword")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class KeywordJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private UserJpaEntity user;

    private String keyword;

    public static KeywordJpaEntity createKeyword(UserJpaEntity userJpaEntity, String keyword) {
        KeywordJpaEntity keywordJpaEntity = KeywordJpaEntity.builder()
                .user(userJpaEntity)
                .keyword(keyword)
                .build();
        return keywordJpaEntity;
    }

    boolean isGranted(UserJpaEntity userJpaEntity) {
        return id == userJpaEntity.getId();
    }
}
