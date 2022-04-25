package edu.mns.locmns.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Materiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMateriel;         // Integer car c'est un objet il peut contenir la valeur Null contrairement a int


    private String numeroSerie;

    @ManyToOne
    private LieuStockage lieuStockage;

    @ManyToOne
    private Modele modele;

    @ManyToOne
    private Etat etat;

    @ManyToMany
    private List<Document> listdocument = new ArrayList<>();

    @OneToMany(mappedBy = "materiel")
    private Emprunt emprunt;

    @OneToMany(mappedBy = "materiel")
    private Dysfonctionnement dysfonctionnement;



}
