package com.hama.Hama.service;

import com.hama.Hama.entities.RateEntity;

import java.util.List;

public interface RateService {
    Integer saveRate(RateEntity rateEntity);

    Boolean deleteRate(Integer id);

    List<RateEntity> getRates();

    RateEntity getRate(Integer id);
}
