package com.example.fooddelivery.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String foodName;
    private double weight;
    private BigDecimal price;

    @OneToMany(mappedBy = "menu", cascade = CascadeType.ALL)
    private List<OrderDetail> orderDetails;

    // getters and setters
}
