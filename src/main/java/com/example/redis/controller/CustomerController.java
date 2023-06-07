package com.example.redis.controller;

import com.example.redis.enitity.Customer;
import com.example.redis.service.CustomerService;
import lombok.Data;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
@Data
public class CustomerController {
    private final CustomerService service;

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return service.save(customer);
    }

    @GetMapping
    public List<Customer> list() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable("id") long id) {
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") long id) {
        service.deleteById(id);
    }

    @PutMapping("/{id}")
    public Customer update(@RequestBody Customer customer, @PathVariable("id") long id) {
        return service.update(customer, id);
    }


}
