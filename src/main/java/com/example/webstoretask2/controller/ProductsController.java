package com.example.webstoretask2.controller;

import com.example.webstoretask2.domain.Product;
import com.example.webstoretask2.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/product")
public class ProductsController {
    private final ProductService productService;
    @PostMapping("/save")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.saveProduct(product));

    }

    @GetMapping("/id")
    public ResponseEntity<Product> getProductById(@RequestParam(name = "id") Integer id) {
        return ResponseEntity.ok(productService.getById(id));

    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.getAllProducts());

    }
    @DeleteMapping("/delete")
    public ResponseEntity<Boolean> deleteProduct(@RequestParam(name = "id") Integer id) {
        return ResponseEntity.ok(productService.deleteProduct(id));

    }
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(product));

    }
}
