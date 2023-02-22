package com.example.hotdealverse.user.adapter.out.persistence;

import com.example.hotdealverse.user.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    User mapToDomainEntity(UserJpaEntity userJpaEntity) {
        return User.of(
                userJpaEntity.getId(),
                userJpaEntity.getName(),
                userJpaEntity.getProviderType(),
                userJpaEntity.getProviderKey(),
                userJpaEntity.getAccessDate(),
                userJpaEntity.getRole()
        );
    }
}
