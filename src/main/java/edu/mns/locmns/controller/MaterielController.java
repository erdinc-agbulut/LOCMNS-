package edu.mns.locmns.controller;


import com.fasterxml.jackson.annotation.JsonView;
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
    public MaterielController(MaterielDao materielDao) { this.materielDao = materielDao;}

    @GetMapping("/gestionnaire/liste-materiels")
    //@JsonView(VueMateriel.class)
    public List<Materiel> listeMateriels(){

        return this.materielDao.findAll();
    }

    @GetMapping("/gestionnaire/materiel/{id}")
    //@JsonView(VueMateriel.class)
    public Materiel materiel(@PathVariable Integer id) {
        return this.materielDao.findById(id).orElse(null);
    }

    @PostMapping("/gestionnaire/materiel")
    public String createMateriel(@RequestBody Materiel materiel) {

        this.materielDao.save(materiel);

        return "Le materiel " + materiel +  " à été créer";
    }

    @DeleteMapping("/gestionnaire/materiel/{id}")
    public String deleteMateriel(@PathVariable int id) {

        this.materielDao.deleteById(id);

        return "Le materiel à été supprimer";

    }
}
