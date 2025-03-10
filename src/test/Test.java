/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.AffectationProjet;
import beans.Enseignant;
import beans.ProjetRecherche;
import java.sql.Date;
import java.util.List;
import services.AffectationProjetService;
import services.EnseignantService;
import services.ProjetRechercheService;

/**
 *
 * @author FATI
 */
public class Test {
    public static void main(String[] args) {
        ProjetRechercheService ps = new ProjetRechercheService();
        EnseignantService es = new EnseignantService();
        AffectationProjetService aps = new AffectationProjetService();
        
//       ps.create(new ProjetRecherche("Projet A", "Informatique", Date.valueOf("2025-01-01"), Date.valueOf("2025-07-31")));
//       ps.create(new ProjetRecherche("Projet B", "Biologie", Date.valueOf("2025-02-01"), Date.valueOf("2025-08-31")));
        //     ps.create(new ProjetRecherche("Projet C", "Chimie", Date.valueOf("2025-11-01"), Date.valueOf("2025-05-31")));
  //    ps.create(new ProjetRecherche("Projet D", "MATH", Date.valueOf("2024-11-01"), Date.valueOf("2025-05-31")));
       
//      ProjetRecherche p  = ps.findById(3);
//         p.setAxe("Physique");
//          ps.update(p);
        //ps.delete(ps.findById(2));
        
//        for(ProjetRecherche p : ps.findAll())
//              System.out.println(p.getTitre());
        
//        es.create(new Enseignant("SOPHIE", "Amal", "sophie.amal@example.com"));
//        es.create(new Enseignant("EN-NESYRY", "Fatima Zahra", "ennesyry@example.com"));
//        es.create(new Enseignant("ELAMI", "Fatima", "elami@example.com"));


//        Enseignant e = es.findById(3);
//          e.setNom("SAMI");
//          es.update(e);

        //  es.delete(es.findById(2));

//     for (Enseignant e : es.findAll()) {
//       System.out.println(e.getNom());
//     }
        
//       Fonctionnalité d'assigner les projets à chaque Enseignant:
//       aps.create(new AffectationProjet(es.findById(3), ps.findById(1)));
//       aps.create(new AffectationProjet(es.findById(1), ps.findById(3)));
//       aps.create(new AffectationProjet(es.findById(1), ps.findById(5)));
     
    
//   List<AffectationProjet> affectations = aps.findAll();
//       for (AffectationProjet ap : affectations) {
//         System.out.println("Le projet : " + ap.getProjet().getTitre() 
//                   + " est affecté à " + ap.getEnseignant().getNom());
//      }
//
//       AffectationProjet affectationsupprimé = aps.findAll().get(1);
//        aps.delete(affectationsupprimé);
//      System.out.println("Affectation supprimée : " + affectationsupprimé.getEnseignant().getNom() + "/" + affectationsupprimé.getProjet().getTitre()+ " d'axe:"+affectationsupprimé.getProjet().getAxe());

    
        for (AffectationProjet ap : aps.findAll()) {
            System.out.println("Affectation : " + ap.getEnseignant().getNom() + " qui prent le projet " + ap.getProjet().getTitre());
        }
}
  
}
