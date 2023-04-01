package com.christianosorio.eagle.exception;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public abstract class AbstractServiceException extends RuntimeException {
    private final String code;
    private final ErrorMessage errorMessage;

    protected AbstractServiceException(final String exceptionMessage,
                                       final Throwable cause,
                                       final String code,
                                       final String errorMessagePropertyKey,
                                       final Object[] errorMessagePropertyArgs) {
        super(exceptionMessage, cause);
        this.code = code;
        this.errorMessage = new ErrorMessage(errorMessagePropertyKey, errorMessagePropertyArgs);
    }
}
