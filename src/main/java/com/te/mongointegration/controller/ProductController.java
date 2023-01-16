package com.te.mongointegration.controller;

import com.te.mongointegration.dto.NewProductDto;
import com.te.mongointegration.product.Product;
import com.te.mongointegration.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/product")
public class ProductController {

    public final ProductService service;
    @PostMapping("/products")
    ResponseEntity<String> saveProduct(@RequestBody NewProductDto newProductDto){
        String response=service.saveProduct(newProductDto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    ResponseEntity<List<Product>> getProducts(){
        List<Product> responce = service.getProductList();
        return ResponseEntity.ok(responce);

    }



}
