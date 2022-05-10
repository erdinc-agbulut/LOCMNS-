package edu.mns.locmns.controller;

import edu.mns.locmns.dao.LieuStockageDao;
import edu.mns.locmns.model.LieuStockage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class LieuStockageController {
    private LieuStockageDao lieuStockageDao;

    @Autowired
    public LieuStockageController(LieuStockageDao lieuStockageDao) {
        this.lieuStockageDao = lieuStockageDao;
    }

    @GetMapping("/gestionnaire/liste_lieuxStockage")
    public List<LieuStockage> listeLieuxStockage(){
        return this.lieuStockageDao.findAll();
    }

    @GetMapping ("gestionnaire/lieuStockage/{id}")
    public LieuStockage lieuStockage(@PathVariable Integer id){
        return this.lieuStockageDao.findById(id).orElse(null);
    }


}
