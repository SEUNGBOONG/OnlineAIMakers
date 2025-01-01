package com.example.study.member.exception.exceptions.auth;


import com.example.study.member.exception.exceptions.MemberErrorCode;
import com.example.study.member.exception.exceptions.MemberException;

public class DuplicateNickNameException extends MemberException {

    public DuplicateNickNameException() {
        super(MemberErrorCode.DUPLICATED_NICK_NAME);
    }
}
