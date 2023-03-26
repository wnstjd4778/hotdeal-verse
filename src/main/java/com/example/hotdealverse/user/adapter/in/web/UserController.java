package com.example.hotdealverse.user.adapter.in.web;

import com.example.hotdealverse.common.security.CurrentUser;
import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import com.example.hotdealverse.user.application.port.in.GetUserQuery;
import com.example.hotdealverse.user.domain.User;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final GetUserQuery getUserQuery;

    @Operation(summary = "토큰을 통한 사용자 정보 조회")
    @GetMapping("user/me")
    public ResponseEntity<User> getMe(
            @CurrentUser UserPrincipal userPrincipal
    ) {
        User user = this.getUserQuery.getUser(userPrincipal.getId());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }


}
