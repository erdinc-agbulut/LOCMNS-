package edu.mns.locmns.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
import java.util.zip.DataFormatException;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class InfoReparation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Date datePrevueReparation;

    private String cheminDocument;

    @ManyToOne
    @JoinColumn(name = "id_materiel")
    private Materiel materiel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDatePrevueReparation() {
        return datePrevueReparation;
    }

    public void setDatePrevueReparation(Date datePrevueReparation) {
        this.datePrevueReparation = datePrevueReparation;
    }

    public String getCheminDocument() {
        return cheminDocument;
    }

    public void setCheminDocument(String cheminDocument) {
        this.cheminDocument = cheminDocument;
    }
}
