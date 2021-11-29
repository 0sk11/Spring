package com.exercise.order.controller;

import com.exercise.order.model.Order;
import com.exercise.order.modelreposistory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    @Autowired
    Repository repository;
    @GetMapping("/")
    public ResponseEntity<?> home(){
        return new ResponseEntity<>("Welcome", HttpStatus.OK);
    }

    @GetMapping("/orders/view")
    public ResponseEntity<?> viewOrders(){
        List<Order> listOrder = repository.findAll();
        if(listOrder.size()>0){
            return new ResponseEntity<>(listOrder,HttpStatus.OK);
        }
        return new ResponseEntity<>("Orders are empty",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/order/view/{id}")
    public ResponseEntity<?> viewOrder(@PathVariable("id") String id){
        Optional<Order> order = repository.findById(id);
        if(order.isPresent()){
            return new ResponseEntity<>(order,HttpStatus.OK);
        }
        return new ResponseEntity<>("No such order found",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/orders/add")
    public ResponseEntity<?> addOrder(@RequestBody Order order){
        try{
            repository.save(order);
            return new ResponseEntity<>("Added",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/orders/edit/{id}")
    public ResponseEntity<?> editOrder(@RequestBody Order order,@PathVariable("id") String id){
        Optional<Order> order1 = repository.findById(id);
        if(order1.isPresent()){
            Order oldOrder = order1.get();
            oldOrder.setName(order.getName()!=null? order.getName() : oldOrder.getName());
            return new ResponseEntity<>(order,HttpStatus.OK);
        }
        return new ResponseEntity<>("No such order found",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/orders/delete/{id}")
    public  ResponseEntity<?> deleteOrder(@PathVariable("id") String id){
        Optional<Order> order = repository.findById(id);
        if(order.isPresent()){
            repository.deleteById(id);
            return new ResponseEntity<>("Deleted Order",HttpStatus.OK);
        }
        return new ResponseEntity<>("No such order found",HttpStatus.NOT_FOUND);
    }
}
