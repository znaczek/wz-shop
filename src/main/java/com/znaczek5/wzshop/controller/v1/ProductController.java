package com.znaczek5.wzshop.controller.v1;

import com.znaczek5.wzshop.controller.v1.request.ProductsListFilterParams;
import com.znaczek5.wzshop.entity.product.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

interface ProductController {
  public ResponseEntity<List<Product>> findAll(ProductsListFilterParams productsListFilterParams, Pageable pagable);
}
