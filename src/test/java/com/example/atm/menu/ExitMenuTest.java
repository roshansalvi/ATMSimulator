package com.example.atm.menu;

import com.example.atm.menu.impl.DepositMenu;
import com.example.atm.menu.impl.DisplayBalanceMenu;
import com.example.atm.menu.impl.ExitMenu;
import com.example.atm.util.Status;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class ExitMenuTest {


    @Test
    public void execute(){

        ExitMenu menu = new ExitMenu("Display Balance");
        Status status = menu.execute();
        Assert.assertEquals(status.getCode(), 1001);

    }
}
