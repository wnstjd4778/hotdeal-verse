package com.example.hotdealverse.alarm.adapter.out.persistance;

import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "keyword", cascade = CascadeType.ALL)
    private List<AlarmJpaEntity> alarmList = new ArrayList<>();

    public static KeywordJpaEntity createKeyword(UserJpaEntity userJpaEntity, String keyword) {
        KeywordJpaEntity keywordJpaEntity = KeywordJpaEntity.builder()
                .user(userJpaEntity)
                .keyword(keyword)
                .build();
        return keywordJpaEntity;
    }

    boolean isGranted(UserJpaEntity userJpaEntity) {
        return user.getId() == userJpaEntity.getId();
    }

    void addAlarm(AlarmJpaEntity alarmJpaEntity) {
        System.out.println(alarmJpaEntity.getKeyword());
        if(alarmList == null) {
            this.alarmList = new ArrayList<>();
        }
        this.alarmList.add(alarmJpaEntity);
    }
}
