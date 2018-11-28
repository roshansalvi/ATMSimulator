package com.example.atm.service;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Audit {


    private Audit(){

    }

    private static Queue<Transaction> transactionList = new LinkedList<Transaction>();

    public static void addTransaction (Transaction transaction){
        transactionList.add(transaction);
    }

    public static Transaction[] getTransactions(){
        return transactionList.toArray(new Transaction[transactionList.size()]);
    }

}
