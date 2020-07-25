package com.seunfapps.latecomer.api.controllers;

import com.seunfapps.latecomer.dtos.EmployeeAttendanceRequest;
import com.seunfapps.latecomer.entities.Employee;
import com.seunfapps.latecomer.entities.EmployeeAttendance;
import com.seunfapps.latecomer.services.EmployeeAttendanceService;
import com.seunfapps.latecomer.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee-attendance")
public class EmployeeAttendanceController {

    @Autowired
    private EmployeeAttendanceService service;

    @PostMapping
    public ResponseEntity<Employee> create (@RequestBody EmployeeAttendanceRequest request){
        return new ResponseEntity<>(service.create(request), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<EmployeeAttendance>> get (){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

}
