package com.example.api;

import com.example.api.controller.CustomerController;
import com.example.api.domain.Customer;
import com.example.api.service.impl.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class CustomerControllerTest {
  @InjectMocks
  private CustomerController customerController;

  @Mock
  private CustomerService customerService;

  private Customer customer;
  private List<Customer> customerList;

  @Before
  public void setUp(){
    MockitoAnnotations.initMocks(this);
    this.customer = new Customer();
    this.customer.setEmail("email");
    this.customer.setId(Long.decode("2"));
    this.customer.setEndereco(null);
    this.customer.setName("name");

    this.customerList = new ArrayList<>(Arrays.asList(customer));
  }
  @Test
  public void shouldBySuccessWhenPostCustomer(){
    when(this.customerService.createCustomer(any(Customer.class))).thenReturn(this.customer);
    final DeferredResult<ResponseEntity<Customer>> customer = this.customerController
        .postCustomer(this.customer);
    final ResponseEntity<Customer> response = (ResponseEntity<Customer>) customer.getResult();
    Assert.assertEquals("should by equals",this.customer,response.getBody());
  }
  @Test
  public void shouldBySuccessWhenAllCustomer(){
    when(this.customerService.findAll()).thenReturn(this.customerList);
    final List<Customer> customer = this.customerController.findAll();
    Assert.assertEquals("should by equals",this.customerList,customer);
  }

  //ver com o miura
  /*@Test
  public void shouldBySuccessWithFindByCustomer(){
    when(this.customerService.findById(anyLong())).thenReturn(this.customer);
    final List<Customer> customer = this.customerController.findAll();
    Assert.assertEquals("should by equals",this.customerList,customer);
  }*/

  @Test
  public void shouldBySuccessWhenDeleteCustomer(){
    doNothing().when(this.customerService).deleteCustomer(anyLong());
    this.customerController.deleteCustomer(this.customer.getId());
    Assert.assertNotNull(this.customer);
  }

  @Test
  public void shouldBySuccessWhenPutCustomer(){
    when(this.customerService.alterCustomer(any(Customer.class))).thenReturn(this.customer);
    final DeferredResult<ResponseEntity<Customer>> customer =
        this.customerController.putCustomer(this.customer);
    final ResponseEntity<Customer> response = (ResponseEntity<Customer>) customer.getResult();
    Assert.assertEquals("should by equals",this.customer,response.getBody());
  }
}
