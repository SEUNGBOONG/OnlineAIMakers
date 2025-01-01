package com.example.study.global.exception.exceptions.jwt;

import com.example.study.global.exception.exceptions.CustomErrorCode;
import com.example.study.global.exception.exceptions.CustomException;

public class NotFoundTokenException extends CustomException {

    public NotFoundTokenException() {
        super(CustomErrorCode.NOT_FIND_TOKEN);
    }
}
