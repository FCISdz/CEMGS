package cemgs;

import java.util.Date;
import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

public class Home extends javax.swing.JFrame {

    Connection Conn = null;
    PreparedStatement Pst = null;
    ResultSet rs = null;
    String RefString = " ";
    Date dNow = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("dd.MMMyyyy");
    SimpleDateFormat Pdfdate = new SimpleDateFormat("dd.MMMyyyy");

    public Home() {
        initComponents();
        DateText.setText(ft.format(dNow));
        Conn = Connect.connect();
        SetDesigComboFromDb();
        TableFilHome();
    }

    public void TableFilHome() {
        String SqlTab = "Select id,nom,quntity,reference,Designation,source, nbrBon,date from Stock";
        try {
            Pst = Conn.prepareStatement(SqlTab);
            rs = Pst.executeQuery();
            HomeTable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException e) {
            e.getMessage();
        }

        HomeTable.getColumnModel().getColumn(0).setMinWidth(20);
        HomeTable.getColumnModel().getColumn(0).setMaxWidth(40);
        HomeTable.getColumnModel().getColumn(0).setHeaderValue("Id");

        HomeTable.getColumnModel().getColumn(1).setMinWidth(120);
        HomeTable.getColumnModel().getColumn(1).setMaxWidth(140);
        HomeTable.getColumnModel().getColumn(1).setHeaderValue("Nom");

        HomeTable.getColumnModel().getColumn(2).setMinWidth(50);
        HomeTable.getColumnModel().getColumn(2).setMaxWidth(70);
        HomeTable.getColumnModel().getColumn(2).setHeaderValue("Qentiteé");

        HomeTable.getColumnModel().getColumn(3).setMinWidth(50);
        HomeTable.getColumnModel().getColumn(3).setMaxWidth(70);
        HomeTable.getColumnModel().getColumn(3).setHeaderValue("Référence");

        HomeTable.getColumnModel().getColumn(4).setMinWidth(100);
        HomeTable.getColumnModel().getColumn(4).setMaxWidth(120);
        HomeTable.getColumnModel().getColumn(4).setHeaderValue("Designation");

        HomeTable.getColumnModel().getColumn(5).setMinWidth(120);
        HomeTable.getColumnModel().getColumn(5).setMaxWidth(150);
        HomeTable.getColumnModel().getColumn(5).setHeaderValue("Source");

        HomeTable.getColumnModel().getColumn(6).setMinWidth(65);
        HomeTable.getColumnModel().getColumn(6).setMaxWidth(80);
        HomeTable.getColumnModel().getColumn(6).setHeaderValue("N° de Bon");

        HomeTable.getColumnModel().getColumn(7).setMinWidth(65);
        HomeTable.getColumnModel().getColumn(7).setMaxWidth(85);
        HomeTable.getColumnModel().getColumn(7).setHeaderValue("Date");

    }

    public void SetDesigComboFromDb() {

        try {
            String sql = "SELECT nom ,reference FROM Designation";
            Pst = Conn.prepareStatement(sql);
            rs = Pst.executeQuery();
            while (rs.next()) {
                String Ref = rs.getString("reference");
                String Item = rs.getString("nom");
                DesigStockDB.addItem(Item);
                SearchByDesigCom.addItem(Item);

                //String query = "UPDATE Stock  SET  reference = '" + Ref + "' WHERE Designation = '" + Item + "' ";
                //Pst = Conn.prepareStatement(query);
                //Pst.executeUpdate();
            }
            DesigStock.setText((String) DesigStockDB.getSelectedItem());
            Pst.close();
            rs.close();
        } catch (Exception e) {
        }
        try {

        } catch (Exception e) {

        }
    }

    public void TableFilHomeSearch(String nom, String Ref) {
        String SqlTab = "Select id,nom,quntity,reference,Designation,source, nbrBon,date from Stock "
                + "WHERE nom ='" + nom + "', reference ='" + Ref + "'";
        try {
            Pst = Conn.prepareStatement(SqlTab);
            rs = Pst.executeQuery();
            HomeTable.setModel(DbUtils.resultSetToTableModel(rs));
            Pst.close();
            rs.close();
        } catch (SQLException e) {
            e.getMessage();
        }

        HomeTable.getColumnModel().getColumn(0).setMinWidth(20);
        HomeTable.getColumnModel().getColumn(0).setMaxWidth(40);
        HomeTable.getColumnModel().getColumn(0).setHeaderValue("Id");

        HomeTable.getColumnModel().getColumn(1).setMinWidth(120);
        HomeTable.getColumnModel().getColumn(1).setMaxWidth(140);
        HomeTable.getColumnModel().getColumn(1).setHeaderValue("Nom");

        HomeTable.getColumnModel().getColumn(2).setMinWidth(50);
        HomeTable.getColumnModel().getColumn(2).setMaxWidth(70);
        HomeTable.getColumnModel().getColumn(2).setHeaderValue("Qentiteé");

        HomeTable.getColumnModel().getColumn(3).setMinWidth(50);
        HomeTable.getColumnModel().getColumn(3).setMaxWidth(70);
        HomeTable.getColumnModel().getColumn(3).setHeaderValue("Référence");

        HomeTable.getColumnModel().getColumn(4).setMinWidth(100);
        HomeTable.getColumnModel().getColumn(4).setMaxWidth(120);
        HomeTable.getColumnModel().getColumn(4).setHeaderValue("Designation");

        HomeTable.getColumnModel().getColumn(5).setMinWidth(120);
        HomeTable.getColumnModel().getColumn(5).setMaxWidth(150);
        HomeTable.getColumnModel().getColumn(5).setHeaderValue("Source");

        HomeTable.getColumnModel().getColumn(6).setMinWidth(65);
        HomeTable.getColumnModel().getColumn(6).setMaxWidth(80);
        HomeTable.getColumnModel().getColumn(6).setHeaderValue("N° de Bon");

        HomeTable.getColumnModel().getColumn(7).setMinWidth(65);
        HomeTable.getColumnModel().getColumn(7).setMaxWidth(85);
        HomeTable.getColumnModel().getColumn(7).setHeaderValue("Date");

    }

