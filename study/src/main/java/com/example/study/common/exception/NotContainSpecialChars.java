package com.example.study.common.exception;

public class NotContainSpecialChars extends RuntimeException {
    public NotContainSpecialChars() {
        super("특수문자를 포함하세요");
    }
}
