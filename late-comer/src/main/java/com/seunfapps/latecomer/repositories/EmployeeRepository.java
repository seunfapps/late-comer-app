package com.seunfapps.latecomer.repositories;


import com.seunfapps.latecomer.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,String> {
    List<Employee> findByEmail(String email);

    @Query( value = "{'name' : ?0,'email':?0,'address': ?0}")
    Page<Employee> findAllBySearch(String searchParam, Pageable pageable);
}
