package com.rest.exercise.repository;

import com.rest.exercise.model.Model;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ModelRepository extends MongoRepository<Model, String> {
    @Query("{zipcode : ?0}")
    List<Model> getAddressByZid(int zipcode);

    @Query("{city : ?0}")
    List<Model> getAddressByCity(String city);
}
