package com.example.demo.controller;

import com.example.demo.service.AllowedStatusCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {

    @Autowired
    private AllowedStatusCodeService allowedStatusCodeService;

    @GetMapping("/")
    public String mainPage() {
        return "main";
    }

    @PostMapping("/get-cat")
    public String getCat(@RequestParam(required = false) Integer statusCode, Model model) {
        if (statusCode != null) {
            if (allowedStatusCodeService.isAllowed(statusCode)) {
                model.addAttribute("statusCode", statusCode);
                model.addAttribute("catUrl", "https://http.cat/" + statusCode);
            } else {
                model.addAttribute("error", "Этот статус-код не разрешён администратором.");
            }
        }
        return "main";
    }
} 