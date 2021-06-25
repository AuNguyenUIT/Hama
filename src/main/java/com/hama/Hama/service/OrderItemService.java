package com.hama.Hama.service;

import com.hama.Hama.entities.OrderItemEntity;

import java.util.List;

public interface OrderItemService {
    List<OrderItemEntity> getOrderItems();

    int saveOrderItem(OrderItemEntity orderItemEntity);

    Boolean deleteOrderItem(int id);

    OrderItemEntity getOrderItem(int id);

    List<OrderItemEntity> getOrderItemByOrderId(Integer order_id);
}
