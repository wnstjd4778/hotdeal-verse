package com.example.hotdealverse.alarm.adapter.out.persistance;

import com.example.hotdealverse.item.adapter.out.persistence.ItemJpaEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "alarm")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AlarmJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "keyword_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private KeywordJpaEntity keyword;

    @JoinColumn(name = "item_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ItemJpaEntity item;

}
