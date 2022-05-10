package edu.mns.locmns.dao;

import edu.mns.locmns.model.InfoReparation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoReparationDao extends JpaRepository<InfoReparation, Integer> {
}
