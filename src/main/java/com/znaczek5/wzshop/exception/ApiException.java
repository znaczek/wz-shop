package com.znaczek5.wzshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApiException extends RuntimeException {
  private final ApiErrorCode errorCode;
  private final Map<String, String> errorPayload;

  public ApiException(String message) {
    this(message, null, null);
  }

  public ApiException(String message, ApiErrorCode errorCode) {
    this(message, errorCode, null);
  }

  public ApiException(String message, ApiErrorCode errorCode, Map<String, String> errorPayload) {
    super(message);
    this.errorCode = errorCode;
    this.errorPayload = errorPayload;
  }

  Map<String, Object> getErrorAttributes(WebRequest request, boolean includeStackTrace) {
    ErrorAttributes errorAttributes = new ErrorAttributes();
    return errorAttributes.getErrorAttributes(request, getStatus(), errorCode, errorPayload, includeStackTrace);
  }

  HttpStatus getStatus() {
    return getClass().getAnnotation(ResponseStatus.class).value();
  }

}
