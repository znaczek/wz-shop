package com.znaczek5.wzshop.service.product;

import com.znaczek5.wzshop.controller.v1.request.ProductsListFilterParams;
import com.znaczek5.wzshop.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ProductService {
  Page<Product> findAll(ProductsListFilterParams productsListFilterParams, Pageable pagable);
}
