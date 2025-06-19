package com.example.fooddelivery.controller;

import com.example.fooddelivery.entity.Menu;
import com.example.fooddelivery.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/menu")
public class MenuController {
    private final MenuService menuService;

    public MenuController(MenuService menuService) {
        this.menuService = menuService;
    }

    @GetMapping
    public String listMenu(Model model) {
        model.addAttribute("menuItems", menuService.findAll());
        return "menu";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("menu", new Menu());
        return "menu-form";
    }

    @PostMapping
    public String createMenu(@ModelAttribute Menu menu) {
        menuService.save(menu);
        return "redirect:/menu";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        menuService.findById(id).ifPresent(item -> model.addAttribute("menu", item));
        return "menu-form";
    }

    @PostMapping("/update/{id}")
    public String updateMenu(@PathVariable Long id, @ModelAttribute Menu menu) {
        menu.setId(id);
        menuService.save(menu);
        return "redirect:/menu";
    }

    @GetMapping("/delete/{id}")
    public String deleteMenu(@PathVariable Long id) {
        menuService.deleteById(id);
        return "redirect:/menu";
    }
}
