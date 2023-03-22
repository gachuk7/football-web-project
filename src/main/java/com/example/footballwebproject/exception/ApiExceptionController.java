package com.example.footballwebproject.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionController {

    @ExceptionHandler(value = {ApiException.class})
    protected ResponseEntity handleCustomException(ApiException e) {
        ExceptionEnum exceptionEnum = e.getExceptionEnum();
        return ResponseEntity.status(exceptionEnum.getHttpStatus()).body(new ApiExceptionResponse(
                exceptionEnum.getHttpStatus().value(),
                exceptionEnum.getDetail()
        ));
    }
}


//
