package com.te.mongointegration.dto;

import com.te.mongointegration.product.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class ProductListDto {

   private List<Product> productList = new ArrayList<>();
}
