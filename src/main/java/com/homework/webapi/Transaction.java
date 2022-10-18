package com.homework.webapi;

import java.time.LocalDate;

public class Transaction {
    public int transId;
    private String accountId;
    public double amount;
    public LocalDate transDate;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String newAccountId) {
        this.accountId = newAccountId;
    }
}
