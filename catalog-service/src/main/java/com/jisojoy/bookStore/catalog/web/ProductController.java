package com.jisojoy.bookStore.catalog.web;

import com.jisojoy.bookStore.catalog.domain.PagedResult;
import com.jisojoy.bookStore.catalog.domain.ProductEntity;
import com.jisojoy.bookStore.catalog.domain.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public PagedResult<ProductEntity> getAllProducts(@RequestParam(name = "page" , defaultValue="1") int pages){
        return productService.getAll(pages);
    }
}
