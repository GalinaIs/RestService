package com.mycompany.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private Long managerId;

    public Client() {

    }

    public Client(String name, String address) {
        this(name, address, null);
    }

    public Client(String name, String address, Long managerId) {
        this.name = name;
        this.address = address;
        this.managerId = managerId;
    }
}
