package com.example.api.controller;

import 	java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.server.ResponseStatusException;
import com.example.api.domain.Customer;
import com.example.api.service.impl.CustomerService;

import javax.validation.Valid;


/**
 * The type Customer controller.
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

	private CustomerService service;

	/**
	 * Instantiates a new Customer controller.
	 *
	 * @param service the service
	 */
	@Autowired
	public CustomerController(CustomerService service) {
		this.service = service;
	}

	/**
	 * Find all list.
	 *
	 * @return the list
	 */
	@GetMapping
	public List<Customer> findAll() {
		return this.service.findAll();
	}

	/**
	 * Find by id customer.
	 *
	 * @param id the id
	 * @return the customer
	 */
	@GetMapping("/{id}")
	public Customer findById(@PathVariable Long id) {
		return this.service.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Customer not found"));
	}

	/**
	 * Post customer deferred result.
	 *
	 * @param customer the customer
	 * @return the deferred result
	 */
	@PostMapping()
	public DeferredResult<ResponseEntity<Customer>> postCustomer(@RequestBody Customer customer){
		DeferredResult<ResponseEntity<Customer>> response = new DeferredResult<>();
		response.setResult(new ResponseEntity<>(this.service.createCustomer(customer),HttpStatus.CREATED));
		return response;
	}

	/**
	 * Delete customer deferred result.
	 *
	 * @param id the id
	 * @return the deferred result
	 */
	@DeleteMapping("/{id}")
	public DeferredResult<ResponseEntity<HttpStatus>> deleteCustomer(@RequestParam(value = "id") Long id){
		DeferredResult<ResponseEntity<HttpStatus>> response = new DeferredResult<>();
		this.service.deleteCustomer(id);
		response.setResult(new ResponseEntity<>(HttpStatus.NO_CONTENT));
		return response;
	}

	/**
	 * Put customer deferred result.
	 *
	 * @param customer the customer
	 * @return the deferred result
	 */
	@PutMapping()
	public DeferredResult<ResponseEntity<Customer>> putCustomer(@RequestBody Customer customer){
		DeferredResult<ResponseEntity<Customer>> response = new DeferredResult<>();
		response.setResult(new ResponseEntity<>(this.service.alterCustomer(customer), HttpStatus.OK));
		return response;
	}
}
