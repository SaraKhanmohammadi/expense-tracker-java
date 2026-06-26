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

    public void setTitle(String title) {this.title = title;}

    public void setAmount(double amount) {this.amount = amount;}

    public void setCategory(String category) {this.category = category;}

}
