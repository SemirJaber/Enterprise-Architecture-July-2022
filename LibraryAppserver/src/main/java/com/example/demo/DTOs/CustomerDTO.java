package com.example.demo.DTOs;

import com.example.demo.BookClient.Book;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.List;

public class CustomerDTO {

    private long customernumber;
    private String name;
    private String email;
    private double outstandingbalance;
    private PaymentDTO payment;
    private ReservationDTO reserve;
    private BorrowDTO borrow;


    public double getOutstandingbalance() {
        return outstandingbalance;
    }

    public void setOutstandingbalance(double outstandingbalance) {
        this.outstandingbalance = outstandingbalance;
    }


    public CustomerDTO() {
    }

    public CustomerDTO(String name, String email) {

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

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public ReservationDTO getReserve() {
        return reserve;
    }

    public void setReserve(ReservationDTO reserve) {
        this.reserve = reserve;
    }

    public BorrowDTO getBorrow() {
        return borrow;
    }

    public void setBorrow(BorrowDTO borrow) {
        this.borrow = borrow;
    }

    public void checkoutBook(List<Book> book, LocalDate checkoutdate) {
        borrow.checkoutBook(book, checkoutdate);
    }

    public void returnBook(List<Book> book, LocalDate checkindate) {
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
    public void reserve(Book book,LocalDate date){
        reserve=new ReservationDTO(date);
    }
}
