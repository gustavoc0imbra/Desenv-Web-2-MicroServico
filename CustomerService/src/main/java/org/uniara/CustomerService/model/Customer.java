package org.uniara.CustomerService.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document
@Getter @Setter
public class Customer {
    @Id
    private String id;
    private String name;
    private String phoneNumber;
    private Date createdAt;
}
