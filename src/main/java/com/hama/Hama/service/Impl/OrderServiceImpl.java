package com.hama.Hama.service.Impl;

import com.hama.Hama.dao.OrderDao;
import com.hama.Hama.entities.OrderEntity;
import com.hama.Hama.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderDao orderDao;

    @Override
    @Transactional
    public List<OrderEntity> getOrders() {
        return orderDao.getOrders();
    }

    @Override
    @Transactional
    public int saveOrder(OrderEntity orderEntity) {
        return orderDao.saveOrder(orderEntity);
    }

    @Override
    @Transactional
    public Boolean deleteOrder(int id) {
        return orderDao.deleteOrder(id);

    }

    @Override
    @Transactional
    public OrderEntity getOrder(int id) {
        return orderDao.getOrder(id);
    }

    @Override
    @Transactional
    public OrderEntity getOrderByStatusAndUid(String order_status, Integer uid) {
        return orderDao.getOrderByStatusAndUid(order_status, uid);
    }
}
