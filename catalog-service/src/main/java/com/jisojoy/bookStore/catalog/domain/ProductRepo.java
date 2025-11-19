package com.jisojoy.bookStore.catalog.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepo extends JpaRepository<ProductEntity, Long> {
    Optional<ProductEntity> findByCode(String code);
}
