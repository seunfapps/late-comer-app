package com.seunfapps.latecomer.repositories;


import com.seunfapps.latecomer.entities.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee,String> {
    List<Employee> findByEmail(String email);

    @Query("{$or: [{'name' : {$regex: ?0, $options : 'i'}}, {'email' : {$regex: ?0, $options : 'i'}}, {'address': {$regex: ?0, $options : 'i'}}]}")
    Page<Employee> findAllBySearch(String searchParam, Pageable pageable);
}
