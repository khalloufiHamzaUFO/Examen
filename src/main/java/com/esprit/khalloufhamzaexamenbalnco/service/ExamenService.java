package com.esprit.khalloufhamzaexamenbalnco.service;

import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.*;
import com.esprit.khalloufhamzaexamenbalnco.DAO.repository.AeroportRepo;
import com.esprit.khalloufhamzaexamenbalnco.DAO.repository.ReservationRepo;
import com.esprit.khalloufhamzaexamenbalnco.DAO.repository.VolRepo;
import com.esprit.khalloufhamzaexamenbalnco.DAO.repository.VoyageurRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
public class ExamenService implements IExamneService {

    @Autowired
    AeroportRepo aeroportRepo;

    @Autowired
    VolRepo volRepo;

    @Autowired
    VoyageurRepo voyageurRepo;

    @Autowired
    ReservationRepo reservationRepo;

    @Override
    public String ajouterVolAeroport(Vol vol) {
        Aeroport alle = aeroportRepo.findByCodeAITA(vol.getAeroport1().getCodeAITA());
        Aeroport arrive = aeroportRepo.findByCodeAITA(vol.getAeroport2().getCodeAITA());
        System.out.println(arrive.getCodeAITA());
        if (arrive.getCodeAITA().equals(alle.getCodeAITA())) {
            return "Verifier les aeroports saisis";
        }else{
            volRepo.save(vol);
            return "Le vol est ajoute avec succes";
        }
    }

    @Override
    public List<Voyageur> ajouterVoyageurs(List<Voyageur> voyageurs) {
        return  voyageurRepo.saveAll(voyageurs);
    }

    @Override
    public String reserverVol(int voyageurId, int volId, ClassePlace classePlace) {
        Reservation reservation = new Reservation();
        String eco = "ECO-";
        String bui = "BUS-";
        Vol v = volRepo.findByIdVol(volId);
        if (classePlace == ClassePlace.ECONOMIQUE) {
            List<Reservation> reservations = reservationRepo.findAllByClassePlaceAndVolIdVol(ClassePlace.ECONOMIQUE,volId);

            if (reservations.size()<=3) {
                reservation.setIdReservation("ECO-" + volId + "-" + voyageurId);
                reservation.setDateReservation(LocalDate.now());
                reservation.setClassePlace(ClassePlace.ECONOMIQUE);
                reservation.setEtatReservation(EtatReservation.ENCOURS);
                reservationRepo.save(reservation);
                return "Affectation avec succes"+reservation.getIdReservation();
            }else
                return classePlace+" du vol "+volId+" est  complet";
        } else if (classePlace == ClassePlace.BUISNESS) {
            List<Reservation> reservations = reservationRepo.findAllByClassePlaceAndVolIdVol(ClassePlace.BUISNESS,volId);
            if (reservations.size() <= 2) {
                reservation.setIdReservation("ECO-" + volId + "-" + voyageurId);
                reservation.setDateReservation(LocalDate.now());
                reservation.setClassePlace(ClassePlace.BUISNESS);
                reservation.setEtatReservation(EtatReservation.ENCOURS);
                return "Affectation avec succes"+reservation.getIdReservation();
            } else
                return classePlace+" du vol "+volId+" est  complet";
        }
        return null;
    }

    @Override
    public Reservation confirmerReservation(String resId) {
        Reservation r = reservationRepo.findByIdReservation(resId);
        r.setEtatReservation(EtatReservation.CONFIRME);
        reservationRepo.save(r);
        return r;
    }

    @Override
    public Map<Integer, List<Voyageur>> getVouyageurByVol() {
        List<Vol> vols = volRepo.findByDateDepart(LocalDate.now());
        Map<Integer , List<Voyageur>> Voyageurs = new HashMap<>();
        ArrayList<Voyageur> voyageurs ;
        for (Vol vol : vols) {
            voyageurs = new ArrayList<>() ;
            List<Reservation> reservations = vol.getReservations();
            for (Reservation r : reservations) {
                if(r.getEtatReservation().equals(EtatReservation.CONFIRME)){
                    voyageurs.add(r.getVoyageur()) ;
                }
            }
            Voyageurs.put(vol.getIdVol() ,voyageurs);
        }
        return Voyageurs;
    }
}


//    @Override
//    public void getAllTransactionByDate() {
//        List<Transaction> transactions= transactionRepo.findByDateTransaction(LocalDate.now());
//        log.info("La liste des transactions");
//        for (Transaction  transaction: transactions) {
//            log.info(transaction.getIdTransaction()+"");
//        }
//    }
