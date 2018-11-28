package com.example.atm.menu.impl;

import com.example.atm.service.CashBank;
import com.example.atm.util.Constants;
import com.example.atm.util.Status;
import com.example.atm.menu.MenuItem;

public class DisplayBalanceMenu implements MenuItem {
    private String name="";

    public DisplayBalanceMenu(String name){
        this.name = name;
    }

    public Status execute() {
        System.out.println("Available balance : " + CashBank.getInstance().balance());
        return new Status(Constants.SUCCESS_CODE,"");
    }

    public String getName() {
        return name;
    }
}
