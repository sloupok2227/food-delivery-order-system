package com.example.fooddelivery.service;

import com.example.fooddelivery.entity.OrderDetail;
import com.example.fooddelivery.repository.OrderDetailRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService {
    private final OrderDetailRepository repository;

    public OrderDetailService(OrderDetailRepository repository) {
        this.repository = repository;
    }

    public List<OrderDetail> findAll() {
        return repository.findAll();
    }

    public Optional<OrderDetail> findById(Long id) {
        return repository.findById(id);
    }

    public OrderDetail save(OrderDetail detail) {
        return repository.save(detail);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
