package com.example.hotdealverse.user.application.port.out;

import com.example.hotdealverse.user.adapter.in.web.dto.req.PatchEmailReqDto;

public interface UserPort {

    void patchEmail(Long userId, PatchEmailReqDto patchEmailReqDto);
}
