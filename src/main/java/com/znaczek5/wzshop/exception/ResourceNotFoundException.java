package com.znaczek5.wzshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends ApiException {

  public ResourceNotFoundException(String resourceName, String resourceKey) {
    super("Resource not found", ApiErrorCode.RESOURCE_NOT_FOUND, Map.of("resouceName", resourceName, "resourceKey", resourceKey));
  }

}
