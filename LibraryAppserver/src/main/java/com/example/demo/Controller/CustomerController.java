package com.example.demo.Controller;

import com.example.demo.BookClient.Book;
import com.example.demo.DTOs.CustomerDTO;
import com.example.demo.Domain.Customer;
import com.example.demo.Services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/Check_out")
    public ResponseEntity<?> checkoutBook(@PathVariable long customernumber, @RequestBody Book book, @PathVariable LocalDate checkindate){
           service.checkout(customernumber,book,checkindate);
           return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
     @GetMapping("/return")
    public ResponseEntity<?> returnBook(@PathVariable long customernumber, @RequestBody Book book,@PathVariable LocalDate returndate){
        service.returnBook(customernumber,book,returndate);
        return new ResponseEntity<Book>(book,HttpStatus.OK);
    }
    @GetMapping("/customers")
    public ResponseEntity<?> getAllCustomers(){
        List<CustomerDTO> customer=service.getAllCustomers();
        return new ResponseEntity<List<CustomerDTO>>(customer,HttpStatus.OK);
    }
   @GetMapping("/{customernumber}")
    public ResponseEntity<?> getCustomer(@PathVariable long customernumber){
        Customer customer=service.getCustomer(customernumber);
        return new  ResponseEntity<Customer>(customer,HttpStatus.OK);
    }
    @DeleteMapping("/remove_customer")
    public ResponseEntity<?> removeCustomer(@RequestBody CustomerDTO customer){
        service.removeCustomer(customer);
        return new ResponseEntity<CustomerDTO>(customer,HttpStatus.OK);
    }
    @PostMapping("/add_customer")
    public ResponseEntity<?> addCustomer(CustomerDTO customer){
        service.addcustomer(customer);
        return new ResponseEntity<CustomerDTO>(customer,HttpStatus.OK);
    }

}
