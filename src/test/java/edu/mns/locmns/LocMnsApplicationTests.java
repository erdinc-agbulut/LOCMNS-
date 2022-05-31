package edu.mns.locmns;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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

    @Test
    @WithMockUser(username = "donec@aol.ca", roles = {"UTILISATEUR"})
    void UtilisateurRecupereListeMarques_reponse200ok() throws Exception{
        mvc.perform(get("/liste-marques")).andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "donec@aol.ca", roles = {"UTILISATEUR"})
    void UtilisateurRecupereListeMateriel_reponse403forbidden() throws Exception{
        mvc.perform(get("/gestionnaire/liste-materiels")).andExpect(status().isForbidden());
    }

}
