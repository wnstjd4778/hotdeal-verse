package com.example.hotdealverse.user.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;

@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class User {

    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AuthProvider providerType;

    private String providerKey;

    private Date accessDate;

    @Enumerated(EnumType.STRING)
    private RoleType role;

    public static User of(long id, String name, AuthProvider providerType, String providerKey, Date accessDate, RoleType role) {
        return User.builder()
                .id(id)
                .name(name)
                .providerType(providerType)
                .providerKey(providerKey)
                .accessDate(accessDate)
                .role(role)
                .build();
    }
}
