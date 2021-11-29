package com.exercise.customer.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "customer")
public class Customer {
    @Id
    @Setter @Getter
    private String id;
    @Getter @Setter
    private String name;
}
