/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import beans.ProjetRecherche;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import services.ProjetRechercheService;

/**
 *
 * @author FATI
 */
public class ProjetByAxeForm extends javax.swing.JInternalFrame {

    private ProjetRechercheService prs;
    private DefaultTableModel model;

    /**
     * Creates new form ProjetByAxe
     */
   public ProjetByAxeForm() {
    initComponents();
    prs = new ProjetRechercheService();
    model = (DefaultTableModel) listProjetByAxe.getModel();
    loadAxeOptions();  // Remplissage des axes
    loadProjetRecherche();
}
private void loadAxeOptions() {
    listAxe.removeAllItems();
    

    List<String> axes = new ArrayList<>();
    for (ProjetRecherche projet : prs.findAll()) {
        if (!axes.contains(projet.getAxe())) {
            axes.add(projet.getAxe());
        }
    }

    for (String axe : axes) {
        listAxe.addItem(axe);
    }
}


    private void loadProjetRecherche() {
        model.setRowCount(0);
        for (ProjetRecherche p : prs.findAll()) {
            model.addRow(new Object[]{p.getId(), p.getTitre(), p.getDateDebut(), p.getDateFin()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        listAxe = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        listProjetByAxe = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("ProjetsByAxe"));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\go\\Documents\\NetBeansProjects\\ProjetsDeRecherche\\src\\Images\\icons8-gestion-de-projet-30.png")); // NOI18N
        jLabel1.setText("Axe:");

        listAxe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                listAxeActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 16)); // NOI18N
        jLabel2.setText("Filtrage des projets par axe de recherche:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(listAxe, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(listAxe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        listProjetByAxe.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "id", "Titre", "Date de début", "Date fin"
            }
        ));
        jScrollPane1.setViewportView(listProjetByAxe);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 530, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void listAxeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_listAxeActionPerformed
       // TODO add your handling code here:
        String selectedAxe = (String) listAxe.getSelectedItem();

    if (selectedAxe != null && !selectedAxe.equals("Choisir un axe")) {
        model.setRowCount(0); // Vider la table avant d'ajouter les nouveaux résultats

        List<ProjetRecherche> projets = prs.findByAxe(selectedAxe);

        if (projets.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Aucun projet trouvé pour cet axe !");
        } else {
            for (ProjetRecherche p : projets) {
                model.addRow(new Object[]{p.getId(), p.getTitre(), p.getDateDebut(), p.getDateFin()});
            }
        }
    } else {
        JOptionPane.showMessageDialog(this, "Veuillez choisir un axe !");
    }
    }//GEN-LAST:event_listAxeActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox listAxe;
    private javax.swing.JTable listProjetByAxe;
    // End of variables declaration//GEN-END:variables

}
