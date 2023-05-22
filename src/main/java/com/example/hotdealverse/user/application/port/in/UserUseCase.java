package com.example.hotdealverse.user.application.port.in;

import com.example.hotdealverse.user.adapter.dto.req.PatchEmailReqDto;

public interface UserUseCase {

    void sendMailToEmail(Long userId, PatchEmailReqDto patchEmailReqDto);

    void verifyAndUpdateEmail(String email, String token);
}
