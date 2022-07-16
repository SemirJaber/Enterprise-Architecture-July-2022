package com.example.demo.Domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import com.example.demo.BookClient.Book;

import java.time.LocalDate;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;

class CustomerTest {

    @Test
    void testConstructor() {
        Customer actualCustomer = new Customer();
        Borrow borrow = new Borrow();
        borrow.setBorrownumber(1L);
        borrow.setCheckOutDate(LocalDate.ofEpochDay(1L));
        borrow.setCheckinDate(LocalDate.ofEpochDay(1L));
        actualCustomer.setBorrow(borrow);
        actualCustomer.setCustomernumber(1L);
        actualCustomer.setEmail("jane.doe@example.org");
        actualCustomer.setName("Name");
        actualCustomer.setOutstandingbalance(10.0d);
        Payment payment = new Payment();
        payment.setAmount(10.0d);
        payment.setPaymentnumber(1L);
        actualCustomer.setPayment(payment);
        Reservation reservation = new Reservation();
        reservation.reserve(LocalDate.ofEpochDay(1L));
        reservation.setReservationdate(LocalDate.ofEpochDay(1L));
        reservation.setReservationnumber(1L);
        actualCustomer.setReserve(reservation);
        assertSame(borrow, actualCustomer.getBorrow());
        assertEquals(1L, actualCustomer.getCustomernumber());
        assertEquals("jane.doe@example.org", actualCustomer.getEmail());
        assertEquals("Name", actualCustomer.getName());
        assertEquals(10.0d, actualCustomer.getOutstandingbalance());
        assertSame(payment, actualCustomer.getPayment());
        assertSame(reservation, actualCustomer.getReserve());
    }

    @Test
    void testConstructor2() {
        Customer actualCustomer = new Customer("Name", "jane.doe@example.org");
        Borrow borrow = new Borrow();
        borrow.setBorrownumber(1L);
        borrow.setCheckOutDate(LocalDate.ofEpochDay(1L));
        borrow.setCheckinDate(LocalDate.ofEpochDay(1L));
        actualCustomer.setBorrow(borrow);
        actualCustomer.setCustomernumber(1L);
        actualCustomer.setEmail("jane.doe@example.org");
        actualCustomer.setName("Name");
        actualCustomer.setOutstandingbalance(10.0d);
        Payment payment = new Payment();
        payment.setAmount(10.0d);
        payment.setPaymentnumber(1L);
        actualCustomer.setPayment(payment);
        Reservation reservation = new Reservation();
        reservation.reserve(LocalDate.ofEpochDay(1L));
        reservation.setReservationdate(LocalDate.ofEpochDay(1L));
        reservation.setReservationnumber(1L);
        actualCustomer.setReserve(reservation);
        assertSame(borrow, actualCustomer.getBorrow());
        assertEquals(1L, actualCustomer.getCustomernumber());
        assertEquals("jane.doe@example.org", actualCustomer.getEmail());
        assertEquals("Name", actualCustomer.getName());
        assertEquals(10.0d, actualCustomer.getOutstandingbalance());
        assertSame(payment, actualCustomer.getPayment());
        assertSame(reservation, actualCustomer.getReserve());
    }

    @Test
    void testConstructor3() {
        Customer actualCustomer = new Customer(1L, "Name", "jane.doe@example.org", 10.0d);

        assertEquals(10.0d, actualCustomer.getOutstandingbalance());
        assertEquals("Name", actualCustomer.getName());
        assertEquals("jane.doe@example.org", actualCustomer.getEmail());
        assertEquals(1L, actualCustomer.getCustomernumber());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testCheckoutBook() {

        Customer customer = new Customer();
        customer.checkoutBook(new Book("Isbn", "Dr"), LocalDate.ofEpochDay(1L));
    }

    @Test
    void testCheckoutBook2() {
        Borrow borrow = new Borrow();
        borrow.setBorrownumber(1L);
        borrow.setCheckOutDate(LocalDate.ofEpochDay(1L));
        borrow.setCheckinDate(LocalDate.ofEpochDay(1L));

        Customer customer = new Customer();
        customer.setBorrow(borrow);
        customer.checkoutBook(new Book("Isbn", "Dr"), LocalDate.ofEpochDay(1L));
        assertEquals(0.0d, customer.getBorrow().penality());
    }

    @Test
    @Disabled("TODO: Complete this test")
    void testReturnBook() {
        Customer customer = new Customer();
        customer.returnBook(new Book("Isbn", "Dr"), LocalDate.ofEpochDay(1L));
    }

    @Test
    void testReturnBook2() {
        Borrow borrow = new Borrow();
        borrow.setBorrownumber(1L);
        borrow.setCheckOutDate(LocalDate.ofEpochDay(1L));
        borrow.setCheckinDate(LocalDate.ofEpochDay(1L));

        Customer customer = new Customer();
        customer.setBorrow(borrow);
        customer.returnBook(new Book("Isbn", "Dr"), LocalDate.ofEpochDay(1L));
        assertEquals(0.0d, customer.getBorrow().penality());
    }


    @Test
    @Disabled("TODO: Complete this test")
    void testPaypenality() {


        (new Customer()).paypenality(10.0d);
    }

    @Test
    void testPaypenality2() {
        Payment payment = new Payment();
        payment.setAmount(10.0d);
        payment.setPaymentnumber(1L);

        Customer customer = new Customer();
        customer.setPayment(payment);
        assertEquals(20.0d, customer.paypenality(10.0d));
        assertEquals(-10.0d, customer.getOutstandingbalance());
        assertEquals(20.0d, customer.getPayment().getAmount());
    }
    @Test
    @Disabled("TODO: Complete this test")
    void testReserve() {

        (new Customer()).reserve(LocalDate.ofEpochDay(1L));
    }

    @Test
    void testReserve2() {
        Reservation reservation = new Reservation();
        reservation.reserve(LocalDate.ofEpochDay(1L));
        reservation.setReservationdate(LocalDate.ofEpochDay(1L));
        reservation.setReservationnumber(1L);

        Customer customer = new Customer();
        customer.setReserve(reservation);
        LocalDate ofEpochDayResult = LocalDate.ofEpochDay(1L);
        customer.reserve(ofEpochDayResult);
        assertSame(ofEpochDayResult, customer.getReserve().getReservationdate());
    }
}

