package com.example.footballwebproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.*;

@Getter
@AllArgsConstructor
public enum ExceptionEnum {
    /* 400 BAD_REQUEST : 잘못된 요청 */
    NO_TOKEN(BAD_REQUEST, "토큰이 없습니다. 로그인이 필요합니다."),
    NOT_PROPER_USERNAME(BAD_REQUEST, "아이디는 {우리가 만들 정규식}이어야 합니다."),
    NOT_PROPER_PASSWORD(BAD_REQUEST, "비밀번호는 {우리가 만들 정규식}이어야 합니다."),
    NOT_SAME_PASSWORD(BAD_REQUEST, "비밀번호 확인과 일치하지 않습니다."),
    DUPLICATED_USERNAME(BAD_REQUEST, "중복된 아이디입니다."),

    /* 403 FORBIDDEN : 권한 없음 */
    INVALID_TOKEN(FORBIDDEN, "유효하지 않은 토큰입니다."),

    /* 추가 */
    USER_NOT_FOUND(NOT_FOUND,"유저를 찾을 수 없습니다."),
    GAME_NOT_FOUND(NOT_FOUND, "선택한 경기를 찾을 수 없습니다."),
    COMMENT_NOT_FOUND(NOT_FOUND, "선택한 댓글을 찾을 수 없습니다."),



    ;

    private final HttpStatus httpStatus;
    private final String detail;
}
