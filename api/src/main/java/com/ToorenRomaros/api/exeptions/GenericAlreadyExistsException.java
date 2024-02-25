package com.ToorenRomaros.api.exeptions;

public class GenericAlreadyExistsException extends RuntimeException {

    private static final long serialVersionUID = 1L;
    private final String errMsgKey;
    private final String errorCode;

    public GenericAlreadyExistsException(ErrorCode code) {
        super(code.getErrMsgKey());
        this.errMsgKey = code.getErrMsgKey();
        this.errorCode = code.getErrCode();
    }

    public GenericAlreadyExistsException(final String message) {
        super(message);
        this.errMsgKey = ErrorCode.CONSTRAINT_VIOLATION_EXCEPTION.getErrMsgKey();
        this.errorCode = ErrorCode.CONSTRAINT_VIOLATION_EXCEPTION.getErrCode();
    }

    public String getErrMsgKey() {
        return errMsgKey;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
