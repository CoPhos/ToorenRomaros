package com.ToorenRomaros.api.exeptions;

public enum ErrorCode {
    //Internal Errors: 1 to 9999
    GENERIC_ERROR("API-0001", "The system is unable to complete the request."),
    HTTP_MEDIATYPE_NOT_SUPPORTED("API-0002", "Requested media type is not supported. Please use application/json or application/xml as 'Content-Type' header value"),
    HTTP_MESSAGE_NOT_WRITABLE("API-0003", "Missing 'Accept' header. Please add 'Accept' header."),
    HTTP_MEDIA_TYPE_NOT_ACCEPTABLE("API-0004", "Requested 'Accept' header value is not supported. Please use application/json or application/xml as 'Accept' value"),
    JSON_PARSE_ERROR("API-0005", "Make sure request payload should be a valid JSON object."),
    ACCESS_DENIED("API-0006", "Access Denied."),
    UNAUTHORIZED("API-0007", "Unauthorized"),
    HTTP_MESSAGE_NOT_READABLE("API-0008", "Make sure request payload should be a valid JSON or XML object according to 'Content-Type'."),
    METHOD_ARGUMENT_NOT_VALUD("API-0009","Please verify data contraints"),
    HTTP_REQUEST_METHOD_NOT_SUPPORTED("API-0010", "Request method not supported."),
    ILLEGAL_ARGUMENT_EXCEPTION("API-0011", "Invalid data passed."),
    CONSTRAINT_VIOLATION_EXCEPTION("API-0012", "Invalid data passed."),
    IO_EXCEPTION("API-0013", "Error occured with the file."),
    /*
    * custom exceptions*/
    USER_NOT_FOUND("API-0101", "Requested user not found."),
    RESOURCE_NOT_FOUND("API-0102", "Requested resource not found."),
    GENERIC_ALREADY_EXISTS("API-0103", "Already exists.");

    

    private String errCode;
    private String errMsgKey;

    ErrorCode(final String errCode, final String errMsgKey) {
        this.errCode = errCode;
        this.errMsgKey = errMsgKey;
    }

    /**
     * @return the errCode
     */
    public String getErrCode() {
        return errCode;
    }

    /**
     * @return the errMsgKey
     */
    public String getErrMsgKey() {
        return errMsgKey;
    }
}
