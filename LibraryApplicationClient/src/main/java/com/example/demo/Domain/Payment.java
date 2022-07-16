package com.example.demo.Domain;


public class Payment {

    private long paymentnumber;
    private double amount;
    public Payment(){}
    public Payment(double amount) {
        this.amount = amount;
    }

    public long getPaymentnumber() {
        return paymentnumber;
    }

    public void setPaymentnumber(long paymentnumber) {
        this.paymentnumber = paymentnumber;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
