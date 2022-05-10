package edu.mns.locmns.dao;

import edu.mns.locmns.model.Modele;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModeleDao extends JpaRepository<Modele, Integer> {
}
