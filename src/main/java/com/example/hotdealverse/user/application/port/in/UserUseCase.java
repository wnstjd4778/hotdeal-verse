package com.example.hotdealverse.user.application.port.in;

import com.example.hotdealverse.user.adapter.in.web.dto.req.PatchEmailReqDto;

public interface UserUseCase {

    void patchEmail(Long userId, PatchEmailReqDto patchEmailReqDto);
}
