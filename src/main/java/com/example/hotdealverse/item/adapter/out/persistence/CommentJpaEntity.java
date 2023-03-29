package com.example.hotdealverse.item.adapter.out.persistence;

import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "comment")
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserJpaEntity user;

    @JoinColumn(name = "item_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private ItemJpaEntity item;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private CommentJpaEntity parent;

    void setParent(CommentJpaEntity commentJpaEntity) {
        this.parent = commentJpaEntity;
    }
}
