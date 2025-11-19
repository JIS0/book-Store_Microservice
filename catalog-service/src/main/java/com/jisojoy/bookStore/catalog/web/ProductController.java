package com.jisojoy.bookStore.catalog.web;

import com.jisojoy.bookStore.catalog.domain.PagedResult;
import com.jisojoy.bookStore.catalog.domain.Product;
import com.jisojoy.bookStore.catalog.domain.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public PagedResult<Product> getAllProducts(@RequestParam(name = "page" , defaultValue="0") int pages){
        return productService.getAll(pages);
    }

    @GetMapping("/{code}")
    public Product getProductByCode(@PathVariable String code){
        return productService.getByCode(code);
    }
}
