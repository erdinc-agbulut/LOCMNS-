package edu.mns.locmns.dao;

import edu.mns.locmns.model.LieuUtilisation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuUtilisationDao extends JpaRepository<LieuUtilisation, Integer> {
}
