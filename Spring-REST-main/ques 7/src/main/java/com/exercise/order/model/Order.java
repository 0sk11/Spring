package com.exercise.order.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "order")
public class Order {
    @Id
    @Setter @Getter
    private String id;
    @Getter @Setter
    private String name;
}
