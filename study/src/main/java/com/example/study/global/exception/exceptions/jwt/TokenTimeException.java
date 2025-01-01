package com.example.study.global.exception.exceptions.jwt;

import com.example.study.global.exception.exceptions.CustomErrorCode;
import com.example.study.global.exception.exceptions.CustomException;

public class TokenTimeException extends CustomException {

    public TokenTimeException() {
        super(CustomErrorCode.EXPIRED_TOKEN);
    }
}
