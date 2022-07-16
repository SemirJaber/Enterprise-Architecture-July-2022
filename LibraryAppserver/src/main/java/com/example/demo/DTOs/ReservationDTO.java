package com.example.demo.DTOs;

import com.example.demo.BookClient.Book;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDate;


public class ReservationDTO {

    private long reservationnumber;

    private LocalDate reservationdate;
    public ReservationDTO(){}

    public ReservationDTO( LocalDate reservationdate) {
        this.reservationdate = reservationdate;

    }

    public long getReservationnumber() {
        return reservationnumber;
    }

    public void setReservationnumber(long reservationnumber) {
        this.reservationnumber = reservationnumber;
    }

    public LocalDate getReservationdate() {
        return reservationdate;
    }

    public void setReservationdate(LocalDate reservationdate) {
        this.reservationdate = reservationdate;
    }


}
