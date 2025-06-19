package com.example.fooddelivery.service;

import com.example.fooddelivery.entity.Menu;
import com.example.fooddelivery.repository.MenuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private final MenuRepository repository;

    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public List<Menu> findAll() {
        return repository.findAll();
    }

    public Optional<Menu> findById(Long id) {
        return repository.findById(id);
    }

    public Menu save(Menu menu) {
        return repository.save(menu);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
