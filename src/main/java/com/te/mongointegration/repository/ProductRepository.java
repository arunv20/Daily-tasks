package com.te.mongointegration.repository;

import com.te.mongointegration.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product,String> {

}
