package com.example.atm.util;

public class Status {

    private int code;
    private String msg;

    public Status(int code, String msg){
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }


    public String getMsg() {
        return msg;
    }

}
