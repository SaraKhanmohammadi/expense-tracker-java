package com.expense.service;
import com.expense.model.Expense;

import java.util.ArrayList;

public class ExpenseService {


    private ArrayList<Expense> expenses =
            new ArrayList<>();

    public void addExpense(
            Expense expense) {

        expenses.add(expense);

        System.out.println(
                "Expense added successfully"
        );
    }


}
