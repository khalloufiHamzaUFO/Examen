package com.esprit.khalloufhamzaexamenbalnco.DAO.entities;


import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Voyageur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idVoyageur;
    String nom;
    String prenom;
    LocalDate dateNaissance;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "voyageur")
    List<Reservation> reservationList;
}
