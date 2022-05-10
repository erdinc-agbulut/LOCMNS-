package edu.mns.locmns.controller;

import edu.mns.locmns.dao.CadreUtilisationDao;
import edu.mns.locmns.dao.LieuUtilisationDao;
import edu.mns.locmns.model.CadreUtilisation;
import edu.mns.locmns.model.LieuUtilisation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class CadreUtilisationController {

        private CadreUtilisationDao cadreUtilisationDao;

        @Autowired
        public CadreUtilisationController(CadreUtilisationDao cadreUtilisationDao) {
            this.cadreUtilisationDao = cadreUtilisationDao;
        }

        @GetMapping("/liste-cadres-utilisation")
        public List<CadreUtilisation> cadreUtilisations(){
            return this.cadreUtilisationDao.findAll();
        }

        @GetMapping("/liste-cadres-utilisation/{id}")
        public CadreUtilisation cadreUtilisation(@PathVariable Integer id){
            return this.cadreUtilisationDao.findById(id).orElse(null);
        }
    }