    public String Setreference(String Aref, String DesigStockDBVar, int id) {
        String Ref = "";
        try {

            String sql = "SELECT nom,reference FROM Designation";
            Pst = Conn.prepareStatement(sql);
            rs = Pst.executeQuery();
            while (rs.next()) {
                Ref = rs.getString("reference");
                String Nom = rs.getString("nom");
                if (Nom.equals(DesigStockDBVar)) {
                    RefStock.setText(Ref);
                }
            }
            Pst.close();
            rs.close();
        } catch (Exception e) {
        }
        return Ref;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        AddDesig = new javax.swing.JButton();
        DesigID = new javax.swing.JTextField();
        DesigNom = new javax.swing.JTextField();
        DesigRef = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        DesigZone = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        IdStock = new javax.swing.JTextField();
        NameStock = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        DesigStock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        RefStock = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        NbrBonStock = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        SourceStock = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        DateStock = new com.toedter.calendar.JDateChooser();
        AddStock = new javax.swing.JButton();
        DesigStockDB = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        QentityStock = new javax.swing.JTextField();
        SetRef = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        Prix = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        MoveStock = new javax.swing.JButton();
        MisajourInter = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HomeTable = new javax.swing.JTable();
        TabeActule = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        DateText = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        SearchByNom = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        SearchByDesigCom = new javax.swing.JComboBox<>();
        Search = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Exit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Home");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(7, 148, 186));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel2.setText("Id :");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel3.setText("Nom :");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel4.setText("Reference :");

        AddDesig.setBackground(new java.awt.Color(56, 195, 164));
        AddDesig.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_plus_filled_32.png"))); // NOI18N
        AddDesig.setText("Ajouter");
        AddDesig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddDesigActionPerformed(evt);
            }
        });

        DesigID.setEditable(false);
        DesigID.setText("0");

        DesigNom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DesigNomKeyPressed(evt);
            }
        });

        DesigRef.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DesigRefKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel5.setText("Zone :");

        DesigZone.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                DesigZoneKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(AddDesig)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(DesigID, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(DesigZone, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DesigNom)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DesigRef, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(DesigID, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(DesigZone, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(DesigNom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DesigRef, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(AddDesig, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 410, 180));

        jPanel2.setBackground(new java.awt.Color(7, 148, 186));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel6.setText("ID :");

        IdStock.setEditable(false);
        IdStock.setText("0");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel7.setText("Nom :");

        DesigStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesigStockActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel8.setText("Designation :");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel11.setText("Reference :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel9.setText("N° De Bon :");

        NbrBonStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NbrBonStockActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel10.setText("Source :");

        SourceStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SourceStockActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel12.setText("Date :");

        DateStock.setBackground(new java.awt.Color(7, 148, 186));

        AddStock.setBackground(new java.awt.Color(56, 195, 164));
        AddStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_plus_filled_32.png"))); // NOI18N
        AddStock.setText("Ajouter");
        AddStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddStockActionPerformed(evt);
            }
        });

        DesigStockDB.setMaximumRowCount(100);
        DesigStockDB.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                DesigStockDBItemStateChanged(evt);
            }
        });
        DesigStockDB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DesigStockDBActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel15.setText("Qenteté :");

        QentityStock.setText("0");

        SetRef.setBackground(new java.awt.Color(7, 148, 186));
        SetRef.setText("Desig Reference");
        SetRef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SetRefActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jLabel17.setText("Prix :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel15)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(QentityStock, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(DateStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IdStock, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(NameStock))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(NbrBonStock))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(DesigStock, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(DesigStockDB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(RefStock, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SetRef, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AddStock))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(SourceStock)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Prix, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(37, 37, 37))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel7)
                        .addComponent(NameStock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(IdStock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DesigStock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DesigStockDB, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(15, 15, 15))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RefStock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SetRef, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(NbrBonStock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SourceStock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel17)
                    .addComponent(Prix, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(QentityStock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12)
                        .addComponent(jLabel15))
                    .addComponent(DateStock, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(AddStock, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 430, 300));

        jPanel3.setBackground(new java.awt.Color(40, 169, 203));

        MoveStock.setBackground(new java.awt.Color(56, 195, 164));
        MoveStock.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_move_by_trolley_filled_32px_1.png"))); // NOI18N
        MoveStock.setText("Movement");
        MoveStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MoveStockActionPerformed(evt);
            }
        });

        MisajourInter.setBackground(new java.awt.Color(56, 195, 164));
        MisajourInter.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_synchronize_filled_32px_1.png"))); // NOI18N
        MisajourInter.setText("Mis à jour");
        MisajourInter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MisajourInterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(MisajourInter, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(MoveStock, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MoveStock)
                    .addComponent(MisajourInter))
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 570, 470, 80));

        jPanel4.setBackground(new java.awt.Color(40, 169, 203));

        HomeTable.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Stock", "Reference", "Qet Entree ", "Qet Sortie", "N° de Bon", "Designation", "Date", "Source"
            }
        ));
        HomeTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                HomeTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(HomeTable);
        if (HomeTable.getColumnModel().getColumnCount() > 0) {
            HomeTable.getColumnModel().getColumn(0).setMinWidth(140);
            HomeTable.getColumnModel().getColumn(0).setPreferredWidth(140);
            HomeTable.getColumnModel().getColumn(0).setMaxWidth(140);
            HomeTable.getColumnModel().getColumn(1).setMinWidth(63);
            HomeTable.getColumnModel().getColumn(1).setPreferredWidth(63);
            HomeTable.getColumnModel().getColumn(1).setMaxWidth(63);
            HomeTable.getColumnModel().getColumn(2).setMinWidth(85);
            HomeTable.getColumnModel().getColumn(2).setPreferredWidth(85);
            HomeTable.getColumnModel().getColumn(2).setMaxWidth(85);
            HomeTable.getColumnModel().getColumn(3).setMinWidth(85);
            HomeTable.getColumnModel().getColumn(3).setPreferredWidth(85);
            HomeTable.getColumnModel().getColumn(3).setMaxWidth(85);
            HomeTable.getColumnModel().getColumn(4).setMinWidth(63);
            HomeTable.getColumnModel().getColumn(4).setPreferredWidth(63);
            HomeTable.getColumnModel().getColumn(4).setMaxWidth(63);
            HomeTable.getColumnModel().getColumn(6).setMinWidth(80);
            HomeTable.getColumnModel().getColumn(6).setPreferredWidth(80);
            HomeTable.getColumnModel().getColumn(6).setMaxWidth(80);
        }

        TabeActule.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_synchronize_filled_32px_1.png"))); // NOI18N
        TabeActule.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabeActuleMouseClicked(evt);
            }
        });

        jLabel16.setText("Date :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DateText, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(501, 501, 501)
                        .addComponent(TabeActule))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 752, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                        .addComponent(TabeActule)
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(DateText, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 80, 780, 360));

        jPanel5.setBackground(new java.awt.Color(40, 169, 203));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Nom :");

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Designation :");

        SearchByDesigCom.setMaximumRowCount(100);
        SearchByDesigCom.setToolTipText("");
        SearchByDesigCom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchByDesigComActionPerformed(evt);
            }
        });

        Search.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_search_filled_32px.png"))); // NOI18N
        Search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SearchMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchByNom, javax.swing.GroupLayout.DEFAULT_SIZE, 155, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SearchByDesigCom, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Search)
                .addGap(9, 9, 9))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel14))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SearchByNom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Search)
                            .addComponent(SearchByDesigCom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 460, 490, 50));

        jPanel6.setBackground(new java.awt.Color(185, 178, 167));

        Exit.setBackground(new java.awt.Color(197, 82, 82));
        Exit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_shutdown_filled_32px.png"))); // NOI18N
        Exit.setText("Exit ");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(56, 195, 164));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_deskew_image_automatically_filled_32px.png"))); // NOI18N
        jButton3.setText("Stock Rapport");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                    .addComponent(Exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Exit, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 570, 170, 100));

        jLabel1.setBackground(new java.awt.Color(7, 148, 186));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/Home.png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AddDesigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddDesigActionPerformed
        String DesigIDVar = DesigID.getText();
        String DesigNomVar = DesigNom.getText();
        String DesigRefVar = DesigRef.getText();
        String DesigZoneVar = DesigZone.getText();
        String sql = "INSERT INTO Designation (nom, reference, zone) values ('" + DesigNomVar + "','" + DesigRefVar + "','" + DesigZoneVar + "')";
        if (DesigNomVar.equals("") || DesigRefVar.equals("")) {
            JOptionPane.showMessageDialog(this, "le nom et la référence est une obligation que vous devez remplir");
        } else {
            try {
                Pst = Conn.prepareStatement(sql);
                Pst.execute();
                Pst.close();
            } catch (Exception e) {
            }
        }
        DesigStockDB.removeAllItems();
        SetDesigComboFromDb();
        DesigNom.setText("");
        DesigRef.setText("");
        DesigZone.setText("");
    }//GEN-LAST:event_AddDesigActionPerformed

    private void SourceStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SourceStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SourceStockActionPerformed

    private void AddStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddStockActionPerformed
        String IdStockVar = IdStock.getText();
        int id = Integer.parseInt(IdStock.getText());
        String NameStockVar = NameStock.getText();
        String RefStockVar = RefStock.getText();
        String DesigStockVar = DesigStock.getText();
        String DesigStockDBVar = (String) DesigStockDB.getSelectedItem();
        String NbrBonStockVar = NbrBonStock.getText();
        String SourceStockVar = SourceStock.getText();
        String QentityStockvar = QentityStock.getText();
        String DateStockVar = ((JTextField) DateStock.getDateEditor().getUiComponent()).getText();
        String ref = RefStockVar;
        int Qet = Integer.parseInt(QentityStockvar);
        int prix = Integer.parseInt(Prix.getText());

        String sql = "INSERT INTO Stock (nom, reference, Designation, nbrBon, date, source , quntity, quntityEntry,quntitySortie,destination,prixachet,prixvent) values ('" + NameStockVar + "','" + RefStockVar + "'"
                + ",'" + DesigStockVar + "','" + NbrBonStockVar + "','" + DateStockVar + "','" + SourceStockVar + "','" + Qet + "','" + Qet + "',' ',' ','" + prix + "',' ')";
        int PrixTotal = 0;
        PrixTotal = prix * Qet;
        if (NameStockVar.equals("") || RefStockVar.equals("") || DesigStockVar.equals("") || NbrBonStockVar.equals("") || SourceStockVar.equals("") || DateStockVar.equals("")) {
            JOptionPane.showMessageDialog(this, "le nom et référence , Designation, N° de Bon, date, source , quntity ,est une obligation que vous devez remplir");
        } else {
            try {

                Pst = Conn.prepareStatement(sql);
                Pst.execute();
                Pst.close();
                String sqlEntree = "INSERT INTO Entree (Nom, Qentity,Forniseur,Date,prixachet,prixtotal) values ('" + NameStockVar + "','" + QentityStockvar + "','" + SourceStockVar + "','" + DateStockVar + "','" + prix + "','" + PrixTotal + "')";
                Pst = Conn.prepareStatement(sqlEntree);
                Pst.execute();
                Pst.close();
            } catch (Exception e) {
            }
        }
        Setreference(RefStockVar, DesigStockDBVar, id);
        TableFilHome();

        IdStock.setText("0");
        QentityStock.setText("0");
        Prix.setText("0");
    }//GEN-LAST:event_AddStockActionPerformed

    private void MoveStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MoveStockActionPerformed
        CEMGS.StartMoveStock();
    }//GEN-LAST:event_MoveStockActionPerformed

    private void MisajourInterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MisajourInterActionPerformed
        UserMis UserMisStart = new UserMis();
        UserMisStart.setVisible(true);
    }//GEN-LAST:event_MisajourInterActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        dispose();
    }//GEN-LAST:event_ExitActionPerformed

    private void DesigStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesigStockActionPerformed

    }//GEN-LAST:event_DesigStockActionPerformed

    private void DesigStockDBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DesigStockDBActionPerformed

        DesigStock.setText((String) DesigStockDB.getSelectedItem());

        //Setreference(RefStock.getText(),Disg , Integer.parseInt(IdStock.getText()));
    }//GEN-LAST:event_DesigStockDBActionPerformed

    private void NbrBonStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NbrBonStockActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NbrBonStockActionPerformed

    private void DesigStockDBItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_DesigStockDBItemStateChanged

    }//GEN-LAST:event_DesigStockDBItemStateChanged

    private void SetRefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SetRefActionPerformed
        RefString = Setreference(RefStock.getText(), (String) DesigStockDB.getSelectedItem(), Integer.parseInt(IdStock.getText()));

    }//GEN-LAST:event_SetRefActionPerformed

    private void SearchByDesigComActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchByDesigComActionPerformed

    }//GEN-LAST:event_SearchByDesigComActionPerformed

    private void TabeActuleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabeActuleMouseClicked
        TableFilHome();
    }//GEN-LAST:event_TabeActuleMouseClicked

    private void SearchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SearchMouseClicked
        if (SearchByNom.getText().equals("") && ((String) SearchByDesigCom.getSelectedItem()).equals("")) {
            JOptionPane.showMessageDialog(this, "SVP entrer quelque chose en Nom ou Desigenation");
            TableFilHome();
        } else {
            String Name = SearchByNom.getText(), Desigenation = (String) SearchByDesigCom.getSelectedItem();
            String SqlTab = " ";
            if (SearchByNom.getText().equals("")) {
                SqlTab = "Select id,nom,quntity,reference,Designation,source, nbrBon,date from Stock WHERE Designation = '" + Desigenation + "'";
            } else {
                SqlTab = "Select id,nom,quntity,reference,Designation,source, nbrBon,date from Stock WHERE nom = '" + Name + "'";
            }
            try {
                Pst = Conn.prepareStatement(SqlTab);
                rs = Pst.executeQuery();
                HomeTable.setModel(DbUtils.resultSetToTableModel(rs));
            } catch (SQLException e) {
                e.getMessage();
            }

            HomeTable.getColumnModel().getColumn(0).setMinWidth(20);
            HomeTable.getColumnModel().getColumn(0).setMaxWidth(40);
            HomeTable.getColumnModel().getColumn(0).setHeaderValue("Id");

            HomeTable.getColumnModel().getColumn(1).setMinWidth(120);
            HomeTable.getColumnModel().getColumn(1).setMaxWidth(140);
            HomeTable.getColumnModel().getColumn(1).setHeaderValue("Nom");

            HomeTable.getColumnModel().getColumn(2).setMinWidth(50);
            HomeTable.getColumnModel().getColumn(2).setMaxWidth(70);
            HomeTable.getColumnModel().getColumn(2).setHeaderValue("Qentiteé");

            HomeTable.getColumnModel().getColumn(3).setMinWidth(50);
            HomeTable.getColumnModel().getColumn(3).setMaxWidth(70);
            HomeTable.getColumnModel().getColumn(3).setHeaderValue("Référence");

            HomeTable.getColumnModel().getColumn(4).setMinWidth(100);
            HomeTable.getColumnModel().getColumn(4).setMaxWidth(120);
            HomeTable.getColumnModel().getColumn(4).setHeaderValue("Designation");

            HomeTable.getColumnModel().getColumn(5).setMinWidth(120);
            HomeTable.getColumnModel().getColumn(5).setMaxWidth(150);
            HomeTable.getColumnModel().getColumn(5).setHeaderValue("Source");

            HomeTable.getColumnModel().getColumn(6).setMinWidth(65);
            HomeTable.getColumnModel().getColumn(6).setMaxWidth(80);
            HomeTable.getColumnModel().getColumn(6).setHeaderValue("N° de Bon");

            HomeTable.getColumnModel().getColumn(7).setMinWidth(65);
            HomeTable.getColumnModel().getColumn(7).setMaxWidth(85);
            HomeTable.getColumnModel().getColumn(7).setHeaderValue("Date");

        }
    }//GEN-LAST:event_SearchMouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
            PdfExport();
        } catch (DocumentException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void HomeTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_HomeTableMouseClicked
        //id,nom,quntity,reference,Designation,source, nbrBon,date
        int Ligne = HomeTable.getSelectedRow();
        String id = HomeTable.getModel().getValueAt(Ligne, 0).toString();
        String nom = HomeTable.getModel().getValueAt(Ligne, 1).toString();
        String quntity = HomeTable.getModel().getValueAt(Ligne, 2).toString();
        String reference = HomeTable.getModel().getValueAt(Ligne, 3).toString();
        String Designation = HomeTable.getModel().getValueAt(Ligne, 4).toString();
        String source = HomeTable.getModel().getValueAt(Ligne, 5).toString();
        String nbrBon = HomeTable.getModel().getValueAt(Ligne, 6).toString();

        DesigID.setText(id);
        NameStock.setText(nom);
        SearchByNom.setText(nom);
        DesigStock.setText(Designation);
        DesigNom.setText(Designation);
        RefStock.setText(reference);
        NbrBonStock.setText(nbrBon);
        SourceStock.setText(source);
        QentityStock.setText(quntity);
    }//GEN-LAST:event_HomeTableMouseClicked

    private void DesigRefKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DesigRefKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String DesigIDVar = DesigID.getText();
            String DesigNomVar = DesigNom.getText();
            String DesigRefVar = DesigRef.getText();
            String DesigZoneVar = DesigZone.getText();
            String sql = "INSERT INTO Designation (nom, reference, zone) values ('" + DesigNomVar + "','" + DesigRefVar + "','" + DesigZoneVar + "')";
            if (DesigNomVar.equals("") || DesigRefVar.equals("")) {
                JOptionPane.showMessageDialog(this, "le nom et la référence est une obligation que vous devez remplir");
            } else {
                try {
                    Pst = Conn.prepareStatement(sql);
                    Pst.execute();
                    Pst.close();
                } catch (Exception e) {
                }
            }
            DesigStockDB.removeAllItems();
            SetDesigComboFromDb();
            DesigNom.setText("");
            DesigRef.setText("");
            DesigZone.setText("");
        }
    }//GEN-LAST:event_DesigRefKeyPressed

    private void DesigNomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DesigNomKeyPressed
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String DesigIDVar = DesigID.getText();
            String DesigNomVar = DesigNom.getText();
            String DesigRefVar = DesigRef.getText();
            String DesigZoneVar = DesigZone.getText();
            String sql = "INSERT INTO Designation (nom, reference, zone) values ('" + DesigNomVar + "','" + DesigRefVar + "','" + DesigZoneVar + "')";
            if (DesigNomVar.equals("") || DesigRefVar.equals("")) {
                JOptionPane.showMessageDialog(this, "le nom et la référence est une obligation que vous devez remplir");
            } else {
                try {
                    Pst = Conn.prepareStatement(sql);
                    Pst.execute();
                    Pst.close();
                } catch (Exception e) {
                }
            }
            DesigStockDB.removeAllItems();
            SetDesigComboFromDb();
            DesigNom.setText("");
            DesigRef.setText("");
            DesigZone.setText("");
        }
    }//GEN-LAST:event_DesigNomKeyPressed

    private void DesigZoneKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_DesigZoneKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String DesigIDVar = DesigID.getText();
            String DesigNomVar = DesigNom.getText();
            String DesigRefVar = DesigRef.getText();
            String DesigZoneVar = DesigZone.getText();
            String sql = "INSERT INTO Designation (nom, reference, zone) values ('" + DesigNomVar + "','" + DesigRefVar + "','" + DesigZoneVar + "')";
            if (DesigNomVar.equals("") || DesigRefVar.equals("")) {
                JOptionPane.showMessageDialog(this, "le nom et la référence est une obligation que vous devez remplir");
            } else {
                try {
                    Pst = Conn.prepareStatement(sql);
                    Pst.execute();
                    Pst.close();
                } catch (Exception e) {
                }
            }
            DesigStockDB.removeAllItems();
            SetDesigComboFromDb();
            DesigRef.setText("");
            DesigNom.setText("");
        }
    }//GEN-LAST:event_DesigZoneKeyPressed

