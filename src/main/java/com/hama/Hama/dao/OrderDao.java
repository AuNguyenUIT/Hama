package com.hama.Hama.dao;

import com.hama.Hama.entities.OrderEntity;

import java.util.List;

public interface OrderDao {
    void insert(OrderEntity order);

    void edit(OrderEntity order);

    void delete(int id);

    OrderEntity get(int id);

    List<OrderEntity> getAll();

}
