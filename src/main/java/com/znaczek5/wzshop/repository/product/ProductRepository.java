package com.znaczek5.wzshop.repository.product;

import com.znaczek5.wzshop.entity.product.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;

public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

  @Override
  @EntityGraph(attributePaths = {"category"})
  Page<Product> findAll(@Nullable Specification<Product> var1, Pageable var2);

}
