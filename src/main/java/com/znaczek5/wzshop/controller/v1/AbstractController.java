package com.znaczek5.wzshop.controller.v1;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

class AbstractController {
  private static final String VERSION = "/v1";
  static final String MODULE = VERSION + "/product";
  static final String CATEGORY = VERSION + "/category";

  private static final String RESPONSE_HEADER_TOTAL_COUNT = "X-Total-Count";
  static final String DEFAULT_SORT = "createdDate";

  @Autowired
  ModelMapper modelMapper;

  <T> ResponseEntity<List<T>> getListResponse(Page<T> page) {
    return getListResponse(page.getTotalElements(), page.getContent());
  }

  private <T> ResponseEntity<List<T>> getListResponse(long totalCount, List<T> listData) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.add(RESPONSE_HEADER_TOTAL_COUNT, String.valueOf(totalCount));
    return new ResponseEntity<>(listData, httpHeaders, HttpStatus.OK);
  }
}
