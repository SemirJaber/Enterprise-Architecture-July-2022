package com.example.demo.Domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Reservation {
    @Id
    @GeneratedValue
    private long reservationnumber;


    private LocalDate reservationdate;
    public Reservation(){}

    public Reservation(LocalDate reservationdate) {
        this.reservationdate = reservationdate;

    }

    public void reserve(LocalDate date){
        this.reservationdate=date;
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
