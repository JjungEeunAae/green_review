package com.catdog.care.exception;

import lombok.Getter;

@Getter
public class EmpExcption extends RuntimeException{
    private ErrorCode errorCode;

    public EmpExcption(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }
}
