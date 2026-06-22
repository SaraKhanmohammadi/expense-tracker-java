package org.example;
import com.expense.service.ExpenseService;
import com.expense.model.Expense;

public class Main {
    public static void main(String[] args) {
        ExpenseService expenseService = new ExpenseService();

        Expense expense = new Expense("Lunche", 15, "food");
        expenseService.addExpense(expense);
        System.out.println("Total Expense: " + expenseService.getExpenseCount());
    }
}