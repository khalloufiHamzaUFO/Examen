package com.esprit.khalloufhamzaexamenbalnco.DAO.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Reservation {
    @Id
    String idReservation;
    LocalDate dateReservation;
    @Enumerated(EnumType.STRING)
    ClassePlace classePlace;
    @Enumerated(EnumType.STRING)
    EtatReservation etatReservation;


    //MRGL
    @ManyToOne
    @JsonIgnore
    Vol vol;

    @ManyToOne
    @JsonIgnore
    Voyageur voyageur;
}
