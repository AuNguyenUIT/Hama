package com.hama.Hama.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hama.Hama.entities.OrderEntity;
import com.hama.Hama.entities.OrderItemEntity;
import com.hama.Hama.entities.ProductEntity;
import com.hama.Hama.entities.UserEntity;
import com.hama.Hama.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @Autowired
    UserService userService;
    @Autowired
    OrderItemService orderItemService;
    @Autowired
    TransactionService transactionService;

    @Value("${stripe.keys.public}")
    private String API_PUBLIC_KEY;

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

        HttpSession session = request.getSession(true);
        if (session.getAttribute("uid") == null) {
            return "redirect:/dang-nhap";
        } else {
            UserEntity user = userService.getUser((int) session.getAttribute("uid"));
            OrderEntity order = orderService.getOrderByStatusAndUid(OrderStatus.CART, user.getId());
            if (order.getId() == null) {
                order = new OrderEntity();
                order.setEmail((String) session.getAttribute("email"));
                order.setUser(user);
                order.setCreated(new Date());
                order.setModified(new Date());
                order.setTotal((float) 0);
                order.setStatus(OrderStatus.CART);
                int order_id = orderService.saveOrder(order);
            }
            OrderItemEntity orderItem = new OrderItemEntity();
            float unitPrice = product.getPrice() - product.getPrice() * product.getSale() / 100;
            float total = unitPrice * Integer.parseInt(quantity);
            orderItem.setProduct(product);
            orderItem.setQuantity(Integer.parseInt(quantity));
            orderItem.setSize(size);
            orderItem.setUnitPrice(unitPrice);
            orderItem.setTotal(total);
            orderItem.setOrder(order);
            orderItem.setCreated(new Date());
            orderItem.setModified(new Date());
            float order_total = order.getTotal() + total;
            order.setTotal(order_total);
            int order_item = orderItemService.saveOrderItem(orderItem);
            List<OrderItemEntity> orderItems = (List<OrderItemEntity>) session.getAttribute("order_items");
            if (orderItems != null) {
                orderItems.add(orderItem);

            } else {
                orderItems = new ArrayList<>();
                orderItems.add(orderItem);
            }
            session.setAttribute("order_items", orderItems);
            session.setAttribute("total", order_total);
            session.setAttribute("length", orderItems.size());
            orderService.saveOrder(order);
        }
        return "redirect:" + current_path;
    }


    @RequestMapping("/gio-hang")
    public String showCart(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("uid") != null) {
            OrderEntity order = orderService.getOrderByStatusAndUid(OrderStatus.CART, (int) session.getAttribute("uid"));
            if (order.getId() != null) {
                List<OrderItemEntity> orderItems = orderItemService.getOrderItemByOrderId(order.getId());
                model.addAttribute("order", order);
                model.addAttribute("items", orderItems);
                session.setAttribute("order_items", orderItems);
                session.setAttribute("total", order.getTotal());
                session.setAttribute("length", orderItems.size());
            }
        } else {
            return "redirect:/";
        }
        return "client/cart";
    }

    @RequestMapping("/gio-hang/xoa")
    public String deleteOrderItem(Model model, HttpServletRequest request) {
        String item_id = request.getParameter("id");
        HttpSession session = request.getSession(true);
        if (item_id != null) {
            OrderEntity order = orderService.getOrderByStatusAndUid(OrderStatus.CART, (int) session.getAttribute("uid"));
            OrderItemEntity orderItem = orderItemService.getOrderItem(Integer.parseInt(item_id));
            if (orderItem.getId() != null) {
                order.setTotal(order.getTotal() - orderItem.getTotal());
            }
            Boolean status_delete = orderItemService.deleteOrderItem(Integer.parseInt(item_id));
            if (status_delete) {
                orderService.saveOrder(order);
            }
        }
        return "redirect:/gio-hang";
    }


    @RequestMapping("/thanh-toan")
    public String showCheckoutPane(Model model) {
        return "client/checkout";
    }

    @RequestMapping(value = "/thanh-toan", method = RequestMethod.POST)
    public String checkout(Model model, HttpServletRequest request) {
//        String tr_username = request.getParameter("transaction_name");
//        String tr_usermail = request.getParameter("transaction_email");
        String phone = request.getParameter("transaction_phone");
        String address = request.getParameter("transaction_address");
        String mess = request.getParameter("transaction_mess");
//        String tr_created = request.getParameter("transaction_created");
        String payment = request.getParameter("transaction_payment");
        System.out.println(payment);
        return "client/checkout";
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

