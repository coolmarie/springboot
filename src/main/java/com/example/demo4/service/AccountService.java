package com.example.demo4.service;

import com.example.demo4.mapper.AccountMapper;
import com.example.demo4.entity.Account;
import com.example.demo4.entity.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountMapper mapper;
    public AccountService(AccountMapper mapper) { this.mapper = mapper; }

    public Account getAccount(Long id) { return mapper.findAccountById(id); }
    public List<Transaction> getTransactions(Long accountId) { return mapper.findTransactionsByAccountId(accountId); }

    public Account addAccount(Account account){
        return mapper.addAccount(account);
    }

    public Account deleteAccount(Long id){
        return mapper.deleteAccount(id);
    }

    public void deleteAllTransactionsByAccountId(Long accountId){
        mapper.deleteAllTransaction(accountId);
    }

    public List<Account> getAccounts(String owner) { return mapper.findAccounts(owner); }

    //@Transactional
    public void withdraw(Long accountId,BigDecimal amount) {
        Account acc = mapper.findAccountById(accountId);
        BigDecimal newBalance = acc.getBalance().subtract(amount);
        mapper.updateAccountBalance(accountId, newBalance);
    }

    public void deposit(Long accountId,BigDecimal amount) {
        Account acc = mapper.findAccountById(accountId);
        BigDecimal newBalance = acc.getBalance().add(amount);
        mapper.updateAccountBalance(accountId, newBalance);
    }



    @Transactional
    public void addTransaction(Long accountId, BigDecimal amount, String type, String description) {
        Account acc = mapper.findAccountById(accountId);
        BigDecimal newBalance = acc.getBalance();
        if ("deposit".equals(type)) newBalance = newBalance.subtract(amount);
        else if ("withdrawal".equals(type)) newBalance = newBalance.subtract(amount);
        mapper.insertTransaction(new Transaction(null, accountId, amount, type, description, LocalDateTime.now()));
        mapper.updateAccountBalance(accountId, newBalance);
    }

    @Transactional
    public void deleteTransaction(Long Id,Transaction tx) {
        Account acc = mapper.findAccountById(tx.getAccountId());
        BigDecimal newBalance = acc.getBalance().subtract(tx.getAmount());
        mapper.deleteTransaction(Id);
        mapper.updateAccountBalance(tx.getAccountId(), newBalance);
    }
}
