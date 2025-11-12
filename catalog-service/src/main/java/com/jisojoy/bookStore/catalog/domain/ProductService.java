package com.jisojoy.bookStore.catalog.domain;

import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {

    ProductRepo productRepo;
    public ProductService(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
    public List<ProductEntity> getAll() {
        return productRepo.findAll();
    }
}
