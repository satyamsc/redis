package com.example.redis.enitity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

@Data
@Entity
@ToString
public class Customer implements Serializable{
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String email;
}
