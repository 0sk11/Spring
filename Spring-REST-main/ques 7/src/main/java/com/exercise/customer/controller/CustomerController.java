package com.exercise.customer.controller;

import com.exercise.customer.model.Customer;
import com.exercise.customer.modelreposistory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    @Autowired
    Repository repository;
    @GetMapping("/")
    public ResponseEntity<?> home(){
        return new ResponseEntity<>("Welcome", HttpStatus.OK);
    }

    @GetMapping("/customers/view")
    public ResponseEntity<?> viewCustomer(){
        List<Customer> listCustomer = repository.findAll();
        if(listCustomer.size()>0){
            return new ResponseEntity<>(listCustomer,HttpStatus.OK);
        }
        return new ResponseEntity<>("Customer are empty",HttpStatus.NOT_FOUND);
    }
    @GetMapping("/customer/view/{id}")
    public ResponseEntity<?> viewCustomer(@PathVariable("id") String id){
        Optional<Customer> customer = repository.findById(id);
        if(customer.isPresent()){
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
        return new ResponseEntity<>("No such Customer found",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/customer/add")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer){
        try{
            repository.save(customer);
            return new ResponseEntity<>("Added",HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/customer/edit/{id}")
    public ResponseEntity<?> editCustomer(@RequestBody Customer customer, @PathVariable("id") String id){
        Optional<Customer> optionalCustomer = repository.findById(id);
        if(optionalCustomer.isPresent()){
            Customer customer1 = optionalCustomer.get();
            customer1.setName(customer.getName()!=null? customer.getName() : customer1.getName());
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
        return new ResponseEntity<>("No such Customer found",HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/customer/delete/{id}")
    public  ResponseEntity<?> deleteCustomer(@PathVariable("id") String id){
        Optional<Customer> customer = repository.findById(id);
        if(customer.isPresent()){
            repository.deleteById(id);
            return new ResponseEntity<>("Deleted Customer",HttpStatus.OK);
        }
        return new ResponseEntity<>("No such Customer found",HttpStatus.NOT_FOUND);
    }
}
