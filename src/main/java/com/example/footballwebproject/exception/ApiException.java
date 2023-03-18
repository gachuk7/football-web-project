package com.example.footballwebproject.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ApiException extends RuntimeException{
    private final ExceptionEnum exceptionEnum;
}
