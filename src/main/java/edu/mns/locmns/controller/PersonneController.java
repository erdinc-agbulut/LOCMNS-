package edu.mns.locmns.controller;

import edu.mns.locmns.dao.PersonneDao;
import edu.mns.locmns.model.Personne;
import edu.mns.locmns.security.JwtUtils;
import edu.mns.locmns.security.PersonneDetailsLocMns;
import edu.mns.locmns.security.PersonneDetailsServiceLocMns;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
public class PersonneController {

    public PersonneController(PersonneDao personneDao) {
        this.personneDao = personneDao;
    }

    private PersonneDao personneDao;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PersonneDetailsServiceLocMns personneDetailsSeviceLocMns;


    @PostMapping("/connexion")            // renvoyer un token si l'utilisateur existe dans la BDD
    public Map<String,String> connexion(@RequestBody Personne personne) throws Exception {

        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            personne.getMail(),
                            personne.getMotDePasse()
                    )
            );
        }catch (BadCredentialsException e) {

            Map<String,String> retour = new HashMap<>();
            retour.put("erreur", "Mauvais login/ mot de passe"); // ne jamais préciser si c'est le login ou le mot de passe qui est mauvais
            return retour;
        }

        PersonneDetailsLocMns personneDetails = personneDetailsSeviceLocMns.loadUserByUsername(personne.getMail());

        Map<String,String> retour = new HashMap<>();
        retour.put("token",jwtUtils.generateToken(personneDetails));

        return retour;
    }


}
