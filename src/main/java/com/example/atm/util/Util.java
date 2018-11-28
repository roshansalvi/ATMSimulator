package com.example.atm.util;

import com.example.atm.service.CashBank;

import java.text.NumberFormat;

public class Util {

    public static boolean isValidCurrency (int currencyNote){

        boolean check = false;

        for(int acceptedNote : CashBank.VALID_CURRENCY){
            if(currencyNote == acceptedNote){
                check = true;
            }
        }
        return check;
    }

    public static String currencyFormater(int value){
        String formattedValue = "";
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        return formatter.format(value);
    }
}
