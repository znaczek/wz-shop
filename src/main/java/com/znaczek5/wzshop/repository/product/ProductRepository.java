package com.znaczek5.wzshop.repository.product;

import com.znaczek5.wzshop.entity.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
