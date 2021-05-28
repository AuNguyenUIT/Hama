package com.hama.Hama.dao;

import com.hama.Hama.model.Cart;

import java.util.List;

public interface CartDao {
    void insert(Cart cart);

    void edit(Cart cart);

    void delete(int id);

    Cart get(int id);

    List<Cart> getAll();

}
