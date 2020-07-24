package com.seunfapps.latecomer.services;

import com.seunfapps.latecomer.dtos.EmployeeAttendanceRequest;
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

    @Autowired
    private EmployeeService employeeService;

    public List<EmployeeAttendance> findAll(){
        return repository.findAll();
    }

    public Optional<EmployeeAttendance> findById(String id){
        return repository.findById(id);
    }

    public EmployeeAttendance create (EmployeeAttendanceRequest request){

        EmployeeAttendance employeeAttendance = new EmployeeAttendance(
            request.getName(),
            request.getArrivalTime()
        );

        EmployeeAttendance response = repository.save(employeeAttendance);
        employeeService.updateAmountOwed(request);
        return response;
    }

    public EmployeeAttendance update(String id, EmployeeAttendanceRequest request){
        Optional<EmployeeAttendance> employeeEntryLog = findById(id);

        if(employeeEntryLog.isPresent()){
            EmployeeAttendance entryLog = employeeEntryLog.get();
            entryLog.setName(request.getName());
            entryLog.setArrivalTime(request.getArrivalTime());

            EmployeeAttendance response = repository.save(entryLog);
            employeeService.updateAmountOwed(request);
            return response;
        }
        else{
            throw new ResourceNotFoundException("Employee with id: "+id+" not found");
        }
    }

    public void delete (String id){
         repository.deleteById(id);
    }
}
