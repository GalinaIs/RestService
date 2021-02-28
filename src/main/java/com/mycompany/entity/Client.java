package com.mycompany.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mycompany.serializer.CustomManagerSerializerForClient;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    @ManyToOne
    @JoinColumn(name = "manager_id", referencedColumnName = "id")
    @JsonSerialize(using = CustomManagerSerializerForClient.class)
    private Manager manager;

    public Client() {

    }

    public Client(String name, String address) {
        this.name = name;
        this.address = address;
    }
}
