package com.example.footballwebproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
    /* 400 BAD_REQUEST : 잘못된 요청 */
    INVALID_TOKEN(BAD_REQUEST, "토큰이 유효하지 않습니다"),
    NOT_PROPER_USERNAME(BAD_REQUEST, "아이디는 {우리가 만들 정규식}이어야 합니다."),
    NOT_PROPER_PASSWORD(BAD_REQUEST, "비밀번호는 {우리가 만들 정규식}이어야 합니다."),
    NOT_SAME_PASSWORD(BAD_REQUEST, "비밀번호 확인과 일치하지 않습니다."),
    DUPLICATED_USERNAME(BAD_REQUEST, "중복된 아이디입니다."),

    /* 403 FORBIDDEN : 권한 없음 */
    USER_NOT_FOUND(FORBIDDEN, "등록된 사용자가 없습니다"),
//    POST_NOT_FOUND(NOT_FOUND, "선택한 게시물을 찾을 수 없습니다."),
//    COMMENT_NOT_FOUND(NOT_FOUND, "선택한 댓글을 찾을 수 없습니다."),

    ;

    private final HttpStatus httpStatus;
    private final String detail;
}

// api 명세서에서는 400으로 모든에러 처리하고, 토큰 권한 검증만