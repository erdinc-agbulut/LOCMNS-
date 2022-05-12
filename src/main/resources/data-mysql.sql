INSERT INTO personne (nom, prenom, mail, mot_de_passe)
VALUES
    ("Norman","John","lorem@icloud.com","CGU46PYY9KI"), -- Gestionnaires
    ("Hopper","Wylie","cursus.integer.mollis@protonmail.com","UZV81JBI8FJ"),
    ("Roy","Cameran","eros.nec@aol.edu","AZL72XCD4TD"),
    ("Vaughan","Elliott","donec@aol.ca","ZHH08RUD4LY"), -- Utilisateurs
    ("Levine","Blossom","aenean@outlook.ca","FEU83FRV6RN"),
    ("Crosby","Elijah","ipsum@icloud.org","QVB43WTB0QH"),
    ("Wong","Brenden","eu.tempor@outlook.org","GNP87BTE3TH"),
    ("Diaz","Mercedes","leo.vivamus@icloud.edu","YZT02JCD7KB"),
    ("Brock","Colt","sociis.natoque.penatibus@google.ca","SAX33YRX1OM"),
    ("Lowe","Naomi","magna.praesent.interdum@yahoo.ca","TVJ72HAS5BK"),
    ("Gregory","Leigh","turpis.egestas.aliquam@hotmail.com","WMR85SKE4KO"),
    ("Padilla","Bradley","nam.ac@hotmail.net","VSQ22GLQ8VP"),
    ("Terry","Omar","urna.nunc@aol.com","JCC86LXU2WI"),
    ("Terrell","John","risus.odio@icloud.edu","AYK82CSL7MK"),
    ("Brown","Ezra","interdum.enim@aol.org","PVH26NPG2GK"),
    ("Quinn","Camilla","penatibus@protonmail.ca","HRN84FMO5JX"),
    ("Bray","Curran","velit.quisque@icloud.net","SXL12PQH1XR"),
    ("Clayton","Valentine","non.hendrerit.id@yahoo.couk","EAA57JCQ1DE"),
    ("Beach","Amaya","at.sem.molestie@hotmail.net","VGX97VON5MM"),
    ("Porter","Victor","cras.convallis@icloud.edu","QYM49WMG7AE");

INSERT INTO lieu_stockage (nom_lieu_stockage)
VALUES
    ("MNS"),
    ("IFA");

INSERT INTO type_materiel (nom_type)
VALUES
    ("ordinateur portable"),
    ("projecteur"),
    ("Webcam"),
    ("casque VR");


INSERT INTO caracteristique (nom_caracteristique)
VALUES
    ("13 pouces"),
    ("8 GO RAM"),
    ("intel core i7"),
    ("Windows"),
    ("1TO"),
    ("intel core i5"),
    ("15 pouces"),
    ("intel core i5"),
    ("128 GO"),
    ("13 pouces"),
    ("256 GO"),
    ("intel core i5"),
    ("Windows"),
    ("16 GO RAM"),
    ("15 pouces"),
    ("15 pouces"),
    ("Windows"),
    ("Windows"),
    ("512 GO"),
    ("128 GO");

# INSERT INTO marque (nom_marque)
# VALUES
#     ("ACER"),
#     ("DELL"),
#     ("OCULUS"),
#     ("ASUS"),
#     ("LOGITECH"),
#     ("HP"),
#     ("LENOVO"),
#     ("BENQ"),
#     ("APPLE");

INSERT INTO marque (nom_marque)
VALUES
    ("ACER"),
    ("DELL"),
    ("OCULUS"),
    ("ASUS"),
    ("LOGITECH"),
    ("HP"),
    ("LENOVO"),
    ("BENQ"),
    ("APPLE");

INSERT INTO etat (statut)
VALUES
    ("operationnel"),
    ("hors d'usage");

INSERT INTO document (nom_doc)
VALUES
    ("notice d'utilisation Ordinateur"),
    ("fiches techniques Ordinateur"),
    ("fiches produits Ordinateur"),

    ("notice d'utilisation Casque VR"),
    ("fiches produits Casque VR"),
    ("fiches techniques Casque VR"),

    ("notice d'utilisation Vidéoprojecteurs"),
    ("fiches produits Vidéoprojecteurs"),
    ("fiches techniques Vidéoprojecteurs"),

    ("notice d'utilisation Webcam"),
    ("fiches techniques Webcam"),
    ("fiches produits Webacam");

INSERT INTO lieu_utilisation (nom_lieu_utilisation)
VALUES
    ("salon"),
    ("cours"),
    ("réunion"),
    ("location longue");

INSERT INTO cadre_utilisation(type_evenement)
VALUES
    ("Salon professionnel"),
    ("Réunion"),
    ("Journée portes ouvertes"),
    ("Cours"),
    ("Location longue");

INSERT INTO statut (role)
VALUES
    ("etudiant"),
    ("intervenant");



