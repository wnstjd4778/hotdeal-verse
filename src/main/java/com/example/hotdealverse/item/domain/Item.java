package com.example.hotdealverse.item.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;


@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Item {

    private long id;

    private String title;

    private String nickname;

    private Long replyNum;

    private Long recommendNum;

    private String href;

    private Date createdAt;
}
