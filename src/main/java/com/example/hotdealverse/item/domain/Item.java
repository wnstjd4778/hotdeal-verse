package com.example.hotdealverse.item.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Date;
import java.util.List;


@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Item {

    private long id;

    private String title;

    private String nickname;

    private List<Comment> commentList;

    private List<Like> likeList;

    private String href;

    private Date createdAt;

    private String imgName;
}
