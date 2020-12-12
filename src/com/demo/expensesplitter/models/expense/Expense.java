package com.demo.expensesplitter.models.expense;

import java.util.List;

import com.demo.expensesplitter.models.User;
import com.demo.expensesplitter.models.split.Split;

public abstract class Expense {
    private String id;
    private double amount;
    private User payer;
    private List<Split> splits;
    

    public Expense(double amount, User payer, List<Split> splits) {
        this.amount = amount;
        this.payer = payer;
        this.splits = splits;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public User getPayer() {
        return payer;
    }

    public void getPayer(User paidBy) {
        this.payer = paidBy;
    }

    public List<Split> getSplits() {
        return splits;
    }

    public void setSplits(List<Split> splits) {
        this.splits = splits;
    }

    public abstract boolean validate();
}