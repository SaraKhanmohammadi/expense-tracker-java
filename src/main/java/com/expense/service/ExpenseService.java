package com.expense.service;

import com.expense.model.Expense;

import java.util.ArrayList;

public class ExpenseService {

    private ArrayList<Expense> expenses = new ArrayList<>();

    private int nextId = 1;

    public void addExpense(String title, double amount, String category) {

        Expense expense = new Expense(
                nextId,
                title,
                amount,
                category
        );

        expenses.add(expense);

        nextId++;

        System.out.println("Expense added successfully");
    }

    public int getExpenseCount() {
        return expenses.size();
    }

    public void showAllExpenses() {

        for (Expense expense : expenses) {

            System.out.println(
                    expense.getId()
                            + " | "
                            + expense.getTitle()
                            + " | "
                            + expense.getAmount()
                            + " | "
                            + expense.getCategory()
            );
        }
    }

    public void deleteExpense(int id) {

        for (Expense expense : expenses) {

            if (expense.getId() == id) {

                expenses.remove(expense);

                System.out.println("Expense deleted successfully");

                return;
            }
        }

        System.out.println("Expense not found");
    }

    public void updateExpense(
            int id,
            String title,
            double amount,
            String category) {

        for (Expense expense : expenses) {

            if (expense.getId() == id) {

                expense.setTitle(title);
                expense.setAmount(amount);
                expense.setCategory(category);

                System.out.println("Expense updated successfully");

                return;
            }
        }

        System.out.println("Expense not found");
    }
}