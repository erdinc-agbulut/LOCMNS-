package edu.mns.locmns.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Materiel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMateriel;         // Integer car c'est un objet il peut contenir la valeur Null contrairement a int


    private String numeroSerie;

    @ManyToOne
    @JoinColumn(name="id_lieu_stockage")
    private LieuStockage lieuStockage;

    @ManyToOne
    @JoinColumn(name="id_modele")
    private Modele modele;

    @ManyToOne
    @JoinColumn(name="id_etat")
    private Etat etat;

    @ManyToMany
    @JoinTable(
            name="fournit",
            joinColumns = @JoinColumn(name="id_materiel"),
            inverseJoinColumns = @JoinColumn(name="id_listdocument")

    )
    private List<Document> listdocument = new ArrayList<>();

    @OneToMany(mappedBy = "materiel")
    private List<Emprunt> emprunt = new ArrayList<>();

    @OneToMany(mappedBy = "materiel")
    private List <Dysfonctionnement>  dysfonctionnement = new ArrayList<>();



}
