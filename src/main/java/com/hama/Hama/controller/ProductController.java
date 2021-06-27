package com.hama.Hama.controller;

import com.hama.Hama.entities.CategoryEntity;
import com.hama.Hama.entities.CommentEntity;
import com.hama.Hama.entities.ProductEntity;
import com.hama.Hama.service.CategoryService;
import com.hama.Hama.service.CommentService;
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
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;

    @Autowired
    CommentService commentService;

    @GetMapping("/san-pham/{product_id}")
    public String showDetailProduct(Model model, @PathVariable String product_id, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        ProductEntity product = productService.getProduct(Integer.parseInt(product_id));
        if (product == null) {
            return "client/404";
        }
        if (session != null) {
            Set<Integer> productIds = new HashSet<>();
            if (session.getAttribute("productsLastView") != null) {
                Set<Integer> productOldIds = (Set<Integer>) session.getAttribute("productsLastView");
                productIds.add(Integer.parseInt(product_id));
                Iterator<Integer> iterator = productOldIds.iterator();
                int i = 0;
                while (iterator.hasNext() && i < 3) {
                    productIds.add(iterator.next());
                    i++;
                }
            } else {
                productIds.add(Integer.parseInt(product_id));
            }
            session.setAttribute("productsLastView", productIds);
        }
        List<CommentEntity> comments = commentService.getCommentsByProductId(product.getId());
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
        model.addAttribute("product", product);
        model.addAttribute("comments", comments);
        return "client/product-detail";
    }

    @RequestMapping(value = "/san-pham/tim-kiem", method = RequestMethod.POST, produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public ModelAndView searchProduct(HttpServletRequest request, ModelMap model) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String category_id = request.getParameter("category_id");
        String title = request.getParameter("title");

        if (category_id != null) {
            if (!category_id.equals("0")) {
                model.addAttribute("danh-muc", category_id);
                model.addAttribute("ten", title);
//            return "redirect:/san-pham?danh-muc=" + category_id + "&ten=" + title;
            } else {
                model.addAttribute("ten", title);
            }
        }
        model.addAttribute("ten", title);
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
        HttpSession session = request.getSession(true);
        if (session != null) {
            if (session.getAttribute("productsLastView") != null) {
                Set<Integer> productIds = (Set<Integer>) session.getAttribute("productsLastView");
                Iterator<Integer> iterator = productIds.iterator();
                StringBuilder ids = new StringBuilder("( ");
                int i = 1;
                while (iterator.hasNext()) {
                    if (i == productIds.size()) {
                        ids.append(iterator.next());
                    } else {
                        ids.append(iterator.next());
                        ids.append(",");
                    }
                    i++;
                }
                ids.append(")");
                String queryString = "From ProductEntity WHERE id IN " + ids + " ORDER BY created DESC";
                List<ProductEntity> products = productService.getProductsByQuery(queryString);
                model.addAttribute("productsLastView", products);
            }
        }
        List<ProductEntity> products = productService.getProductByCategoryAndName(id, title);
        model.addAttribute("products", products);
        return "client/products";
    }
}
