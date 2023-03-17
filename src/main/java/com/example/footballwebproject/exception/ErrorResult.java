package com.example.footballwebproject.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public class ErrorResult {
    private int status;
    private HttpStatus code;
    private String message;
}
