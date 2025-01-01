package com.example.study.member.exception.exceptions.auth;

import com.example.study.member.exception.exceptions.MemberErrorCode;
import com.example.study.member.exception.exceptions.MemberException;

public class InvalidPasswordFormatException extends MemberException {
    public InvalidPasswordFormatException(){
        super(MemberErrorCode.INVALID_PASSWORD);
    }
}
