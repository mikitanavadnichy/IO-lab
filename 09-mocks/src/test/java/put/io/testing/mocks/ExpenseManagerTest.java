package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.mockito.stubbing.Answer;


import put.io.students.fancylibrary.service.FancyService;

public class ExpenseManagerTest {

    @Test
    void testCalculateTotal() {
        ExpenseRepository repMock = mock(ExpenseRepository.class);
        FancyService fancyMock = new FancyService();

        List<Expense> list  = new ArrayList<Expense>();
        Expense exp1 = new Expense();
        Expense exp2 = new Expense();
        Expense exp3 = new Expense();
        exp1.setAmount(2);
        exp2.setAmount(1);
        exp3.setAmount(4);
        list.add(exp1);
        list.add(exp2);
        list.add(exp3);
        when(repMock.getExpenses()).thenReturn(list);

        ExpenseManager manager = new ExpenseManager(repMock, fancyMock);
        assertEquals(7, manager.calculateTotal());

    }

    @Test
    void testCalculateTotalForCategory() {
        ExpenseRepository repMock = mock(ExpenseRepository.class);
        FancyService fancyMock = new FancyService();
        ExpenseManager manager = new ExpenseManager(repMock, fancyMock);

        List<Expense> list = new ArrayList<Expense>();
        Expense exp = new Expense();
        exp.setAmount(10);
        list.add(exp);

        when(repMock.getExpensesByCategory(anyString())).thenReturn(Collections.emptyList());
        when(repMock.getExpensesByCategory("Home")).thenReturn(list);
        when(repMock.getExpensesByCategory("Car")).thenReturn(list);

        assertEquals(0, manager.calculateTotalForCategory("Food"));
        assertEquals(0, manager.calculateTotalForCategory("Sport"));
        assertEquals(10, manager.calculateTotalForCategory("Car"));
        assertEquals(10, manager.calculateTotalForCategory("Home"));


    }



    @Test
    void testCalculateTotalInDollars() throws ConnectException {

        ExpenseRepository repMock = mock(ExpenseRepository.class);
        FancyService fancyMock = mock(FancyService.class);
        ExpenseManager manager = new ExpenseManager(repMock, fancyMock);

        List<Expense> list = new ArrayList<Expense>();
        Expense exp = new Expense();
        exp.setAmount(40);
        list.add(exp);
        when(repMock.getExpenses()).thenReturn(list);

        when(fancyMock.convert(anyDouble(), eq("PLN"), eq("USD"))).thenAnswer((Answer) invocation -> {
            Object[] args = invocation.getArguments();
            return (double) args[0]/4;
        });

        assertEquals(10,manager.calculateTotalInDollars());

    }


}
