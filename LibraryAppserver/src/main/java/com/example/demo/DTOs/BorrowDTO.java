package com.example.demo.DTOs;


import com.example.demo.BookClient.Book;
import com.example.demo.BookClient.BookCopies;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;

public class BorrowDTO {

    private long borrownumber;


    private CustomerDTO customer;
    private LocalDate checkOutDate;
    private LocalDate checkinDate;

    public BorrowDTO(LocalDate checkOutDate, LocalDate checkinDate) {
        this.checkOutDate = checkOutDate;
        this.checkinDate = checkinDate;
    }
    public long getBorrownumber() {
        return borrownumber;
    }

    public void setBorrownumber(long borrownumber) {
        this.borrownumber = borrownumber;
    }

    public CustomerDTO getCustomers() {
        return customer;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public LocalDate getCheckinDate() {
        return checkinDate;
    }

    public void setCheckinDate(LocalDate checkinDate) {
        this.checkinDate = checkinDate;
    }
    public void checkoutBook(List<Book> book, LocalDate checkoutDate){

List<Book> list=new ArrayList<>();
        this.checkOutDate=checkoutDate;
        for(Book b:book){
           for(BookCopies c:b.getCopies()){
                  int a=c.getQuantity();
                  if(a>0){
                      a--;
                      list.add(b);
                  }else {System.out.println("the is no copy available ");}
           }
        }

    }
    public void returnBook(List<Book> book, LocalDate checkinDate){
        List<Book> list=new ArrayList<>();
        this.checkinDate=checkinDate;
        long daysBetween = DAYS.between(checkinDate,checkOutDate);
        if(daysBetween>21){
            double balance=0;
            balance=customer.getOutstandingbalance()+penality();
             customer.setOutstandingbalance(balance);}
        for(Book b:book){
            for(BookCopies c:b.getCopies()){
                int a=c.getQuantity();
                   a++;
                   list.remove(b);
            }
        }
    }

    public double penality(){
        long days=DAYS.between(checkinDate,checkOutDate);
        double penalityamount=days*0.5;
        return penalityamount;
    }
}
