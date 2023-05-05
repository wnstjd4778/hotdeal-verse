package com.example.hotdealverse.user.application.service;

import com.example.hotdealverse.user.adapter.in.web.dto.req.PatchEmailReqDto;
import com.example.hotdealverse.user.application.port.in.GetUserQuery;
import com.example.hotdealverse.user.application.port.in.UserUseCase;
import com.example.hotdealverse.user.application.port.out.GetUserPort;
import com.example.hotdealverse.user.application.port.out.UserPort;
import com.example.hotdealverse.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GetUserService implements GetUserQuery, UserUseCase {

    private final GetUserPort getUserPort;
    private final UserPort userPort;

    @Override
    public User getUser(Long userId) {
        return getUserPort.getUser(userId);
    }


    @Override
    public void patchEmail(Long userId, PatchEmailReqDto patchEmailReqDto) {
        this.userPort.patchEmail(userId, patchEmailReqDto);
    }
}
