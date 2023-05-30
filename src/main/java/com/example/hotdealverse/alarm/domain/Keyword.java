package com.example.hotdealverse.alarm.domain;

import com.example.hotdealverse.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Keyword {
    private long id;

    private User user;

    private String keyword;
}
