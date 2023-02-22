package com.example.hotdealverse.product.domain;

import java.util.List;

public class Comment {

    private String content;

    private Comment parent;

    private List<Comment> children;
}
