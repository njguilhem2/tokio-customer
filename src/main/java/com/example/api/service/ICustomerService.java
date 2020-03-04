package com.example.api.service;

import com.example.api.domain.Customer;
import com.example.api.domain.Endereco;

import java.util.List;
import java.util.Optional;

/**
 * The interface Customer service.
 */
public interface ICustomerService {

  /**
   * Create customer customer.
   *
   * @param customer the customer
   * @return the customer
   */
  Customer createCustomer(Customer customer);

  /**
   * Find all list.
   *
   * @return the list
   */
  List<Customer> findAll();

  /**
   * Find by id optional.
   *
   * @param id the id
   * @return the optional
   */
  Optional<Customer> findById(Long id);

  /**
   * Delete customer.
   *
   * @param id the id
   */
  void deleteCustomer(Long id);

  /**
   * Alter customer customer.
   *
   * @param customer the customer
   * @return the customer
   */
  Customer alterCustomer(Customer customer);
}
