package com.example.hotdealverse.user.application.service;

import com.example.hotdealverse.user.application.port.in.GetUserQuery;
import com.example.hotdealverse.user.application.port.out.GetUserPort;
import com.example.hotdealverse.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetUserService implements GetUserQuery {

    private final GetUserPort getUserPort;

    @Override
    public User getUser(Long userId) {
        return getUserPort.getUser(userId);
    }
}
