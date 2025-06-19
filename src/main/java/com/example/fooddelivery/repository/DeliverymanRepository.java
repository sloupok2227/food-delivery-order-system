package com.example.fooddelivery.repository;

import com.example.fooddelivery.entity.Deliveryman;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliverymanRepository extends JpaRepository<Deliveryman, Long> {
}
