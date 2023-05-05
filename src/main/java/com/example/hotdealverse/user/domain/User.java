package com.example.hotdealverse.user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Builder
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private long id;

    private String name;

    private String email;

    @Enumerated(EnumType.STRING)
    private AuthProvider providerType;

    private String providerKey;

    private Date accessDate;

    @Enumerated(EnumType.STRING)
    private RoleType role;
}
