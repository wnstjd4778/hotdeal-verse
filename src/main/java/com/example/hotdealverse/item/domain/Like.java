package com.example.hotdealverse.item.domain;

import com.example.hotdealverse.user.domain.User;
import lombok.Builder;

@Builder
public class Like {

    private Long id;
    private User user;
    private Item item;
}
