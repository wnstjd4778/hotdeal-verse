package com.example.hotdealverse.item.adapter.out.persistence;

import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import com.example.hotdealverse.user.adapter.out.persistence.base.BaseTimeEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "_like")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LikeJpaEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserJpaEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private ItemJpaEntity item;

    public static LikeJpaEntity createLike(UserJpaEntity user, ItemJpaEntity item) {
        LikeJpaEntity like = LikeJpaEntity.builder()
                .user(user)
                .item(item)
                .build();

        return like;
    }
}
