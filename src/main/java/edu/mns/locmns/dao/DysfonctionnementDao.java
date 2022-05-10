package edu.mns.locmns.dao;

import edu.mns.locmns.model.Dysfonctionnement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DysfonctionnementDao extends JpaRepository<Dysfonctionnement, Integer> {
}
