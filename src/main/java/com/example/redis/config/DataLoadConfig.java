package com.example.redis.config;

import com.example.redis.dao.CustomerRepository;
import com.example.redis.enitity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class DataLoadConfig {

    @Autowired
    private CustomerRepository customerRepository;

    @Bean
    public CommandLineRunner dataInsertRunner() {
        return args -> {
            List<Customer> customers = new ArrayList<>();
            for (int i = 0; i < 1000; i++) {
                Customer customer = new Customer();
                customer.setName("Test " + i);
                customer.setEmail(" email_" + i + "@gmail.com");
                customers.add(customer);
            }
            customerRepository.saveAll(customers);
        };
    }
}
