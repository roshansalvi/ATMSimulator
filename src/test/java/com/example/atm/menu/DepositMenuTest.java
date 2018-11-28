package com.example.atm.menu;

import com.example.atm.menu.impl.DepositMenu;
import com.example.atm.util.Status;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class DepositMenuTest {


    @Test
    public void execute(){

        DepositMenu menu = new DepositMenu("Deposit");
        InputStream anyInputStream = new ByteArrayInputStream("10 20 30 20 10 40 50 .".getBytes());
        System.setIn(anyInputStream);
        Status status = menu.execute();
        Assert.assertEquals(status.getCode(), 200);

    }

    @Test
    public void execute2(){

        DepositMenu menu = new DepositMenu("Deposit");
        InputStream anyInputStream = new ByteArrayInputStream("20 30 . 40 50 . ".getBytes());
        System.setIn(anyInputStream);
        Status status = menu.execute();
        Assert.assertEquals(status.getCode(), 200);

    }
}
