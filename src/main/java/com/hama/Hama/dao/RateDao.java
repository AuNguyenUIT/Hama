package com.hama.Hama.dao;

import com.hama.Hama.model.Rate;

import java.util.List;

public interface RateDao {

    void insert(Rate rate);

    void edit(Rate rate);

    void delete(int id);

    Rate get(int id);

    List<Rate> getAll();

}
