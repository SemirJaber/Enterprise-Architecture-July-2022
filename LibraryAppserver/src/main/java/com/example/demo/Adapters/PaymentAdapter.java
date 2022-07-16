package com.example.demo.Adapters;

import com.example.demo.DTOs.PaymentDTO;
import com.example.demo.Domain.Payment;

public class PaymentAdapter {

    public static Payment getPaymentfromPaymentDTO(PaymentDTO pay){
        Payment p=new Payment(pay.getAmount());
        return p;
    }
    public static PaymentDTO getPaymentDTOfromPayment(Payment pay){
        PaymentDTO p=new PaymentDTO(pay.getAmount());
        return p;
    }
}
