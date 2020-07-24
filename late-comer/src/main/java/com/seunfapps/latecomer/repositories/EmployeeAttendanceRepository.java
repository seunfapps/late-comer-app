package com.seunfapps.latecomer.repositories;


import com.seunfapps.latecomer.entities.EmployeeAttendance;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeAttendanceRepository extends MongoRepository<EmployeeAttendance,String> {
}
