package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/admin/users")
    public String userList(Model model, Authentication authentication) {
        model.addAttribute("users", userRepository.findAll());
        model.addAttribute("currentUser", authentication.getName());
        return "admin/users";
    }

    @PostMapping("/admin/delete-user")
    public String deleteUser(@RequestParam Long userId, Authentication authentication) {
        User user = userRepository.findById(userId).orElse(null);
        if (user != null && !user.getUsername().equals(authentication.getName())) {
            userRepository.deleteById(userId);
        }
        return "redirect:/admin/users";
    }
} 