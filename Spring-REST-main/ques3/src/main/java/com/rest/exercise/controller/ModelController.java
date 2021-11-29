package com.rest.exercise.controller;

import com.rest.exercise.model.Model;
import com.rest.exercise.repository.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ModelController {
    @Autowired
    private ModelRepository modelRepository;

    @GetMapping("/")
    public String home(){
        return ("<h1>Welcome</h1>");
    }
    @GetMapping("/address")
    public ResponseEntity<?> getAllAddress(){
        List<com.rest.exercise.model.Model> address = modelRepository.findAll();
        if(address.size()>0){
            return new ResponseEntity<>(address, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>("No contain found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/address")
    public ResponseEntity<?> postAddress(@RequestBody Model address){
        try {
            modelRepository.save(address);
            return new ResponseEntity<>(address+" Added",HttpStatus.ACCEPTED);
        }catch (Exception e){
            return new ResponseEntity<>("Failed to add",HttpStatus.FORBIDDEN);
        }
    }

    @GetMapping("/address/zipcode/{zipcode}")
    public ResponseEntity<?> getAddress(@PathVariable("zipcode")int zipcode){
        List<Model> ListAddress = modelRepository.getAddressByZid(zipcode);
        if(!ListAddress.isEmpty()) {
            return new ResponseEntity<>(modelRepository.getAddressByZid(zipcode),HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found anything @ "+zipcode,HttpStatus.NOT_FOUND);
    }
    @GetMapping("/address/city/{city}")
    public ResponseEntity<?> getAddressCity(@PathVariable("city")String city){
        List<Model> ListAddress = modelRepository.getAddressByCity(city);
        if(!ListAddress.isEmpty()) {
            return new ResponseEntity<>(modelRepository.getAddressByCity(city),HttpStatus.OK);
        }
        return new ResponseEntity<>("City not found as "+city,HttpStatus.NOT_FOUND);
    }

}
