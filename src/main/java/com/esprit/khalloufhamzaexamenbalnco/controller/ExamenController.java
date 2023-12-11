package com.esprit.khalloufhamzaexamenbalnco.controller;


import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.ClassePlace;
import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.Reservation;
import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.Vol;
import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.Voyageur;
import com.esprit.khalloufhamzaexamenbalnco.service.IExamneService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
public class ExamenController {

    IExamneService iExamenService;

    @PostMapping("/ajouterVol")
    public String ajouterVolAeroport(@RequestBody Vol vol) {
        return iExamenService.ajouterVolAeroport(vol);
    }

    @PostMapping("/ajouterVoyageur")
    public List<Voyageur> ajouterVoyageurs(List<Voyageur> voyageurs) {
        return iExamenService.ajouterVoyageurs(voyageurs);
    }

    @PostMapping("/resrverVol")
    public String reserverVol(@RequestParam int voyageurId,@RequestParam int volId,@RequestParam ClassePlace classePlace) {
        return iExamenService.reserverVol(voyageurId,volId,classePlace);
    }

    @PutMapping("/confirmerReservation")
    public Reservation confirmerReservation(@RequestParam String resId) {
        return iExamenService.confirmerReservation(resId);
    }

    @GetMapping("/getVouyageurByVol")
    public Map<Integer, List<Voyageur>> getVouyageurByVol() {
        return iExamenService.getVouyageurByVol();
    }



}
