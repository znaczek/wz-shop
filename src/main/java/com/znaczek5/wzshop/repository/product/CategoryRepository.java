package com.znaczek5.wzshop.repository.product;

import com.znaczek5.wzshop.entity.product.Category;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>, JpaSpecificationExecutor<Category> {

  @Override
  @EntityGraph(attributePaths = {"children"})
  List<Category> findAll(@Nullable Specification<Category> var1);

}
