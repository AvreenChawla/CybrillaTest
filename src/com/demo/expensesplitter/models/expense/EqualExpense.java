package com.demo.expensesplitter.models.expense;

import com.demo.expensesplitter.models.User;
import com.demo.expensesplitter.models.split.EqualSplit;
import com.demo.expensesplitter.models.split.Split;
import java.util.List;

public class EqualExpense extends Expense {
    public EqualExpense(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof EqualSplit)) {
                return false;
            }
        }

        return true;
    }
}