package edu.mns.locmns.dao;

import edu.mns.locmns.model.Emprunt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.Optional;

@Repository
public interface EmpruntDao extends JpaRepository<Emprunt, Integer> {
/*    Optional<Emprunt> findByIdUtilisateurAndIdMaterielAndDateEmprunt(Integer id_utilisateur, Integer idMateriel, Date dateEmprunt);

    void deleteByIdUtilisateurAndIdMaterielAndDateEmprunt(Integer idUtilisateur, Integer idMateriel, Date date);*/
}
