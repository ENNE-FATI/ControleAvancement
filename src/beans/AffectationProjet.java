/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author FATI
 */
public class AffectationProjet {
   
    private int id;
    private ProjetRecherche projetId;
    private Enseignant enseignantId;

    // Getters et setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
     public ProjetRecherche getProjetId() {
        return projetId;
    }

    public Enseignant getEnseignantId() {
        return enseignantId;
    }

    public void setProjetId(ProjetRecherche projetId) {
        this.projetId = projetId;
    }

    public void setEnseignantId(Enseignant enseignantId) {
        this.enseignantId = enseignantId;
    }
  
}
