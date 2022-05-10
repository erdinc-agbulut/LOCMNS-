package edu.mns.locmns.controller;

import edu.mns.locmns.dao.MaterielDao;
import edu.mns.locmns.model.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class MaterielController {

    private MaterielDao materielDao;

    @Autowired
    public MaterielController(MaterielDao materielDao){
        this.materielDao = materielDao;
    }

    @GetMapping("/gestionnaire/liste-materiels")
    public List<Materiel> listeMateriels (){
        return this.materielDao.findAll();
    }

    @GetMapping("/gestionnaire/materiel/{id}")
    public Materiel materiel(@PathVariable Integer id){
        return this.materielDao.findById(id).orElse(null);
    }

    @PostMapping("/materiel")
    public String createMateriel(@RequestBody Materiel materiel){
        this.materielDao.save(materiel);
        return "Le materiel" + materiel + "a été crée";
    }

    @DeleteMapping("gestionnaire/materiel/{id}")
    public String deleteMateriel(@PathVariable int id){
        this.materielDao.deleteById(id);
        return "Le materiel a été supprimé";
    }

}
