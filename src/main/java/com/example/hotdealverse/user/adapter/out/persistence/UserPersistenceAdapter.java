package com.example.hotdealverse.user.adapter.out.persistence;

import com.example.hotdealverse.user.application.port.out.GetUserPort;
import com.example.hotdealverse.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements GetUserPort {

    private final UserRepository userRepository;

    @Override
    public User getUser(long userId) {

        Optional<UserJpaEntity> optionalUserJpaEntity
                = this.userRepository.findById(userId);

        if (optionalUserJpaEntity.isPresent()) {
            UserJpaEntity userJpaEntity = optionalUserJpaEntity.get();
            return UserMapper.converEntityToUser(userJpaEntity);
        }

        return null;
    }
}
