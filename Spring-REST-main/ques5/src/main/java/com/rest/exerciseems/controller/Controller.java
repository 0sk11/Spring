package com.rest.exerciseems.controller;

import com.rest.exerciseems.model.Employee;
import com.rest.exerciseems.modelrepository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    @Autowired
    Repository repository;

    @GetMapping("/")
    public ResponseEntity<?> home(){
        return new ResponseEntity<>("<h1>Welcome</h1>", HttpStatus.OK);
    }

    @GetMapping("/employees")
    public ResponseEntity<?> getAllEmployess(){
        List<Employee> employeeList = repository.findAll();
        if(employeeList.size()>0){
            return new ResponseEntity<>(employeeList,HttpStatus.OK);
        }
        return new ResponseEntity<>("No List Found",HttpStatus.NOT_FOUND);
    }

    @PostMapping("/employee/add")
    public ResponseEntity<?> addAnEmployee(@RequestBody Employee emp){
        try {
            repository.save(emp);
            return new ResponseEntity<>(emp,HttpStatus.OK);
        }catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.FORBIDDEN);
        }
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<?> deleteAnEmployee(@PathVariable("id") String id){
        Optional<Employee> optionalEmployee = repository.findById(id);
        if(optionalEmployee.isPresent()){
            repository.deleteById(id);
            return new ResponseEntity<>("Deleted ",HttpStatus.OK);
        }
        return new ResponseEntity<>("No File found...",HttpStatus.NOT_FOUND);
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<?> editAnEmployee(@RequestBody Employee emp,@PathVariable("id")String id){
        Optional<Employee> optionalEmployee = repository.findById(id);
        if(optionalEmployee.isPresent()){
            Employee empl = optionalEmployee.get();
            empl.setName(emp.getName()==null?empl.getName():empl.getName());
            empl.setDept(emp.getDept()==null?empl.getDept():empl.getDept());
            empl.setDesignation(emp.getDesignation()==null?empl.getDesignation():empl.getDesignation());
            empl.setSalary(emp.getSalary()==0?empl.getSalary():empl.getSalary());
            return new ResponseEntity<>("Employee details added "+optionalEmployee.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>("Something went wrong",HttpStatus.NOT_FOUND);
    }

}
