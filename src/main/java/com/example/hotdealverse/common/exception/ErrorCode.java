package com.example.hotdealverse.common.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    // 400 BAD_REQUEST
    JWT_INVALID(HttpStatus.BAD_REQUEST, "jwt 토큰이 유효하지 않습니다."),
    REFRESH_TOKEN_INVALID(HttpStatus.BAD_REQUEST, "리프레시 토큰이 유효하지 않습니다"),
    OAUTH2_AUTHENTICATION_PROCESSING_FAILED(HttpStatus.BAD_REQUEST, "해당 프로바이더로 oauth2에 로그인할 수 없습니다."),
    EMAIL_HAS_REQUIRED(HttpStatus.BAD_REQUEST, "이메일 정보가 필요합니다."),

    // 403 Forbidden
    COMMENT_NOT_ACCESS(HttpStatus.FORBIDDEN, "해당 댓글에 접근할 수 없습니다."),
    TOKEN_NOT_INVALID(HttpStatus.FORBIDDEN, "토큰이 유효하지 않습니다."),
    KEYWORD_NOT_ACCESS(HttpStatus.FORBIDDEN, "해당 키워드에 접근할 수 없습니다."),

    // 404 NOT_FOUND
    COMMENT_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 댓글을 찾을 수 없습니다."),
    KEYWORD_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 키워드를 찾을 수 없습니다."),
    ITEM_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 아이템을 찾을 수 없습니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 유저를 찾을 수 없습니다."),

    // 412 PRECONDITION_FAILED
    JWT_EXPIRED(HttpStatus.PRECONDITION_FAILED, "엑세스 토큰이 만료되었습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String detail;
}
