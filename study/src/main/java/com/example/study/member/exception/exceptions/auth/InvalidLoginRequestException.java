package com.example.study.member.exception.exceptions.auth;


import com.example.study.member.exception.exceptions.MemberErrorCode;
import com.example.study.member.exception.exceptions.MemberException;

public class InvalidLoginRequestException extends MemberException {
    public InvalidLoginRequestException() {
        super(MemberErrorCode.INVALID_LOGIN_REQUEST);
    }
}
