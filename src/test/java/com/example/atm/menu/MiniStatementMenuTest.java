package com.example.atm.menu;

import com.example.atm.menu.impl.DepositMenu;
import com.example.atm.menu.impl.DisplayBalanceMenu;
import com.example.atm.menu.impl.MiniStatementMenu;
import com.example.atm.util.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class MiniStatementMenuTest {


    @Before
    public void init(){

        DepositMenu menu = new DepositMenu("Deposit");
        InputStream anyInputStream = new ByteArrayInputStream("10 20 30 20 10 40 50 .".getBytes());
        System.setIn(anyInputStream);
        menu.execute();
    }


    @Test
    public void execute(){

        MiniStatementMenu menu = new MiniStatementMenu("Mini Statement");
        Status status = menu.execute();
        Assert.assertEquals(status.getCode(), 200);

    }
}
