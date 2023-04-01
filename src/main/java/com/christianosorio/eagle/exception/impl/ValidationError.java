package com.christianosorio.eagle.exception.impl;

import com.christianosorio.eagle.exception.ErrorMessage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class ValidationError {
    private String path;
    private ErrorMessage errorMessage;

    public ValidationError(final String path,
                           final String errorMessageCode,
                           final Object... args) {
        this.path = path;
        this.errorMessage = new ErrorMessage(errorMessageCode, args);
    }
}