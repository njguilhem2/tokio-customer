package com.example.api.service.impl;

import java.util.List;
import java.util.Optional;
import com.example.api.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

	private CustomerRepository repository;

	@Autowired
	public CustomerService(CustomerRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Customer> findAll() {
		return this.repository.findAllByOrderByNameAsc();
	}

	@Override
	public Optional<Customer> findById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Customer createCustomer(Customer customer){
		return this.repository.save(customer);
	}
	@Override
	public void deleteCustomer(Long id){
	  this.repository.deleteById(id);
  }

  @Override
  public Customer alterCustomer(Customer customer){
	  this.repository.deleteById(customer.getId());
	  this.repository.save(customer);
	  return customer;
	}

}
