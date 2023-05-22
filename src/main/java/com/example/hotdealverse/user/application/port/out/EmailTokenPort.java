package com.example.hotdealverse.user.application.port.out;

import com.example.hotdealverse.user.adapter.dto.req.PatchEmailReqDto;
import com.example.hotdealverse.user.domain.EmailToken;

public interface EmailTokenPort {
    EmailToken sendMailToEmail(Long userId, PatchEmailReqDto patchEmailReqDto);

    void verifyAndUpdateEmail(String email, String token);
}
