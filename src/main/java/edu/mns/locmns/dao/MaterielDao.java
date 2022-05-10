package edu.mns.locmns.dao;

import edu.mns.locmns.model.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MaterielDao extends JpaRepository<Materiel, Integer> {
}
