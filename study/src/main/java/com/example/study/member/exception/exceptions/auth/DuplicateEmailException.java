package com.example.study.member.exception.exceptions.auth;

import com.example.study.member.exception.exceptions.MemberErrorCode;
import com.example.study.member.exception.exceptions.MemberException;

public class DuplicateEmailException extends MemberException {

    public DuplicateEmailException() {
        super(MemberErrorCode.DUPLICATED_EMAIL);
    }
}
