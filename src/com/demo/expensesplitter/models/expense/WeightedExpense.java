package com.demo.expensesplitter.models.expense;

import java.util.List;

import com.demo.expensesplitter.models.User;
import com.demo.expensesplitter.models.split.Split;
import com.demo.expensesplitter.models.split.WeightedSplit;

public class WeightedExpense extends Expense {
    public WeightedExpense(double amount, User paidBy, List<Split> splits) {
        super(amount, paidBy, splits);
    }

    @Override
    public boolean validate() {
        for (Split split : getSplits()) {
            if (!(split instanceof WeightedSplit)) {
                return false;
            }
        }

        double totalPercent = 100;
        double sumSplitPercent = 0;
        for (Split split : getSplits()) {
        	WeightedSplit exactSplit = (WeightedSplit) split;
            sumSplitPercent += exactSplit.getPercent();
        }

        if (totalPercent != sumSplitPercent) {
            return false;
        }

        return true;
    }
}