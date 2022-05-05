package edu.mns.locmns.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@EntityListeners(AuditingEntityListener.class)
public class LieuStockage {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idStock;


    private String nomLieuStockage;

    @OneToMany(mappedBy = "lieuStockage")
    private List<Materiel> listeMateriel = new ArrayList<>();
}
