/*
 * Copyright (C) 2017 esgcc.com.cn - All Rights Reserved.
 */

package com.myproj.myproj.utils;

/**
 * 业务异常
 * Created by wangjinyu on 2018/11/17 10:23.
 */
public class BusinessException extends RuntimeException {
    public BusinessException() {
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
