package com.example.redis.service.impl;

import com.example.redis.dao.CustomerRepository;
import com.example.redis.enitity.Customer;
import com.example.redis.service.CustomerService;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository repository;

    @Override
    @CachePut(value = "saveCustomer", key = "#customer.id")
    public Customer save(Customer customer) {
        return repository.save(customer);
    }

    @Override
    @CacheEvict(value = "DeleteCustomer", key = "#id")
    public void deleteById(Long id) {
        repository.deleteById(id);

    }

    @Override
    @Cacheable(value = "customer", key = "#id")
    public Customer findById(Long id) {
        return repository.findById(id).orElseThrow(IllegalAccessError::new);
    }

    @Override
    @Cacheable(value = "Customers", key = "'allCustomers'")
    public List<Customer> findAll() {
        return repository.findAll();
    }

    @Override
    @CachePut(value = "update", key = "#id")
    public Customer update(Customer customer, Long id) {
        findById(id);
        customer.setId(id);
        return save(customer);
    }
}
