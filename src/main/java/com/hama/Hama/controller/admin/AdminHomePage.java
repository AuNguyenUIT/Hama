package com.hama.Hama.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminHomePage {
    @RequestMapping("/quan-tri")
    public String hello(Model model) {
        return "admin/index";
    }

}