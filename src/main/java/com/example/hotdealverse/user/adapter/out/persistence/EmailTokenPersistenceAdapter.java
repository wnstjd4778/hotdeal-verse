package com.example.hotdealverse.user.adapter.out.persistence;

import com.example.hotdealverse.common.exception.CustomException;
import com.example.hotdealverse.common.exception.ErrorCode;
import com.example.hotdealverse.user.adapter.in.web.dto.req.PatchEmailReqDto;
import com.example.hotdealverse.user.application.port.out.EmailTokenPort;
import com.example.hotdealverse.user.domain.EmailToken;
import com.example.hotdealverse.user.mapper.EmailTokenMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class EmailTokenPersistenceAdapter implements EmailTokenPort {

    private final UserRepository userRepository;
    private final EmailTokenRepository emailTokenRepository;

    @Override
    public EmailToken sendMailToEmail(Long userId, PatchEmailReqDto patchEmailReqDto) {
        UserJpaEntity userJpaEntity = this.userRepository.findById(userId).orElseThrow(
                () -> new CustomException(ErrorCode.USER_NOT_FOUND)
        );

        EmailTokenJpaEntity emailTokenJpaEntity = EmailTokenJpaEntity.builder()
                .email(patchEmailReqDto.getEmail())
                .token(UUID.randomUUID().toString())
                .user(userJpaEntity)
                .build();

        this.emailTokenRepository.save(emailTokenJpaEntity);
        return EmailTokenMapper.convertEntityToEmailToken(emailTokenJpaEntity);
    }

    @Override
    public void verifyAndUpdateEmail(String email, String token) {
        EmailTokenJpaEntity emailTokenJpaEntity = this.emailTokenRepository.findByEmailAndToken(email, token).orElseThrow(
                () -> new CustomException(ErrorCode.EMAIL_TOKEN_NOT_FOUND)
        );

        UserJpaEntity userJpaEntity = emailTokenJpaEntity.getUser();
        userJpaEntity.setEmail(email);
        this.userRepository.save(userJpaEntity);
    }
}
