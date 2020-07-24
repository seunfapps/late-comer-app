package com.seunfapps.latecomer.services;

import com.seunfapps.latecomer.dtos.EmployeeEntryLogRequest;
import com.seunfapps.latecomer.entities.EmployeeEntryLog;
import com.seunfapps.latecomer.exceptions.ResourceNotFoundException;
import com.seunfapps.latecomer.repositories.EmployeeEntryLogRepository;
import com.seunfapps.latecomer.utilities.EmployeeEntryLogUtil;
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

    public EmployeeEntryLog create (EmployeeEntryLogRequest request){
        EmployeeEntryLog employeeEntryLog = new EmployeeEntryLog(
            request.getName(),
            request.getEmail(),
            request.getAddress(),
            request.getArrivalTime()
        );
        employeeEntryLog.setAmountOwed(EmployeeEntryLogUtil.calculateAmountOwed(employeeEntryLog.getArrivalTime()));

        return repository.save(employeeEntryLog);
    }

    public EmployeeEntryLog update(String id, EmployeeEntryLogRequest request){
        Optional<EmployeeEntryLog> employeeEntryLog = findById(id);

        if(employeeEntryLog.isPresent()){
            EmployeeEntryLog entryLog = employeeEntryLog.get();
            entryLog.setName(request.getName());
            entryLog.setEmail(request.getEmail());
            entryLog.setAddress(request.getAddress());
            entryLog.setArrivalTime(request.getArrivalTime());
            entryLog.setAmountOwed(EmployeeEntryLogUtil.calculateAmountOwed(entryLog.getArrivalTime()));

            return repository.save(entryLog);
        }
        else{
            throw new ResourceNotFoundException("Employee with id: "+id+" not found");
        }
    }

    public void delete (String id){
         repository.deleteById(id);
    }
}
