package edu.mns.locmns.dao;

import edu.mns.locmns.model.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface EmpruntDao extends JpaRepository<Emprunt, Integer> {

    // Optionnal permet de gérer que le resultat soit vide ou non. Permet d'éviter de faire une condition if/else

    Optional<Emprunt> findByUtilisateurIdAndMaterielIdMaterielAndDateEmprunt(
            Integer idUtilisateur,
            Integer idMateriel,
            Date date
    );

    void deleteByUtilisateurIdAndMaterielIdMaterielAndDateEmprunt(
            Integer idUtilisateur,
            Integer idMateriel,
            Date dateEmrunt
    );
}
