package com.demo.splitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.demo.expensesplitter.models.User;
import com.demo.expensesplitter.models.expense.ExpenseType;
import com.demo.expensesplitter.models.split.EqualSplit;
import com.demo.expensesplitter.models.split.Split;
import com.demo.expensesplitter.models.split.WeightedSplit;

public class App {
	
	 public static void main(String[] args) {
	        ExpenseManager expenseManager = new ExpenseManager();

	        expenseManager.addUser(new User("1", "Ajay",  "9898989898"));
	        expenseManager.addUser(new User("2", "Ram", "9797979797"));
	        expenseManager.addUser(new User("3", "Krish", "9696969696"));
	        expenseManager.addUser(new User("4", "Kumar","9595959595"));

	        Scanner scanner = new Scanner(System.in);
	        while (true) {
	            String command = scanner.nextLine();
	            String[] commands = command.split(" ");
	            String commandType = commands[0];

	            switch (commandType) {
	                case "SHOW":
	                    if (commands.length == 1) {
	                        expenseManager.showBalances();
	                    } else {
	                        expenseManager.showBalance(commands[1]);
	                    }
	                    break;
	                case "EXPENSE":
	                    String paidBy = commands[1];
	                    Double amount = Double.parseDouble(commands[2]);
	                    int noOfUsers = Integer.parseInt(commands[3]);
	                    String expenseType = commands[4 + noOfUsers];
	                    List<Split> splits = new ArrayList<>();
	                    switch (expenseType) {
	                        case "EQUAL":
	                            for (int i = 0; i < noOfUsers; i++) {
	                                splits.add(new EqualSplit(expenseManager.userMap.get(commands[4 + i])));
	                            }
	                            expenseManager.addExpense(ExpenseType.EQUAL, amount, paidBy, splits);
	                            break;
	                       
	                        case "PERCENT":
	                            for (int i = 0; i < noOfUsers; i++) {
	                                splits.add(new WeightedSplit(expenseManager.userMap.get(commands[4 + i]), Double.parseDouble(commands[5 + noOfUsers + i])));
	                            }
	                            expenseManager.addExpense(ExpenseType.WEIGHTED, amount, paidBy, splits);
	                            break;
	                    }
	                    break;
	            }
	        }
	    }

}
