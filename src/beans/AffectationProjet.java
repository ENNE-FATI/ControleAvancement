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
   
    private ProjetRecherche projet;
    private Enseignant enseignant;

    public AffectationProjet(Enseignant enseignant,ProjetRecherche projet ) {
        this.projet = projet;
        this.enseignant = enseignant;
    }

    public ProjetRecherche getProjet() {
        return projet;
    }

    public Enseignant getEnseignant() {
        return enseignant;
    }

    public void setProjet(ProjetRecherche projet) {
        this.projet = projet;
    }

    public void setEnseignant(Enseignant enseignant) {
        this.enseignant = enseignant;
    }

}