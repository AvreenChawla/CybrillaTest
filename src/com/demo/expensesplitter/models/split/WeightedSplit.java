package com.demo.expensesplitter.models.split;

import com.demo.expensesplitter.models.User;

public class WeightedSplit extends Split {
    double percent;

    public WeightedSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    public double getPercent() {
        return percent;
    }

    public void setPercent(double percent) {
        this.percent = percent;
    }
}