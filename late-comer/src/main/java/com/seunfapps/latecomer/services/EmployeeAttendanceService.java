package com.seunfapps.latecomer.services;

import com.seunfapps.latecomer.dtos.EmployeeAttendanceRequest;
import com.seunfapps.latecomer.entities.Employee;
import com.seunfapps.latecomer.entities.EmployeeAttendance;
import com.seunfapps.latecomer.exceptions.ResourceNotFoundException;
import com.seunfapps.latecomer.repositories.EmployeeAttendanceRepository;
import org.joda.time.LocalTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAttendanceService {
    @Autowired
    private EmployeeAttendanceRepository repository;

    @Autowired
    private EmployeeService employeeService;

    public List<EmployeeAttendance> findAll(){
        return repository.findAll();
    }

    public Employee create (EmployeeAttendanceRequest request){
        Optional<Employee> employee = employeeService.findById(request.getEmployeeId());
        if(!employee.isPresent())
            throw new ResourceNotFoundException("Employee with id: "+request.getEmployeeId()+" not found");

        EmployeeAttendance employeeAttendance = new EmployeeAttendance(request.getEmployeeId(), request.getArrivalTime());

        repository.save(employeeAttendance);
        return employeeService.updateAmountOwed(request,employee.get());
    }
}
