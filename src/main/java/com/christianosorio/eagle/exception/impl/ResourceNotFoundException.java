package com.christianosorio.eagle.exception.impl;

import com.christianosorio.eagle.exception.AbstractServiceException;
import lombok.ToString;

@ToString(callSuper = true)
public class ResourceNotFoundException extends AbstractServiceException {
    private static final String CODE = "eagle-001";

    private ResourceNotFoundException(final String exceptionMessage,
                                      final Throwable cause,
                                      final String errorMessagePropertyKey,
                                      final Object[] errorMessagePropertyArgs) {
        super(exceptionMessage, cause, CODE, errorMessagePropertyKey, errorMessagePropertyArgs);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String exceptionMessage;
        private String errorMessagePropertyKey;
        private Object[] errorMessagePropertyArgs;

        private Builder() {
        }

        public Builder exceptionMessage(final String exceptionMessage) {
            this.exceptionMessage = exceptionMessage;
            return this;
        }

        public Builder displayMessage(final String errorMessagePropertyKey,
                                      final Object... errorMessagePropertyArgs) {
            this.errorMessagePropertyKey = errorMessagePropertyKey;
            this.errorMessagePropertyArgs = errorMessagePropertyArgs;

            return this;
        }

        public ResourceNotFoundException build() {
            return new ResourceNotFoundException(exceptionMessage, null, errorMessagePropertyKey, errorMessagePropertyArgs);
        }
    }
}