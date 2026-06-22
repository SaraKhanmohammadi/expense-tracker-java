package com.expense;

import com.expense.model.Expense;
import com.expense.service.ExpenseService;

public class Main {

    public static void main(String[] args) {

        ExpenseService expenseService = new ExpenseService();

        Expense expense = new Expense("Lunch", 15, "Food");

        expenseService.addExpense(expense);

        System.out.println("Total Expenses: " + expenseService.getExpenseCount());
    }
}