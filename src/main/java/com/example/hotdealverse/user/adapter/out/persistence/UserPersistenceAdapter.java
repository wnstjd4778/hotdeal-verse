package com.example.hotdealverse.user.adapter.out.persistence;

import com.example.hotdealverse.common.util.PersistenceAdapter;
import com.example.hotdealverse.user.application.port.out.GetUserPort;
import com.example.hotdealverse.user.domain.User;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
@PersistenceAdapter
public class UserPersistenceAdapter implements GetUserPort {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public User getUser(long userId) {

        Optional<UserJpaEntity> optionalUserJpaEntity
                = this.userRepository.findById(userId);

        if(optionalUserJpaEntity.isPresent()) {
            UserJpaEntity userJpaEntity = optionalUserJpaEntity.get();
            return userMapper.mapToDomainEntity(userJpaEntity);
        }

        return null;
    }
}
