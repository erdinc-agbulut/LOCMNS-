package edu.mns.locmns.dao;

import edu.mns.locmns.model.Caracteristique;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaracteristiqueDao extends JpaRepository<Caracteristique, Integer> {
}
