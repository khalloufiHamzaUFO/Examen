package com.esprit.khalloufhamzaexamenbalnco.service;


import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.ClassePlace;
import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.Reservation;
import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.Vol;
import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.Voyageur;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface IExamneService {

    String ajouterVolAeroport(Vol vol);
    List<Voyageur> ajouterVoyageurs(List<Voyageur> voyageurs);
    String reserverVol(int voyageurId, int volId, ClassePlace classePlace);
    Reservation confirmerReservation(String s);
    Map<Integer,List<Voyageur>> getVouyageurByVol();
//    public void getAllTransactionByDate();
}
