/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author FATI
 */
public class ProjetRecherche {
    private int id;
    private String titre;
    private String axe;
    private Date dateDebut;
    private Date dateFin;

    public ProjetRecherche(int id, String titre, String axe, Date dateDebut, Date dateFin) {
        this.id = id;
        this.titre = titre;
        this.axe = axe;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public ProjetRecherche(String titre, String axe, Date dateDebut, Date dateFin) {
        this.titre = titre;
        this.axe = axe;
        this.dateDebut = dateDebut;
        this.dateFin = dateFin;
    }

    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public String getAxe() {
        return axe;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setAxe(String axe) {
        this.axe = axe;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    @Override
    public String toString() {
        return titre ;
    }
   
}
