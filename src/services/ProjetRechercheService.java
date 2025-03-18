/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.ProjetRecherche;
import connexion.Connexion;
import dao.IDao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FATI
 */
public class ProjetRechercheService implements IDao<ProjetRecherche> {

    private Connexion connexion;
    private ProjetRechercheService ps;

    public ProjetRechercheService() {
        connexion = Connexion.getInstance();

    }

    @Override
    public boolean create(ProjetRecherche o) {
        String req = "insert into ProjetRecherche (idP, titre, axe, dateDebut, dateFin) values (null, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getTitre());
            ps.setString(2, o.getAxe());
            ps.setDate(3, new Date(o.getDateDebut().getTime()));
            ps.setDate(4, new Date(o.getDateFin().getTime()));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(ProjetRecherche o) {
        String req = "delete from ProjetRecherche where idP = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(ProjetRecherche o) {
        String req = "UPDATE ProjetRecherche SET titre = ?, axe = ?, dateDebut = ?, dateFin = ? WHERE idP = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getTitre());
            ps.setString(2, o.getAxe());
            ps.setDate(3, new Date(o.getDateDebut().getTime()));
            ps.setDate(4, new Date(o.getDateFin().getTime()));
            ps.setInt(5, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public ProjetRecherche findById(int id) {
        String req = "select * from ProjetRecherche where idP  = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ProjetRecherche(rs.getInt("idP"), rs.getString("titre"), rs.getString("axe"), rs.getDate("dateDebut"), rs.getDate("dateFin"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<ProjetRecherche> findAll() {
        List<ProjetRecherche> projets = new ArrayList<>();
        String req = "SELECT * FROM ProjetRecherche";
        try {
            Statement st = connexion.getCn().createStatement();
            ResultSet rs = st.executeQuery(req);
            while (rs.next()) {
                projets.add(new ProjetRecherche(
                        rs.getInt("idP"),
                        rs.getString("titre"),
                        rs.getString("axe"),
                        rs.getDate("dateDebut"),
                        rs.getDate("dateFin")
                ));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return projets;
    }

  public List<ProjetRecherche> findByAxe(String axe) {
    List<ProjetRecherche> result = new ArrayList<>();
    
    for (ProjetRecherche p : findAll()) {
        if (p.getAxe().equalsIgnoreCase(axe)) {
            result.add(p);
        }
    }
    return result;
}


    public ProjetRecherche findByTire(String titre) {
        String req = "select * from ProjetRecherche where titre  = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, titre);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new ProjetRecherche(rs.getInt("idP"), rs.getString("titre"), rs.getString("axe"), rs.getDate("dateDebut"), rs.getDate("dateFin"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}
