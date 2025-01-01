package com.example.study.member.ui.auth.dto;

public record LoginRequest(
        String memberEmail,
        String memberPassword
) {
}
