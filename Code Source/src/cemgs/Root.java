/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cemgs;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author ZaHi
 */
public class Root extends javax.swing.JFrame {

    static String RtPwd = "Root@Elias5031$";
    static String RtUspn = "Root";
    public static String URL = "C:\\Users\\ZaHi\\Documents\\NetBeansProjects\\CEMGS\\dist\\DataBase\\Stock.db";

    public Root() {
        initComponents();
    }
    
    //String RootPasswdVar = RootPasswd.getText();
    public static String [] RootGetInf(){
        String [] info = null;
        info[0] = DateFin.getText();
        info[1] = DateStart.getText();
        return info;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        DateFin = new javax.swing.JTextField();
        DateStart = new javax.swing.JTextField();
        DateExp = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        DurationExp = new javax.swing.JTextField();
        Apply = new javax.swing.JButton();
        Exit = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        Start = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Bg = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Root");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Duration :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 290, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Start Date :");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Expiration Date :");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, -1));
        getContentPane().add(DateFin, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 250, 190, -1));
        getContentPane().add(DateStart, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 210, 190, -1));
        getContentPane().add(DateExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 290, 130, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Expiration date:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 290, -1, -1));
        getContentPane().add(DurationExp, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 290, 70, -1));

        Apply.setBackground(new java.awt.Color(197, 82, 82));
        Apply.setText("Oky");
        Apply.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ApplyActionPerformed(evt);
            }
        });
        getContentPane().add(Apply, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 360, -1, -1));

        Exit.setBackground(new java.awt.Color(94, 6, 6));
        Exit.setText("Exit");
        Exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExitActionPerformed(evt);
            }
        });
        getContentPane().add(Exit, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 500, -1, -1));

        jLabel1.setText("Start Date:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, -1, -1));

        jLabel3.setText("Exprit Date :");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));
        getContentPane().add(Start, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 100, 20));
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 100, 20));

        Bg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cemgs/Image/Root.png"))); // NOI18N
        getContentPane().add(Bg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void ApplyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ApplyActionPerformed
        String Duration = DurationExp.getText();
        String Fin = DateFin.getText();
        String DStart = DateStart.getText();
        String DateExpir = DateExp.getInputContext().toString();

        Start.setText(DateExpir);
    }//GEN-LAST:event_ApplyActionPerformed

    private void ExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExitActionPerformed
        CEMGS.StartLogin();dispose();
    }//GEN-LAST:event_ExitActionPerformed
   

    static final String Today = "10.avr.2019";
    static final String Tomoro = "12.avr.2019";
    static SimpleDateFormat ft = new SimpleDateFormat("dd.MMMyyyy");

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
            java.util.logging.Logger.getLogger(Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Root.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
  
       
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Root().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Apply;
    private javax.swing.JLabel Bg;
    private com.toedter.calendar.JDateChooser DateExp;
    private static javax.swing.JTextField DateFin;
    private static javax.swing.JTextField DateStart;
    private javax.swing.JTextField DurationExp;
    private javax.swing.JButton Exit;
    private javax.swing.JLabel Start;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    // End of variables declaration//GEN-END:variables
}
