package com.demo.splitter;

import java.util.List;

import com.demo.expensesplitter.models.User;
import com.demo.expensesplitter.models.expense.EqualExpense;
import com.demo.expensesplitter.models.expense.Expense;
import com.demo.expensesplitter.models.expense.ExpenseType;
import com.demo.expensesplitter.models.expense.WeightedExpense;
import com.demo.expensesplitter.models.split.Split;
import com.demo.expensesplitter.models.split.WeightedSplit;

public class ExpenseService {
    public static Expense createExpense(ExpenseType expenseType, double amount,
    		User paidBy, List<Split> splits) {
        switch (expenseType) {
            
            case WEIGHTED:
                for (Split split : splits) {
                    WeightedSplit percentSplit = (WeightedSplit) split;
                    split.setAmount((amount*percentSplit.getPercent())/100.0);
                }
                return new WeightedExpense(amount, paidBy, splits);
            case EQUAL:
                int totalSplits = splits.size();
                double splitAmount = ((double) Math.round(amount*100/totalSplits))/100.0;
                for (Split split : splits) {
                    split.setAmount(splitAmount);
                }
                splits.get(0).setAmount(splitAmount + (amount - splitAmount*totalSplits));
                return new EqualExpense(amount, paidBy, splits);
            default:
                return null;
        }
    }
}