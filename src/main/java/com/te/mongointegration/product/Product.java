package com.te.mongointegration.product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@AllArgsConstructor
@Document
@NoArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private String description;


}
