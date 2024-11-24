package com.springdatajpa.example.model;


import jakarta.persistence.*;

@Entity
@Table(name = "address")
public class Address {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String city;

    @OneToOne(mappedBy = "address")
    private Employee emp;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


}
