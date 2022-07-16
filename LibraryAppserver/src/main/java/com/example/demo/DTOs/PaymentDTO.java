package com.example.demo.DTOs;

import org.springframework.stereotype.Component;


public class PaymentDTO {

    private long paymentnumber;
    private double amount;
    public PaymentDTO(){}
    public PaymentDTO(double amount) {
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
