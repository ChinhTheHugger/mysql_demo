package com.test_mysql_connection.mysql_demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.test_mysql_connection.mysql_demo.entity.CustomerAndApartment;

@Repository
public interface CustomerAndApartmentRepository extends CrudRepository<CustomerAndApartment, String> {
    
}
