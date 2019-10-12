package com.znaczek5.wzshop.controller.v1;

import com.znaczek5.wzshop.entity.product.Product;
import com.znaczek5.wzshop.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.znaczek5.wzshop.controller.v1.AbstractController.MODULE;

@RestController
@RequestMapping(MODULE)
@RequiredArgsConstructor
@Slf4j
public class ProductControllerImpl extends AbstractController implements ProductController {

  private final ProductService productService;

  @Override
  @GetMapping
  public List<Product> getAllProducts() {
    return this.productService.getAll();
  }

}
