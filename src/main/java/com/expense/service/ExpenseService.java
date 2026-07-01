package com.expense.service;

import com.expense.model.Expense;
import java.util.HashMap;
import java.util.ArrayList;
import com.expense.util.FileService;
import com.expense.exception.InvalidExpenseException;
import java.util.Comparator;

public class ExpenseService {

    private ArrayList<Expense> expenses = new ArrayList<>();

    private int nextId = 1;
    private FileService fileService = new FileService();

    public void addExpense(String title, double amount, String category)
            throws InvalidExpenseException {


        if (title.trim().isEmpty()) {

            throw new InvalidExpenseException(
                    "Title cannot be empty."
            );
        }


        if (category.trim().isEmpty()) {

            throw new InvalidExpenseException(
                    "Category cannot be empty."
            );
        }
        if (amount <= 0) {

            throw new InvalidExpenseException(
                    "Amount must be greater than zero."
            );
        }

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

    }

    public int getExpenseCount() {
        return expenses.size();
    }

    public void showAllExpenses() {

        for (Expense expense : expenses) {

            System.out.println(
                    expense.getId() + " | " + expense.getTitle() + " | " + expense.getAmount() + " | " + expense.getCategory()
            );
        }
    }

    public void deleteExpense(int id) {

        for (Expense expense : expenses) {

            if (expense.getId() == id) {

                expenses.remove(expense);
                saveAllExpenses();



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


                return;
            }
        }

        System.out.println("Expense not found");
    }
    public void generateReport() {

        HashMap<String, Double> report = new HashMap<>();

        double total = 0;
        for (Expense expense : expenses) {

            total += expense.getAmount();

            String category = expense.getCategory();

            double amount = expense.getAmount();

            report.put(
                    category,
                    report.getOrDefault(category, 0.0) + amount
            );

        }
        System.out.println("===== Monthly Report =====");
        System.out.println("Total Expenses: " + total);

        for (String category : report.keySet()) {

            System.out.println(
                    category + ": " + report.get(category)
            );

        }

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


    }
    public void saveAllExpenses() {

        fileService.overwriteExpenses(expenses);
    }
    public void sortByAmount() {

        expenses.sort(
                Comparator.comparingDouble(Expense::getAmount)
        );

        showAllExpenses();
    }

}