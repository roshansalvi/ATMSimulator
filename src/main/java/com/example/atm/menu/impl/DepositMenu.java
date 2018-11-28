package com.example.atm.menu.impl;

import com.example.atm.service.CashBank;
import com.example.atm.util.Constants;
import com.example.atm.util.Status;
import com.example.atm.util.Util;
import com.example.atm.menu.MenuItem;

import java.util.Scanner;

public class DepositMenu implements MenuItem {

    private String name = "";

    public DepositMenu(String name) {
        this.name = name;
    }

    public Status execute() {
        System.out.println("Enter ccy to deposit terminated by . e.g. 10 20 50. :");
        while (true) {
            Status status = handleUserInput();
            System.out.println(status.getMsg());
            if (status.getCode() == 200) return status;
        }
    }

    private Status handleUserInput() {
        String userInput = readUserInput();
        String[] inputs = userInput.split(" ");
        StringBuffer currencyAccepted = new StringBuffer();
        boolean endDot = false;
        for (String input : inputs) {
            if (".".equals(input)) {
                endDot = true;
                break;
            }
            try {
                int value = Integer.parseInt(input);

                if (Util.isValidCurrency(value)) {
                    currencyAccepted.append(" Accepted : " + value + "\n");
                    CashBank.getInstance().depositCash(value);
                }

            } catch (NumberFormatException e) {
                return new Status(Constants.ERROR_OCCURED_CODE, Constants.INVALID_CURRENCY_INPUT);
            }
        }
        if (endDot) {
            return new Status(Constants.SUCCESS_CODE, currencyAccepted.toString());
        }
        return new Status(Constants.USER_INPUT_WAIT_CODE, Constants.USER_INPUT_WAIT_MSG);
    }

    public String readUserInput() {
        Scanner sc = new Scanner(System.in);
        return sc.nextLine();
    }

    public String getName() {
        return name;
    }
}
