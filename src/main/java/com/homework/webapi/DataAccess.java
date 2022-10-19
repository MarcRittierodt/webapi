package com.homework.webapi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataAccess {
    public List<Transaction> getTransactions() {
        List<Transaction> transactions = new ArrayList<Transaction>();
        Transaction trans = new Transaction();
        trans.transId = 100;
        trans.setAccountId("1234");
        trans.amount = 17;
        trans.transDate = LocalDate.parse("2022-08-23");
        transactions.add(trans);

        Transaction trans2 = new Transaction();
        trans2.transId = 101;
        trans2.setAccountId("4321");
        trans2.amount = 120;
        trans2.transDate = LocalDate.parse("2022-09-23");
        transactions.add(trans2);

        Transaction trans3 = new Transaction();
        trans3.transId = 102;
        trans3.setAccountId("4321");
        trans3.amount = 57;
        trans3.transDate = LocalDate.parse("2022-09-27");
        transactions.add(trans3);

        Transaction trans4 = new Transaction();
        trans4.transId = 103;
        trans4.setAccountId("12345");
        trans4.amount = 99;
        trans4.transDate = LocalDate.parse("2022-06-27");
        transactions.add(trans4);

        //One transaction out of the three month window to make sure filtering works.
        Transaction trans5 = new Transaction();
        trans5.transId = 104;
        trans5.setAccountId("12345");
        trans5.amount = 68;
        trans5.transDate = LocalDate.parse("2022-08-27");
        transactions.add(trans5);

        return transactions;
    }
}
