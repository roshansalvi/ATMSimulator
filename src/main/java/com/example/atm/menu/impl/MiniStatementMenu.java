package com.example.atm.menu.impl;

import com.example.atm.service.Audit;
import com.example.atm.util.Constants;
import com.example.atm.util.Status;
import com.example.atm.service.Transaction;
import com.example.atm.util.Util;
import com.example.atm.menu.MenuItem;

public class MiniStatementMenu implements MenuItem {
    private String name="";

    public MiniStatementMenu(String name){
        this.name = name;
    }

    public Status execute() {

        Transaction[] transactions = Audit.getTransactions();
        printTransactionReport(transactions);
        return new Status(Constants.SUCCESS_CODE, Constants.SUCCESS_MSG);
    }

    private void printTransactionReport(Transaction[] transactions) {
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.println("Date Time                           Transaction             Amount            Closing Balance     ");
        System.out.println("-----------------------------------------------------------------------------------------------------");
        for (Transaction transaction : transactions){
            System.out.println();
            System.out.print(transaction.getCreatedOn());
            System.out.print("            ");
            System.out.print(transaction.getType().toString());
            System.out.print("            ");
            System.out.print(Util.currencyFormater(transaction.getAmount()));
            System.out.print("            ");
            System.out.print(Util.currencyFormater(transaction.getClosingBalance()));
        }
        System.out.println();
    }

    public String getName() {
        return name;
    }
}
