package com.hama.Hama.controller;

import com.hama.Hama.entities.CommentEntity;
import com.hama.Hama.entities.ProductEntity;
import com.hama.Hama.service.CommentService;
import com.hama.Hama.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.Date;

@Controller
public class CommentController {
    @Autowired
    ProductService productService;

    @Autowired
    CommentService commentService;

    @RequestMapping(value = "/san-pham/danh-gia", method = RequestMethod.POST)
    public String comment(Model model, HttpServletRequest request) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        String product_id = request.getParameter("san-pham");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        ProductEntity product = productService.getProduct(Integer.parseInt(product_id));
        if (product != null) {
            CommentEntity comment = new CommentEntity();
            comment.setProduct(product);
            comment.setCreated(new Date());
            comment.setBody(message);
            comment.setName(name);
            comment.setEmail(email);
            commentService.saveComment(comment);
            return "redirect:/san-pham/" + product_id;
        } else {
            return "redirect:/";
        }

    }
}
