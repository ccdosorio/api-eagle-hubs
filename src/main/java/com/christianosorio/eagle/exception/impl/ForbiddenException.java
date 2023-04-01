package com.christianosorio.eagle.exception.impl;

import com.christianosorio.eagle.exception.AbstractServiceException;
import lombok.ToString;

@ToString(callSuper = true)
public class ForbiddenException extends AbstractServiceException {
    private static final String CODE = "eagle-004";
    private static final String ERROR_MESSAGE_KEY = "global.error.access-denied";

    private ForbiddenException(final String exceptionMessage,
                               final Throwable cause) {
        super(exceptionMessage, cause, CODE, ERROR_MESSAGE_KEY, null);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String exceptionMessage;

        private Builder() {
        }

        public Builder exceptionMessage(final String exceptionMessage) {
            this.exceptionMessage = exceptionMessage;
            return this;
        }

        public ForbiddenException build() {
            return new ForbiddenException(exceptionMessage, null);
        }
    }
}
