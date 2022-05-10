package edu.mns.locmns.dao;

import edu.mns.locmns.model.Retard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RetardDao extends JpaRepository<Retard, Integer> {
}
