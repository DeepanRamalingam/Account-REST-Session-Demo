package com.deepan.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Account {

    @Id
    private String accNumber;
    private String accType;

    private String accountHolderName;

    private double balance;

//  ArrayList (dynamic array) of Transactions

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Transaction> transactionList;

    public Account(String accNumber, String accType, String accountHolderName, double balance) {
        this.accNumber = accNumber;
        this.accType = accType;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public Account(){}

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accNumber='" + accNumber + '\'' +
                ", accType='" + accType + '\'' +
                ", accountHolderName='" + accountHolderName + '\'' +
                ", balance=" + balance +
                ", transactionList=" + transactionList +
                '}';
    }
}



//properties ----  keyvalue pairs (name: Deepan, age: 37)
//actions/behaviour ---- functions (methods functions belong to objects) (sleep(), drink(), eat())

//{name: deepan, age: 37, action1: eat(){}, action2: takingSession()}
//{personName: deepan, personAge: 37, action1: eat(){}, action2: takingSession()}
