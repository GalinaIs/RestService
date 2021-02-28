package com.mycompany.entity;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mycompany.serializer.CustomManagerSerializer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Setter
@Getter
@ToString(exclude = {"clients", "deputy"})
@JsonSerialize(using = CustomManagerSerializer.class)
public class Manager {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surname;
    private String name;
    private String patronymic;
    private String phoneNumber;
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "manager_id")
    Set<Client> clients;
    @ManyToOne
    @JoinColumn(name = "deputy_id", insertable = false, updatable = false)
    private Manager deputy;
    @Column(name = "deputy_id")
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
