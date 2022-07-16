package com.example.demo.Adapters;

import com.example.demo.DTOs.BorrowDTO;
import com.example.demo.Domain.Borrow;

public class BorrowAdapter {

    public static Borrow getBorrowfromBorrowDTO(BorrowDTO borrowdto){
        Borrow b=new Borrow(borrowdto.getCheckOutDate(),borrowdto.getCheckinDate());
        return b;
    }
    public static BorrowDTO getBorrowDTOfromBorrow(Borrow borrow){
        BorrowDTO b= new BorrowDTO(borrow.getCheckOutDate(),borrow.getCheckinDate());
        return b;
    }
}
