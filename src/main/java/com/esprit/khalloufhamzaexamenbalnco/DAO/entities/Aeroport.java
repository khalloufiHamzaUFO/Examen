package com.esprit.khalloufhamzaexamenbalnco.DAO.entities;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.FieldDefaults;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Aeroport {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idAeroport;
    @Column(nullable = false)
    String nom;
    @Column(length = 3)
    String codeAITA;
    long telephone;

    //mrgl
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "aeroport1")
    List<Vol> volList;
    //mrgla
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "aeroport2")
    List<Vol> listDesVol;

}
