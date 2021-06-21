package com.hama.Hama.dao;

import com.hama.Hama.entities.RateEntity;

import java.util.List;

public interface RateDao {

    List<RateEntity> getRates();

    int saveRate(RateEntity rateEntity);

    void deleteRate(int id);

    RateEntity getRate(int id);

}
