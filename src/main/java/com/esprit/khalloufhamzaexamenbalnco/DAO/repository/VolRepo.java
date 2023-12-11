package com.esprit.khalloufhamzaexamenbalnco.DAO.repository;

import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.Aeroport;
import com.esprit.khalloufhamzaexamenbalnco.DAO.entities.Vol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface VolRepo  extends JpaRepository<Vol,Integer> {

    Vol findByIdVol(int i);
    List<Vol> findByDateDepart(LocalDate now);

//    @Query("select transaction from Transaction transaction  join Banque bank on ((transaction.destinataire member bank.comptes) or (transaction.expediteur member bank.comptes)) where bank.idBanque=:idBank")
//    List<Transaction> findByBankIdBank(long idBank);
//Schedule
//    List<Transaction> findByDestinataireIdCompteOrExpediteurIdCompteAndType(long destintaire, long expediteur, TypeTransaction type);

}
