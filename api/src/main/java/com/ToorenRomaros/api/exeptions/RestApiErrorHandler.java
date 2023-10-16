package com.ToorenRomaros.api.exeptions;

import com.fasterxml.jackson.core.JsonParseException;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.MethodNotAllowedException;

@ControllerAdvice
public class RestApiErrorHandler {
    @Value("${keycloak.tokenurl}")
    private String TOKEN_URL;
    private final MessageSource messageSource;
    @Autowired
    public RestApiErrorHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    //TODO mapping exception
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Error> handleException(HttpServletRequest request, Exception ex,
                                                 Locale locale) {
        Error error = ErrorUtils
                .createError(ErrorCode.GENERIC_ERROR.getErrMsgKey(), ErrorCode.GENERIC_ERROR.getErrCode(),
                        HttpStatus.INTERNAL_SERVER_ERROR.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMediaTypeNotSupportedException.class)
    public ResponseEntity<Error> handleHttpMediaTypeNotSupportedException(HttpServletRequest request,
                                                                          HttpMediaTypeNotSupportedException ex,
                                                                          Locale locale) {
        Error error = ErrorUtils
                .createError(ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrMsgKey(),
                        ErrorCode.HTTP_MEDIATYPE_NOT_SUPPORTED.getErrCode(),
                        HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<Error> handleAuthenticationException(
            HttpServletRequest request,
            AuthenticationException ex,
            Locale locale) {
        String errorMsg = "";
        if (ex instanceof InsufficientAuthenticationException) {
            errorMsg = ex.getMessage();
        } else {
            errorMsg = ErrorCode.UNAUTHORIZED.getErrMsgKey();
        }
        Error error = ErrorUtils
                .createError(errorMsg, ErrorCode.UNAUTHORIZED.getErrCode(),
                        HttpStatus.UNAUTHORIZED.value()).setUrl(TOKEN_URL)
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<Error> handleAccessDeniedException(
            HttpServletRequest request,
            AccessDeniedException ex,
            Locale locale) {
        //InvalidRefreshTokenException
        String errorMsg = String.format("%s %s",ErrorCode.ACCESS_DENIED.getErrMsgKey(), ex.getMessage());
        Error error = ErrorUtils
                .createError(errorMsg, ErrorCode.ACCESS_DENIED.getErrCode(),
                        HttpStatus.FORBIDDEN.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler(HttpMessageNotWritableException.class)
    public ResponseEntity<Error> handleHttpMessageNotWritableException(HttpServletRequest request,
                                                                       HttpMessageNotWritableException ex,
                                                                       Locale locale) {
        Error error = ErrorUtils
                .createError(ErrorCode.HTTP_MESSAGE_NOT_WRITABLE.getErrMsgKey(),
                        ErrorCode.HTTP_MESSAGE_NOT_WRITABLE.getErrCode(),
                        HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMediaTypeNotAcceptableException.class)
    public ResponseEntity<Error> handleHttpMediaTypeNotAcceptableException(HttpServletRequest request,
                                                                           HttpMediaTypeNotAcceptableException ex,
                                                                           Locale locale) {
        Error error = ErrorUtils
                .createError(ErrorCode.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE.getErrMsgKey(),
                        ErrorCode.HTTP_MEDIA_TYPE_NOT_ACCEPTABLE.getErrCode(),
                        HttpStatus.UNSUPPORTED_MEDIA_TYPE.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<Error> handleHttpMessageNotReadableException(HttpServletRequest request,
                                                                       HttpMessageNotReadableException ex,
                                                                       Locale locale) {
        Error error = ErrorUtils
                .createError(ErrorCode.HTTP_MESSAGE_NOT_READABLE.getErrMsgKey(),
                        ErrorCode.HTTP_MESSAGE_NOT_READABLE.getErrCode(),
                        HttpStatus.NOT_ACCEPTABLE.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(JsonParseException.class)
    public ResponseEntity<Error> handleJsonParseException(HttpServletRequest request,
                                                          JsonParseException ex,
                                                          Locale locale) {
        Error error = ErrorUtils
                .createError(ErrorCode.JSON_PARSE_ERROR.getErrMsgKey(),
                        ErrorCode.JSON_PARSE_ERROR.getErrCode(),
                        HttpStatus.NOT_ACCEPTABLE.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleMethodArgumentNotValidException(HttpServletRequest request,
                                                                                           MethodArgumentNotValidException ex,
                                                                                           Locale locale) {
        List<String> errors = ex.getBindingResult().getFieldErrors()
                .stream().map(FieldError::getDefaultMessage).collect(Collectors.toList());


        return new ResponseEntity<>(getErrorsMap(errors, request), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    private Map<String, List<String>> getErrorsMap(List<String> errors, HttpServletRequest request) {
        Map<String, List<String>> errorResponse = new HashMap<>();
        Error error = ErrorUtils
                .createError(ErrorCode.METHOD_ARGUMENT_NOT_VALUD.getErrMsgKey(),
                        ErrorCode.METHOD_ARGUMENT_NOT_VALUD.getErrCode(),
                        HttpStatus.BAD_REQUEST.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());

        errorResponse.put("errors", errors);
        errorResponse.put("info", List.of(error.getErrorCode(), error.getMessage(), error.getStatus().toString(), error.getUrl(), error.getTimestamp().toString()));
        return errorResponse;
    }

    @ExceptionHandler(MethodNotAllowedException.class)
    public ResponseEntity<Error> handleMethodNotAllowedException(
            HttpServletRequest request,
            MethodNotAllowedException ex,
            Locale locale) {
        Error error = ErrorUtils
                .createError(String
                                .format("%s. Supported methods: %s", ex.getMessage(), ex.getSupportedMethods()),
                        ErrorCode.HTTP_REQUEST_METHOD_NOT_SUPPORTED.getErrCode(),
                        HttpStatus.METHOD_NOT_ALLOWED.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.METHOD_NOT_ALLOWED);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Error> handleIllegalArgumentException(
            HttpServletRequest request,
            IllegalArgumentException ex,
            Locale locale) {
        Error error = ErrorUtils
                .createError(String
                                .format("%s %s", ErrorCode.ILLEGAL_ARGUMENT_EXCEPTION.getErrMsgKey(), ex.getMessage()),
                        ErrorCode.ILLEGAL_ARGUMENT_EXCEPTION.getErrCode(),
                        HttpStatus.BAD_REQUEST.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<Error> handleDataIntegrityViolationException(
            HttpServletRequest request,
            DataIntegrityViolationException ex,
            Locale locale) {
        Error error = ErrorUtils
                .createError(String
                                .format("%s %s", ErrorCode.CONSTRAINT_VIOLATION_EXCEPTION.getErrMsgKey(), ex.getRootCause()),
                        ErrorCode.CONSTRAINT_VIOLATION_EXCEPTION.getErrCode(),
                        HttpStatus.BAD_REQUEST.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    /**
     * Custom Exceptions
     */
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<Error> handleUserNotFoundException(HttpServletRequest request,
                                                             UserNotFoundException ex,
                                                             Locale locale){
        Error error = ErrorUtils.createError(
                        String.format("%s %s", ErrorCode.USER_NOT_FOUND.getErrMsgKey(), ex.getMessage()),
                        ex.getErrorCode(),
                        HttpStatus.NOT_FOUND.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(GenericAlreadyExistsException.class)
    public ResponseEntity<Error> handleGenericAlreadyExistsException(HttpServletRequest request,
                                                                     GenericAlreadyExistsException ex, Locale locale) {
        Error error = ErrorUtils
                .createError(
                        String
                                .format("%s %s", ErrorCode.GENERIC_ALREADY_EXISTS.getErrMsgKey(), ex.getMessage()),
                        ex.getErrorCode(),
                        HttpStatus.NOT_ACCEPTABLE.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_ACCEPTABLE);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Error> handleResourceNotFoundException(HttpServletRequest request,
                                                                 ResourceNotFoundException ex, Locale locale) {
        Error error = ErrorUtils
                .createError(
                        String.format("%s %s", ErrorCode.RESOURCE_NOT_FOUND.getErrMsgKey(), ex.getMessage()),
                        ex.getErrorCode(),
                        HttpStatus.NOT_FOUND.value()).setUrl(request.getRequestURL().toString())
                .setReqMethod(request.getMethod())
                .setTimestamp(Instant.now());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
