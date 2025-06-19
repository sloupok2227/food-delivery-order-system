package com.example.fooddelivery.controller;

import com.example.fooddelivery.entity.*;
import com.example.fooddelivery.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    private final ClientService clientService;
    private final DeliverymanService deliverymanService;

    public OrderController(OrderService orderService, ClientService clientService, DeliverymanService deliverymanService) {
        this.orderService = orderService;
        this.clientService = clientService;
        this.deliverymanService = deliverymanService;
    }

    @GetMapping
    public String listOrders(Model model) {
        model.addAttribute("orders", orderService.findAll());
        return "orders";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("order", new Order());
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("deliverymen", deliverymanService.findAll());
        return "order-form";
    }

    @PostMapping
    public String createOrder(@ModelAttribute Order order) {
        order.setOrderDate(LocalDateTime.now());
        orderService.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        orderService.findById(id).ifPresent(o -> model.addAttribute("order", o));
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("deliverymen", deliverymanService.findAll());
        return "order-form";
    }

    @PostMapping("/update/{id}")
    public String updateOrder(@PathVariable Long id, @ModelAttribute Order order) {
        order.setId(id);
        orderService.save(order);
        return "redirect:/orders";
    }

    @GetMapping("/delete/{id}")
    public String deleteOrder(@PathVariable Long id) {
        orderService.deleteById(id);
        return "redirect:/orders";
    }
}
