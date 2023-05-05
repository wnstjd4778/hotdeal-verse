package com.example.hotdealverse.user.adapter.out.persistence;

import com.example.hotdealverse.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User converEntityToUser(UserJpaEntity userJpaEntity) {
        return User.of(
                userJpaEntity.getId(),
                userJpaEntity.getName(),
                userJpaEntity.getProviderType(),
                userJpaEntity.getProviderKey(),
                userJpaEntity.getAccessDate(),
                userJpaEntity.getRole()
        );
    }

    public static UserJpaEntity convertUserToEntity(User user) {

        return UserJpaEntity.builder()
                .id(user.getId())
                .name(user.getName())
                .providerKey(user.getProviderKey())
                .providerType(user.getProviderType())
                .accessDate(user.getAccessDate())
                .role(user.getRole())
                .build();
    }
}
