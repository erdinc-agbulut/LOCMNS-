package edu.mns.locmns.dao;

import edu.mns.locmns.model.Statut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatutDao extends JpaRepository<Statut, Integer> {
}
