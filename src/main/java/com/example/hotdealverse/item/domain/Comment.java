package com.example.hotdealverse.item.domain;

import com.example.hotdealverse.user.domain.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Comment {

    private Long id;

    private String content;

    private Comment parent;

    private User user;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;

}
