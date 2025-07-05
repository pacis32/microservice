package com.jamani.productservice.service;

import com.jamani.productservice.dto.ProductRequest;
import com.jamani.productservice.dto.ProductResponse;
import com.jamani.productservice.model.Product;
import com.jamani.productservice.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void addProduct(@RequestBody ProductRequest productRequest){
        Product product =  Product.builder()
                .name(productRequest.getName())
                .description(productRequest.getDescription())
                .price(productRequest.getPrice())
                .build();
        productRepository.save(product);
        log.info("Added  {} product ",product.getId());

    }

    public List<ProductResponse> getAllProducts(){
        List<Product> products = productRepository.findAll();
      return   products.stream().map(this::mapToProductResponse).toList();
    }

    private ProductResponse mapToProductResponse(Product product) {
         return ProductResponse.builder()
                 .id(product.getId())
                 .name(product.getName())
                 .description(product.getDescription())
                 .price(product.getPrice())
                 .build();
    }

}
