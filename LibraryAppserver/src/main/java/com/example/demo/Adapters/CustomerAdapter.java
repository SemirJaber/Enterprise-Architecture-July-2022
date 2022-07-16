package com.example.demo.Adapters;

import com.example.demo.DTOs.BorrowDTO;
import com.example.demo.DTOs.CustomerDTO;
import com.example.demo.DTOs.PaymentDTO;
import com.example.demo.DTOs.ReservationDTO;
import com.example.demo.Domain.Borrow;
import com.example.demo.Domain.Customer;
import com.example.demo.Domain.Payment;
import com.example.demo.Domain.Reservation;

import java.util.ArrayList;
import java.util.List;

public class CustomerAdapter {
    public static CustomerDTO getCustomerDTOfromCustomer(Customer cust){
        CustomerDTO custdto=new CustomerDTO(cust.getName(),cust.getEmail());
        Payment p=new Payment(cust.getPayment().getAmount());
        Borrow b=new Borrow(cust.getBorrow().getCheckinDate(),cust.getBorrow().getCheckOutDate());
        Reservation r=new Reservation(cust.getReserve().getReservationdate());
        cust.setBorrow(b);
        cust.setPayment(p);
        cust.setReserve(r);
        return custdto;
    }
    public static Customer getCustomerfromCustomerDTO(CustomerDTO cust) {
        Customer custdto = new Customer(cust.getName(), cust.getEmail());
        PaymentDTO p = new PaymentDTO(cust.getPayment().getAmount());
        BorrowDTO b = new BorrowDTO(cust.getBorrow().getCheckinDate(), cust.getBorrow().getCheckOutDate());
        ReservationDTO r = new ReservationDTO(cust.getReserve().getReservationdate());
        cust.setBorrow(b);
        cust.setPayment(p);
        cust.setReserve(r);
        return custdto;
    }
    public static List<CustomerDTO> getAllCustomerDTOfromCustomer(List<Customer> list){
        List<CustomerDTO> customers=new ArrayList<>();
        for(Customer c:list){
            customers.add(getCustomerDTOfromCustomer(c));
        }
        return customers;
    }
}
