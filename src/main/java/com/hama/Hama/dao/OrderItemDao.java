package com.hama.Hama.dao;

import com.hama.Hama.entities.OrderItemEntity;

import java.util.List;

public interface OrderItemDao {
    List<OrderItemEntity> getOrderItems();

    int saveOrderItem(OrderItemEntity orderItemEntity);

    Boolean deleteOrderItem(int id);

    OrderItemEntity getOrderItem(int id);

    List<OrderItemEntity> getOrderItemsByOrderId(Integer order_id);
}
