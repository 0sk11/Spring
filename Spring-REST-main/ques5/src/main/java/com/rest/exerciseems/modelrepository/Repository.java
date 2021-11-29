package com.rest.exerciseems.modelrepository;

import com.rest.exerciseems.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface Repository extends MongoRepository<Employee,String> {

}
