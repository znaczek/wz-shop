package com.znaczek5.wzshop.model;

public interface Tree<T extends Tree<T>> {
  public void setParent(T parent);

  public T getParent();

  public void addChild(T child);
}
