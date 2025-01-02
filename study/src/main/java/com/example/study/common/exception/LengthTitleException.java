package com.example.study.common.exception;

public class LengthTitleException extends RuntimeException {
    public LengthTitleException() {
        super("길이는 10자 이하입니다.");
    }
}
