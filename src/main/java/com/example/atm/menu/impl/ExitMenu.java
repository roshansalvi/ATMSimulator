package com.example.atm.menu.impl;

import com.example.atm.util.Constants;
import com.example.atm.util.Status;
import com.example.atm.menu.MenuItem;

public class ExitMenu implements MenuItem {
    private String name="Exit";

    public ExitMenu(String name){
        this.name = name;
    }

    public Status execute() {
        return new Status (Constants.EXIT_CODE, Constants.EXIT_MSG);
    }

    public String getName() {
        return name;
    }
}
