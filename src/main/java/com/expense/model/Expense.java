package com.expense.model;

public class Expense {
    private int id;
    private  String title;
    private double amount;
    private String category;

    public Expense(int id ,String title, double amount, String category){
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.category = category;
    }
    public int getId() {return id;}
    public String getTitle(){
        return title;
    }

    public double getAmount(){
        return amount;
    }

    public String getCategory(){
        return category;
    }

}
