package com.example.footballwebproject.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionController {

    @ExceptionHandler
    protected ResponseEntity handleCustomException(ExceptionEnum e) {
        return ResponseEntity.status(e.getHttpStatus()).body(new ErrorResult(
                e.getHttpStatus().value(),
                e.getHttpStatus(),
                e.getDetail() // (토) reseult에서 api대로 수정하고 수정한대로 맞춰주기
        ));
    }
}


//
