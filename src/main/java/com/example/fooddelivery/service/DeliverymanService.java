package com.example.fooddelivery.service;

import com.example.fooddelivery.entity.Deliveryman;
import com.example.fooddelivery.repository.DeliverymanRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliverymanService {
    private final DeliverymanRepository repository;

    public DeliverymanService(DeliverymanRepository repository) {
        this.repository = repository;
    }

    public List<Deliveryman> findAll() {
        return repository.findAll();
    }

    public Optional<Deliveryman> findById(Long id) {
        return repository.findById(id);
    }

    public Deliveryman save(Deliveryman deliveryman) {
        return repository.save(deliveryman);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
