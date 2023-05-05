package com.example.hotdealverse.user.mapper;

import com.example.hotdealverse.user.adapter.out.persistence.UserJpaEntity;
import com.example.hotdealverse.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public static User convertEntityToUser(UserJpaEntity userJapEntity) {

        return User.builder()
                .id(userJapEntity.getId())
                .name(userJapEntity.getName())
                .email(userJapEntity.getEmail())
                .providerKey(userJapEntity.getProviderKey())
                .providerType(userJapEntity.getProviderType())
                .accessDate(userJapEntity.getAccessDate())
                .role(userJapEntity.getRole())
                .build();
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
