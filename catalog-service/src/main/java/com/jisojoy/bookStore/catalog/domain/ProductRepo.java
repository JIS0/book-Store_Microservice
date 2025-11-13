package com.jisojoy.bookStore.catalog.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
    ProductEntity findByCode(String code);
}
