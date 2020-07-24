package com.seunfapps.latecomer.repositories;


import com.seunfapps.latecomer.entities.EmployeeEntryLog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEntryLogRepository extends MongoRepository<EmployeeEntryLog,String> {
}
