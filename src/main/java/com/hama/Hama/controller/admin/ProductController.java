package com.hama.Hama.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @RequestMapping("/quan-tri/san-pham/danh-sach")
    public String productList(Model model) {
        return "products";
    }

    @RequestMapping("/quan-tri/san-pham/them")
    public String addProduct(){
        return "product-add-form";
    }
}
