package com.hama.Hama.service.Impl;

import com.hama.Hama.dao.RateDao;
import com.hama.Hama.entities.RateEntity;
import com.hama.Hama.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class RateServiceImpl implements RateService {
    
    @Autowired
    RateDao rateDao;

    @Override
    @Transactional
    public Integer saveRate(RateEntity rate) {
        return rateDao.saveRate(rate);
    }

    @Override
    @Transactional
    public Boolean deleteRate(Integer id) {
       return  rateDao.deleteRate(id);
    }

    @Override
    @Transactional
    public List<RateEntity> getRates() {
        return rateDao.getRates();
    }

    @Override
    @Transactional
    public RateEntity getRate(Integer id) {
        return rateDao.getRate(id);
    }


}
