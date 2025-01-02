package com.example.study.common.exception;

public class NotSamePasswordChangeException extends RuntimeException {
    public NotSamePasswordChangeException() {
        super("비밀번호가 이전과 동일합니다.");
    }
}
