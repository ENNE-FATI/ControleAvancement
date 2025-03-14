"# ControleAvancement" 
    

            Gestion des Projets de Recherche

Objectif:Ce projet est une application de gestion des projets de recherche. Il permet de gérer les projets, les enseignants et leurs affectations aux projets. L'application est développée en Java avec une base de données MySQL et Swing pour la partie des interfaces graphique.

-----------------------------------------------------------------
Structure de la Base de Données   
La base de données MySQL est composée des tables suivantes : 

Les tables :  

1. ProjetRecherche :  
   Contient les informations sur les projets de recherche.  

2. Enseignant :  
   Contient les informations sur les enseignants.  

3. AffectationProjet :  
   Contient les informations sur les affectations des enseignants aux projets. 
   
Relations entre les Tables :  

- Un projet (ProjetRecherche) peut avoir plusieurs enseignants assignés via la table AffectationProjet.  
- Un enseignant peut participer à plusieurs projets.  
- La table AffectationProjet sert de table de liaison pour gérer la relation many-to-many entre ProjetRecherche et Enseignant.  

Fonctionnalités :  

1. Créer un projet de recherche :  
   Permet d'ajouter un nouveau projet avec son titre, son axe de recherche, sa date de début et sa date de fin.  

2. Assigner des enseignants :  
   Permet d'assigner un ou plusieurs enseignants à un projet de recherche.  

3. Filtrer les projets par axe de recherche :  
   Permet de lister tous les projets appartenant à un axe de recherche spécifique.  

4. Rechercher un projet par titre :  
   Permet de rechercher un projet en fonction de son titre ou d'une partie de son titre. 
------------------------------------------------------------------------------------------------------

Schéma de la Base de Données:

CREATE TABLE ProjetRecherche (
    idP INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(255) NOT NULL,
    axe VARCHAR(255) NOT NULL,
    date_debut DATE NOT NULL,
    date_fin DATE NOT NULL
);

CREATE TABLE Enseignant (
    idE INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(100) NOT NULL,
    prenom VARCHAR(100) NOT NULL,
    email VARCHAR(255) NOT NULL UNIQUE
);


CREATE TABLE AffecteProjet (
    id_enseignant INT NOT NULL,
    id_projet INT NOT NULL,
    PRIMARY KEY (id_enseignant, id_projet),
    FOREIGN KEY (id_enseignant) REFERENCES Enseignant(idE) ON DELETE CASCADE,
    FOREIGN KEY (id_projet) REFERENCES ProjetRecherche(idP) ON DELETE CASCADE
);

