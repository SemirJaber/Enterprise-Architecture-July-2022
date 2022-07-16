package com.example.demo.Services;

import com.example.demo.Adapters.CustomerAdapter;
import com.example.demo.BookClient.Book;
import com.example.demo.DTOs.CustomerDTO;
import com.example.demo.Domain.Borrow;
import com.example.demo.Domain.Customer;
import com.example.demo.Domain.Payment;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class CustomerService {
@Autowired
    private CustomerRepository repository;

    //add customer
  public void addcustomer(CustomerDTO cust){
      Customer c=CustomerAdapter.getCustomerfromCustomerDTO(cust);
      repository.save(c);
  }
  //remove customer
    public void removeCustomer(CustomerDTO cust){
        Customer c=CustomerAdapter.getCustomerfromCustomerDTO(cust);
        repository.delete(c);
    }
    //getAllCustomers
    public List<CustomerDTO> getAllCustomers(){
      List<Customer> customer=repository.findAll();
      List<CustomerDTO> list=CustomerAdapter.getAllCustomerDTOfromCustomer(customer);
      return list;
    }
    //getCustomerbycustomernumber
    public Customer getCustomer(long customernumber){
     Customer cust= repository.findBycustomernumber(customernumber);
     CustomerDTO c=CustomerAdapter.getCustomerDTOfromCustomer(cust);
     return cust;
    }
    public CustomerDTO createcustomer(long customernumber,String name,String email,double outstandingbalance){
        Customer cust=new Customer(customernumber,name,email,outstandingbalance);
        Payment p=new Payment(0);
        Borrow b=new Borrow();
        cust.setPayment(p);
        cust.setBorrow(b);
        repository.save(cust);
        CustomerDTO c=CustomerAdapter.getCustomerDTOfromCustomer(cust);
          return c;
    }
    public void checkout(long customernumber,Book book, LocalDate date){
           Customer c= repository.findBycustomernumber(customernumber);
           c.checkoutBook(book,date);
    }
    public void returnBook(long customernumber,Book book,LocalDate date){
        Customer c=repository.findBycustomernumber(customernumber);
        c.returnBook(book,date);
    }
    public void pay(long customernumber,double amount){
        Customer c=repository.findBycustomernumber(customernumber);
        c.paypenality(amount);
    }
    public void reserve(long customernumber,LocalDate date){
        Customer c=repository.findBycustomernumber(customernumber);
        c.reserve(date);
    }
}
