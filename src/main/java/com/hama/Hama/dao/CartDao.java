package com.hama.Hama.dao;

import com.hama.Hama.entities.CartEntity;

import java.util.List;

public interface CartDao {
    void insert(CartEntity cart);

    void edit(CartEntity cart);

    void delete(int id);

    CartEntity get(int id);

    List<CartEntity> getAll();

}
