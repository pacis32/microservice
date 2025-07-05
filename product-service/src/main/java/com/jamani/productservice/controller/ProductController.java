package com.jamani.productservice.controller;

import com.jamani.productservice.dto.ProductRequest;
import com.jamani.productservice.dto.ProductResponse;
import com.jamani.productservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/addProduct")
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody ProductRequest productRequest){
         productService.addProduct(productRequest);
    }


    @GetMapping("/products")
    public List<ProductResponse> getAllProducts(){
       return productService.getAllProducts();
    }

}


