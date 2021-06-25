package com.hama.Hama.dao;

import com.hama.Hama.entities.OrderEntity;

import java.util.List;

public interface OrderDao {
    List<OrderEntity> getOrders();

    int saveOrder(OrderEntity OrderEntity);

    Boolean deleteOrder(int id);

    OrderEntity getOrder(int id);

    OrderEntity getOrderByStatusAndUid(String order_status, Integer uid);
}
