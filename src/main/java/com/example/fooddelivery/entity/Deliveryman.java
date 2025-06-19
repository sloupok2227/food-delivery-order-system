package com.example.fooddelivery.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Deliveryman {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private String phone;

    @OneToMany(mappedBy = "deliveryman", cascade = CascadeType.ALL)
    private List<Order> orders;

    // getters and setters
}
