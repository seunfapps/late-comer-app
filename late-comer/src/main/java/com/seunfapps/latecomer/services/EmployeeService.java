package com.seunfapps.latecomer.services;

import com.seunfapps.latecomer.dtos.EmployeeAttendanceRequest;
import com.seunfapps.latecomer.dtos.EmployeeRequest;
import com.seunfapps.latecomer.entities.Employee;
import com.seunfapps.latecomer.exceptions.ResourceAlreadyExistsException;
import com.seunfapps.latecomer.exceptions.ResourceNotFoundException;
import com.seunfapps.latecomer.repositories.EmployeeRepository;
import com.seunfapps.latecomer.utilities.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public List<Employee> findAll(){
        return repository.findAll();
    }

    public Optional<Employee> findById(String id){
        return repository.findById(id);
    }

    public Employee create(EmployeeRequest request){
        if(repository.findByEmail(request.getEmail()) != null)
            throw new ResourceAlreadyExistsException("Employee with email: "+request.getEmail()+" already exists");

        Employee employee = new Employee(request.getName(),request.getEmail(),request.getAddress());
        employee.setAmountOwed(0);

        return repository.save(employee);
    }
    public Employee update(String id, EmployeeRequest request){
        Optional<Employee> employeeOptional = findById(id);

        if(employeeOptional.isPresent()){
            Employee employee = employeeOptional.get();
            employee.setName(request.getName());
            employee.setEmail(request.getEmail());
            employee.setAddress(request.getAddress());

            return repository.save(employee);
        }
        else{
            throw new ResourceNotFoundException("Employee with id: "+id+" not found");
        }
    }
    public Employee updateAmountOwed (EmployeeAttendanceRequest request, Employee employee){
        employee.setAmountOwed(employee.getAmountOwed() + EmployeeUtil.calculateAmountOwed(request.getArrivalTime()));

        return repository.save(employee);
    }

    public void delete (String id){
         repository.deleteById(id);
    }
}
