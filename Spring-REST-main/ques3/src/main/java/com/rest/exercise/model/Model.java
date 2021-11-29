package com.rest.exercise.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="model")

public class Model {
    @Id
    private String id;
    @Getter @Setter
    private int zipcode;
    @Getter @Setter
    private String city;
    @Getter @Setter
    private String country;
    @Getter @Setter
    private String state;

}
