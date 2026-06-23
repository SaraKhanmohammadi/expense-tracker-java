package com.expense;

import com.expense.model.Expense;
import com.expense.service.ExpenseService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ExpenseService expenseService = new ExpenseService();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;


        while (running) {
            System.out.println("\n=== EXPENSE TRACKER ===");
            System.out.println("1. Add Expense");
            System.out.println("2. Show All Expenses");
            System.out.println("3. Exit");

            System.out.print("Choose option: ");


            int choice = scanner.nextInt();

            switch (choice){
                case 1:
                    scanner.nextLine();
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    Double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();

                    Expense expense = new Expense(title, amount, category);
                    expenseService.addExpense(expense);

                    break;

                case 2:
                    expenseService.showAllExpenses();
                    break;
                case 3:
                    running = false;
                    System.out.println("Goodbye");
                    break;

                default:
                    System.out.println("Invalid option");
            }

        }
        scanner.close();
           }
}