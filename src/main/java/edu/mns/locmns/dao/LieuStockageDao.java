package edu.mns.locmns.dao;

import edu.mns.locmns.model.LieuStockage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LieuStockageDao extends JpaRepository<LieuStockage, Integer> {
}
