package put.io.testing.mocks;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.Collections;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import put.io.students.fancylibrary.database.IFancyDatabase;


public class ExpenseRepositoryTest {

    @Test
    void testLoadExpenses1() {
        ExpenseRepository repo = new ExpenseRepository(new MyDatabase());
        repo.loadExpenses();
        assertEquals(Collections.emptyList(),repo.getExpenses());
    }


    @Test
    void testLoadExpenses2() {
        IFancyDatabase mock = mock(IFancyDatabase.class);
        ExpenseRepository rep = new ExpenseRepository(mock);
        InOrder order = inOrder(mock);

        when(mock.queryAll()).thenReturn(Collections.emptyList());
        rep.loadExpenses();

        order.verify(mock).connect();
        order.verify(mock).queryAll();
        order.verify(mock).close();

        assertEquals(Collections.emptyList(), rep.getExpenses());
    }

    @Test
    void testSaveExpenses() {
        IFancyDatabase mock = mock(IFancyDatabase.class);
        when(mock.queryAll()).thenReturn(Collections.emptyList());

        ExpenseRepository rep = new ExpenseRepository(mock);

        rep.addExpense(new Expense());
        rep.addExpense(new Expense());
        rep.addExpense(new Expense());
        rep.addExpense(new Expense());
        rep.addExpense(new Expense());
        rep.saveExpenses();

        verify(mock, times(5)).persist(any(Expense.class));
    }

}
