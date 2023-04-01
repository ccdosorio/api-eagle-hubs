package com.christianosorio.eagle.exception.impl;

import com.christianosorio.eagle.exception.AbstractServiceException;
import lombok.ToString;

@ToString(callSuper = true)
public class UnauthorizedException extends AbstractServiceException {
    private static final String CODE = "eagle-006";
    private static final String ERROR_MESSAGE_KEY = "global.error.unauthorized";

    private UnauthorizedException(final String exceptionMessage,
                                  final Throwable cause) {
        super(exceptionMessage, cause, CODE, ERROR_MESSAGE_KEY, null);
    }
}