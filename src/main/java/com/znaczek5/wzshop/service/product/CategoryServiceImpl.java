package com.znaczek5.wzshop.service.product;

import com.znaczek5.wzshop.controller.v1.request.ProductsListFilterParams;
import com.znaczek5.wzshop.entity.product.Category;
import com.znaczek5.wzshop.repository.product.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.JoinType;
import java.util.List;

import static com.znaczek5.wzshop.specification.SpecificationUtils.getSlugWildcard;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

  private final CategoryRepository categoryRepository;

  @Override
  public List<Category> findAll(ProductsListFilterParams productsListFilterParams) {
    Specification<Category> specification = Specification.where(null);

    if (!StringUtils.isEmpty(productsListFilterParams.getCategory())) {
      specification = (root, criteriaQuery, criteriaBuilder) -> {
        criteriaQuery.distinct(true);
        return criteriaBuilder.or(
          criteriaBuilder.like(root.get("path"), getSlugWildcard(productsListFilterParams.getCategory())),
          criteriaBuilder.equal(root.join("children", JoinType.LEFT).get("slug"), productsListFilterParams.getCategory())
        );
      };
    }
    return categoryRepository.findAll(specification);
  }

}
