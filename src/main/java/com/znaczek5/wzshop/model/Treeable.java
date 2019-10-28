package com.znaczek5.wzshop.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

public interface Treeable<T, K extends Treeable<T, K>> {

  @NotNull
  T getKey();

  @Null
  T getParentKey();

}
