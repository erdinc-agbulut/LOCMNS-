package edu.mns.locmns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;  // permet d'importer toutes les méthodes static d'une classe
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LocMnsApplicationTests {

    @Autowired
    private WebApplicationContext context;

    private MockMvc mvc;

    @BeforeEach         // permet de réinitialisé l'objet mvc avant chaque @Test
    private void initialisation() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

//---------------------------------------- Test sur la page ETUDIANT --------------------------------------------------
    @Test
    @WithMockUser(username = "donec@aol.ca", roles = {"UTILISATEUR"})
    void UtilisateurRecupereListeMateriel_reponse403forbidden() throws Exception{
        mvc.perform(get("/gestionnaire/liste-materiels")).andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "donec@aol.ca", roles = {"UTILISATEUR"})
    void UtilisateurRecupereListeTypeMateriels_reponse200ok() throws Exception{
        mvc.perform(get("/liste-typeMateriels"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nomType").value("ordinateur portable"))
                .andExpect(jsonPath("$[1].nomType").value("projecteur"))
                .andExpect(jsonPath("$[2].nomType").value("Webcam"))
                .andExpect(jsonPath("$[3].nomType").value("casque VR"));
    }

    @Test //Test que l'utilisateur puisse envoyer un dysfonctionnement
    @WithMockUser(username = "donec@aol.ca", roles = {"UTILISATEUR"})
    void UtilisateurSaisirDysfonctionnement_reponse200ok() throws Exception{
        mvc.perform(post("/saisir-dysfonctionnement")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"descriptif\": \"mon ordi est cassé\", \"dateDysfonctionnement\": \"2022-06-14\", \"utilisateur\": {\"id\": 5}, \"materiel\": {\"idMateriel\": 5} }")
        ).andExpect(status().isOk());
    }



 //---------------------------------------- Test sur la page GESTIONNAIRE ----------------------------------------------


    //Test que l'on récupère bien la listes des roles du Statut
    @Test
    @WithMockUser(username = "lorem@icloud.com", roles = {"GESTIONNAIRE"})
    void GestonnaireRecupereListeStatut_reponse200ok() throws Exception{
        mvc.perform(get("/liste-statut"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].role").value("etudiant"))
                .andExpect(jsonPath("$[1].role").value("intervenant"));
    }

    //Test que l'on récupère bien la liste des lieux de stockage
    @Test
    @WithMockUser(username = "lorem@icloud.com", roles = {"GESTIONNAIRE"})
    void GestonnaireRecupereListeLieuxStockage_reponse200ok() throws Exception{
        mvc.perform(get("/gestionnaire/liste-lieuxStockage"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].nomLieuStockage").value("MNS"))
                .andExpect(jsonPath("$[1].nomLieuStockage").value("IFA"));
    }

    // Test que le gestionnaire cree un compte utilisateur
    // Il faut créer un compte auparavant ( ne pas utiliser utilisateur déjà present en BDD )
    @Test
    @WithMockUser(username = "lorem@icloud.com", roles = {"GESTIONNAIRE"})
    void GestionnaireCreeCompte_reponse200ok() throws Exception{
        mvc.perform(post("/donnees-CreationCompte")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"nom\": \"AGBULUT\", \"prenom\": \"Erdinc\", \"motDePasse\": \"$2a$10$NLdeNpChEhDulRjwXwSoV.rQY/3ikKBPqngGOa8RPYcWYYB5TB3RK\", \"mail\": \"erdinc@erdinc.com\", \"adresse\": \"103 Rue De Verdun\", \"numeroTelephone\": \"0629540449\", \"statut\": {\"id\": 1}  }")
        ).andExpect(status().isOk());
    }

}
