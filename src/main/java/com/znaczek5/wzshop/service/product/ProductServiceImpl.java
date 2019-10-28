package com.znaczek5.wzshop.service.product;

import com.znaczek5.wzshop.controller.v1.request.ProductsListFilterParams;
import com.znaczek5.wzshop.entity.product.Product;
import com.znaczek5.wzshop.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;

import static com.znaczek5.wzshop.specification.SpecificationUtils.*;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  @Override
  public Page<Product> findAll(ProductsListFilterParams productsListFilterParams, Pageable pageable) {

    Specification<Product> specification = Specification.where(null);

    if (!StringUtils.isEmpty(productsListFilterParams.getCategory())) {
      specification = (root, criteriaQuery, criteriaBuilder) -> {
        Path<String> path = root.join("category").get("path");
        return criteriaBuilder.like(path, getSlugWildcard(productsListFilterParams.getCategory()));
      };
    }

    return productRepository.findAll(specification, pageable);
  }

}
