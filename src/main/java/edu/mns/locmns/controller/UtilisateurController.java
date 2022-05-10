package edu.mns.locmns.controller;

import edu.mns.locmns.dao.UtilisateurDao;
import edu.mns.locmns.model.Utilisateur;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class UtilisateurController {

    public UtilisateurDao utilisateurDao;

    public UtilisateurController(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }

    @GetMapping("/gestionnaire/liste-utilisateurs")
    public List<Utilisateur> listeUtilisateurs(){
        return this.utilisateurDao.findAll();
    }

    @GetMapping("/gestionnaire/utilisateur/{id}")
    public Utilisateur utilisateur(@PathVariable Integer id){
        return this.utilisateurDao.findById(id).orElse(null);
    }
}
