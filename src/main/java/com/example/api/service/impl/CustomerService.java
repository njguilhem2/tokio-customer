package com.example.api.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import com.example.api.config.RestTemplateConfig;
import com.example.api.domain.Endereco;
import com.example.api.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;

@Service
public class CustomerService implements ICustomerService {

  private CustomerRepository repository;

  @Autowired
  private RestTemplateConfig restTemplate;
  @Autowired
  private EnderecoService enderecoService;

  @Autowired
  public CustomerService(CustomerRepository repository) {
    this.repository = repository;
  }

  @Override
  public List<Customer> findAll() {
    List<Customer> customerList = this.repository.findAllByOrderByNameAsc();
    return customerList;
  }

  @Override
  public Optional<Customer> findById(Long id) {
    return this.repository.findById(id);
  }

  @Override
  public Customer createCustomer(Customer customer) {
    List<Endereco> cepString = new ArrayList<Endereco>(Arrays.asList
        (this.enderecoService.cepEndereco("09981400")));
    customer.setEndereco(cepString);
    return this.repository.save(customer);
  }

  @Override
  public void deleteCustomer(Long id) {
    this.repository.deleteById(id);
  }

  @Override
  public Customer alterCustomer(Customer customer) {
    List<Endereco> cepString = new ArrayList<Endereco>
        (Arrays.asList(this.enderecoService.cepEndereco("09981400")));
    this.repository.deleteById(customer.getId());
    customer.setEndereco(cepString);
    this.repository.save(customer);
    return customer;
  }
}
