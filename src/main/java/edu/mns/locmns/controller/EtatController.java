package edu.mns.locmns.controller;

import edu.mns.locmns.dao.EtatDao;
import edu.mns.locmns.model.Etat;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EtatController {

    private EtatDao etatDao;

    public EtatController(EtatDao etatDao) {
        this.etatDao = etatDao;
    }

    @GetMapping("/gestionnaire/etat/{id}")
    public Etat statut(@PathVariable Integer id) {

        return this.etatDao.findById(id).orElse(null);
    }

}
