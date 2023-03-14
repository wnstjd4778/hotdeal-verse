package com.example.hotdealverse.product.adapter.out.persistence;

import com.example.hotdealverse.product.domain.Post;
import com.example.hotdealverse.user.domain.User;
import jakarta.persistence.*;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

public class CommentJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @JoinColumn(name = "post_id", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @Column(nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private CommentJpaEntity parent;

    @Builder.Default
    @OneToMany(mappedBy = "parent", orphanRemoval = true)
    private List<CommentJpaEntity> children = new ArrayList<>();

}
