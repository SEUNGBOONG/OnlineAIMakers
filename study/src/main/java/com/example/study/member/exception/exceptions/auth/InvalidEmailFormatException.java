package com.example.study.member.exception.exceptions.auth;

import com.example.study.member.exception.exceptions.MemberErrorCode;
import com.example.study.member.exception.exceptions.MemberException;

public class InvalidEmailFormatException extends MemberException {
    public InvalidEmailFormatException() {
        super(MemberErrorCode.INVALID_EMAIL);
    }
}
