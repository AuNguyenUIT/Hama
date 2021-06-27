package com.hama.Hama.controller.admin;

import com.hama.Hama.entities.OrderEntity;
import com.hama.Hama.entities.OrderItemEntity;
import com.hama.Hama.service.OrderItemService;
import com.hama.Hama.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/quan-tri/don-hang")
public class AdminOrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    @RequestMapping("/danh-sach")
    public String getAllOrders(Model model) {
        List<OrderEntity> orders = orderService.getOrders();
        model.addAttribute("orders", orders);
        return "admin/orders";

    }

    @RequestMapping("/{order_id}")
    public String orderDetail(Model model, @PathVariable String order_id) {

        OrderEntity order = orderService.getOrder(Integer.parseInt(order_id));
        if (order.getId() != null) {
            List<OrderItemEntity> orderItems = orderItemService.getOrderItemByOrderId(order.getId());
            model.addAttribute("items", orderItems);
            model.addAttribute("order", order);
        }
        return "admin/order-detail";
    }

}
