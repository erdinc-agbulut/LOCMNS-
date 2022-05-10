package edu.mns.locmns.controller;

import edu.mns.locmns.dao.RetardDao;
import edu.mns.locmns.model.Retard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class RetardController {

    private RetardDao retardDao;

    @Autowired
    public RetardController(RetardDao retardDao) {
        this.retardDao = retardDao;
    }

    @GetMapping("/gestionnaire/liste-retards")
    public List<Retard> listeRetard() {
        return this.retardDao.findAll();
    }

    @GetMapping("/gestionnaire/liste-retards/{id}")
    public Retard retard(@PathVariable Integer id){
        return this.retardDao.findById(id).orElse(null);
    }
}
