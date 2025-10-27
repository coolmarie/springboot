package com.example.demo4.controller;


import com.example.demo4.entity.Account;
import com.example.demo4.entity.Transaction;
import com.example.demo4.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/accounts")

public class AccountController {
    @Autowired
    private final AccountService service;
    public AccountController(AccountService service) { this.service = service; }

    @GetMapping("/{id}")
    public Account getAccount(@PathVariable Long id) { return service.getAccount(id); }

    @GetMapping("/{id}/transactions")
    public List<Transaction> getTransactions(@PathVariable Long id) { return service.getTransactions(id); }



    @PostMapping("/account")
    public void addAccount(@RequestBody Account account) {
        service.addAccount(account);
    }

    @GetMapping("/account/{owner}")
    public List<Account> getAccounts(@RequestParam String owner) {
        return service.getAccounts(owner);
    }

    @DeleteMapping("/account/{id}")
    public void deleteAccount(@PathVariable Long id) {
        service.deleteAccount(id);
        service.deleteAllTransactionsByAccountId(id);

    }

    //@PostMapping("/{id}/deposit")
    //public void deposit(@PathVariable Long id, @RequestBody Transaction tx) {
      //  service.addTransaction(id, tx.getAmount(), "deposit", tx.getDescription());
    //}

    @PostMapping("/{id}/withdraw")
    public void withdraw(@PathVariable Long id ,@RequestBody BigDecimal amount) {
        service.withdraw(id,amount);
    }

    @PostMapping("/{id}/deposit")
    public void deposit(@PathVariable Long id ,@RequestBody BigDecimal amount) {
        service.deposit(id,amount);
    }
    @PostMapping("/{id}/trasactions")
    public void addtransactions(@PathVariable Long id ,@RequestBody Transaction tx) {
        service.addTransaction(id, tx.getAmount(), "withdrawal", tx.getDescription());
        //service.deleteTransactionsByAccountId(tx.getAccountId());
    }

    @DeleteMapping("/{id}/trasactions")
    public void deletetransactions(@PathVariable Long id ,@RequestBody Transaction tx) {
        service.deleteTransaction(id,tx);
        //service.deleteTransactionsByAccountId(tx.getAccountId());
    }
}
