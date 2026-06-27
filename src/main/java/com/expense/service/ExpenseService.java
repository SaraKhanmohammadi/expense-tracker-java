package com.expense.service;

import com.expense.model.Expense;

import java.util.ArrayList;
import com.expense.util.FileService;

public class ExpenseService {

    private ArrayList<Expense> expenses = new ArrayList<>();

    private int nextId = 1;
    private FileService fileService = new FileService();

    public void addExpense(String title, double amount, String category) {

        Expense expense = new Expense(
                nextId,
                title,
                amount,
                category
        );

        expenses.add(expense);

        String data = expense.getId() + "," + expense.getTitle() + "," + expense.getAmount() + "," + expense.getCategory();

        fileService.saveExpense(data);

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
                saveAllExpenses();

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
                saveAllExpenses();
                System.out.println("Expense updated successfully");

                return;
            }
        }

        System.out.println("Expense not found");
    }
    public void loadExpenses() {

        ArrayList<String> savedExpenses = fileService.readExpenses();

        for (String data : savedExpenses) {

            String[] parts = data.split(",");

            int id = Integer.parseInt(parts[0]);

            String title = parts[1];

            double amount = Double.parseDouble(parts[2]);

            String category = parts[3];

            Expense expense = new Expense(id, title, amount, category);

            expenses.add(expense);

            if (id >= nextId) {
                nextId = id + 1;
            }
        }

        System.out.println("Expenses loaded successfully");
    }
    public void saveAllExpenses() {

        fileService.overwriteExpenses(expenses);
    }
}