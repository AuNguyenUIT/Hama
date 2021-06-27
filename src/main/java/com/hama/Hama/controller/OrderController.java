package com.hama.Hama.controller;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hama.Hama.entities.*;
import com.hama.Hama.service.*;
import com.stripe.Stripe;
import com.stripe.model.Charge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.*;

@Controller
@PropertySource("classpath:application.properties")

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
    @Autowired
    StripeService stripeService;
    @Value("${stripe.keys.public}")
    private String API_PUBLIC_KEY;

    @RequestMapping(value = "/them-gio-hang", method = RequestMethod.POST)
    public String addToCart(Model model, HttpServletRequest request, HttpServletResponse response, RedirectAttributes rm) throws UnsupportedEncodingException {
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
        String message = "Thêm gi? hàng thành công!";
        String type = "success";
        rm.addFlashAttribute("message", message);
        rm.addFlashAttribute("type", type);
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
        return "client/cart";
    }

    @RequestMapping("/gio-hang/xoa")
    public String deleteOrderItem(Model model, HttpServletRequest request, RedirectAttributes rm) {
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
        String message = "Xóa thành công!";
        String type = "success";
        rm.addFlashAttribute("message", message);
        rm.addFlashAttribute("type", type);
        return "redirect:/gio-hang";
    }


    @RequestMapping("/thanh-toan")
    public String showCheckoutPane(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session.getAttribute("uid") != null) {
            OrderEntity order = orderService.getOrderByStatusAndUid(OrderStatus.CART, (int) session.getAttribute("uid"));
            if (order.getId() != null) {
                return "client/checkout";
            } else {
                return "redirect:/";
            }
        } else {
            return "redirect:/dang-nhap";
        }

    }

    @RequestMapping(value = "/thanh-toan", method = RequestMethod.POST)
    public String checkout(Model model, HttpServletRequest request, RedirectAttributes rm) {
        String phone = request.getParameter("transaction_phone");
        String address = request.getParameter("transaction_address");
        String mess = request.getParameter("transaction_mess");
        String payment = request.getParameter("transaction_payment");
        String name = request.getParameter("transaction_name");
        HttpSession session = request.getSession(true);
        OrderEntity order = orderService.getOrderByStatusAndUid(OrderStatus.CART, (int) session.getAttribute("uid"));
        UserEntity user = order.getUser();
        TransactionEntity transaction = new TransactionEntity();
        transaction.setAddress(address);
        transaction.setAmount(String.valueOf(order.getTotal()));
        transaction.setPhone(phone);
        transaction.setOrder(order);
        transaction.setMessage(mess);
        transaction.setUser(user);
        transaction.setName(name);
        transaction.setCreated(new Date());
        transaction.setModified(new Date());
        if (payment.equals("stripe")) {
            String token = request.getParameter("stripeToken");
            stripeService.createCharge(user.getMail(), token, Math.round(order.getTotal()));
            transaction.setPayment("stripe");

        } else {
            transaction.setPayment("cod");
        }
        order.setStatus(OrderStatus.COMPLETED);
        session.removeAttribute("order_items");
        session.removeAttribute("order");
        session.removeAttribute("total");
        session.removeAttribute("length");
        orderService.saveOrder(order);
        transactionService.saveTransaction(transaction);
        String message = "??t hàng thành công!";
        String type = "success";
        rm.addFlashAttribute("message", message);
        rm.addFlashAttribute("type", type);
        return "redirect:/";
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

