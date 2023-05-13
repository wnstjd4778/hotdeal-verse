package com.example.hotdealverse.user.mapper;

import com.example.hotdealverse.user.adapter.out.persistence.EmailTokenJpaEntity;
import com.example.hotdealverse.user.domain.EmailToken;
import org.springframework.stereotype.Component;

@Component
public class EmailTokenMapper {

    public static EmailToken convertEntityToEmailToken(EmailTokenJpaEntity emailTokenJpaEntity) {

        return EmailToken.builder()
                .token(emailTokenJpaEntity.getToken())
                .email(emailTokenJpaEntity.getEmail())
                .id(emailTokenJpaEntity.getId())
                .user(UserMapper.convertEntityToUser(emailTokenJpaEntity.getUser()))
                .build();
    }

}
