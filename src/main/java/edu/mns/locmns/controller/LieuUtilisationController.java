package edu.mns.locmns.controller;

import edu.mns.locmns.dao.LieuStockageDao;
import edu.mns.locmns.dao.LieuUtilisationDao;
import edu.mns.locmns.model.LieuUtilisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class LieuUtilisationController {

    private LieuUtilisationDao lieuUtilisationDaoDao;

    @Autowired
    public LieuUtilisationController(LieuUtilisationDao lieuUtilisationDao) {
        this.lieuUtilisationDaoDao = lieuUtilisationDao;
    }

    @GetMapping("/liste-lieux-utilisation")
    public List<LieuUtilisation> lieuUtilisations(){

        return this.lieuUtilisationDaoDao.findAll();
    }

    @GetMapping("/liste-lieux-utilisation/{id}")
    public LieuUtilisation lieuUtilisation(@PathVariable Integer id){
        return this.lieuUtilisationDaoDao.findById(id).orElse(null);
    }
}
