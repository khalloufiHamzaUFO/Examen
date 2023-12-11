package com.esprit.khalloufhamzaexamenbalnco.DAO.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
public class Vol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idVol;
    LocalDate dateArrive;
    LocalDate dateDepart;

    //mrgl
    @ManyToOne
    Aeroport aeroport1;
    @ManyToOne
    Aeroport aeroport2;

    @OneToMany( cascade = CascadeType.ALL,mappedBy = "vol")
    List<Reservation> reservations;

}
