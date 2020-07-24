package com.seunfapps.latecomer.services;

import com.seunfapps.latecomer.entities.EmployeeEntryLog;
import com.seunfapps.latecomer.repositories.EmployeeEntryLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeEntryLogService {
    @Autowired
    private EmployeeEntryLogRepository repository;

    public List<EmployeeEntryLog> findAll(){
        return repository.findAll();
    }

    public Optional<EmployeeEntryLog> findById(String id){
        return repository.findById(id);
    }

    public EmployeeEntryLog save (EmployeeEntryLog employeeEntryLog){
        return repository.save(employeeEntryLog);
    }

    public void delete (String id){
         repository.deleteById(id);
    }
}
