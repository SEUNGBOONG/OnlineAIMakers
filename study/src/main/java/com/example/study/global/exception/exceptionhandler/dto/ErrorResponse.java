package com.example.study.global.exception.exceptionhandler.dto;

public record ErrorResponse(
        String customCode,
        String message
) {
}
