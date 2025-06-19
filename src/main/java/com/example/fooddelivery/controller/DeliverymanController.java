package com.example.fooddelivery.controller;

import com.example.fooddelivery.entity.Deliveryman;
import com.example.fooddelivery.service.DeliverymanService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/deliverymen")
public class DeliverymanController {
    private final DeliverymanService deliverymanService;

    public DeliverymanController(DeliverymanService deliverymanService) {
        this.deliverymanService = deliverymanService;
    }

    @GetMapping
    public String listDeliverymen(Model model) {
        model.addAttribute("deliverymen", deliverymanService.findAll());
        return "deliverymen";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("deliveryman", new Deliveryman());
        return "deliveryman-form";
    }

    @PostMapping
    public String createDeliveryman(@ModelAttribute Deliveryman deliveryman) {
        deliverymanService.save(deliveryman);
        return "redirect:/deliverymen";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        deliverymanService.findById(id).ifPresent(d -> model.addAttribute("deliveryman", d));
        return "deliveryman-form";
    }

    @PostMapping("/update/{id}")
    public String updateDeliveryman(@PathVariable Long id, @ModelAttribute Deliveryman deliveryman) {
        deliveryman.setId(id);
        deliverymanService.save(deliveryman);
        return "redirect:/deliverymen";
    }

    @GetMapping("/delete/{id}")
    public String deleteDeliveryman(@PathVariable Long id) {
        deliverymanService.deleteById(id);
        return "redirect:/deliverymen";
    }
}
