package com.znaczek5.wzshop.utils;

import com.znaczek5.wzshop.model.Tree;
import com.znaczek5.wzshop.model.Treeable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public abstract class ListToTree<T, S extends Treeable<T, S>, K extends Tree<K>> {

  public List<K> createTree(List<S> items) {

    final Map<T, K> itemsMap = new HashMap<>();

    for (S item : items) {
      itemsMap.put(item.getKey(), this.createTreeNode(item));
    }

    for (S item : items) {
      T key = item.getKey();
      K node = itemsMap.get(key);
      T parentKey = item.getParentKey();
      K parent = itemsMap.get(parentKey);

      if (parent != null) {
        parent.addChild(node);
        node.setParent(parent);
      } else {
        node.setParent(null);
      }
    }

    return itemsMap.values().stream()
      .filter(item -> item.getParent() == null)
      .collect(Collectors.toList());
  }

  protected abstract K createTreeNode(S source);

}
