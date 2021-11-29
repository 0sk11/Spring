package com.exercise.arth.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @GetMapping("/")
    public ResponseEntity<?> home(){
        return new ResponseEntity<>("<h1>Welcome</h1>", HttpStatus.OK);
    }
    @GetMapping("/add")
    @ResponseBody
    public String getAdd(@RequestParam List<Integer> id) {
        int sum = Integer.valueOf(id.get(0)) + Integer.valueOf(id.get(1));
        return "Sum is " + sum;
    }

    @GetMapping("/sub")
    @ResponseBody
    public String getSub(@RequestParam List<Integer> id) {
        int sub = Integer.valueOf(id.get(0)) - Integer.valueOf(id.get(1));
        return "Sub is " + sub;
    }

    @GetMapping("/multiply")
    @ResponseBody
    public String getMul(@RequestParam List<Integer> id) {
        int mul = Integer.valueOf(id.get(0)) * Integer.valueOf(id.get(1));
        return "Sum is " + mul;
    }

    @GetMapping("/div")
    @ResponseBody
    public String getDiv(@RequestParam List<Integer> id) {
        double div;
        try{
           div = Double.valueOf(id.get(0)) / Double.valueOf(id.get(1));
        }
        catch (Exception e){
            return "Denominator cannot be 0";
        }
        return "Division  is " + div;
    }
}
