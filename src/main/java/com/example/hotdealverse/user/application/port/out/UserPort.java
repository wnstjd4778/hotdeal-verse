package com.example.hotdealverse.user.application.port.out;

import com.example.hotdealverse.user.adapter.dto.req.PatchEmailReqDto;

public interface UserPort {

    void patchEmail(Long userId, PatchEmailReqDto patchEmailReqDto);
}
