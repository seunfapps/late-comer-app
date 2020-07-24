package com.seunfapps.latecomer.services;

import com.seunfapps.latecomer.dtos.EmployeeEntryLogRequest;
import com.seunfapps.latecomer.entities.EmployeeAttendance;
import com.seunfapps.latecomer.exceptions.ResourceNotFoundException;
import com.seunfapps.latecomer.repositories.EmployeeAttendanceRepository;
import com.seunfapps.latecomer.utilities.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeAttendanceService {
    @Autowired
    private EmployeeAttendanceRepository repository;

    public List<EmployeeAttendance> findAll(){
        return repository.findAll();
    }

    public Optional<EmployeeAttendance> findById(String id){
        return repository.findById(id);
    }

    public EmployeeAttendance create (EmployeeEntryLogRequest request){

        EmployeeAttendance employeeAttendance = new EmployeeAttendance(
            request.getName(),
            request.getEmail(),
            request.getAddress(),
            request.getArrivalTime()
        );
        employeeAttendance.setAmountOwed(EmployeeUtil.calculateAmountOwed(employeeAttendance.getArrivalTime()));

        return repository.save(employeeAttendance);
    }

    public EmployeeAttendance update(String id, EmployeeEntryLogRequest request){
        Optional<EmployeeAttendance> employeeEntryLog = findById(id);

        if(employeeEntryLog.isPresent()){
            EmployeeAttendance entryLog = employeeEntryLog.get();
            entryLog.setName(request.getName());
            entryLog.setEmail(request.getEmail());
            entryLog.setAddress(request.getAddress());
            entryLog.setArrivalTime(request.getArrivalTime());
            entryLog.setAmountOwed(EmployeeUtil.calculateAmountOwed(entryLog.getArrivalTime()));

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
