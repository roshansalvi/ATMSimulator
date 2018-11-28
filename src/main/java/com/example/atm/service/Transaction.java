package com.example.atm.service;

import java.util.Date;

public class Transaction {


    public Transaction(TransactionType type,Date createdOn, int amount, int closingBalance){
        this.type = type;
        this.createdOn = createdOn;
        this.amount = amount;
        this.closingBalance = closingBalance;
    }

    public enum TransactionType{
        CREDIT,
        DEBIT
    }
    private Date createdOn = null;
    private TransactionType type = null;
    private int amount = 0;
    private int closingBalance = 0;


    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public TransactionType getType() {
        return type;
    }

    public void setType(TransactionType type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getClosingBalance() {
        return closingBalance;
    }

    public void setClosingBalance(int closingBalance) {
        this.closingBalance = closingBalance;
    }
}
