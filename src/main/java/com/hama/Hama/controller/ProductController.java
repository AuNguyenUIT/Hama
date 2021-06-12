package com.hama.Hama.controller;

import com.hama.Hama.entities.ProductEntity;
import com.hama.Hama.service.CategoryService;
import com.hama.Hama.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/san-pham/chi-tiet/{product_id}")
    public String showDetailProduct(Model model, @PathVariable String product_id) {
        ProductEntity product = productService.getProduct(Integer.parseInt(product_id));
        model.addAttribute("product", product);
        return "client/product-detail";
    }
}