INSERT INTO utilisateur (id,numero_telephone,adresse, id_statut)
VALUES
    (4,"08 61 48 82 14","7786 Tincidunt Street",1), -- Etudiants
    (5,"07 78 98 57 37","561-2014 Arcu. Av.",1),
    (6,"07 25 44 14 62","Ap #443-1511 Natoque Road",1),
    (7,"04 62 78 38 64","P.O. Box 629, 8121 Fermentum Avenue",1),
    (8,"03 60 07 19 66","Ap #579-9965 Nullam St.",1),
    (9,"04 47 81 84 20","600-9942 Blandit Av.",1),
    (10,"03 25 18 88 63","Ap #114-8027 Nunc Ave",1),
    (11,"06 41 30 32 76","ornare.in@yahoo.ca",1),
    (12,"08 55 19 11 24","aliquam.auctor@aol.com",1),
    (13,"02 75 57 16 55","fermentum.arcu@outlook.edu",1),
    (14,"08 78 50 78 36","elit.pellentesque@icloud.couk",1),
    (15,"05 51 06 84 57","aliquam@icloud.org",1),
    (16,"07 27 85 58 77","ad.litora@hotmail.ca",1),
    (17,"03 55 91 38 64","velit@protonmail.net",2), -- Intervenants
    (18,"04 51 18 59 67","accumsan.laoreet.ipsum@yahoo.org",2),
    (19,"02 29 65 57 86","in@hotmail.net",2),
    (20,"03 32 73 96 91","aliquet@protonmail.ca",2);

INSERT INTO gestionnaire (id)
VALUES
    (1),
    (2),
    (3);

INSERT INTO modele (nom_Modele, id_marque, id_type )
VALUES
    ('SV900',1,3),
    ('BR500',6,4),
    ('VV500',5,1),
    ('PK750',3,2),
    ('FF770',4,3),
    ('BK600',6,4),
    ('CD800',1,1),
    ('AS650',5,2),
    ('Modele UX800',3,4);

INSERT INTO retard (id_personne_gestionnaire, id_personne_utilisateur)
VALUES
    (1,5),
    (2,9),
    (2,12),
    (3,12),
    (1,5);

INSERT INTO materiel (numero_serie, id_etat, id_modele, id_lieu_stockage)
VALUES
    ("VX950",1,1,2),
    ("CX800",1,2,1),
    ("VP800",2,9,2),
    ("XC60",1,3,2),
    ("VX550",2,4,2),
    ("XC90",1,7,1),
    ("VP410",1,8,2),
    ("510FF",2,5,1),
    ("85DE",1,6,2),
    ("77CR",1,7,2);

INSERT INTO emprunt (date_emprunt, date_retour ,date_validation, id_gestionnaire_entree, id_gestionnaire_retour, id_materiel, id_utilisateur) -- Emprunts retournés
VALUES
    ('2020-01-25','2023-01-28','2022-09-09',1, 1, 1, 5),
    ('2021-02-10','2022-04-05','2021-02-13', 2, 3, 5, 20),
    ('2021-09-30', '2022-03-15', '2022-04-02', 1, 2, 2, 9);
INSERT INTO emprunt(date_emprunt, date_validation, date_retour, id_gestionnaire_entree, id_materiel, id_utilisateur, date_prolongation, id_gestionnaire_prolongation) -- Emprunts prolongés
VALUES
    ('2021-02-23', '2021-02-23', '2022-06-07', 3, 4, 12, '2023-04-01', 1),
    ('2021-03-04', '2021-03-06', '2022-06-01', 2, 1, 19, '2022-12-25', 2);

INSERT INTO dysfonctionnement(date_dysfonctionnement, descriptif, id_materiel, id_utilisateur) -- Dysfonctionnements déclarés
VALUES
    ('2022-03-02', "Mon ordinateur ne s'allume plus", 1, 5),
    ('2022-03-02', "Ma webcam est floue", 2, 5),
    ('2022-04-25', "Le casque VR ne fonctionne plus", 4,12);
INSERT INTO dysfonctionnement(date_dysfonctionnement, descriptif, id_materiel, id_utilisateur, date_prise_en_charge, id_gestionnaire) -- Dysfonctionnements déclarés et pris en charge par un gestionnaire
VALUES
    ('2022-04-27', "Le projecteur n'affiche plus correctement le contenu", 3, 9, '2022-04-28', 1),
    ('2022-04-27', "Le bouton allumer de mon ordinateur ne répond plus", 4, 5, '2022-04-28', 3);

INSERT INTO info_reparation(date_prevue_reparation, chemin_document, id_materiel)
VALUES
    ('2008-08-11',"/documents/images",1),
    ("2023-03-06","/documents/images",5),
    ("2022-05-28","/documents/images",7),
    ("2023-02-04","/documents/images",4),
    ("2022-11-16","/documents/images",3),
    ("2022-08-10","/documents/images",9),
    ("2023-04-13","/documents/images",10),
    ("2022-02-10","/documents/images",6),
    ("2022-04-30","/documents/images",2),
    ("2023-02-10","/documents/images",8),
    ("2022-01-29","/documents/images",5);

INSERT INTO detailler (id_caracteristique, id_modele )
VALUES
    (15,2),
    (13,9),
    (8,1),
    (6,5),
    (10,7);

INSERT INTO fournit (id_materiel, id_document)
VALUES
    (1,2),
    (1,1),
    (2,3),
    (4,5),
    (6,5);

INSERT INTO affecter(id_lieu, id_emprunt)
VALUES
    (1,1),
    (4,2),
    (2,3),
    (3,4),
    (1,5);

INSERT INTO contient(id_cadre, id_emprunt)
VALUES
    (2,1),
    (1,2),
    (4,3),
    (3,4),
    (5,5);