/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Enseignant;
import beans.ProjetRecherche;
import java.sql.Date;
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
        
//       ps.create(new ProjetRecherche("Projet A", "Informatique", Date.valueOf("2025-01-01"), Date.valueOf("2025-07-31")));
//       ps.create(new ProjetRecherche("Projet B", "Biologie", Date.valueOf("2025-02-01"), Date.valueOf("2025-08-31")));
//       ps.create(new ProjetRecherche("Projet C", "Chimie", Date.valueOf("2025-11-01"), Date.valueOf("2025-05-31")));

       
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

     for (Enseignant e : es.findAll()) {
       System.out.println(e.getNom());
     }
}
  
}
