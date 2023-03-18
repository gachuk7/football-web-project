package com.example.footballwebproject.exception;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;

@Getter
@Builder
public class ApiExceptionResponse {
    private final LocalDateTime localDateTime = LocalDateTime.now();
    private final int status;
    private String message;

    public static ResponseEntity<ApiExceptionResponse> toResponseEntity(ExceptionEnum e) {
        return ResponseEntity
                .status(e.getHttpStatus())
                .body(ApiExceptionResponse.builder()
                        .status(e.getHttpStatus().value())
                        .message(e.getDetail())
                        .build()
                );
    }

}
