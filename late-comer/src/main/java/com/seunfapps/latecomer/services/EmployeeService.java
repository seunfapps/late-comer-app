package com.seunfapps.latecomer.services;

import com.seunfapps.latecomer.dtos.EmployeeAttendanceRequest;
import com.seunfapps.latecomer.dtos.EmployeeRequest;
import com.seunfapps.latecomer.dtos.Pagination;
import com.seunfapps.latecomer.dtos.PagingRequest;
import com.seunfapps.latecomer.entities.Employee;
import com.seunfapps.latecomer.exceptions.ResourceAlreadyExistsException;
import com.seunfapps.latecomer.exceptions.ResourceNotFoundException;
import com.seunfapps.latecomer.repositories.EmployeeRepository;
import com.seunfapps.latecomer.utilities.EmployeeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Pagination<Employee> findAll(PagingRequest paging){
        Pageable pageable;

        if(paging.getSortBy() == null || paging.getSortBy().trim().length() == 0)
            pageable = PageRequest.of(paging.getNumber(), paging.getSize());
        else if(paging.getSortDirection().equalsIgnoreCase("desc"))
            pageable = PageRequest.of(paging.getNumber(),paging.getSize(), Sort.by(paging.getSortBy()).descending());
        else
            pageable = PageRequest.of(paging.getNumber(),paging.getSize(), Sort.by(paging.getSortBy()).ascending());

        Page<Employee> result;

        if(paging.getSearchParam() == null || paging.getSearchParam().trim().length() == 0)
            result = repository.findAll(pageable);
        else
            result = repository.findAllBySearch(paging.getSearchParam(), pageable);

        return new Pagination<Employee>(result.getNumberOfElements(), result.getContent());
    }

    public Optional<Employee> findById(String id){
        return repository.findById(id);
    }

    public Employee create(EmployeeRequest request){
        if(repository.findByEmail(request.getEmail()).size() != 0)
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
