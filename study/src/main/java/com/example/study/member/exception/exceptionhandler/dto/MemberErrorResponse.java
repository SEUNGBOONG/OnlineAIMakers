package com.example.study.member.exception.exceptionhandler.dto;

public record MemberErrorResponse(
        String customCode,
        String message
) {
}
