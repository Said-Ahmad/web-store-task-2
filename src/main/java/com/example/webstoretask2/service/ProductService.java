package com.example.webstoretask2.service;

import com.example.webstoretask2.domain.Product;
import com.example.webstoretask2.entity.ProductEntity;
import com.example.webstoretask2.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public Product saveProduct(Product product) {
        ProductEntity productEntity = productRepository.save(modelMapper.map(product, ProductEntity.class));
        return modelMapper.map(productEntity, Product.class);
    }

    public Product getById(Integer id) {
        Optional<ProductEntity> optional = productRepository.findById(id);
        return optional.map(item -> modelMapper.map(item, Product.class)).orElse(null);
    }


    public List<Product> getAllProducts() {
        List<ProductEntity> list = productRepository.findAll();
        return list.stream().map(item -> modelMapper.map(item, Product.class)).collect(Collectors.toList());
    }

    public Product updateProduct(Product product) {
        boolean result = productRepository.existsById(product.getId());
        if (!result) {
            log.warn("Error :{}", product.getId());
            throw new RuntimeException("ERROR");
        }

        return this.saveProduct(product);

    }

    public Boolean deleteProduct(Integer id) {
        productRepository.deleteById(id);
        Optional<ProductEntity> optional = productRepository.findById(id);
        return !optional.isPresent();
    }
}
