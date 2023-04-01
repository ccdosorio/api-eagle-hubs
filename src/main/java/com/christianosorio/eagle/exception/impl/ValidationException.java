package com.christianosorio.eagle.exception.impl;

import com.christianosorio.eagle.exception.AbstractServiceException;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@ToString(callSuper = true)
public class ValidationException extends AbstractServiceException {
    private static final String CODE = "eagle-002";
    private static final String ERROR_MESSAGE_KEY = "global.error.validation-exception-message";

    @Getter
    private final List<ValidationError> validationErrors;

    private ValidationException(final String exceptionMessage,
                                final Throwable cause,
                                final List<ValidationError> validationErrors) {
        super(exceptionMessage, cause, CODE, ERROR_MESSAGE_KEY, null);
        this.validationErrors = validationErrors;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private String exceptionMessage;
        private List<ValidationError> validationErrors;

        private Builder() {
        }

        public Builder exceptionMessage(final String exceptionMessage) {
            this.exceptionMessage = exceptionMessage;
            return this;
        }

        public Builder addValidationError(final String path, final String errorMessageCode, final Object... args) {
            if (validationErrors == null) {
                validationErrors = new ArrayList<>();
            }

            final ValidationError validationError = new ValidationError(path, errorMessageCode, args);
            validationErrors.add(validationError);
            return this;
        }

        public Builder addValidationErrors(final List<ValidationError> validationErrors) {
            if (this.validationErrors == null) {
                this.validationErrors = new ArrayList<>();
            }

            this.validationErrors.addAll(validationErrors);
            return this;
        }

        public ValidationException build() {
            return new ValidationException(exceptionMessage, null, validationErrors);
        }
    }
}