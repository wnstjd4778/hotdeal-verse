package com.example.hotdealverse.user.adapter.in.web.controller;

import com.example.hotdealverse.common.aop.Authenticated;
import com.example.hotdealverse.common.aop.CurrentUser;
import com.example.hotdealverse.common.payload.ApiBaseResponse;
import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import com.example.hotdealverse.user.adapter.in.web.dto.req.PatchEmailReqDto;
import com.example.hotdealverse.user.application.port.in.GetUserQuery;
import com.example.hotdealverse.user.application.port.in.UserUseCase;
import com.example.hotdealverse.user.domain.User;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final GetUserQuery getUserQuery;
    private final UserUseCase userUseCase;

    @Operation(summary = "토큰을 통한 사용자 정보 조회")
    @Authenticated
    @GetMapping("user/me")
    public ResponseEntity<ApiBaseResponse> getMe(
            @CurrentUser UserPrincipal userPrincipal
    ) {
        User user = this.getUserQuery.getUser(userPrincipal.getId());
        ApiBaseResponse apiBaseResponse = new ApiBaseResponse(user);
        return new ResponseEntity<>(apiBaseResponse, HttpStatus.OK);
    }

    @Operation(summary = "이메일 설정")
    @PutMapping("user/email")
    @Authenticated
    public ResponseEntity patchEmail(
            @CurrentUser UserPrincipal userPrincipal,
            @RequestBody() PatchEmailReqDto patchEmailReqDto
    ) {
        this.userUseCase.patchEmail(userPrincipal.getId(), patchEmailReqDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

}
