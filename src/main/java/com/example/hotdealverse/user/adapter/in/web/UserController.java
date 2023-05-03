package com.example.hotdealverse.user.adapter.in.web;

import com.example.hotdealverse.common.aop.Authenticated;
import com.example.hotdealverse.common.aop.CurrentUser;
import com.example.hotdealverse.common.payload.ApiBaseResponse;
import com.example.hotdealverse.common.security.jwt.UserPrincipal;
import com.example.hotdealverse.user.application.port.in.GetUserQuery;
import com.example.hotdealverse.user.domain.User;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "user")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final GetUserQuery getUserQuery;

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

    @PostMapping("/aaaa")
    public ResponseEntity test(

    ) {
        return new ResponseEntity<>("", HttpStatus.OK);
    }

}
