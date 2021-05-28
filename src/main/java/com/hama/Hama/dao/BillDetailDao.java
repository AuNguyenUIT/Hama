package com.hama.Hama.dao;

import com.hama.Hama.model.BillDetail;

import java.util.List;

public interface BillDetailDao {
    void insert(BillDetail billDetail);

    void edit(BillDetail billDetail);

    void delete(int id);

    BillDetail get(int id);

    List<BillDetail> getAll();


}