//arialuni.ttf
    final static String dir = System.getProperty("user.dir");
    final static String Fontdir = System.getProperty("c:/windows/fonts/arialuni.ttf");

    public void PdfExport() throws DocumentException, BadElementException, IOException {
        //BaseFont bf = BaseFont.createFont(Fontdir ,BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font Normal = FontFactory.getFont(Fontdir, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 12, Font.NORMAL);
        Font NormalText = FontFactory.getFont(Fontdir, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 10, Font.NORMAL);
        Font Titl = FontFactory.getFont(Fontdir, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 18, Font.BOLD);
        Font SuTitel = FontFactory.getFont(Fontdir, BaseFont.IDENTITY_H, BaseFont.EMBEDDED, 16, Font.NORMAL);
        Document Doc = new Document();
        String sql = "SELECT nom, reference, quntity, nbrBon, source, date From Stock";
        String sqlEntree = "SELECT nom, Qentity, Forniseur, Date From Entree";
        String sqlSortie = "SELECT Nom, QetSortie, Distination, Date From Sortie";

        try {
            PreparedStatement PstPdf = Conn.prepareStatement(sql);
            ResultSet Res = PstPdf.executeQuery();
            PdfWriter.getInstance(Doc, new FileOutputStream(dir + "\\PdfRepport\\StockRepport_" + ft.format(dNow) + ".pdf"));
            Doc.open();
            /* Header */
            Image img = Image.getInstance(dir + "\\Image\\Header.png");
            img.scaleAbsoluteHeight(140);
            img.scaleAbsoluteWidth(600);
            img.setAlignment(Image.ALIGN_CENTER);
            Doc.add(img);
            /* End Header */
 /* Body */
 /* Titel*/
            Doc.add(new Paragraph(" "));//.setAlignment(Element.ALIGN_RIGHT);
            String Titel = "Fiche de valorisation des stocks";
            Paragraph TitelPh = new Paragraph(Titel, Titl);
            TitelPh.setAlignment(Element.ALIGN_CENTER);
            Doc.add(TitelPh);
            Doc.add(new Paragraph(" "));
            /* End Titel */

            String Titel0 = "Stocks Total";
            Paragraph Titel00 = new Paragraph(Titel0, SuTitel);
            // Titel00.setAlignment(Element.ALIGN_CENTER);
            Doc.add(Titel00);
            Doc.add(new Paragraph(" "));
            /* Table */
 /* Declaration Table */
            PdfPTable Table = new PdfPTable(7);
            Table.setWidthPercentage(100);
            PdfPCell Cell;
            Table.setWidthPercentage(100);
            Table.setWidths(new float[]{0.6f, 3.5f, 1f, 1.2f, 2f, 1.6f, 1.5f});

            /* End Dec Table */
 /* Remplir Table Header */
            Cell = new PdfPCell(new Phrase("Nbr", Normal));
            Cell.setBackgroundColor(BaseColor.GRAY);
            Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell.setVerticalAlignment(Element.ALIGN_CENTER);
            Table.addCell(Cell);

            Cell = new PdfPCell(new Phrase("Nom Stock", Normal));
            Cell.setBackgroundColor(BaseColor.GRAY);
            Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell.setVerticalAlignment(Element.ALIGN_CENTER);
            Table.addCell(Cell);

            Cell = new PdfPCell(new Phrase("Réf.", Normal));
            Cell.setBackgroundColor(BaseColor.GRAY);
            Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell.setVerticalAlignment(Element.ALIGN_CENTER);
            Table.addCell(Cell);

            Cell = new PdfPCell(new Phrase("Qentité", Normal));
            Cell.setBackgroundColor(BaseColor.GRAY);
            Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell.setVerticalAlignment(Element.ALIGN_CENTER);
            Table.addCell(Cell);

            Cell = new PdfPCell(new Phrase("N° de Bon", Normal));
            Cell.setBackgroundColor(BaseColor.GRAY);
            Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell.setVerticalAlignment(Element.ALIGN_CENTER);
            Table.addCell(Cell);

            Cell = new PdfPCell(new Phrase("Fournisseur", Normal));
            Cell.setBackgroundColor(BaseColor.GRAY);
            Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell.setVerticalAlignment(Element.ALIGN_CENTER);
            Table.addCell(Cell);

            Cell = new PdfPCell(new Phrase("Date", Normal));
            Cell.setBackgroundColor(BaseColor.GRAY);
            Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell.setVerticalAlignment(Element.ALIGN_CENTER);
            Table.addCell(Cell);
            /* Fin Remplir Table Header*/
 /* Table Column*/
            int nbr = 1;
            while (Res.next()) {//nom, reference, quntity, nbrBon, source, date  
                Cell = new PdfPCell(new Phrase(Integer.toString(nbr), NormalText));
                Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell.setVerticalAlignment(Element.ALIGN_CENTER);
                Table.addCell(Cell);
                //JOptionPane.showMessageDialog(this, Res.getString("nom").toString());
                Cell = new PdfPCell(new Phrase(Res.getString("nom").toString(), NormalText));
                // Cell.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
                Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell.setVerticalAlignment(Element.ALIGN_CENTER);
                Table.addCell(Cell);

                Cell = new PdfPCell(new Phrase(Res.getString("reference").toString(), NormalText));
                Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                //Cell.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
                Cell.setVerticalAlignment(Element.ALIGN_CENTER);
                Table.addCell(Cell);

                Cell = new PdfPCell(new Phrase(Res.getString("quntity").toString(), NormalText));
                Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell.setVerticalAlignment(Element.ALIGN_CENTER);
                Table.addCell(Cell);

                Cell = new PdfPCell(new Phrase(Res.getString("nbrBon").toString(), NormalText));
                Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell.setVerticalAlignment(Element.ALIGN_CENTER);
                Table.addCell(Cell);

                Cell = new PdfPCell(new Phrase(Res.getString("source").toString(), NormalText));
                Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                //Cell.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
                Cell.setVerticalAlignment(Element.ALIGN_CENTER);
                Table.addCell(Cell);

                Cell = new PdfPCell(new Phrase(Res.getString("date").toString(), NormalText));
                Cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell.setVerticalAlignment(Element.ALIGN_CENTER);
                Table.addCell(Cell);
                nbr++;
            }
            /* End Table Column*/
            Doc.add(Table);
            /* Table */
            PstPdf = Conn.prepareStatement(sqlEntree);
            Res = PstPdf.executeQuery();
            /* Tite2*/
            Doc.add(new Paragraph(" "));//.setAlignment(Element.ALIGN_RIGHT);
            String Tite2 = "Stocks Entrée";
            Paragraph Titel02 = new Paragraph(Tite2, SuTitel);
            //Titel02.setAlignment(Element.ALIGN_CENTER);
            Doc.add(Titel02);
            Doc.add(new Paragraph(" "));
            /* End Tite2 */
 /* Table 2*/
 /* Declaration Table */
            PdfPTable Table2 = new PdfPTable(5);
            PdfPCell Cell2;
            Table2.setWidthPercentage(100);
            Table2.setWidths(new float[]{0.6f, 3.5f, 1f, 2.1f, 1.2f});

            /* End Dec Table */
 /* Remplir Table Header */
            Cell2 = new PdfPCell(new Phrase("Nbr", Normal));
            Cell2.setBackgroundColor(BaseColor.GRAY);
            Cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell2.setVerticalAlignment(Element.ALIGN_CENTER);
            Table2.addCell(Cell2);

            Cell2 = new PdfPCell(new Phrase("Nom Stock", Normal));
            Cell2.setBackgroundColor(BaseColor.GRAY);
            Cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell2.setVerticalAlignment(Element.ALIGN_CENTER);
            Table2.addCell(Cell2);

            Cell2 = new PdfPCell(new Phrase("Qet.Entrée", Normal));
            Cell2.setBackgroundColor(BaseColor.GRAY);
            Cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell2.setVerticalAlignment(Element.ALIGN_CENTER);
            Table2.addCell(Cell2);

            Cell2 = new PdfPCell(new Phrase("Fournisseur", Normal));
            Cell2.setBackgroundColor(BaseColor.GRAY);
            Cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell2.setVerticalAlignment(Element.ALIGN_CENTER);
            Table2.addCell(Cell2);

            Cell2 = new PdfPCell(new Phrase("Date", Normal));
            Cell2.setBackgroundColor(BaseColor.GRAY);
            Cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell2.setVerticalAlignment(Element.ALIGN_CENTER);
            Table2.addCell(Cell2);
            /* Fin Remplir Table Header*/
 /* Table Column*/
            int nbre = 1;
            while (Res.next()) {//nom, reference, quntity, nbrBon, source, date  

                Cell2 = new PdfPCell(new Phrase(Integer.toString(nbre), NormalText));
                Cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell2.setVerticalAlignment(Element.ALIGN_CENTER);
                Table2.addCell(Cell2);

                Cell2 = new PdfPCell(new Phrase(Res.getString("nom").toString(), NormalText));
                Cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell2.setVerticalAlignment(Element.ALIGN_CENTER);
                Table2.addCell(Cell2);

                Cell2 = new PdfPCell(new Phrase(Integer.toString(Res.getInt("Qentity")), NormalText));
                Cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell2.setVerticalAlignment(Element.ALIGN_CENTER);
                Table2.addCell(Cell2);

                Cell2 = new PdfPCell(new Phrase(Res.getString("Forniseur").toString(), NormalText));
                Cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell2.setVerticalAlignment(Element.ALIGN_CENTER);
                Table2.addCell(Cell2);

                Cell2 = new PdfPCell(new Phrase(Res.getString("Date").toString(), NormalText));
                Cell2.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell2.setVerticalAlignment(Element.ALIGN_CENTER);
                Table2.addCell(Cell2);
                nbre += 1;
            }
            /* End Table Column*/
            Doc.add(Table2);

            PstPdf = Conn.prepareStatement(sqlSortie);
            Res = PstPdf.executeQuery();
            /* Tite2*/
            Doc.add(new Paragraph(" "));//.setAlignment(Element.ALIGN_RIGHT);
            String Tite3 = "Stocks Sortie";
            Paragraph Titel03 = new Paragraph(Tite3, SuTitel);
            // Titel03.setAlignment(Element.ALIGN_CENTER);
            Doc.add(Titel03);
            Doc.add(new Paragraph(" "));
            /* End Tite2 */
 /* Table 2*/
 /* Declaration Table */
            PdfPTable Table3 = new PdfPTable(5);
            PdfPCell Cell3;
            Table3.setWidthPercentage(100);
            Table3.setWidthPercentage(100);
            Table3.setWidths(new float[]{0.6f, 3.5f, 1f, 2.1f, 1.2f});

            /* End Dec Table */
 /* Remplir Table Header */
            Cell3 = new PdfPCell(new Phrase("Nbr", Normal));
            Cell3.setBackgroundColor(BaseColor.GRAY);
            Cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell3.setVerticalAlignment(Element.ALIGN_CENTER);
            Table3.addCell(Cell3);

            Cell3 = new PdfPCell(new Phrase("Nom Stock", Normal));
            Cell3.setBackgroundColor(BaseColor.GRAY);
            Cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell3.setVerticalAlignment(Element.ALIGN_CENTER);
            Table3.addCell(Cell3);

            Cell3 = new PdfPCell(new Phrase("Qet.Sortie", Normal));
            Cell3.setBackgroundColor(BaseColor.GRAY);
            Cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell3.setVerticalAlignment(Element.ALIGN_CENTER);
            Table3.addCell(Cell3);

            Cell3 = new PdfPCell(new Phrase("Distination", Normal));
            Cell3.setBackgroundColor(BaseColor.GRAY);
            Cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell3.setVerticalAlignment(Element.ALIGN_CENTER);
            Table3.addCell(Cell3);

            Cell3 = new PdfPCell(new Phrase("Date", Normal));
            Cell3.setBackgroundColor(BaseColor.GRAY);
            Cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell3.setVerticalAlignment(Element.ALIGN_CENTER);
            Table3.addCell(Cell3);
            /* Fin Remplir Table Header*/
 /* Table Column*/
            int nbrs = 1;
            while (Res.next()) {//nom, reference, quntity, nbrBon, source, date  

                Cell3 = new PdfPCell(new Phrase(Integer.toString(nbrs), NormalText));
                Cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell3.setVerticalAlignment(Element.ALIGN_CENTER);
                Table3.addCell(Cell3);

                Cell3 = new PdfPCell(new Phrase(Res.getString("Nom").toString(), NormalText));
                Cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell3.setVerticalAlignment(Element.ALIGN_CENTER);
                Table3.addCell(Cell3);

                Cell3 = new PdfPCell(new Phrase(Integer.toString(Res.getInt("QetSortie")), NormalText));
                Cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell3.setVerticalAlignment(Element.ALIGN_CENTER);
                Table3.addCell(Cell3);

                Cell3 = new PdfPCell(new Phrase(Res.getString("Distination").toString(), NormalText));
                Cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell3.setVerticalAlignment(Element.ALIGN_CENTER);
                Table3.addCell(Cell3);

                Cell3 = new PdfPCell(new Phrase(Res.getString("Date").toString(), NormalText));
                Cell3.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell3.setVerticalAlignment(Element.ALIGN_CENTER);
                Table3.addCell(Cell3);
                nbrs += 1;
            }
            /* End Table Column*/
            Doc.add(Table3);

            Date date1 = new Date();
            Doc.add(new Paragraph(" "));
            Paragraph ParDate1 = new Paragraph("Date : " + Pdfdate.format(date1).toString());
            ParDate1.setAlignment(Element.ALIGN_RIGHT);
            Doc.add(ParDate1);

            Doc.newPage();
            /* Header */
            img.scaleAbsoluteHeight(140);
            img.scaleAbsoluteWidth(600);
            img.setAlignment(Image.ALIGN_CENTER);
            Doc.add(img);
            /* End Header */

            String sqlFACTUR = "SELECT Nom, Qentity, prixachet, prixtotal From Entree";
            PstPdf = Conn.prepareStatement(sqlFACTUR);
            Res = PstPdf.executeQuery();
            /* Tite2*/
            Doc.add(new Paragraph(" "));//.setAlignment(Element.ALIGN_RIGHT);
            String Tite4 = "F A C T U R E";
            Paragraph Titel04 = new Paragraph(Tite4, Titl);
            Titel04.setAlignment(Element.ALIGN_CENTER);
            Doc.add(Titel04);
            Doc.add(new Paragraph(" "));
            /* End Tite2 */
            Doc.add(new Paragraph(" "));//.setAlignment(Element.ALIGN_RIGHT);
            String FactEntree = "Facture de revenu";
            Paragraph TitelFactEntree = new Paragraph(FactEntree, SuTitel);
            //TitelFactEntree.setAlignment(Element.ALIGN_CENTER);
            Doc.add(TitelFactEntree);
            Doc.add(new Paragraph(" "));
            /* Table 2*/
 /* Declaration Table */
            PdfPTable Table4 = new PdfPTable(5);
            PdfPCell Cell4;
            Table4.setWidthPercentage(100);
            Table4.setWidths(new float[]{0.6f, 3.5f, 1f, 1.6f, 2f});

            /* End Dec Table */
 /* Remplir Table Header */
            Cell4 = new PdfPCell(new Phrase("Nbr", Normal));
            Cell4.setBackgroundColor(BaseColor.GRAY);
            Cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell4.setVerticalAlignment(Element.ALIGN_CENTER);
            Table4.addCell(Cell4);

            Cell4 = new PdfPCell(new Phrase("Nom Stock", Normal));
            Cell4.setBackgroundColor(BaseColor.GRAY);
            Cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell4.setVerticalAlignment(Element.ALIGN_CENTER);
            Table4.addCell(Cell4);

            Cell4 = new PdfPCell(new Phrase("Qentité", Normal));
            Cell4.setBackgroundColor(BaseColor.GRAY);
            Cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell4.setVerticalAlignment(Element.ALIGN_CENTER);
            Table4.addCell(Cell4);

            Cell4 = new PdfPCell(new Phrase("Prix unitaire", Normal));
            Cell4.setBackgroundColor(BaseColor.GRAY);
            Cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell4.setVerticalAlignment(Element.ALIGN_CENTER);
            Table4.addCell(Cell4);

            Cell4 = new PdfPCell(new Phrase("Prix total ", Normal));
            Cell4.setBackgroundColor(BaseColor.GRAY);
            Cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell4.setVerticalAlignment(Element.ALIGN_CENTER);
            Table4.addCell(Cell4);
            /* Fin Remplir Table Header*/
 /* Table Column*/
            int nbrF = 1;
            double Total = 0;
            while (Res.next()) {//Nom, Qentity, prixachet, prixtotal  

                Cell4 = new PdfPCell(new Phrase(Integer.toString(nbrF), NormalText));
                Cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell4.setVerticalAlignment(Element.ALIGN_CENTER);
                Table4.addCell(Cell4);

                Cell4 = new PdfPCell(new Phrase(Res.getString("Nom").toString(), NormalText));
                Cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell4.setVerticalAlignment(Element.ALIGN_CENTER);
                Table4.addCell(Cell4);

                Cell4 = new PdfPCell(new Phrase(Integer.toString(Res.getInt("Qentity")), NormalText));
                Cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell4.setVerticalAlignment(Element.ALIGN_CENTER);
                Table4.addCell(Cell4);

                Cell4 = new PdfPCell(new Phrase(Res.getString("prixachet").toString() + " DA", NormalText));
                Cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell4.setVerticalAlignment(Element.ALIGN_CENTER);
                Table4.addCell(Cell4);

                Cell4 = new PdfPCell(new Phrase(Res.getString("prixtotal").toString() + " DA", NormalText));
                Cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell4.setVerticalAlignment(Element.ALIGN_CENTER);
                Table4.addCell(Cell4);
                nbrF += 1;
                Total = Total + Integer.parseInt(Res.getString("prixtotal"));
            }
            /* End Table Column*/

            Doc.add(Table4);

            Doc.add(new Paragraph(" "));
            PdfPTable TableTotalEntree = new PdfPTable(2);
            PdfPCell CellTotal;
            //float [] pointColumnWidthsCellTotal = {20F, 200F};
            TableTotalEntree.setWidths(new float[]{0.4f, 1.2f});
            TableTotalEntree.setHorizontalAlignment(Element.ALIGN_RIGHT);
            TableTotalEntree.setWidthPercentage(30);
            CellTotal = new PdfPCell(new Phrase("Total", Normal));

            CellTotal.setBackgroundColor(BaseColor.GRAY);
            CellTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
            CellTotal.setVerticalAlignment(Element.ALIGN_CENTER);
            TableTotalEntree.addCell(CellTotal);

            CellTotal = new PdfPCell(new Phrase(Total + " DA", Normal));
            CellTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
            CellTotal.setVerticalAlignment(Element.ALIGN_CENTER);
            TableTotalEntree.addCell(CellTotal);
            Doc.add(TableTotalEntree);

            PstPdf.close();
            Res.close();

            String sqlFSorti = "SELECT Nom,QetSortie,prixvent, prixtotal From Sortie";//QetSortie,,  prixvent, prixtotal
            PreparedStatement PstPdfs = Conn.prepareStatement(sqlFSorti);
            ResultSet Resf = PstPdfs.executeQuery();
            Doc.add(new Paragraph(" "));//.setAlignment(Element.ALIGN_RIGHT);
            String FactSortie = "Facture de Sortie";
            Paragraph TitelFactSortie = new Paragraph(FactSortie, SuTitel);
            //TitelFactEntree.setAlignment(Element.ALIGN_CENTER);
            Doc.add(TitelFactSortie);
            Doc.add(new Paragraph(" "));
            /* Table 2*/
 /* Declaration Table */
            PdfPTable Table5 = new PdfPTable(5);
            PdfPCell Cell5;
            Table5.setWidthPercentage(100);
            Table5.setWidths(new float[]{0.6f, 3.5f, 1f, 1.6f, 2f});

            /* End Dec Table */
 /* Remplir Table Header */
            Cell5 = new PdfPCell(new Phrase("Nbr", Normal));
            Cell5.setBackgroundColor(BaseColor.GRAY);
            Cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell5.setVerticalAlignment(Element.ALIGN_CENTER);
            Table5.addCell(Cell5);

            Cell5 = new PdfPCell(new Phrase("Nom Stock", Normal));
            Cell5.setBackgroundColor(BaseColor.GRAY);
            Cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell5.setVerticalAlignment(Element.ALIGN_CENTER);
            Table5.addCell(Cell5);

            Cell5 = new PdfPCell(new Phrase("Qentité", Normal));
            Cell5.setBackgroundColor(BaseColor.GRAY);
            Cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell5.setVerticalAlignment(Element.ALIGN_CENTER);
            Table5.addCell(Cell5);

            Cell5 = new PdfPCell(new Phrase("Prix unitaire", Normal));
            Cell5.setBackgroundColor(BaseColor.GRAY);
            Cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell5.setVerticalAlignment(Element.ALIGN_CENTER);
            Table5.addCell(Cell5);

            Cell5 = new PdfPCell(new Phrase("Prix total ", Normal));
            Cell5.setBackgroundColor(BaseColor.GRAY);
            Cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
            Cell5.setVerticalAlignment(Element.ALIGN_CENTER);
            Table5.addCell(Cell5);
            /* Fin Remplir Table Header*/
 /* Table Column*/
            int nbrFs = 1;
            double TotalS = 0;
            while (Resf.next()) {//Nom, QetSortie, prixvent, prixtotal  

                Cell5 = new PdfPCell(new Phrase(Integer.toString(nbrFs), NormalText));
                Cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell5.setVerticalAlignment(Element.ALIGN_CENTER);
                Table5.addCell(Cell5);

                Cell5 = new PdfPCell(new Phrase(Resf.getString("Nom").toString(), NormalText));
                Cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell5.setVerticalAlignment(Element.ALIGN_CENTER);
                Table5.addCell(Cell5);

                Cell5 = new PdfPCell(new Phrase(Integer.toString(Resf.getInt("QetSortie")), NormalText));//QetSortie
                Cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell5.setVerticalAlignment(Element.ALIGN_CENTER);
                Table5.addCell(Cell5);

                Cell5 = new PdfPCell(new Phrase(Resf.getString("prixvent").toString() + " DA", NormalText));
                Cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell5.setVerticalAlignment(Element.ALIGN_CENTER);
                Table5.addCell(Cell5);

                Cell5 = new PdfPCell(new Phrase(Resf.getString("prixtotal").toString() + " DA", NormalText));
                Cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                Cell5.setVerticalAlignment(Element.ALIGN_CENTER);
                Table5.addCell(Cell5);
                nbrFs += 1;
                TotalS = TotalS + Integer.parseInt(Resf.getString("prixtotal"));
            }
            /* End Table Column*/
            Doc.add(Table5);
            Doc.add(new Paragraph(" "));
            PdfPTable TableTotalSortie = new PdfPTable(2);
            PdfPCell CellTotatSortie;
            //float [] pointColumnWidthsCellTotal = {20F, 200F};
            TableTotalSortie.setWidths(new float[]{0.4f, 1.2f});
            TableTotalSortie.setHorizontalAlignment(Element.ALIGN_RIGHT);
            TableTotalSortie.setWidthPercentage(30);
            CellTotatSortie = new PdfPCell(new Phrase("Total", Normal));

            CellTotatSortie.setBackgroundColor(BaseColor.GRAY);
            CellTotatSortie.setHorizontalAlignment(Element.ALIGN_CENTER);
            CellTotatSortie.setVerticalAlignment(Element.ALIGN_CENTER);
            TableTotalSortie.addCell(CellTotatSortie);

            CellTotatSortie = new PdfPCell(new Phrase(TotalS + " DA", Normal));
            CellTotatSortie.setHorizontalAlignment(Element.ALIGN_CENTER);
            CellTotatSortie.setVerticalAlignment(Element.ALIGN_CENTER);
            TableTotalSortie.addCell(CellTotatSortie);
            Doc.add(TableTotalSortie);

            /*
                PdfPTable table = new PdfPTable(3);
                table.setWidthPercentage(100);
                table.addCell(getCell("Date : "+Pdfdate.format(date).toString(), PdfPCell.ALIGN_RIGHT));
                table.addCell(getCell("", PdfPCell.ALIGN_CENTER));
                table.addCell(getCell("", PdfPCell.ALIGN_RIGHT));
                Doc.add(table);
             */
            Date date = new Date();
            Doc.add(new Paragraph(" "));
            Paragraph ParDate = new Paragraph("Date : " + Pdfdate.format(date).toString());
            ParDate.setAlignment(Element.ALIGN_RIGHT);
            Doc.add(ParDate);

            /* Add Arabic
                    BaseFont bfk = BaseFont.createFont("c:/windows/fonts/simpfxo.ttf",BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
                    Font trebuchetSmaller = new Font(bfk, 10, 0);
                    PdfPTable tbl = new PdfPTable(1); 
                    PdfPCell cell = new PdfPCell();
                    cell.setRunDirection(PdfWriter.RUN_DIRECTION_RTL);
                    Paragraph paragraph = new Paragraph();
                    paragraph.add(new Phrase("ربط صفحة على شبكة الإنترنت", trebuchetSmaller));
                    cell.addElement(paragraph);
                    tbl.addCell(cell);
                    Doc.add(tbl);
             */
 /* End Body */
            Doc.close();
            Desktop.getDesktop().open(new File(dir + "\\PdfRepport\\StockRepport_" + ft.format(dNow) + ".pdf"));
            PstPdf.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

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
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddDesig;
    private javax.swing.JButton AddStock;
    private com.toedter.calendar.JDateChooser DateStock;
    private javax.swing.JLabel DateText;
    private javax.swing.JTextField DesigID;
    private javax.swing.JTextField DesigNom;
    private javax.swing.JTextField DesigRef;
    private javax.swing.JTextField DesigStock;
    private javax.swing.JComboBox<String> DesigStockDB;
    private javax.swing.JTextField DesigZone;
    private javax.swing.JButton Exit;
    private javax.swing.JTable HomeTable;
    private javax.swing.JTextField IdStock;
    private javax.swing.JButton MisajourInter;
    private javax.swing.JButton MoveStock;
    private javax.swing.JTextField NameStock;
    private javax.swing.JTextField NbrBonStock;
    private javax.swing.JTextField Prix;
    private javax.swing.JTextField QentityStock;
    private javax.swing.JTextField RefStock;
    private javax.swing.JLabel Search;
    private javax.swing.JComboBox<String> SearchByDesigCom;
    private javax.swing.JTextField SearchByNom;
    private javax.swing.JButton SetRef;
    private javax.swing.JTextField SourceStock;
    private javax.swing.JLabel TabeActule;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
