package com.hama.Hama.dao;

import com.hama.Hama.entities.TransactionEntity;

import java.util.List;

public interface TransactionDao {

    List<TransactionEntity> getTransactions();

    int saveTransaction(TransactionEntity transactionEntity);

    Boolean deleteTransaction(int id);

    TransactionEntity getTransaction(int id);
}
