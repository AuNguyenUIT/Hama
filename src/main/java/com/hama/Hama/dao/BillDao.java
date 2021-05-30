package com.hama.Hama.dao;

import com.hama.Hama.entities.BillEntity;

import java.util.List;

public interface BillDao {
    void insert(BillEntity bill);

    void edit(BillEntity bill);

    void delete(int id);

    BillEntity get(int id);

    List<BillEntity> getAll();

}
