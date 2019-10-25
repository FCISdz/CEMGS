/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cemgs;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.event.PrintJobEvent;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author ZaHi
 */
public class MoveStock extends javax.swing.JFrame {

    Connection Conn = null;
    PreparedStatement Pst = null;
    ResultSet rs = null;
    String RefString = " ";

    public MoveStock() {
        initComponents();
        Conn = Connect.connect();
        TableFilMis();
    }
    
     public void TableFilMis() {//id,nom.reference,quntity,quntityEntry ,quntitySortie,Designation,source,destination, nbrBon,date
        String SqlTab = "Select id,nom,quntity,quntityEntry ,quntitySortie,source,destination,date from Stock";
        try {
            Pst = Conn.prepareStatement(SqlTab);
            rs = Pst.executeQuery();
            MoveTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.getMessage();
        }

        MoveTable.getColumnModel().getColumn(0).setMinWidth(20);
        MoveTable.getColumnModel().getColumn(0).setMaxWidth(40);
        MoveTable.getColumnModel().getColumn(0).setHeaderValue("Id");

        MoveTable.getColumnModel().getColumn(1).setMinWidth(100);
        MoveTable.getColumnModel().getColumn(1).setMaxWidth(100);
        MoveTable.getColumnModel().getColumn(1).setHeaderValue("Nom");
        
        MoveTable.getColumnModel().getColumn(2).setMinWidth(50);
        MoveTable.getColumnModel().getColumn(2).setMaxWidth(50);
        MoveTable.getColumnModel().getColumn(2).setHeaderValue("Qentité");

        MoveTable.getColumnModel().getColumn(3).setMinWidth(50);
        MoveTable.getColumnModel().getColumn(3).setMaxWidth(70);
        MoveTable.getColumnModel().getColumn(3).setHeaderValue("Qet Entreé");
        
        MoveTable.getColumnModel().getColumn(4).setMinWidth(50);
        MoveTable.getColumnModel().getColumn(4).setMaxWidth(65);
        MoveTable.getColumnModel().getColumn(4).setHeaderValue("Qet Sortie");

        MoveTable.getColumnModel().getColumn(5).setMinWidth(50);
        MoveTable.getColumnModel().getColumn(5).setMaxWidth(120);
        MoveTable.getColumnModel().getColumn(5).setHeaderValue("Fournisseur");
        
        MoveTable.getColumnModel().getColumn(6).setMinWidth(50);
        MoveTable.getColumnModel().getColumn(6).setMaxWidth(120);
        MoveTable.getColumnModel().getColumn(6).setHeaderValue("Distination");

        MoveTable.getColumnModel().getColumn(7).setMinWidth(50);
        MoveTable.getColumnModel().getColumn(7).setMaxWidth(78);
        MoveTable.getColumnModel().getColumn(7).setHeaderValue("Date");

    }
    
