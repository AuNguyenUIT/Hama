package com.hama.Hama.dao;

import com.hama.Hama.model.Order;

import java.util.List;

public interface OrderDao {
    void insert(Order order);

    void edit(Order order);

    void delete(int id);

    Order get(int id);

    List<Order> getAll();

}
