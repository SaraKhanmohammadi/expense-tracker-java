package com.expense;
import com.expense.exception.InvalidExpenseException;
import com.expense.model.Expense;
import com.expense.service.ExpenseService;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ExpenseService expenseService = new ExpenseService();
        expenseService.loadExpenses();
        Scanner scanner = new Scanner(System.in);

        boolean running = true;


        while (running) {
            System.out.println("\n=== EXPENSE TRACKER ===");
            System.out.println("1. Add Expense");
            System.out.println("2. Show All Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Update Expense");
            System.out.println("5. Monthly Report");
            System.out.println("6. Sort by Amount");
            System.out.println("7. Exit");

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

                    try {

                        expenseService.addExpense(title, amount, category);

                    } catch (InvalidExpenseException e) {

                        System.out.println(e.getMessage());
                    }


                    break;

                case 2:
                    expenseService.showAllExpenses();
                    break;

                case 3:
                    System.out.print("Enter Expense ID: ");
                    int id = scanner.nextInt();

                    expenseService.deleteExpense(id);
                    break;

                case 4:

                    System.out.print("Enter Expense ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter new title: ");
                    String newTitle = scanner.nextLine();

                    System.out.print("Enter new amount: ");
                    double newAmount = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Enter new category: ");
                    String newCategory = scanner.nextLine();

                    expenseService.updateExpense(updateId, newTitle, newAmount, newCategory);

                    break;


                case 5:
                    expenseService.generateReport();
                    break;

                case 6:

                    expenseService.sortByAmount();

                    break;

                case 7:

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