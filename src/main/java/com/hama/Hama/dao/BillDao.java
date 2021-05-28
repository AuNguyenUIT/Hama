package com.hama.Hama.dao;

import com.hama.Hama.model.Bill;

import java.util.List;

public interface BillDao {
    void insert(Bill bill);

    void edit(Bill bill);

    void delete(int id);

    Bill get(int id);

    List<Bill> getAll();

}
