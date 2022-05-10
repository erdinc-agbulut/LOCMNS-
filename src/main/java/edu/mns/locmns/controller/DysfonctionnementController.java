package edu.mns.locmns.controller;

import edu.mns.locmns.dao.DysfonctionnementDao;
import edu.mns.locmns.model.Dysfonctionnement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class DysfonctionnementController {

    private DysfonctionnementDao dysfonctionnementDao;

    @Autowired
    public DysfonctionnementController(DysfonctionnementDao dysfonctionnementDao) {
        this.dysfonctionnementDao = dysfonctionnementDao;
    }

    @GetMapping("/gestionnaire/liste-dysfonctionnements")
    public List<Dysfonctionnement> listeDysfonctionnements() {

        return this.dysfonctionnementDao.findAll();
    }

    @GetMapping("/gestionnaire/liste-dysfonctionnements/{id}")
    public Dysfonctionnement dysfonctionnement(@PathVariable Integer id){

        return this.dysfonctionnementDao.findById(id).orElse(null);
    }
}
