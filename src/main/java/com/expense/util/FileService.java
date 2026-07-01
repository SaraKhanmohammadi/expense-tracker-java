package com.expense.util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import com.expense.model.Expense;
import java.util.List;

public class FileService {

    private final String FILE_NAME = "expenses.txt";

    public void saveExpense(String data) {

        try {

            FileWriter writer = new FileWriter(FILE_NAME, true);

            writer.write(data);

            writer.write("\n");

            writer.close();

        } catch (IOException e) {

            System.out.println("Error saving expense.");
        }
    }
    public ArrayList<String> readExpenses() {

        ArrayList<String> expenses = new ArrayList<>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));

            String line;

            while ((line = reader.readLine()) != null) {

                expenses.add(line);
            }

            reader.close();

        } catch (IOException e) {

            System.out.println("Error reading file.");
        }

        return expenses;
    }


    public void overwriteExpenses(List<Expense> expenses) {

        try {

            FileWriter writer = new FileWriter(FILE_NAME);

            for (Expense expense : expenses) {

                writer.write(expense.getId() + "," + expense.getTitle() + "," + expense.getAmount() + "," + expense.getCategory());

                writer.write("\n");
            }

            writer.close();

        }
        catch (IOException e) {

            System.out.println("Error saving expenses.");
        }
    }
}