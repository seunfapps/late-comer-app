package com.seunfapps.latecomer.repositories;


import com.seunfapps.latecomer.entities.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee,String> {
    List<Employee> findByEmail(String email);
}
