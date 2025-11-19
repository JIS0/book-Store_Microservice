package com.jisojoy.bookStore.catalog.domain;

import com.jisojoy.bookStore.catalog.config.ApplicationConfig;
import com.jisojoy.bookStore.catalog.web.ProductNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductService {

    private final ProductRepo productRepo;
    private final ApplicationConfig appConfig;
    public ProductService(ProductRepo productRepo, ApplicationConfig appConfig) {
        this.productRepo = productRepo;
        this.appConfig=appConfig;
    }
    public PagedResult<Product> getAll(int pages) {

        Sort sort= Sort.by("name").ascending();
        Pageable pageable = PageRequest.of(pages,appConfig.pageSize(),sort);

        Page<Product> productsPage= productRepo.findAll(pageable).map(ProductMapper::toProduct);

        return new PagedResult<>(
                productsPage.getContent(),
                productsPage.getTotalElements(),
                productsPage.getNumber() + 1,
                productsPage.getTotalPages(),
                productsPage.isFirst(),
                productsPage.isLast(),
                productsPage.hasNext(),
                productsPage.hasPrevious()

        );
    }

    public Product getByCode(String code) {
        return productRepo.findByCode(code).map(ProductMapper::toProduct).orElseThrow(()->ProductNotFoundException.errorBycode(code));
    }
}
