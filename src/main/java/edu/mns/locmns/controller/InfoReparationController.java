package edu.mns.locmns.controller;

import edu.mns.locmns.dao.InfoReparationDao;
import edu.mns.locmns.model.InfoReparation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class InfoReparationController {

    private InfoReparationDao infoReparationDao;

    @Autowired
    public InfoReparationController(InfoReparationDao infoReparationDao) {

        this.infoReparationDao = infoReparationDao;
    }

    @GetMapping("/gestionnaire/liste-infoReparations")
    public List<InfoReparation> listeInfoReparations() {
        return this.infoReparationDao.findAll();
    }

}
