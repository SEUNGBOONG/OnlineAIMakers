package com.example.study.global.exception.exceptions;

import lombok.Getter;

@Getter
public class CustomException extends RuntimeException {

    private final CustomErrorCode customErrorCode;

    public CustomException(CustomErrorCode customErrorCode) {
        super(customErrorCode.getCustomCode() + ": " + customErrorCode.getMessage());
        this.customErrorCode = customErrorCode;
    }
}
