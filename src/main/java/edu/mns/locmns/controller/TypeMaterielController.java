package edu.mns.locmns.controller;

import edu.mns.locmns.dao.TypeMaterielDao;
import edu.mns.locmns.model.TypeMateriel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TypeMaterielController {

    private TypeMaterielDao typeMaterielDao;

    @Autowired
    public TypeMaterielController(TypeMaterielDao typeMaterielDao) {
        this.typeMaterielDao = typeMaterielDao;
    }

    @GetMapping("/liste-typeMateriels")
    public List<TypeMateriel> listeTypeMateriels() {
        return this.typeMaterielDao.findAll();
    }

    @GetMapping("/liste-typeMateriels/{id}")
    public TypeMateriel typeMateriels(@PathVariable Integer id){
        return this.typeMaterielDao.findById(id).orElse(null);
    }
}
