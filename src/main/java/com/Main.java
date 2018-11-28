package com;

import com.example.atm.ATMSimulator;
import com.example.atm.menu.MenuItem;
import com.example.atm.menu.impl.*;

public class Main {

    public static void main(String[] args) {

        MenuItem[] menus = new MenuItem[]{
                new DepositMenu("Deposit"),
                new WithdrawMenu("Withdraw"),
                new DisplayBalanceMenu("Display Balance"),
                new MiniStatementMenu("Mini Statement"),
                new ExitMenu("Exit"),
        };

        ATMSimulator simulator = new ATMSimulator(menus);
        simulator.start();
    }


}
