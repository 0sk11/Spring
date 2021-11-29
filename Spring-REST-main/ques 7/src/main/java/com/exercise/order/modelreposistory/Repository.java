package com.exercise.order.modelreposistory;

import com.exercise.order.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface Repository extends MongoRepository<Order,String> {

}
