package com.example.fooddelivery.repository;

import com.example.fooddelivery.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
