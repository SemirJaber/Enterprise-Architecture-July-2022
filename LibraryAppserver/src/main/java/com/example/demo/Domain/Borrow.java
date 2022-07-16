package com.example.demo.Domain;


import com.example.demo.BookClient.Book;
import com.example.demo.BookClient.BookCopies;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.temporal.ChronoUnit.DAYS;
@Entity
public class Borrow {
    @Id
    @GeneratedValue
    private long borrownumber;
    @ManyToOne(cascade= CascadeType.ALL)
    private Customer customer;
    private LocalDate checkOutDate;
    private LocalDate checkinDate;

    public Borrow(){}

    public Borrow(LocalDate checkOutDate, LocalDate checkinDate) {
        this.checkOutDate = checkOutDate;
        this.checkinDate = checkinDate;
    }
    public long getBorrownumber() {
        return borrownumber;
    }

    public void setBorrownumber(long borrownumber) {
        this.borrownumber = borrownumber;
    }

    public Customer getCustomers() {
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
    public void checkoutBook(Book book, LocalDate checkoutDate){
       List<Book> list=new ArrayList<>();

        this.checkOutDate=checkoutDate;
        List<BookCopies> b=book.getCopies();
           for(BookCopies c:b){
                  int a=c.getQuantity();
                  if(a>0){
                      a--;
                      list.add(book);
                  }else {System.out.println("the is no copy available ");}
           }
        }


    public void returnBook(Book book, LocalDate checkinDate){
        List<Book> list=new ArrayList<>();
        this.checkinDate=checkinDate;
        long daysBetween = DAYS.between(checkinDate,checkOutDate);
        if(daysBetween>21){
            double balance=0;
            balance=customer.getOutstandingbalance()+penality();
             customer.setOutstandingbalance(balance);
        List<BookCopies> b=book.getCopies();
            for(BookCopies c:b){
                int a=c.getQuantity();
                   a++;
                   list.remove(book);
            }
        }
    }

    public double penality(){
        long days=DAYS.between(checkinDate,checkOutDate);
        double penalityamount=days*0.5;
        return penalityamount;
    }
}
