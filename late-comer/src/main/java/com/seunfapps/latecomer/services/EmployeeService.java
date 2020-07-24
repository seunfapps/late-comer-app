package com.seunfapps.latecomer.services;

import com.seunfapps.latecomer.entities.Employee;
import com.seunfapps.latecomer.repositories.EmployeeRepository;
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

    public Employee save (Employee employee){
        return repository.save(employee);
    }

    public void delete (String id){
         repository.deleteById(id);
    }
}
