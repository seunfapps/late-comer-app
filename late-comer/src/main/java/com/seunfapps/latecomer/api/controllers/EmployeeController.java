package com.seunfapps.latecomer.api.controllers;

import com.seunfapps.latecomer.dtos.EmployeeAttendanceRequest;
import com.seunfapps.latecomer.dtos.EmployeeRequest;
import com.seunfapps.latecomer.entities.Employee;
import com.seunfapps.latecomer.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping
    public ResponseEntity<Employee> create (@Validated @RequestBody EmployeeRequest request){
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll (){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable String id){
        return new ResponseEntity<>(service.findById(id).get(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable String id, @Validated @RequestBody EmployeeRequest request){
        return new ResponseEntity<>(service.update(id, request), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> delete(@PathVariable String id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
