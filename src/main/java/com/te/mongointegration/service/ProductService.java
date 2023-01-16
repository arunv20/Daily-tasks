package com.te.mongointegration.service;

import com.te.mongointegration.dto.NewProductDto;
import com.te.mongointegration.dto.ProductListDto;
import com.te.mongointegration.product.Product;
import com.te.mongointegration.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public String saveProduct(NewProductDto newProductDto) {
        if (newProductDto == null) {
            throw new IllegalArgumentException("Please Enter the fields");
        }
        Product product = new Product();
        BeanUtils.copyProperties(newProductDto, product);
        repository.save(product);
        return newProductDto.getName() + " saved successfully";
    }

    public List<Product> getProductList() {
      List<Product> product= repository.findAll();
      ProductListDto productListDto= new ProductListDto(product);
      return productListDto.getProductList();
    }
}

