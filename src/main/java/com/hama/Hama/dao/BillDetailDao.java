package com.hama.Hama.dao;

import com.hama.Hama.entities.BillDetailEntity;

import java.util.List;

public interface BillDetailDao {
    void insert(BillDetailEntity billDetail);

    void edit(BillDetailEntity billDetail);

    void delete(int id);

    BillDetailEntity get(int id);

    List<BillDetailEntity> getAll();


}
