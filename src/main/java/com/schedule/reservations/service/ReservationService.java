package com.schedule.reservations.service;

import com.schedule.reservations.domain.Reservation;
import com.schedule.reservations.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    private ReservationRepository reservationRepository;

    @Autowired
    public ReservationService(ReservationRepository reservationRepository){
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> findAllReservations(){
        return reservationRepository.findAll();
    }

    public List<Reservation> findReservationsByClientNumber(String clientNumber){
        return reservationRepository.findByClientNumber(clientNumber);
    }

    public Reservation addReservation( Reservation reservation){
       return reservationRepository.save(reservation);
    }

    public Reservation findById(int id) throws Exception{
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if(reservationOptional.isPresent()){
            return reservationOptional.get();
        }
        else {
            throw new Exception("Reservation not found!");
        }
    }
    public void deleteById(int id) throws Exception{
        Optional<Reservation> reservationOptional = reservationRepository.findById(id);
        if(reservationOptional.isPresent()){
             reservationRepository.deleteById(id);
        }
        else {
            throw new Exception("Reservation not found!");
        }
    }
}
