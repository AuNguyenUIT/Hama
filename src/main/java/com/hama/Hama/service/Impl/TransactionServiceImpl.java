package com.hama.Hama.service.Impl;

import com.hama.Hama.dao.TransactionDao;
import com.hama.Hama.entities.TransactionEntity;
import com.hama.Hama.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    TransactionDao transactionDao;

    @Override
    @Transactional
    public Integer saveTransaction(TransactionEntity transaction) {
        return transactionDao.saveTransaction(transaction);
    }

    @Override
    @Transactional
    public Boolean deleteTransaction(Integer id) {
        return transactionDao.deleteTransaction(id);
    }

    @Override
    @Transactional
    public List<TransactionEntity> getTransactions() {
        return transactionDao.getTransactions();
    }

    @Override
    @Transactional
    public TransactionEntity getTransaction(Integer id) {
        return transactionDao.getTransaction(id);
    }


}
