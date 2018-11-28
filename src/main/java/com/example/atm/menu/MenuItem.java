package com.example.atm.menu;

import com.example.atm.util.Status;

public interface MenuItem {

    public Status execute();

    public String getName();
}
