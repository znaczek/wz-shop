package com.znaczek5.wzshop.specification;

import lombok.ToString;

@ToString
public enum FilterOperation {

  EQUAL("eq"),
  NOT_EQUAL("neq"),
  GREATER_THAN("gt"),
  GREATER_THAN_OR_EQUAL("gte"),
  LESS_THAN("lt"),
  LESS_THAN_OR_EQUAL("lte"),
  IN("in"),
  NOT_IN("nin"),
  BETWEEN("btw"),
  CONTAINS("like");

  private String value;

  FilterOperation(String value) {
    this.value = value;
  }

  public static FilterOperation fromValue(String value) {
    for (FilterOperation operation : FilterOperation.values()) {

      // Case insensitive operation name
      if (String.valueOf(operation.value).equalsIgnoreCase(value)) {
        return operation;
      }
    }
    throw new IllegalArgumentException("Filter operation provided: " + value + " is not valid");
  }


}
