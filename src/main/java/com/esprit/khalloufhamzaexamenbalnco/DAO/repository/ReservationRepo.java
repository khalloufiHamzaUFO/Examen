package com.esprit.khalloufhamzaexamenbalnco.DAO.repository;

import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.ClassePlace;
import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.EtatReservation;
import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface ReservationRepo  extends JpaRepository<Reservation,String> {
    List<Reservation> findAllByClassePlaceAndVolIdVol(ClassePlace classePlace,int vol);
    Reservation findByIdReservation(String s);
    List<Reservation> findAllByEtatReservationAndDateReservation(EtatReservation reservation, LocalDate localDate);
}
