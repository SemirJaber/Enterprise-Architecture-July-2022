package com.example.demo.Domain;

import com.example.demo.BookClient.Book;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private long customernumber;
    private String name;
    private String email;
    private double outstandingbalance;
    @ManyToOne(cascade= CascadeType.ALL)
    private Payment payment;
    @ManyToOne(cascade=CascadeType.ALL)
    private Reservation reserve;
    @ManyToOne(cascade=CascadeType.ALL)
    private Borrow borrow;


    public double getOutstandingbalance() {
        return outstandingbalance;
    }

    public void setOutstandingbalance(double outstandingbalance) {
        this.outstandingbalance = outstandingbalance;
    }


    public Customer() {
    }

    public Customer(long customernumber, String name, String email, double outstandingbalance) {
        this.customernumber = customernumber;
        this.name = name;
        this.email = email;
        this.outstandingbalance = outstandingbalance;
    }

    public Customer(String name, String email) {

        this.name = name;
        this.email = email;
    }

    public long getCustomernumber() {
        return customernumber;
    }

    public void setCustomernumber(long customernumber) {
        this.customernumber = customernumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public Reservation getReserve() {
        return reserve;
    }

    public void setReserve(Reservation reserve) {
        this.reserve = reserve;
    }

    public Borrow getBorrow() {
        return borrow;
    }

    public void setBorrow(Borrow borrow) {
        this.borrow = borrow;
    }

    public void checkoutBook(Book book, LocalDate checkoutdate) {
        borrow.checkoutBook(book, checkoutdate);
    }

    public void returnBook(Book book, LocalDate checkindate) {
        borrow.returnBook(book, checkindate);
    }

    public double paypenality(double amount) {
        double outstanding = 0;
        outstanding = outstandingbalance - amount;
        double balance = payment.getAmount() + amount;
        setOutstandingbalance(outstanding);
        payment.setAmount(balance);
        return balance;
    }
    public void reserve(LocalDate date){
        reserve.reserve(date);
    }
}
