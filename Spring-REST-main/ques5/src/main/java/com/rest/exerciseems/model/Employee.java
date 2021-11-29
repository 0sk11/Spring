package com.rest.exerciseems.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="employee")
public class Employee {
    @Id
    @Setter @Getter
    private String id;
    @Setter @Getter
    private String name;
    @Setter @Getter
    private String dept;
    @Setter @Getter
    private String designation;
    @Setter @Getter
    private double salary;

}
