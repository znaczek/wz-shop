package com.znaczek5.wzshop.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Map;

@RestControllerAdvice
public class RESTExceptionHandler extends ResponseEntityExceptionHandler {

  @Value("${wzs.error.print-stacktrace}")
  private boolean printStacktrace;

  @ExceptionHandler(ApiException.class)
  public ResponseEntity<Object> handleBaseAppException(ApiException e, WebRequest request) {
    return getResponseEntity(e.getStatus(), e.getErrorAttributes(request, printStacktrace));
  }

  private ResponseEntity<Object> getResponseEntity(HttpStatus status, Map<String, Object> errorAttributes) {
    return ResponseEntity
      .status(status)
      .body(errorAttributes);
  }

}
