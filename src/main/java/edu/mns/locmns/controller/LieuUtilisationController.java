package edu.mns.locmns.controller;

import edu.mns.locmns.dao.LieuUtilisationDao;
import edu.mns.locmns.model.LieuUtilisation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class LieuUtilisationController {

    private LieuUtilisationDao lieuUtilisationDao;

    public LieuUtilisationController(LieuUtilisationDao lieuUtilisationDao) {
        this.lieuUtilisationDao = lieuUtilisationDao;
    }

    @GetMapping("/liste-lieux-utilisation")
    public List<LieuUtilisation> listeLieuxUtilisation(){
        return this.lieuUtilisationDao.findAll();
    }

    @GetMapping("/lieu-utilisation/{id}")
    public LieuUtilisation lieuUtilisation(@PathVariable Integer id){
        return this.lieuUtilisationDao.findById(id).orElse(null);
    }
}
