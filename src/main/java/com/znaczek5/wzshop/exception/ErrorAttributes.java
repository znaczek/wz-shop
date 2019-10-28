package com.znaczek5.wzshop.exception;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;
import java.util.Objects;

class ErrorAttributes extends DefaultErrorAttributes {

  private static final String ERROR_CODE = "errorCode";
  private static final String ERROR_PAYLOAD = "errorPayload";

  Map<String, Object> getErrorAttributes(
    WebRequest webRequest,
    HttpStatus status,
    ApiErrorCode errorCode,
    Map<String, String> errorPayload,
    boolean includeStackTrace
  ) {
    Map<String, Object> errorAttributes = super.getErrorAttributes(webRequest, includeStackTrace);

    addStatus(errorAttributes, status);

    if (Objects.nonNull(errorCode)) {
      errorAttributes.put(ERROR_CODE, errorCode);
    }
    if (Objects.nonNull(errorPayload)) {
      errorAttributes.put(ERROR_PAYLOAD, errorPayload);
    }

    return errorAttributes;
  }

  private void addStatus(Map<String, Object> errorAttributes, HttpStatus status) {
    if (status == null) {
      errorAttributes.put("status", 999);
      errorAttributes.put("error", "None");
    } else {
      errorAttributes.put("status", status.value());

      try {
        errorAttributes.put("error", status.getReasonPhrase());
      } catch (Exception var5) {
        errorAttributes.put("error", "Http Status " + status);
      }

    }
  }

}
