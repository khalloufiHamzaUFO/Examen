package com.esprit.khalloufhamzaexamenbalnco.DAO.repository;

import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.Aeroport;
import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.Voyageur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VoyageurRepo extends JpaRepository<Voyageur,Integer> {
}
