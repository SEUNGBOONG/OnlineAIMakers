package com.example.study.member.ui.auth.dto;

public record LoginResponse(
        String token,
        Long memberId,
        String memberName,
        String memberNickName
) {
}