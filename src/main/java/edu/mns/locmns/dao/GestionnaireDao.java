package edu.mns.locmns.dao;

import edu.mns.locmns.model.Gestionnaire;
import edu.mns.locmns.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GestionnaireDao extends JpaRepository<Gestionnaire, Integer> {

        Optional<Gestionnaire> findByMail(String mail);

         @Query("FROM Personne p JOIN FETCH p.listeRoles WHERE p.mail = :mail")
         Optional<Personne> findByMailWithRoles(@Param("mail") String mail);

    }

