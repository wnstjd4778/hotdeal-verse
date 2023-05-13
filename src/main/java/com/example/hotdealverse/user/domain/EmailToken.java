package com.example.hotdealverse.user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class EmailToken {

    private Long id;

    private String token;

    private String email;

    private User user;
}
