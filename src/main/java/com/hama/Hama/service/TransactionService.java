package com.hama.Hama.service;

import com.hama.Hama.entities.TransactionEntity;

import java.util.List;

public interface TransactionService {

    Integer saveTransaction(TransactionEntity post);

    Boolean deleteTransaction(Integer id);

    List<TransactionEntity> getTransactions();

    TransactionEntity getTransaction(Integer id);
}
