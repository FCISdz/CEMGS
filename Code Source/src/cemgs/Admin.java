/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cemgs;

import static cemgs.Home.Fontdir;
import static cemgs.Home.dir;
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
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ZaHi
 */
public class Admin extends javax.swing.JFrame {

    
    Connection Conn = null;
    PreparedStatement Pst = null;
    ResultSet rs = null;
    String RefString = " ";
    Date dNow = new Date();
    SimpleDateFormat ft = new SimpleDateFormat("dd.MMMyyyy");
    SimpleDateFormat Pdfdate = new SimpleDateFormat("dd.MMMyyyy");
    public Admin() {
        initComponents();
        Conn = Connect.connect();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        AdminExit = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        Bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Administration");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton1.setBackground(new java.awt.Color(56, 195, 164));
        jButton1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_add_user_group_filled_32px.png"))); // NOI18N
        jButton1.setText("إدارة المستخدمين");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 240, 170, 45));

        jButton2.setBackground(new java.awt.Color(56, 195, 164));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_deskew_image_automatically_filled_32px.png"))); // NOI18N
        jButton2.setText("طباعة تقرير");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 420, 130, 32));

        AdminExit.setBackground(new java.awt.Color(197, 82, 82));
        AdminExit.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        AdminExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_shutdown_filled_32px.png"))); // NOI18N
        AdminExit.setText("خروج");
        AdminExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AdminExitActionPerformed(evt);
            }
        });
        getContentPane().add(AdminExit, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 420, -1, 32));

        jButton3.setBackground(new java.awt.Color(197, 82, 82));
        jButton3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_clear_shopping_cart_filled_32px_1.png"))); // NOI18N
        jButton3.setText("حذف مخزون");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 340, 170, 45));

        jButton4.setBackground(new java.awt.Color(197, 82, 82));
        jButton4.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_cancel_filled_32px.png"))); // NOI18N
        jButton4.setText("حذف تصنيف");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 340, 170, 45));

        jButton5.setBackground(new java.awt.Color(56, 195, 164));
        jButton5.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/icons8_move_by_trolley_filled_32px_1.png"))); // NOI18N
        jButton5.setText("إدارة المخزون");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 240, 170, 45));

        jButton6.setBackground(new java.awt.Color(204, 204, 255));
        jButton6.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton6.setText("تحديث معلومات مخزون");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 290, 170, 45));

        jButton7.setBackground(new java.awt.Color(204, 204, 255));
        jButton7.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jButton7.setText("تحديث معلومات تصنيف");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, 170, 45));

        Bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/Admin.png"))); // NOI18N
        getContentPane().add(Bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void AdminExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AdminExitActionPerformed
       Login LoInt = new Login();
        LoInt.setVisible(true);
        dispose();
    }//GEN-LAST:event_AdminExitActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        UserGestion UserGestionInt = new UserGestion();
        UserGestionInt.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            PdfExportAdmin();
        } catch (DocumentException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public PdfPCell getCell(String text, int alignment) {
        PdfPCell cell = new PdfPCell(new Phrase(text));
        cell.setPadding(0);
        cell.setHorizontalAlignment(alignment);
        cell.setBorder(PdfPCell.NO_BORDER);
        return cell;
    }
    
    
    public void PdfExportAdmin() throws DocumentException, BadElementException, IOException{
        //BaseFont bf = BaseFont.createFont(Fontdir ,BaseFont.IDENTITY_H, BaseFont.EMBEDDED);
        Font Normal = FontFactory.getFont(Fontdir , BaseFont.IDENTITY_H, BaseFont.EMBEDDED,12,Font.NORMAL);
        Font NormalText = FontFactory.getFont(Fontdir , BaseFont.IDENTITY_H, BaseFont.EMBEDDED,10,Font.NORMAL);
        Font Titl = FontFactory.getFont(Fontdir , BaseFont.IDENTITY_H, BaseFont.EMBEDDED,18,Font.BOLD);
        Font SuTitel = FontFactory.getFont(Fontdir , BaseFont.IDENTITY_H, BaseFont.EMBEDDED,16,Font.NORMAL);
        Document Doc = new Document();
        String sql = "SELECT nom, reference, quntity, nbrBon, source, date From Stock";
        String sqlEntree = "SELECT nom, Qentity, Forniseur, Date From Entree"; 
        String sqlSortie = "SELECT Nom, QetSortie, Distination, Date From Sortie";
        
        try {
            PreparedStatement PstPdf = Conn.prepareStatement(sql); 
            ResultSet Res = PstPdf.executeQuery();
            PdfWriter.getInstance(Doc, new FileOutputStream(dir+"\\PdfRepport\\StockRepport_" + ft.format(dNow) +".pdf"));
            Doc.open();
            /* Header */            
                Image img = Image.getInstance(dir+"\\Image\\Header.png");
                img.scaleAbsoluteHeight(140);
                img.scaleAbsoluteWidth(600);
                img.setAlignment(Image.ALIGN_CENTER);
                Doc.add(img);
            /* End Header */
            /* Body */
                /* Titel*/
                 Doc.add(new Paragraph(" "));//.setAlignment(Element.ALIGN_RIGHT);
                 String Titel = "Fiche de valorisation des stocks";
                 Paragraph TitelPh = new Paragraph(Titel,Titl);
                 TitelPh.setAlignment(Element.ALIGN_CENTER);
                 Doc.add(TitelPh);
                 Doc.add(new Paragraph(" "));
                /* End Titel */
                 
                 String Titel0 = "Stocks Total";
                 Paragraph Titel00 = new Paragraph(Titel0,SuTitel);
                // Titel00.setAlignment(Element.ALIGN_CENTER);
                 Doc.add(Titel00);
                 Doc.add(new Paragraph(" "));
                /* Table */
                    /* Declaration Table */
                        PdfPTable Table = new PdfPTable(7);
                        Table.setWidthPercentage(100);
                        PdfPCell Cell ;
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
                        
                        Cell = new PdfPCell(new Phrase("N° de Bon",Normal));
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
                            Cell = new PdfPCell(new Phrase( Integer.toString(nbr), NormalText));
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
                            nbr ++;
                        }
                    /* End Table Column*/
                   Doc.add(Table);
                /* Table */  
                PstPdf = Conn.prepareStatement(sqlEntree); 
                Res = PstPdf.executeQuery();
                /* Tite2*/
                 Doc.add(new Paragraph(" "));//.setAlignment(Element.ALIGN_RIGHT);
                 String Tite2 = "Stocks Entrée";
                 Paragraph Titel02 = new Paragraph(Tite2,SuTitel);
                 //Titel02.setAlignment(Element.ALIGN_CENTER);
                 Doc.add(Titel02);
                 Doc.add(new Paragraph(" "));
                /* End Tite2 */
                /* Table 2*/
                    /* Declaration Table */
                        PdfPTable Table2 = new PdfPTable(5);
                        PdfPCell Cell2 ;
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
                            
                            Cell2 = new PdfPCell(new Phrase( Integer.toString(nbre), NormalText));
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
                            nbre+=1;
                        }
                    /* End Table Column*/
                   Doc.add(Table2);
 
                   
                   
                PstPdf = Conn.prepareStatement(sqlSortie); 
                Res = PstPdf.executeQuery();
                /* Tite2*/
                 Doc.add(new Paragraph(" "));//.setAlignment(Element.ALIGN_RIGHT);
                 String Tite3 = "Stocks Sortie";
                 Paragraph Titel03 = new Paragraph(Tite3,SuTitel);
                // Titel03.setAlignment(Element.ALIGN_CENTER);
                 Doc.add(Titel03);
                 Doc.add(new Paragraph(" "));
                /* End Tite2 */
                /* Table 2*/
                    /* Declaration Table */
                        PdfPTable Table3 = new PdfPTable(5);
                        PdfPCell Cell3 ;
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
                            
                            Cell3 = new PdfPCell(new Phrase( Integer.toString(nbrs), NormalText));
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
                            nbrs+=1;
                        }
                    /* End Table Column*/
                   Doc.add(Table3);

                   
                   
                   
                   
                    Date date1 = new Date();
                Doc.add(new Paragraph(" "));
                Paragraph ParDate1 = new Paragraph("Date : "+Pdfdate.format(date1).toString());
                ParDate1.setAlignment(Element.ALIGN_RIGHT);
                Doc.add(ParDate1);
                
                
                
                
                
                Doc.newPage(); 
                /* Header */            
                img.scaleAbsoluteHeight(140);
                img.scaleAbsoluteWidth(600);
                img.setAlignment(Image.ALIGN_CENTER);
                Doc.add(img);
            /* End Header */  
                   
                
                String sqlFACTUR ="SELECT Nom, Qentity, prixachet, prixtotal From Entree";
                PstPdf = Conn.prepareStatement(sqlFACTUR); 
                Res = PstPdf.executeQuery();
                /* Tite2*/
                 Doc.add(new Paragraph(" "));//.setAlignment(Element.ALIGN_RIGHT);
                 String Tite4 = "F A C T U R E";
                 Paragraph Titel04 = new Paragraph(Tite4,Titl);
                 Titel04.setAlignment(Element.ALIGN_CENTER);
                 Doc.add(Titel04);
                 Doc.add(new Paragraph(" "));
                /* End Tite2 */
                 Doc.add(new Paragraph(" "));//.setAlignment(Element.ALIGN_RIGHT);
                 String FactEntree = "Facture de revenu";
                 Paragraph TitelFactEntree = new Paragraph(FactEntree,SuTitel);
                 //TitelFactEntree.setAlignment(Element.ALIGN_CENTER);
                 Doc.add(TitelFactEntree);
                 Doc.add(new Paragraph(" "));
                /* Table 2*/
                    /* Declaration Table */
                        PdfPTable Table4 = new PdfPTable(5);
                        PdfPCell Cell4 ;
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
                    int nbrF = 1;double Total = 0;
                        while (Res.next()) {//Nom, Qentity, prixachet, prixtotal  
                            
                            Cell4 = new PdfPCell(new Phrase( Integer.toString(nbrF), NormalText));
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
                        
                            Cell4 = new PdfPCell(new Phrase(Res.getString("prixachet").toString()+" DA", NormalText));
                            Cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                            Cell4.setVerticalAlignment(Element.ALIGN_CENTER);
                            Table4.addCell(Cell4);

                            Cell4 = new PdfPCell(new Phrase(Res.getString("prixtotal").toString()+" DA", NormalText));
                            Cell4.setHorizontalAlignment(Element.ALIGN_CENTER);
                            Cell4.setVerticalAlignment(Element.ALIGN_CENTER);
                            Table4.addCell(Cell4);
                            nbrF+=1;
                            Total = Total + Integer.parseInt(Res.getString("prixtotal"));
                        }
                    /* End Table Column*/
                   
                   Doc.add(Table4);
                   
                   Doc.add(new Paragraph(" "));
                        PdfPTable TableTotalEntree = new PdfPTable(2);
                        PdfPCell CellTotal ;
                        //float [] pointColumnWidthsCellTotal = {20F, 200F};
                        TableTotalEntree.setWidths(new float[]{0.4f, 1.2f});
                        TableTotalEntree.setHorizontalAlignment(Element.ALIGN_RIGHT);
                         TableTotalEntree.setWidthPercentage(30);
                        CellTotal = new PdfPCell(new Phrase("Total", Normal));
                        
                        CellTotal.setBackgroundColor(BaseColor.GRAY);
                        CellTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
                        CellTotal.setVerticalAlignment(Element.ALIGN_CENTER);
                        TableTotalEntree.addCell(CellTotal);
                        
                        CellTotal = new PdfPCell(new Phrase(Total+" DA", Normal));
                        CellTotal.setHorizontalAlignment(Element.ALIGN_CENTER);
                        CellTotal.setVerticalAlignment(Element.ALIGN_CENTER);
                        TableTotalEntree.addCell(CellTotal);
                    Doc.add(TableTotalEntree);
                        
                        
                        
                        
                        
                        
                        
                        
                        
                   PstPdf.close();
                   Res.close();
                   
                String sqlFSorti ="SELECT Nom,QetSortie,prixvent, prixtotal From Sortie";//QetSortie,,  prixvent, prixtotal
                PreparedStatement PstPdfs = Conn.prepareStatement(sqlFSorti); 
                ResultSet Resf = PstPdfs.executeQuery();
                 Doc.add(new Paragraph(" "));//.setAlignment(Element.ALIGN_RIGHT);
                 String FactSortie = "Facture de Sortie";
                 Paragraph TitelFactSortie = new Paragraph(FactSortie,SuTitel);
                 //TitelFactEntree.setAlignment(Element.ALIGN_CENTER);
                 Doc.add(TitelFactSortie);
                 Doc.add(new Paragraph(" "));
                /* Table 2*/
                    /* Declaration Table */
                        PdfPTable Table5 = new PdfPTable(5);
                        PdfPCell Cell5 ;
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
                    int nbrFs = 1;double TotalS = 0;
                        while (Resf.next()) {//Nom, QetSortie, prixvent, prixtotal  
                            
                            Cell5 = new PdfPCell(new Phrase( Integer.toString(nbrFs), NormalText));
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
                        
                            Cell5 = new PdfPCell(new Phrase(Resf.getString("prixvent").toString()+" DA", NormalText));
                            Cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                            Cell5.setVerticalAlignment(Element.ALIGN_CENTER);
                            Table5.addCell(Cell5);

                            Cell5 = new PdfPCell(new Phrase(Resf.getString("prixtotal").toString()+" DA", NormalText));
                            Cell5.setHorizontalAlignment(Element.ALIGN_CENTER);
                            Cell5.setVerticalAlignment(Element.ALIGN_CENTER);
                            Table5.addCell(Cell5);
                            nbrFs+=1;
                            TotalS = TotalS + Integer.parseInt(Resf.getString("prixtotal"));
                        }
                    /* End Table Column*/
                   Doc.add(Table5);
                        Doc.add(new Paragraph(" "));
                        PdfPTable TableTotalSortie = new PdfPTable(2);
                        PdfPCell CellTotatSortie ;
                        //float [] pointColumnWidthsCellTotal = {20F, 200F};
                        TableTotalSortie.setWidths(new float[]{0.4f, 1.2f});
                        TableTotalSortie.setHorizontalAlignment(Element.ALIGN_RIGHT);
                         TableTotalSortie.setWidthPercentage(30);
                        CellTotatSortie = new PdfPCell(new Phrase("Total", Normal));
                        
                        CellTotatSortie.setBackgroundColor(BaseColor.GRAY);
                        CellTotatSortie.setHorizontalAlignment(Element.ALIGN_CENTER);
                        CellTotatSortie.setVerticalAlignment(Element.ALIGN_CENTER);
                        TableTotalSortie.addCell(CellTotatSortie);
                        
                        CellTotatSortie = new PdfPCell(new Phrase(TotalS+" DA", Normal));
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
                Paragraph ParDate = new Paragraph("Date : "+Pdfdate.format(date).toString());
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
            Desktop.getDesktop().open(new File(dir+"\\PdfRepport\\StockRepport_" + ft.format(dNow) +".pdf"));
            PstPdf.close();
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }catch (SQLException ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        CEMGS.StartSupprime();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
       SupprimeCate suppcat = new SupprimeCate();
       suppcat.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        CEMGS.StartHome();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
       CEMGS.StartMisajour();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
       MisDesignation Misinter = new MisDesignation();
       Misinter.setVisible(true);
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Admin().setVisible(true);
            }
        });
          }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AdminExit;
    private javax.swing.JLabel Bg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    // End of variables declaration//GEN-END:variables
}
