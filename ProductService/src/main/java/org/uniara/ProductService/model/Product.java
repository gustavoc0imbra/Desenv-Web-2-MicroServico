package org.uniara.ProductService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document
@Getter @Setter
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private boolean isAvailable;
    private Date createdAt;
}
