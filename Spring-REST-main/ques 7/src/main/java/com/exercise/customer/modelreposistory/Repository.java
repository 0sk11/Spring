package com.exercise.customer.modelreposistory;

import com.exercise.customer.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Customer,String> {

}
