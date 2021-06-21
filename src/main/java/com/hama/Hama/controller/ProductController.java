package com.hama.Hama.controller;

import com.hama.Hama.entities.CategoryEntity;
import com.hama.Hama.entities.ProductEntity;
import com.hama.Hama.service.CategoryService;
import com.hama.Hama.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @GetMapping("/san-pham/chi-tiet/{product_id}")
    public String showDetailProduct(Model model, @PathVariable String product_id) {
        ProductEntity product = productService.getProduct(Integer.parseInt(product_id));
        model.addAttribute("product", product);
        return "client/product-detail";
    }

    @RequestMapping(value = "/san-pham/tim-kiem", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView searchProduct(HttpServletRequest request, ModelMap model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String category_id = request.getParameter("category_id");
        String title = request.getParameter("title");

        if (!category_id.equals("0")) {
            model.addAttribute("danh-muc", category_id);
            model.addAttribute("ten", title);
//            return "redirect:/san-pham?danh-muc=" + category_id + "&ten=" + title;
        } else {
            model.addAttribute("ten", title);
        }
        return new ModelAndView("redirect:/san-pham", model);
    }

    @RequestMapping("/san-pham")
    public String showProducts(Model model, HttpServletRequest request) {
        String category_id = request.getParameter("danh-muc");
        String title = request.getParameter("ten");
        int id = 0;

        if (category_id != null) {
            id = Integer.parseInt(category_id);
        }
        if (title == null) {
            title = "";
        }
        List<CategoryEntity> categoryList = categoryService.getCategories();
        model.addAttribute("categories", categoryList);
        model.addAttribute("category_id", id);
        model.addAttribute("title", title);
        List<ProductEntity> products = productService.getProductByCategoryAndName(id, title);
        model.addAttribute("products", products);
        return "client/products";
    }
}
