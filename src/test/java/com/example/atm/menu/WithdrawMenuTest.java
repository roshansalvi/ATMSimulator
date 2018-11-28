package com.example.atm.menu;

import com.example.atm.menu.impl.DepositMenu;
import com.example.atm.menu.impl.ExitMenu;
import com.example.atm.menu.impl.WithdrawMenu;
import com.example.atm.service.CashBank;
import com.example.atm.util.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

public class WithdrawMenuTest {


    private CashBank cashBank;

    @Before
    public void setUp() {

        DepositMenu menu = new DepositMenu("Deposit");
        InputStream anyInputStream = new ByteArrayInputStream("10 20 30 20 10 40 50 .".getBytes());
        System.setIn(anyInputStream);
        menu.execute();

    }


    @Test
    public void execute(){

        WithdrawMenu menu = new WithdrawMenu("Display Balance");
        InputStream anyInputStream = new ByteArrayInputStream("50".getBytes());
        System.setIn(anyInputStream);
        Status status = menu.execute();
        Assert.assertEquals(status.getCode(), 200);

    }
}
