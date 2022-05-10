package edu.mns.locmns.dao;

import edu.mns.locmns.model.CadreUtilisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CadreUtilisationDao extends JpaRepository<CadreUtilisation, Integer> {
}
