package com.example.hotdealverse.user.adapter.out.persistence;

import com.example.hotdealverse.common.exception.CustomException;
import com.example.hotdealverse.common.exception.ErrorCode;
import com.example.hotdealverse.user.adapter.dto.req.PatchEmailReqDto;
import com.example.hotdealverse.user.application.port.out.GetUserPort;
import com.example.hotdealverse.user.application.port.out.UserPort;
import com.example.hotdealverse.user.domain.User;
import com.example.hotdealverse.user.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserPersistenceAdapter implements GetUserPort, UserPort {

    private final UserRepository userRepository;

    @Override
    public User getUser(long userId) {

        UserJpaEntity userJpaEntity = this.userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        return UserMapper.convertEntityToUser(userJpaEntity);
    }

    @Override
    public void patchEmail(Long userId, PatchEmailReqDto patchEmailReqDto) {

        UserJpaEntity userJpaEntity = this.userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        userJpaEntity.setEmail(patchEmailReqDto.getEmail());
        this.userRepository.save(userJpaEntity);

    }
}
