package com.esprit.khalloufhamzaexamenbalnco.DAO.repository;

import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.Aeroport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AeroportRepo extends JpaRepository<Aeroport,Integer> {
    Aeroport findByCodeAITA(String s);
}
