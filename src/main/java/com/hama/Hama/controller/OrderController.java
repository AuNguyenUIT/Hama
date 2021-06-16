package com.hama.Hama.controller;

import com.hama.Hama.dao.ProductDao;
import com.hama.Hama.entities.OrderItemEntity;
import com.hama.Hama.entities.ProductEntity;
import com.hama.Hama.service.ProductService;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    ProductService productService;

    @RequestMapping(value = "/them-gio-hang", method = RequestMethod.POST)
    public String addToCart(Model model, HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        String product_id = request.getParameter("product_id");
        String quantity = request.getParameter("quantity");
        String size = request.getParameter("size");
        String current_path = request.getParameter("current_path");

        if (size == null) {
            size = "xs";
        }
        if (quantity == null) {
            quantity = "1";
        }
        ProductEntity product = productService.getProduct(Integer.parseInt(product_id));
        ProductEntity new_product = new ProductEntity();
        new_product.setId(product.getId());
        new_product.setTitle(product.getTitle());
        new_product.setPrice(product.getPrice());
        new_product.setSale(product.getSale());
        new_product.setThumb(product.getThumb());

        HttpSession session = request.getSession(false);
        if (session != null) {
            List<OrderItemEntity> orderItems = this.getOrderInCookie(request);
            if (session.getAttribute("uid") == null) {
                OrderItemEntity orderItem = new OrderItemEntity();
                float unitPrice = product.getPrice() - product.getPrice() * product.getSale() / 100;
                Float total = unitPrice * Integer.parseInt(quantity);
                orderItem.setProduct(new_product);
                orderItem.setQuantity(Integer.parseInt(quantity));
                orderItem.setSize(size);
                orderItem.setUnitPrice(unitPrice);
                orderItem.setTotal(total);
                float order_total = 0;
                float total_quantity = 0;
                if (orderItems.isEmpty()) {
                    orderItems.add(orderItem);
                } else {
                    boolean check = false;
                    for (int i = 0; i < orderItems.size(); i++) {
                        OrderItemEntity orderItemOld = orderItems.get(i);
                        if (orderItem.getProduct().getId().equals(orderItemOld.getProduct().getId()) && orderItemOld.getSize().equals(orderItem.getSize())) {
                            check = true;
                            orderItem.setQuantity(orderItemOld.getQuantity() + orderItem.getQuantity());
                            orderItem.setTotal(orderItemOld.getTotal() + orderItem.getTotal());
                            orderItems.set(i, orderItem);
                            order_total = order_total + orderItem.getTotal();
                            total_quantity = total_quantity + orderItem.getQuantity();
                        } else {
                            order_total = order_total + orderItemOld.getTotal();
                            total_quantity = total_quantity + orderItemOld.getQuantity();

                        }
                    }
                    if (!check) {
                        orderItems.add(orderItem);
                    }
                }
                Gson gson = new Gson();
                session.setAttribute("order_items", orderItems);
                session.setAttribute("length", total_quantity);
                session.setAttribute("total", order_total);
                String string = URLEncoder.encode(gson.toJson(orderItems), "UTF-8");
                Cookie cookie = new Cookie("order_items", string);
                response.addCookie(cookie);

            } else {
                //Đã đăng nhập
            }
        }
        return "redirect:" + current_path;
    }


    public List<OrderItemEntity> getOrderInCookie(HttpServletRequest request) throws UnsupportedEncodingException {
        Cookie[] cookies = request.getCookies();
        Gson gson = new Gson();
        List<OrderItemEntity> orderItems = new ArrayList<>();
        Type orderItemsType = new TypeToken<ArrayList<OrderItemEntity>>() {
        }.getType();
        for (Cookie cookie : cookies) {
            if (cookie.getName().equals("order_items")) {
                String string = URLDecoder.decode(cookie.getValue(), "UTF-8");
                orderItems = gson.fromJson(string, orderItemsType);
            }
        }
        return orderItems;
    }
}

