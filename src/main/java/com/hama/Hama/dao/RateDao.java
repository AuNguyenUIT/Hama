package com.hama.Hama.dao;

import com.hama.Hama.entities.RateEntity;

import java.util.List;

public interface RateDao {

    void insert(RateEntity rate);

    void edit(RateEntity rate);

    void delete(int id);

    RateEntity get(int id);

    List<RateEntity> getAll();

}
