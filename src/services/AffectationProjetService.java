/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.AffectationProjet;
import beans.Enseignant;
import beans.ProjetRecherche;
import connexion.Connexion;
import dao.IDao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FATI
 */
public class AffectationProjetService implements IDao<AffectationProjet> {

    private Connexion connexion;
    private EnseignantService es;
    private ProjetRechercheService prs;

 
     public AffectationProjetService() {
        connexion = Connexion.getInstance();
        es = new EnseignantService () ;
        prs = new ProjetRechercheService();
    }

    @Override
    public boolean create(AffectationProjet o) {
        String req = "INSERT INTO AffectationProjet (id_enseignant, id_projet) VALUES (?, ?)";
    try {
        PreparedStatement ps = connexion.getCn().prepareStatement(req);
        ps.setInt(1, o.getEnseignant().getId()); 
        ps.setInt(2, o.getProjet().getId()); 
        ps.executeUpdate();
        return true;
    } catch (SQLException e) {
        System.out.println("Erreur SQL : " + e.getMessage());
    }
    return false;}

    @Override
    public boolean delete(AffectationProjet o) {
        String req = "delete from AffectationProjet WHERE id_enseignant = ? and id_projet=?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1,o.getEnseignant().getId());  
            ps.setInt(2, o.getProjet().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    @Override
    public boolean update(AffectationProjet o) {
      return false; // Impossible d'utiliser update() directement car la clé primaire est composite et 
      //cette classe d'association ne contient aucun autre attribut modifiable
    }

   
    @Override
    public AffectationProjet findById(int id) {
        return null; 
    }

    @Override
    public List<AffectationProjet> findAll() {
        List<AffectationProjet> affectations = new ArrayList<>();
        String req = "select * from AffectationProjet";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ProjetRecherche projet = prs.findById(rs.getInt("id_projet"));
                Enseignant enseignant = es.findById(rs.getInt("id_enseignant"));

            affectations.add(new AffectationProjet(enseignant,projet ));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return affectations;
    }
    
}

