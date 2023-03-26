package com.example.hotdealverse.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 400 BAD_REQUEST
    INVALID_REFRESH_TOKEN(HttpStatus.BAD_REQUEST, "리프레시 토큰이 유효하지 않습니다"),
    OAUTH2_AUTHENTICATION_PROCESSING_FAILED(HttpStatus.BAD_REQUEST, "해당 프로바이더로 oauth2에 로그인할 수 없습니다."),

    // 403 Forbidden
    TOKEN_NOT_INVALID(HttpStatus.FORBIDDEN, "토큰이 유효하지 않습니다."),
    KEYWORD_NOT_ACCESS(HttpStatus.FORBIDDEN, "해당 키워드에 접근할 수 없습니다."),

    // 404 NOT_FOUND
    KEYWORD_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 키워드를 찾을 수 없습니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 게시글을 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 유저를 찾을 수 없습니다."),

    ;

    private final HttpStatus httpStatus;
    private final String detail;
}