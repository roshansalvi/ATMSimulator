package com.example.atm;

import com.example.atm.menu.MenuItem;
import com.example.atm.util.Constants;
import com.example.atm.util.Status;

import java.util.Scanner;

public class ATMSimulator {

    private MenuItem[] menuItems;

    public ATMSimulator(MenuItem[] menuItems){
        this.menuItems = menuItems;
    }

    public void start(){
        while(true){
            displayMenuOptions();
            Status status = handleUserInput();
            if(status.getCode() == Constants.EXIT_CODE){
                System.out.println(status.getMsg());
                break;
            }
        }
    }

    private Status handleUserInput() {

        System.out.println("Select an option: ");
        String userInput = readUserInput().trim();

        try {
            int option =  Integer.parseInt(userInput);
            if (option <= menuItems.length) {
                MenuItem menu = menuItems[option - 1];
                return menu.execute();
            } else {
                System.out.println(Constants.ERR_MSG);
                return new Status(Constants.ERROR_OCCURED_CODE,Constants.ERROR_OCCURED_MSG);
            }
        } catch (Exception e){
            System.out.println(Constants.ERR_MSG);
            return new Status(Constants.ERROR_OCCURED_CODE,Constants.ERROR_OCCURED_MSG);
        }



    }

    private String readUserInput() {
        Scanner sc =  new Scanner(System.in);
        return sc.nextLine();
    }

    private void displayMenuOptions() {
        int counter = 0 ;
        for(MenuItem menu:menuItems) {
            System.out.println( ++counter + ". " + menu.getName());
        }

    }
}
