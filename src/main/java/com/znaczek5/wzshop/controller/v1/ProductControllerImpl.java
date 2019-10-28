package com.znaczek5.wzshop.controller.v1;

import com.znaczek5.wzshop.controller.v1.request.ProductsListFilterParams;
import com.znaczek5.wzshop.entity.product.Product;
import com.znaczek5.wzshop.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.znaczek5.wzshop.controller.v1.AbstractController.*;

@RestController
@RequestMapping(MODULE)
@RequiredArgsConstructor
@Slf4j
public class ProductControllerImpl extends AbstractController implements ProductController {

  private final ProductService productService;

  @Override
  @GetMapping
  public ResponseEntity<List<Product>> findAll(
    @ModelAttribute ProductsListFilterParams productsListFilterParams,
    @PageableDefault(sort = DEFAULT_SORT, direction = Sort.Direction.ASC) Pageable pageable
  ) {
    Page<Product> result = this.productService.findAll(productsListFilterParams, pageable)
      .map(product -> modelMapper.map(product, Product.class));

    return getListResponse(result);
  }

}