    public boolean updateQuntity(String A, int x, boolean ES) throws SQLException {
        boolean go = false;
        int quntity = 0;
        PreparedStatement stmt = null;
        String Sql = "SELECT quntity FROM Stock WHERE nom = '" + A + "'";
        try { 
            stmt = Conn.prepareStatement(Sql);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                 quntity = rs.getInt("quntity");
            }
            if (ES) {
                quntity = quntity + x;
            } else {
                if (x > quntity) {
                    JOptionPane.showMessageDialog(this,"la quantité restante est inférieure à la quantité sortie. quantité restante = "+quntity+"." );
                    go = false;
                }else{
                    quntity =  quntity - x;
                    go = true;
                }   
            }
            
            String query = "UPDATE Stock SET  quntity = '" + quntity + "'  WHERE nom = '" + A + "' ";
            stmt = Conn.prepareStatement(query);
            stmt.execute();
        } catch (SQLException ex) {
        } finally {
        if (stmt != null) { stmt.close(); }
        }
        return go;
    }

    public void updateStock(String A, String B, String C, String x) {
        try {
            String query = "UPDATE Stock "
                    + "     SET  "
                    + x
                    + ",nbrBon = '" + A + "',date = '" + B + "'"
                    + " WHERE nom = '" + C + "' ";
            Pst = Conn.prepareStatement(query);
            Pst.executeUpdate();
        } catch (Exception e) {
            
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        MoveStockNom = new javax.swing.JTextField();
        MoveStockComboES = new javax.swing.JComboBox<>();
        MoveStockES = new javax.swing.JTextField();
        MoveStockComboPD = new javax.swing.JComboBox<>();
        MoveStockPD = new javax.swing.JTextField();
        MoveStockNbrBon = new javax.swing.JTextField();
        MoveDB = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        MoveStockId = new javax.swing.JTextField();
        MoveStockDateCom = new com.toedter.calendar.JDateChooser();
        QentMove = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Prix = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        MoveTable = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        MoveExit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Stock Movement");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(1, 169, 213));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Nom :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Entree/Sortie :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Prov/Dist :");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("N° Bon :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Date :");

        MoveStockNom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoveStockNomActionPerformed(evt);
            }
        });

        MoveStockComboES.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Entree", "Sortie" }));

        MoveStockComboPD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Provenance", "Destination" }));
        MoveStockComboPD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoveStockComboPDActionPerformed(evt);
            }
        });

        MoveDB.setBackground(new java.awt.Color(56, 195, 164));
        MoveDB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MoveDB.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_move_by_trolley_filled_32px_1.png"))); // NOI18N
        MoveDB.setText("Move");
        MoveDB.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        MoveDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoveDBActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Id :");

        MoveStockId.setEditable(false);
        MoveStockId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoveStockIdActionPerformed(evt);
            }
        });

        MoveStockDateCom.setBackground(new java.awt.Color(1, 169, 213));

        QentMove.setEditable(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Qentite :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText("Prix :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(MoveStockNom, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(MoveStockId, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Prix)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(QentMove)
                        .addGap(17, 17, 17))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addComponent(jLabel5))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(MoveStockNbrBon)
                            .addComponent(MoveStockDateCom, javax.swing.GroupLayout.DEFAULT_SIZE, 217, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(MoveDB, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(MoveStockComboES, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(MoveStockComboPD, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(MoveStockPD, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(MoveStockES, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(0, 3, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(MoveStockId, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7)
                        .addComponent(jLabel9))
                    .addComponent(Prix, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(MoveStockNom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QentMove, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MoveStockComboES, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MoveStockES, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MoveStockComboPD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(MoveStockPD, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MoveStockNbrBon, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(MoveStockDateCom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addComponent(MoveDB, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 290, 300));

        jPanel2.setBackground(new java.awt.Color(1, 169, 213));

        MoveTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Nom", "Reference", "Qentite", "Entree", "Sortie", "N° Bon", "Designation"
            }
        ));
        MoveTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                MoveTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(MoveTable);
        if (MoveTable.getColumnModel().getColumnCount() > 0) {
            MoveTable.getColumnModel().getColumn(1).setMinWidth(63);
            MoveTable.getColumnModel().getColumn(1).setPreferredWidth(63);
            MoveTable.getColumnModel().getColumn(1).setMaxWidth(63);
            MoveTable.getColumnModel().getColumn(2).setMinWidth(63);
            MoveTable.getColumnModel().getColumn(2).setPreferredWidth(63);
            MoveTable.getColumnModel().getColumn(2).setMaxWidth(63);
            MoveTable.getColumnModel().getColumn(3).setMinWidth(74);
            MoveTable.getColumnModel().getColumn(3).setPreferredWidth(74);
            MoveTable.getColumnModel().getColumn(3).setMaxWidth(74);
            MoveTable.getColumnModel().getColumn(6).setMinWidth(70);
            MoveTable.getColumnModel().getColumn(6).setPreferredWidth(70);
            MoveTable.getColumnModel().getColumn(6).setMaxWidth(70);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 630, 400));

        jPanel3.setBackground(new java.awt.Color(207, 208, 206));

        MoveExit.setBackground(new java.awt.Color(197, 82, 82));
        MoveExit.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        MoveExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_shutdown_filled_32px.png"))); // NOI18N
        MoveExit.setText("Exit");
        MoveExit.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        MoveExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoveExitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(MoveExit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(MoveExit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 440, 90, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/Move.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void MoveExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveExitActionPerformed
        dispose();
    }//GEN-LAST:event_MoveExitActionPerformed

    private void MoveDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveDBActionPerformed
        String SQLs = " ";
        boolean EouS = true ,WorkinDb = true;
        String MoveStockNomvar = MoveStockNom.getText();
        String MoveStockESvar = MoveStockES.getText();
        int EntrySortei = Integer.parseInt(MoveStockESvar);
        String MoveStockPDvar = MoveStockPD.getText();
        int Prix = Integer.parseInt(this.Prix.getText());
        int PrixTotal = 0;
        String MoveStockComboESvar = (String) MoveStockComboES.getSelectedItem(), x = "";
        String MoveStockComboPDvar = (String) MoveStockComboPD.getSelectedItem();
        String MoveStockDatevar = ((JTextField) MoveStockDateCom.getDateEditor().getUiComponent()).getText();
        String EntSort = "",ES = "" , EsCH = "";
        // Sortie Or Entree
        if (MoveStockComboESvar.equals("Entree") && MoveStockComboPDvar.equals("Provenance")) {
            x = "quntityEntry = '" + MoveStockESvar + "' , source = '" + MoveStockPDvar + "',prixachet = '"+Prix+"', prixvent = '0'";
            String Entree = "Entree"; EntSort = ",prixachet  From Entree";ES = "Entree" ; EsCH = "prixachet";
            PrixTotal = Prix * EntrySortei;
            SQLs = "INSERT INTO "+Entree+" (Nom, Qentity, Forniseur, Date, prixachet ,prixtotal) values ( '"+MoveStockNomvar+"', '"+MoveStockESvar+"', '"+MoveStockPDvar+"', '"+MoveStockDatevar+"', '"+Prix+"','"+PrixTotal+"')";
            EouS = true;//prixvent
        } else {
            if (MoveStockComboESvar.equals("Sortie") && MoveStockComboPDvar.equals("Destination")) {
                x = "quntitySortie = '" + MoveStockESvar + "' , destination= '" + MoveStockPDvar + "' ,prixvent = '"+Prix+"' , prixachet = '0'";
                String Sortie = "Sortie";EntSort = ",prixvent  From Sortie"; ES = "Sortie"; EsCH = "prixvent";
                PrixTotal = Prix * EntrySortei;
                SQLs = "INSERT INTO "+Sortie+" (Nom, QetSortie, Distination, Date ,prixvent ,prixtotal) values ( '"+MoveStockNomvar+"', '"+MoveStockESvar+"', '"+MoveStockPDvar+"', '"+MoveStockDatevar+"', '"+Prix+"','"+PrixTotal+"')";
                EouS = false;
            }else{
                JOptionPane.showMessageDialog(this, "Si vous choisissez Entree vous devez choisir Provenance");
                WorkinDb = false;
            }
        }
        if (WorkinDb) {
            String MoveStockNbrBonvar = MoveStockNbrBon.getText();
            try {
                // Function update Quntity
                if (EouS) {
                    updateStock(MoveStockNbrBonvar, MoveStockDatevar, MoveStockNomvar, x);
                    updateQuntity(MoveStockNomvar, EntrySortei ,EouS);
                } else {
                    boolean work = updateQuntity(MoveStockNomvar, EntrySortei ,EouS);
                    if (work) {
                     // Fuction Update database
                        updateStock(MoveStockNbrBonvar, MoveStockDatevar, MoveStockNomvar, x);
                    }
                }
                
            } catch (Exception e) {
            } 
        }
        try {
            Pst = Conn.prepareStatement(SQLs);
            Pst.execute();
            Pst.close();
        } catch (SQLException ex) {
            Logger.getLogger(MoveStock.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        //Fin Sortie Or Entree
        MoveStockNom.setText("");
        MoveStockES.setText("");
        MoveStockPD.setText("");
        MoveStockNbrBon.setText("");
        TableFilMis();
    }//GEN-LAST:event_MoveDBActionPerformed
  
    
    private void MoveStockComboPDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveStockComboPDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MoveStockComboPDActionPerformed

    private void MoveTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MoveTableMouseClicked
        int Ligne = MoveTable.getSelectedRow();
        String id = MoveTable.getModel().getValueAt(Ligne, 0).toString();
        String Nom = MoveTable.getModel().getValueAt(Ligne, 1).toString();
        String Qent = MoveTable.getModel().getValueAt(Ligne, 2).toString();
        String QentEntree = MoveTable.getModel().getValueAt(Ligne, 3).toString();
        String QentSortie = MoveTable.getModel().getValueAt(Ligne, 4).toString();
        String Fournisseur = MoveTable.getModel().getValueAt(Ligne, 5).toString();
        String Destination = MoveTable.getModel().getValueAt(Ligne, 6).toString();
        String  Date = MoveTable.getModel().getValueAt(Ligne, 7).toString();
                
        MoveStockId.setText(id);
        MoveStockNom.setText(Nom);
        QentMove.setText(Qent);
    }//GEN-LAST:event_MoveTableMouseClicked

    private void MoveStockNomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveStockNomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MoveStockNomActionPerformed

    private void MoveStockIdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveStockIdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_MoveStockIdActionPerformed

    


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
            java.util.logging.Logger.getLogger(MoveStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MoveStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MoveStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MoveStock.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MoveStock().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton MoveDB;
    private javax.swing.JButton MoveExit;
    private javax.swing.JComboBox<String> MoveStockComboES;
    private javax.swing.JComboBox<String> MoveStockComboPD;
    private com.toedter.calendar.JDateChooser MoveStockDateCom;
    private javax.swing.JTextField MoveStockES;
    private javax.swing.JTextField MoveStockId;
    private javax.swing.JTextField MoveStockNbrBon;
    private javax.swing.JTextField MoveStockNom;
    private javax.swing.JTextField MoveStockPD;
    private javax.swing.JTable MoveTable;
    private javax.swing.JTextField Prix;
    private javax.swing.JTextField QentMove;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
