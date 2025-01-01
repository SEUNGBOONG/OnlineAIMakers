package com.example.study.member.ui.auth.dto;

public record SignUpRequest(
        String memberEmail,
        String memberName,
        String memberPassword,
        String memberNickName,
        int annualIncome
) {
}
