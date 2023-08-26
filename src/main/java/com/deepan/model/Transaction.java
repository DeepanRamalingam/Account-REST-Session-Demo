package com.deepan.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;


import java.time.LocalDate;

@Entity
public class Transaction {

    @Id
    private String tid;
    private double tamount;

    private String tDescription;

    private LocalDate date;

//    credit, debit
    private String ttype;


    public Transaction(String tid, double tamount, String tDescription, LocalDate date, String ttype) {
        this.tid = tid;
        this.tamount = tamount;
        this.tDescription = tDescription;
        this.date = date;
        this.ttype = ttype;
    }

    public Transaction(){}

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public double getTamount() {
        return tamount;
    }

    public void setTamount(double tamount) {
        this.tamount = tamount;
    }

    public String gettDescription() {
        return tDescription;
    }

    public void settDescription(String tDescription) {
        this.tDescription = tDescription;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getTtype() {
        return ttype;
    }

    public void setTtype(String ttype) {
        this.ttype = ttype;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "tid='" + tid + '\'' +
                ", tamount=" + tamount +
                ", tDescription='" + tDescription + '\'' +
                ", date=" + date +
                ", ttype='" + ttype + '\'' +
                '}';
    }
}
