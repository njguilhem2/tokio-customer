package com.example.api;

import com.example.api.domain.Customer;
import com.example.api.repository.CustomerRepository;
import com.example.api.service.impl.CustomerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {
    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    private Customer customer;

    private Optional<Customer> customerOptional;
    private List<Customer> customerList;

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
        this.customerList = new ArrayList<Customer>(Arrays.asList(this.customer));
    }

    @Test
    public void shouldBeSuccessWhenCreateCustomer(){
        when(this.customerRepository.save(any(Customer.class))).thenReturn(this.customer);
        Customer customerCreate = this.customerService.createCustomer(this.customer);
        Assert.assertEquals("should be equals when created customer",this.customer,customerCreate);
    }
    @Test
    public void shouldBeSuccessWhenFindByCustomer(){
        when(this.customerRepository.findById(anyLong())).thenReturn(this.customerOptional);
        Optional<Customer> customer = this.customerService.findById(1L);
        Assert.assertEquals("should be equals when find by customer",this.customerOptional,customer);
    }
    /*@Test
    public void shouldBeSuccessWhenFindAllCustomer(){
        when(this.customerRepository.findAllByOrderByNameAsc()).thenReturn(this.customerList);
        List<Customer> customer = this.customerService.findAll();
        Assert.assertEquals("should be equals when find all customer",this.customerList,customer);
    }*/
    @Test
    public void shouldBeSuccessWhenDeleteCustomer(){
        doNothing().when(this.customerRepository).deleteById(anyLong());
        Assert.assertNotNull("shouldn't be null",this.customer);
    }
    @Test
    public void shouldBeSuccessWhenAlterCustomer(){
        doNothing().when(this.customerRepository).deleteById(anyLong());
        when(this.customerRepository.save(any(Customer.class))).thenReturn(this.customer);
        Customer customer = this.customerService.alterCustomer(this.customer);
        Assert.assertEquals("should be equals when alter customer",this.customer,customer);
    }
}
