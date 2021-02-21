package com.mycompany.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "manager")
@Data
public class Manager {
    @Id
    @GeneratedValue
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private String phoneNumber;
    private Long deputyId;

    public Manager() {

    }

    public Manager(String surname, String name, String patronymic, String phoneNumber) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.phoneNumber = phoneNumber;
    }
}
