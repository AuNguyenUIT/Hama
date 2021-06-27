package com.hama.Hama.controller;

import com.hama.Hama.dao.ProductDao;
import com.hama.Hama.entities.CategoryEntity;
import com.hama.Hama.entities.OrderItemEntity;
import com.hama.Hama.entities.PostEntity;
import com.hama.Hama.entities.ProductEntity;
import com.hama.Hama.service.CategoryService;
import com.hama.Hama.service.PostService;
import com.hama.Hama.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    CategoryService categoryService;

    @Autowired
    ProductService productService;

    @Autowired
    PostService postService;

    @RequestMapping("/")
    public String homePage(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession(true);
        if (session.getAttribute("role") != null) {
            if (session.getAttribute("role").equals(UserRole.ADMIN)) {
                return "redirect:/quan-tri";
            }
        }
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
        List<CategoryEntity> categoryList = categoryService.getCategories();
        model.addAttribute("categories", categoryList);
        String queryString = "From ProductEntity ORDER BY created DESC";
        List<ProductEntity> products = productService.getProductsByQuery(queryString);
        model.addAttribute("productsNew", products);
        queryString = "From PostEntity WHERE status =1 ORDER BY created DESC";

        List<PostEntity> posts = postService.getPostsByQuery(queryString);

        queryString = "From ProductEntity WHERE sale > 0 ORDER BY sale DESC";
        products = productService.getProductsByQuery(queryString);
        model.addAttribute("productsSale", products);
        model.addAttribute("posts", posts);
        return "client/index";
    }

    @RequestMapping("/gioi-thieu")
    public String introduce(Model model) {

        return "client/introduce";
    }

    @RequestMapping("/chinh-sach")
    public String policy(Model model) {
        return "client/security";
    }

    @RequestMapping("/huong-dan-dat-hang")
    public String order(Model model) {
        return "client/order";
    }

    @RequestMapping("/huong-dan-thanh-toan")
    public String payment(Model model) {
        return "client/payment";
    }

    @RequestMapping("/chinh-sach-bao-mat")
    public String security(Model model) {
        return "client/security";
    }
}
