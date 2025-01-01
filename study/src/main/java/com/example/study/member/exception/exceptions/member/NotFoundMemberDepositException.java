package com.example.study.member.exception.exceptions.member;


import com.example.study.member.exception.exceptions.MemberErrorCode;
import com.example.study.member.exception.exceptions.MemberException;

public class NotFoundMemberDepositException extends MemberException {

    public NotFoundMemberDepositException() {
        super(MemberErrorCode.NOT_FOUND_MEMBER_DEPOSIT);
    }
}
