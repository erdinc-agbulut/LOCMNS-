package edu.mns.locmns.controller;

import edu.mns.locmns.dao.CaracteristiqueDao;
import edu.mns.locmns.model.Caracteristique;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class CaracteristiqueController {

    private CaracteristiqueDao caracteristiqueDao;

    @Autowired
    public CaracteristiqueController(CaracteristiqueDao caracteristiqueDao) {
        this.caracteristiqueDao = caracteristiqueDao;
    }

    @GetMapping("/gestionnaire/liste-caracteristiques")
    public List<Caracteristique> listeCaracteristiques(){
        return this.caracteristiqueDao.findAll();
    }

    @GetMapping("/gestionnaire/caracteristique/{id}")
    public Caracteristique caracteristique(@PathVariable Integer id){
        return this.caracteristiqueDao.findById(id).orElse(null);
    }
}
