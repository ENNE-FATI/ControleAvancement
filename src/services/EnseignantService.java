/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import beans.Enseignant;
import connexion.Connexion;
import dao.IDao;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author FATI
 */
public class EnseignantService implements IDao<Enseignant>{
 


    private Connexion connexion;
    private EnseignantService es;
    

    public EnseignantService() {
        connexion = Connexion.getInstance();
        
    }
    
    @Override
    public boolean create(Enseignant o) {
        String req = "insert into Enseignant (idE, nom, prenom, email) values (null, ?, ?, ?)"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Enseignant o) {
        String req = "delete from Enseignant where idE = ?"; 
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
    public boolean update(Enseignant o) {
        String req = "update Enseignant set nom = ?, prenom = ?, email = ? where idE  = ?"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getNom());
            ps.setString(2, o.getPrenom());
            ps.setString(3, o.getEmail().toString());
            ps.setInt(4, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Enseignant findById(int id) {
        String req = "select * from Enseignant where idE  = ?"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next())
                return new Enseignant(rs.getInt("idE"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email"));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Enseignant> findAll() {
        List<Enseignant>  enseignants = new ArrayList<>();
        String req = "select * from Enseignant"; 
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next())
                enseignants.add(new Enseignant(rs.getInt("idE"), rs.getString("nom"), rs.getString("prenom"), rs.getString("email")));
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return enseignants;
    }
    
}


