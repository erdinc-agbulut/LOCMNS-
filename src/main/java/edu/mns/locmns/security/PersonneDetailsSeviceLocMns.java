package edu.mns.locmns.security;

import edu.mns.locmns.dao.GestionnaireDao;
import edu.mns.locmns.dao.PersonneDao;
import edu.mns.locmns.model.Gestionnaire;
import edu.mns.locmns.model.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonneDetailsSeviceLocMns implements UserDetailsService {

    private PersonneDao personneDao;

    @Autowired
    private GestionnaireDao gestionnaireDao;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    PersonneDetailsSeviceLocMns(PersonneDao personneDao) { this.personneDao = personneDao; }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Personne personne = personneDao
                .findByMailWithRoles(username)
                .orElseThrow(() -> new UsernameNotFoundException("Mauvais mail / mot de passe"));

        Optional<Gestionnaire> gestionnaire  = gestionnaireDao.findById(personne.getId());

        PersonneDetailLocMns personneDetailsLocMns = new PersonneDetailLocMns(personne, gestionnaire.isPresent() );

         return personneDetailsLocMns;

    }
}
