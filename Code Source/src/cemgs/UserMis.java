/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cemgs;

import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ZaHi
 */
public class UserMis extends javax.swing.JFrame {

    Connection Conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    public UserMis() {
        initComponents();
        Conn = Connect.connect();
        TableFilMis();
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
        jLabel2 = new javax.swing.JLabel();
        UserMisID = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        UsrMisNom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        UsrMisRef = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        UsrMisDesig = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        UsrMisBon = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Prix = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        UsrMisTable = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stock Mis à Jour");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 169, 213));

        jLabel2.setText("ID :");

        UserMisID.setEditable(false);
        UserMisID.setText("0");

        jLabel3.setText("Nom :");

        jLabel4.setText("Reference :");

        jLabel5.setText("Designation :");

        jLabel6.setText("N° de Bon :");

        jButton1.setBackground(new java.awt.Color(56, 195, 164));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_synchronize_filled_32px_1.png"))); // NOI18N
        jButton1.setText("Mis à jour");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel7.setText("Le prix de l'unité :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel2)))
                    .addGap(29, 29, 29)
                    .addComponent(UserMisID, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel6)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(UsrMisBon, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(2, 2, 2))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(Prix, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(UsrMisNom, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(UsrMisDesig)
                            .addComponent(UsrMisRef))
                        .addGap(12, 12, 12)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(UserMisID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsrMisNom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(UsrMisRef, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(UsrMisDesig, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UsrMisBon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Prix, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 110, 270, 290));

        UsrMisTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        UsrMisTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                UsrMisTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(UsrMisTable);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 610, 380));

        jButton2.setBackground(new java.awt.Color(210, 13, 20));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_shutdown_filled_32px.png"))); // NOI18N
        jButton2.setText("Exit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/Misajour.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UsrMisTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_UsrMisTableMouseClicked
        int Ligne = UsrMisTable.getSelectedRow();
        String id = UsrMisTable.getModel().getValueAt(Ligne, 0).toString();
        String nom = UsrMisTable.getModel().getValueAt(Ligne, 1).toString();
        String reference = UsrMisTable.getModel().getValueAt(Ligne, 3).toString();
        String Designation = UsrMisTable.getModel().getValueAt(Ligne, 4).toString();
        String nbrBon = UsrMisTable.getModel().getValueAt(Ligne, 5).toString();
        
        UserMisID.setText(id);
        UsrMisNom.setText(nom);
        UsrMisRef.setText(reference);
        UsrMisBon.setText(nbrBon);
        UsrMisDesig.setText(Designation);
    }//GEN-LAST:event_UsrMisTableMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int idM = Integer.parseInt(UserMisID.getText());
        
       if (UsrMisNom.getText().equals("") || UsrMisRef.getText().equals("") || UsrMisDesig.getText().equals("") || UsrMisBon.getText().equals("")) {
            JOptionPane.showMessageDialog(this, "le nom et référence , Designation, N° de Bon est une obligation que vous devez remplir");
        } else {
            try {
                String query = "UPDATE Stock "
                        + " SET  nom = '" + UsrMisNom.getText() + "' "
                        + ",reference = '" + UsrMisRef.getText() + "',nbrBon = '" + UsrMisBon.getText() + "'"
                        + ",Designation = '" + UsrMisDesig.getText() + "'"
                        + ",prix = '" + Prix.getText() + "' "
                        + " WHERE id = '" + idM + "' ";
                pst = Conn.prepareStatement(query);
                pst.executeUpdate();
                
                Setreference(UsrMisRef.getText() ,UsrMisDesig.getText(),idM);
                UserMisID.setText("0");
                UsrMisNom.setText("");
                UsrMisRef.setText("");
                UsrMisDesig.setText("");
                UsrMisBon.setText("");
                Prix.setText("");
            } catch (Exception e) {

            }
            TableFilMis();
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

     public void Setreference(String Aref, String DesigStockDBVar, int id) {

        try {
            String sql = "SELECT nom ,reference FROM Designation";
            pst = Conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                String Ref = rs.getString("reference");
                if (rs.getString("nom").equals(DesigStockDBVar)) {
                    String query = "UPDATE Stock  SET  reference = '" + Ref + "." + Aref + "' WHERE Designation = '" + DesigStockDBVar + "'and id = '" + id + "'";
                    pst = Conn.prepareStatement(query);
                    pst.executeUpdate();
                }
            }
        } catch (Exception e) {
        }
        try {

        } catch (Exception e) {

        }
    }  
    public void TableFilMis(){
        String SqlTab = "Select id,nom,quntity,reference,Designation, nbrBon,date from Stock";
        try{
            pst = Conn.prepareStatement(SqlTab);
            rs = pst.executeQuery();
            UsrMisTable.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException e){
            e.getMessage();
        }
        
        UsrMisTable.getColumnModel().getColumn(0).setMinWidth(40);
        UsrMisTable.getColumnModel().getColumn(0).setMaxWidth(40);
        UsrMisTable.getColumnModel().getColumn(0).setHeaderValue("Id");
        
        UsrMisTable.getColumnModel().getColumn(1).setMinWidth(120);
        UsrMisTable.getColumnModel().getColumn(1).setMaxWidth(140);
        UsrMisTable.getColumnModel().getColumn(1).setHeaderValue("Nom");
        
        UsrMisTable.getColumnModel().getColumn(2).setMinWidth(50);
        UsrMisTable.getColumnModel().getColumn(2).setMaxWidth(70);
        UsrMisTable.getColumnModel().getColumn(2).setHeaderValue("Qentiteé");
        
        UsrMisTable.getColumnModel().getColumn(3).setMinWidth(50);
        UsrMisTable.getColumnModel().getColumn(3).setMaxWidth(70);
        UsrMisTable.getColumnModel().getColumn(3).setHeaderValue("Référence");
        
        UsrMisTable.getColumnModel().getColumn(4).setMinWidth(100);
        UsrMisTable.getColumnModel().getColumn(4).setMaxWidth(120);
        UsrMisTable.getColumnModel().getColumn(4).setHeaderValue("Designation");
        
        UsrMisTable.getColumnModel().getColumn(5).setMinWidth(65);
        UsrMisTable.getColumnModel().getColumn(5).setMaxWidth(80);
        UsrMisTable.getColumnModel().getColumn(5).setHeaderValue("N° de Bon");
        
        UsrMisTable.getColumnModel().getColumn(6).setMinWidth(65);
        UsrMisTable.getColumnModel().getColumn(6).setMaxWidth(85);
        UsrMisTable.getColumnModel().getColumn(6).setHeaderValue("Date");
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(UserMis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserMis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserMis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserMis.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserMis().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Prix;
    private javax.swing.JTextField UserMisID;
    private javax.swing.JTextField UsrMisBon;
    private javax.swing.JTextField UsrMisDesig;
    private javax.swing.JTextField UsrMisNom;
    private javax.swing.JTextField UsrMisRef;
    private javax.swing.JTable UsrMisTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}