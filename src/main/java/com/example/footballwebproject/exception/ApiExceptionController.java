package com.example.footballwebproject.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionController {

    @ExceptionHandler(value = {ApiException.class})
    protected ResponseEntity handleCustomException(ExceptionEnum e) {
        return ResponseEntity.status(e.getHttpStatus()).body(new ApiExceptionResponse(
                e.getHttpStatus().value(),
                e.getDetail()
        ));
    }
}


//
