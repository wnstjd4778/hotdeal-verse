package com.example.hotdealverse.item.domain;

import com.example.hotdealverse.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Like {

    private Long id;
    private User user;
    private Item item;
}
