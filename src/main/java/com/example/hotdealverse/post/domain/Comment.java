package com.example.hotdealverse.post.domain;

import java.util.List;

public class Comment {

    private Long id;

    private String content;

    private Comment parent;

    private List<Comment> children;
}
