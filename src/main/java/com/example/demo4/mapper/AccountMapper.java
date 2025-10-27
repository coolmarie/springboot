package com.example.demo4.mapper;

import com.example.demo4.entity.Account;
import com.example.demo4.entity.Transaction;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AccountMapper {
    Account findAccountById(Long id);
    List<Transaction> findTransactionsByAccountId(Long accountId);
    void insertTransaction(Transaction tx);
    void updateAccountBalance(Long accountId, java.math.BigDecimal newBalance);
    Account addAccount(Account account);
    Account deleteAccount(Long id);
    void deleteAllTransaction(Long accountId);
    void deleteTransaction(Long accountId);
    List<Account> findAccounts(String owner);
}