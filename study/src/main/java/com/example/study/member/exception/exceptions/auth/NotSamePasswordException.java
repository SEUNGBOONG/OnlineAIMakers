package com.example.study.member.exception.exceptions.auth;


import com.example.study.member.exception.exceptions.MemberErrorCode;
import com.example.study.member.exception.exceptions.MemberException;

public class NotSamePasswordException extends MemberException {

    public NotSamePasswordException() {
        super(MemberErrorCode.NOT_SAME_PASSWORD);
    }
}
