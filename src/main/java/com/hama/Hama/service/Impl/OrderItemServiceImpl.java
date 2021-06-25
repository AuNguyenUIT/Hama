package com.hama.Hama.service.Impl;

import com.hama.Hama.dao.OrderItemDao;
import com.hama.Hama.entities.OrderItemEntity;
import com.hama.Hama.service.OrderItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class OrderItemServiceImpl implements OrderItemService {

    @Autowired
    OrderItemDao orderItemDao;

    @Override
    @Transactional
    public List<OrderItemEntity> getOrderItems() {
        return orderItemDao.getOrderItems();
    }

    @Override
    @Transactional
    public int saveOrderItem(OrderItemEntity orderItemEntity) {
        return orderItemDao.saveOrderItem(orderItemEntity);
    }

    @Override
    @Transactional
    public Boolean deleteOrderItem(int id) {
        return orderItemDao.deleteOrderItem(id);
    }

    @Override
    @Transactional
    public OrderItemEntity getOrderItem(int id) {
        return orderItemDao.getOrderItem(id);
    }

    @Override
    @Transactional
    public List<OrderItemEntity> getOrderItemByOrderId(Integer order_id) {
        return orderItemDao.getOrderItemsByOrderId(order_id);
    }
}
