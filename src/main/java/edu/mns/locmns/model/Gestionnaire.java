package edu.mns.locmns.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)  // permet de transformer la classe en table dans la BDD
public class Gestionnaire extends Personne{

    @ManyToOne                         // représente une clef étrangère dans la BDD ( via le schéma UML : relation Many to One )
    @JoinColumn(name="id_personne")
    private Personne personne;

    @OneToMany(mappedBy = "gestionnaire")                  // mappedBy permet de faire la liaison dans les 2 sens
    private List<Retard> listeRetard = new ArrayList<>();

    @OneToMany(mappedBy = "gestionnaire")
    private List<Dysfonctionnement> listeDysfonctionnements = new ArrayList<>();

    public Gestionnaire() {
    }

    public Gestionnaire(Integer id, String nom, String prenom, String mail) {
        super(id, nom, prenom, mail);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public List<Retard> getListeRetard() {
        return listeRetard;
    }

    public void setListeRetard(List<Retard> listeRetard) {
        this.listeRetard = listeRetard;
    }

    public List<Dysfonctionnement> getListeDysfonctionnements() {
        return listeDysfonctionnements;
    }

    public void setListeDysfonctionnements(List<Dysfonctionnement> listeDysfonctionnements) {
        this.listeDysfonctionnements = listeDysfonctionnements;
    }

}
