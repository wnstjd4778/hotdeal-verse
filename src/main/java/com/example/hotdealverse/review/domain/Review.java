package com.example.hotdealverse.review.domain;

import com.example.hotdealverse.item.domain.Item;
import com.example.hotdealverse.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Review {

    private long id;

    private String content;

    private Item item;

    private User user;

    private float rate;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;
}
