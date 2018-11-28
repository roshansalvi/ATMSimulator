package com.example.atm.menu.impl;

import com.example.atm.service.CashBank;
import com.example.atm.util.Constants;
import com.example.atm.util.Status;
import com.example.atm.menu.MenuItem;

import java.util.List;
import java.util.Scanner;

public class WithdrawMenu implements MenuItem {
    private String name="";

    public WithdrawMenu(String name){
        this.name = name;
    }

    public Status execute() {
        System.out.println("Enter the amount to withdraw :");
        while(true){
            Status status = handleUserInput();
            System.out.println(status.getMsg());
            if(status.getCode() == 200) return status;
        }
    }

    public String getName() {
        return name;
    }

    private String readUserInput() {
        Scanner sc =  new Scanner(System.in);
        return sc.nextLine();
    }

    private Status handleUserInput() {
        StringBuffer sbf = new StringBuffer();
        try{
            int userInput = Integer.parseInt(readUserInput());
            List<Integer> withdrawnCurrency= CashBank.getInstance().withdrawCash(userInput);
            if(withdrawnCurrency != null) {
                for (Integer curr : withdrawnCurrency) {
                    sbf.append("Dispensing : " + curr + "$ \n");
                }
                return new Status(200, sbf.toString());
            }

        }catch (NumberFormatException ex){
            return new Status(Constants.ERROR_OCCURED_CODE,Constants.INVALID_CURRENCY_INPUT);
        }
        return new Status(Constants.ERROR_OCCURED_CODE,Constants.INVALID_CURRENCY_INPUT);
    }
}
