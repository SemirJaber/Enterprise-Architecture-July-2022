package com.example.demo.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Payment {
@Id
@GeneratedValue
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
