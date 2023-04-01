package com.christianosorio.eagle.exception.handler;

import com.christianosorio.eagle.exception.AbstractServiceException;
import com.christianosorio.eagle.exception.ErrorMessage;
import com.christianosorio.eagle.exception.impl.ForbiddenException;
import com.christianosorio.eagle.exception.impl.InternalServerException;
import com.christianosorio.eagle.exception.impl.ResourceNotFoundException;
import com.christianosorio.eagle.exception.impl.ServiceUnavailableException;
import com.christianosorio.eagle.exception.impl.UnauthorizedException;
import com.christianosorio.eagle.exception.impl.ValidationError;
import com.christianosorio.eagle.exception.impl.ValidationException;
import com.christianosorio.eagle.exception.resource.ErrorItemResource;
import com.christianosorio.eagle.exception.resource.ErrorMessageResource;
import com.christianosorio.eagle.exception.service.MessageSourceService;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

import static java.util.stream.Collectors.toList;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;
import static org.springframework.http.HttpStatus.SERVICE_UNAVAILABLE;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.HttpStatus.UNPROCESSABLE_ENTITY;
import static org.springframework.http.HttpStatus.FORBIDDEN;

@Slf4j
@ControllerAdvice
public class ServiceExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSourceService messageSourceService;

    private static final String ACCESS_DENIED_EXCEPTION_CODE = "eagle-004";
    private static final String ACCESS_DENIED_EXCEPTION_MESSAGE_CODE = "global.error.access-denied";
    private static final String UNAUTHORIZED_EXCEPTION_CODE = "eagle-006";
    private static final String UNAUTHORIZED_EXCEPTION_MESSAGE_CODE = "global.error.unauthorized";

    public ServiceExceptionHandler(final MessageSourceService messageSourceService) {
        this.messageSourceService = messageSourceService;
    }

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<ErrorMessageResource> handleNotFoundException(final AbstractServiceException exception) {
        log.debug("Resource not found exception has been thrown. " + exception, exception);

        final ErrorMessageResource errorMessageResource = getErrorMessageResource(exception);

        return getResponseEntity(NOT_FOUND, errorMessageResource);
    }

    @ExceptionHandler({ValidationException.class})
    public ResponseEntity<ErrorMessageResource> handleValidationExceptions(final ValidationException exception) {
        log.debug("Validation exception has been thrown. " + exception, exception);

        final ErrorMessageResource errorMessageResource = getErrorMessageResourceWithItems(exception);

        return getResponseEntity(UNPROCESSABLE_ENTITY, errorMessageResource);
    }

    @ExceptionHandler({InternalServerException.class})
    public ResponseEntity<ErrorMessageResource> handleInternalServerError(final InternalServerException exception) {
        log.error("Fatal exception has been thrown. " + exception, exception);

        final ErrorMessageResource errorMessageResource = getErrorMessageResource(exception);

        return getResponseEntity(
                INTERNAL_SERVER_ERROR,
                errorMessageResource);
    }

    @ExceptionHandler({ForbiddenException.class})
    public ResponseEntity<ErrorMessageResource> handleForbiddenException(final ForbiddenException exception) {
        log.warn("ForbiddenException has been thrown. " + exception, exception);

        final ErrorMessageResource errorMessageResource = getErrorMessageResource(ACCESS_DENIED_EXCEPTION_CODE,
                ACCESS_DENIED_EXCEPTION_MESSAGE_CODE, null);

        return getResponseEntity(FORBIDDEN,
                errorMessageResource);
    }

    @ExceptionHandler({ServiceUnavailableException.class})
    public ResponseEntity<ErrorMessageResource> handleServiceUnavailableException(final ServiceUnavailableException exception) {
        log.error("Fatal exception has been thrown. " + exception, exception);

        final ErrorMessageResource errorMessageResource = getErrorMessageResource(exception);

        return getResponseEntity(SERVICE_UNAVAILABLE,
                errorMessageResource);
    }

    @ExceptionHandler({UnauthorizedException.class})
    public ResponseEntity<ErrorMessageResource> handleUnauthorizedException(final UnauthorizedException exception) {
        log.warn("UnauthorizedException has been thrown. " + exception, exception);

        final ErrorMessageResource errorMessageResource = getErrorMessageResource(UNAUTHORIZED_EXCEPTION_CODE,
                UNAUTHORIZED_EXCEPTION_MESSAGE_CODE, null);

        return getResponseEntity(UNAUTHORIZED,
                errorMessageResource);
    }

    @ExceptionHandler({ExpiredJwtException.class})
    public ResponseEntity<ErrorMessageResource> handleExpiredJwtException() {
        final ErrorMessageResource errorMessageResource = getErrorMessageResource(UNAUTHORIZED_EXCEPTION_CODE,
                UNAUTHORIZED_EXCEPTION_MESSAGE_CODE, null);

        return getResponseEntity(FORBIDDEN,
                errorMessageResource);
    }

    public ErrorMessageResource getErrorMessageResourceWithItems(final ValidationException validationException) {
        final ErrorMessageResource errorMessageResource = getErrorMessageResource(validationException);
        final List<ValidationError> validationErrors = validationException.getValidationErrors();

        if (validationErrors == null || validationErrors.isEmpty()) {
            return errorMessageResource;
        }

        errorMessageResource.setErrors(validationErrors.stream()
                .map(this::getErrorItemResource)
                .collect(toList()));

        return errorMessageResource;
    }

    private ResponseEntity<ErrorMessageResource> getResponseEntity(final HttpStatus httpStatus,
                                                                   final ErrorMessageResource errorMessageResource) {
        return ResponseEntity
                .status(httpStatus)
                .body(errorMessageResource);
    }

    private ErrorMessageResource getErrorMessageResource(final AbstractServiceException abstractServiceException) {
        final ErrorMessage errorMessage = abstractServiceException.getErrorMessage();
        return getErrorMessageResource(abstractServiceException.getCode(), errorMessage.getCode(), errorMessage.getArgs());
    }

    private ErrorMessageResource getErrorMessageResource(final String code, final String messageCode, final Object[] args) {
        final String message = messageSourceService.getMessage(messageCode, args);

        return ErrorMessageResource.builder()
                .code(code)
                .message(message)
                .build();
    }

    private ErrorItemResource getErrorItemResource(final ValidationError validationError) {
        final ErrorMessage errorMessage = validationError.getErrorMessage();
        final String messageCode = errorMessage.getCode();
        final String validationMessage = messageSourceService.getMessage(messageCode, errorMessage.getArgs());

        return new ErrorItemResource(validationError.getPath(), validationMessage);
    }

}
