package com.znaczek5.wzshop.controller.v1;

import com.znaczek5.wzshop.controller.v1.request.ProductsListFilterParams;
import com.znaczek5.wzshop.entity.product.Category;
import com.znaczek5.wzshop.service.CategoryListToTree;
import com.znaczek5.wzshop.service.product.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.znaczek5.wzshop.controller.v1.AbstractController.CATEGORY;
import static com.znaczek5.wzshop.dto.CategoryDTO.CategoryTreeDTO;

@RestController
@RequestMapping(CATEGORY)
@RequiredArgsConstructor
public class CategoryControllerImpl extends AbstractController implements CategoryController {

  private final CategoryService categoryService;

  private final CategoryListToTree categoryListToTree;

  @Override
  @GetMapping
  public List<CategoryTreeDTO> getAllAsTree(ProductsListFilterParams productsListFilterParams) {
    return categoryListToTree.createTree(this.categoryService.findAll(productsListFilterParams));
  }

}
