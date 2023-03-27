package com.example.hotdealverse.item.adapter.out.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ItemJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String title;

    private String nickname;

    private Long replyNum;

    private Long recommendNum;

    private String href;



}
