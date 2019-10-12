package com.znaczek5.wzshop.service.product;

import com.znaczek5.wzshop.entity.product.Product;
import com.znaczek5.wzshop.repository.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }
}
