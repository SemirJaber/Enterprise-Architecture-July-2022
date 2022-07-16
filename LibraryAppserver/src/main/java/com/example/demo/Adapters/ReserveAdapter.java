package com.example.demo.Adapters;

import com.example.demo.DTOs.ReservationDTO;
import com.example.demo.Domain.Reservation;

public class ReserveAdapter {

    public static Reservation getReservefromreserveDTO(ReservationDTO r) {
        Reservation reserv = new Reservation( r.getReservationdate());
        return reserv;
    }

    public static ReservationDTO getReserveDTOfromreserve(Reservation r) {
        ReservationDTO reserv = new ReservationDTO( r.getReservationdate());
        return reserv;
    }
}
