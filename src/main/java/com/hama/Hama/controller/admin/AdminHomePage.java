package com.hama.Hama.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@Controller
public class AdminHomePage {
    @RequestMapping("/quan-tri")
    public String index(Model model) {
        Map md = model.asMap();
        for (Object modelKey : md.keySet()) {
            Object modelValue = md.get(modelKey);
            if (modelKey == "type") {
                model.addAttribute("type", modelValue);
            }
            if (modelKey == "message") {
                model.addAttribute("message", modelValue);
            }
        }
        return "admin/index";
    }

}