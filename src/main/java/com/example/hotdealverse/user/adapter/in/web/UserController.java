package com.example.hotdealverse.user.adapter.in.web;

import com.example.hotdealverse.common.payload.ApiBaseResponse;
import com.example.hotdealverse.common.security.CurrentUser;
import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import com.example.hotdealverse.user.application.port.in.GetUserQuery;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final GetUserQuery getUserQuery;

    @GetMapping("user/me")
    public ResponseEntity<ApiBaseResponse> getMe(
            @CurrentUser UserPrincipal userPrincipal
    ) {
        Object data = this.getUserQuery.getUser(userPrincipal.getId());

        return ResponseEntity.ok(
                ApiBaseResponse.builder()
                        .success(true)
                        .data(data)
                        .build()
        );
    }
}
