package com.picsart.java;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "customers")
public class Customers {
    @Id
    @Column(name = "customer_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "address",nullable = false)
    private String address;
    @Column(name = "created_at",nullable = false)
    private Date created_at;

    public Customers() {
    }

    public Customers(String name, String email, String address, Date created_at) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.created_at = created_at;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
