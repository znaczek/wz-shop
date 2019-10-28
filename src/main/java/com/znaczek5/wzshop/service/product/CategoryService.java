package com.znaczek5.wzshop.service.product;

import com.znaczek5.wzshop.controller.v1.request.ProductsListFilterParams;
import com.znaczek5.wzshop.entity.product.Category;

import java.util.List;

public interface CategoryService {
  List<Category> findAll(ProductsListFilterParams productsListFilterParams);
}
