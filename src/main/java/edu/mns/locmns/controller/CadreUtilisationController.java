package edu.mns.locmns.controller;

import edu.mns.locmns.dao.CadreUtilisationDao;
import edu.mns.locmns.model.CadreUtilisation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CadreUtilisationController {

    private CadreUtilisationDao cadreUtilisationDao;

    public CadreUtilisationController(CadreUtilisationDao cadreUtilisationDao) {
        this.cadreUtilisationDao = cadreUtilisationDao;
    }

    @GetMapping("/liste-cadres-utilisation")
    public List<CadreUtilisation> listeCadresUtilisation(){
        return this.cadreUtilisationDao.findAll();
    }

    @GetMapping("/cadre-utilisation/{id}")
    public CadreUtilisation cadreUtilisation(@PathVariable Integer id){
        return this.cadreUtilisationDao.findById(id).orElse(null);
    }
}
