package com.schedule.reservations.controller;

import com.schedule.reservations.domain.Reservation;
import com.schedule.reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {
    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/reservations")
    List<Reservation> findAllReservations(){
        return reservationService.findAllReservations();
    }
    @PostMapping("/reservation")
    Reservation addReservation(@RequestBody Reservation reservation){
      return reservationService.addReservation(reservation);
    }

    @GetMapping("/reservation/{id}")
    Reservation findReservationById(@PathVariable int id) throws Exception {
       return reservationService.findById(id);
    }

    @DeleteMapping("/reservation/{id}")
    void deleteReservationById(@PathVariable int id) throws Exception {
        reservationService.deleteById(id);
    }

}
