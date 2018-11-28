package com.example.atm.service;

import com.example.atm.util.Status;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class CashBank {


    private static CashBank SINGLE_INSTANCE = null;
    private CashBank() {}
    public static CashBank getInstance() {
        if (SINGLE_INSTANCE == null) {
            synchronized (CashBank.class) {
                if (SINGLE_INSTANCE == null) {
                    SINGLE_INSTANCE = new CashBank();
                }
            }
        }
        return SINGLE_INSTANCE;
    }

    List<Integer> currencyNotes = new ArrayList<Integer>();

    public static final int[] VALID_CURRENCY = {10,20,50};


    public Status depositCash(int currency){

        synchronized (currencyNotes){
            currencyNotes.add(currency);
        }
        Audit.addTransaction(new Transaction(Transaction.TransactionType.CREDIT,new Date(),currency,balance()));
        Collections.sort(currencyNotes,Collections.reverseOrder());
        return new Status(200, "Success");
    }

    public int balance(){
        int sum = 0;
        for(Integer currency : currencyNotes){
            sum = sum + currency;
        }
        return  sum;
    }

    public List<Integer> withdrawCash(int amt){

        synchronized (currencyNotes){
            return withdraw(amt);
        }

    }

    private List<Integer>  withdraw(int amt)
    {

        int sum = 0;
        List<Integer> selectedCurrency = new ArrayList<Integer>();
        synchronized (currencyNotes){

            for(Integer note :  currencyNotes){
                if(amt >= (sum + note)){
                    sum = sum + note;
                    selectedCurrency.add(note);
                }
                if(amt == sum){
                    break;
                }
            }
            if(amt == sum) {
                for(Integer curr : selectedCurrency){
                    currencyNotes.remove(curr);
                    Audit.addTransaction(new Transaction(Transaction.TransactionType.DEBIT,new Date(),curr,balance()));
                }
            }
            else {
                selectedCurrency = null;
                System.out.println("Unable to dispense.  Amount should be in multiple of 10, 20, 50");
            }
        }

        return selectedCurrency;
    }

}
