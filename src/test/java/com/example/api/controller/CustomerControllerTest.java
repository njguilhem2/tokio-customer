package com.example.api.controller;

import com.example.api.domain.Customer;
import com.example.api.service.impl.CustomerService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * The type Customer controller test.
 */

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    private Customer customer;

    private Optional<Customer> customerOptional;

    /**
     * Set up.
     */
    @Before
    public void setUp(){
        this.customer = new Customer();
        this.customer.setEmail("email");
        this.customer.setId(1L);
        this.customer.setName("name");
        this.customer.setEndereco(null);
        this.customerOptional = Optional.of(customer);
    }

    /**
     * Should by success when post customer.
     */
    @Test
    public void shouldBySuccessWhenPostCustomer() {
        this.customerController.postCustomer(new Customer());
        verify(this.customerService, Mockito.atLeast(1)).createCustomer(any(Customer.class));
    }

    /**
     * Should by success when all customer.
     */
 /*   @Test
    public void shouldBySuccessWhenAllCustomer() {

        this.customerController.findAll();
        verify(this.customerService, Mockito.atLeast(1)).findAll();
    }*/

    /**
     * Should by success with find by customer.
     */
    @Test
    public void shouldBySuccessWithFindByCustomer() {
        when(this.customerService.findById(anyLong())).thenReturn(customerOptional);
        this.customerController.findById(1L);
        verify(this.customerService, Mockito.atLeast(1)).findById(anyLong());
    }

    /**
     * Should by success when delete customer.
     */
    @Test
    public void shouldBySuccessWhenDeleteCustomer() {
        this.customerController.deleteCustomer(anyLong());
        verify(this.customerService,Mockito.atLeast(1)).deleteCustomer(anyLong());
    }

    /**
     * Should by success when put customer.
     */
    @Test
    public void shouldBySuccessWhenPutCustomer() {
        this.customerController.putCustomer(new Customer());
        verify(this.customerService,Mockito.atLeast(1)).alterCustomer(any(Customer.class));
    }
}
