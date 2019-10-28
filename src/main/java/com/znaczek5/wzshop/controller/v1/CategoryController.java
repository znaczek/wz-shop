package com.znaczek5.wzshop.controller.v1;

import com.znaczek5.wzshop.controller.v1.request.ProductsListFilterParams;
import com.znaczek5.wzshop.dto.CategoryDTO;

import java.util.List;

public interface CategoryController {
  public List<CategoryDTO.CategoryTreeDTO> getAllAsTree(ProductsListFilterParams productsListFilterParams);
}
