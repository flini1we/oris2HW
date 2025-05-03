package com.example.demo.controller;

import com.example.demo.service.AllowedStatusCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/allowed-codes")
public class AdminAllowedStatusCodeController {
    @Autowired
    private AllowedStatusCodeService service;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("codes", service.findAll());
        return "admin/allowed_codes";
    }

    @PostMapping("/add")
    public String add(@RequestParam Integer code) {
        service.addCode(code);
        return "redirect:/admin/allowed-codes";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long id) {
        service.deleteById(id);
        return "redirect:/admin/allowed-codes";
    }
} 