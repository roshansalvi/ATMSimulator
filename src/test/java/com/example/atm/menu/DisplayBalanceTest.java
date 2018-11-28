package com.example.atm.menu;

import com.example.atm.menu.impl.DepositMenu;
import com.example.atm.menu.impl.DisplayBalanceMenu;
import com.example.atm.service.CashBank;
import com.example.atm.util.Status;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import org.powermock.api.mockito.internal.mockcreation.MockCreator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

public class DisplayBalanceTest {

    private CashBank cashBank;

    @Before
    public void setUp() {

        cashBank =Mockito.mock(CashBank.class);
        setMock(cashBank);
        Mockito.when(cashBank.balance()).thenReturn(100);

    }

    private void setMock(CashBank mock) {
        try {
            Field instance = CashBank.class.getDeclaredField("SINGLE_INSTANCE");
            instance.setAccessible(true);
            instance.set(instance, mock);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @Test
    public void execute(){
        DisplayBalanceMenu menu = new DisplayBalanceMenu("Display Balance");
        Status status = menu.execute();
        Assert.assertEquals(status.getCode(), 200);

    }

}
