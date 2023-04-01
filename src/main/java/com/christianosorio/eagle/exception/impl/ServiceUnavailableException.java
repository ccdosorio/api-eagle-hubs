package com.christianosorio.eagle.exception.impl;

import com.christianosorio.eagle.exception.AbstractServiceException;
import lombok.ToString;

@ToString(callSuper = true)
public class ServiceUnavailableException extends AbstractServiceException {
    private static final String CODE = "eagle-005";

    protected ServiceUnavailableException(final String exceptionMessage,
                                          final Throwable cause,
                                          final String errorMessagePropertyKey) {
        super(exceptionMessage, cause, CODE, errorMessagePropertyKey, null);
    }
}
