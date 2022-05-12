package edu.mns.locmns.controller;

import edu.mns.locmns.dao.UtilisateurDao;
import edu.mns.locmns.model.Personne;
import edu.mns.locmns.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class UtilisateurController {

    public UtilisateurDao utilisateurDao;

    @Autowired
    PasswordEncoder encoder;

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

    @PostMapping("/inscription")
    public String inscription(@RequestBody Personne personne) throws Exception{
        personne.setMotDePasse(encoder.encode(personne.getMotDePasse()));
        personne.setNom("COLNAT");
        personne.setPrenom("Corentin");
        personne.setMail("coco@gmail.com");

        return "utlisateur crée";
    }
}
