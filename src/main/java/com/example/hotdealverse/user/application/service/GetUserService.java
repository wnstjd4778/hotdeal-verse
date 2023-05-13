package com.example.hotdealverse.user.application.service;

import com.example.hotdealverse.user.adapter.in.web.dto.req.PatchEmailReqDto;
import com.example.hotdealverse.user.application.port.in.GetUserQuery;
import com.example.hotdealverse.user.application.port.in.UserUseCase;
import com.example.hotdealverse.user.application.port.out.EmailTokenPort;
import com.example.hotdealverse.user.application.port.out.GetUserPort;
import com.example.hotdealverse.user.application.port.out.UserPort;
import com.example.hotdealverse.user.domain.EmailToken;
import com.example.hotdealverse.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetUserService implements GetUserQuery, UserUseCase {

    private final GetUserPort getUserPort;
    private final UserPort userPort;
    private final EmailTokenPort emailTokenPort;
    private final RabbitTemplate rabbitTemplate;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.list[1].key}")
    private String key2;


    @Override
    public User getUser(Long userId) {
        return getUserPort.getUser(userId);
    }


    @Override
    public void sendMailToEmail(Long userId, PatchEmailReqDto patchEmailReqDto) {
        EmailToken emailToken = this.emailTokenPort.sendMailToEmail(userId, patchEmailReqDto);
        this.rabbitTemplate.convertAndSend(exchange, key2, emailToken);
    }

    @Override
    public void verifyAndUpdateEmail(String email, String token) {
        this.emailTokenPort.verifyAndUpdateEmail(email, token);
    }
}
