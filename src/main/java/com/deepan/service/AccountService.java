package com.deepan.service;

import com.deepan.exceptions.AccountAlreadyPresentException;
import com.deepan.exceptions.AccountNotPresentException;
import com.deepan.model.Account;
import com.deepan.model.Transaction;
import com.deepan.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    //reads data from the repository
//    process the result
//    return the result to the controller
//    contains all the business logic (core functionalities)
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts(String acctype) {

        List<Account> accountList = accountRepository.findAll();
        if(acctype != null){
            accountList = accountList.stream().filter(x->x.getAccType().equals(acctype)).toList();
        }
//
        return accountList;
    }

    public Account addNewAccount(Account account) throws AccountAlreadyPresentException {

        Optional<Account> accountOptional = accountRepository.findById(account.getAccNumber());

        if (accountOptional.isPresent()) {

            throw new AccountAlreadyPresentException();
        }

        account.setTransactionList(new ArrayList<Transaction>());
        accountRepository.save(account);
        return account;
    }


    public Account findAccountByAccountNumber(String accountNumber) throws AccountNotPresentException {

        Optional<Account> accountOptional = accountRepository.findById(accountNumber);

        if(accountOptional.isPresent()){
            Account account = accountOptional.get();
            return account;
        }
        throw new AccountNotPresentException();
    }


}

//optional
//account
//null
//null pointer exception

//Optional(Account) --- optional will contain account ot empty

//AccountAlreadyExist
