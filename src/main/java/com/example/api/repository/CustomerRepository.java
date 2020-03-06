package com.example.api.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.api.domain.Customer;

import java.util.List;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

	List<Customer> findAllByOrderByNameAsc();

}
