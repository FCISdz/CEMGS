/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cemgs;

import static cemgs.CEMGS.expireDate;
import java.util.Calendar;
import javax.swing.JOptionPane;

/**
 *
 * @author ZaHi
 */
public class CEMGS {
    
    

        
    public  static void StartAdmin(){
        Admin AdminStart = new Admin();
        AdminStart.setVisible(true);
    }
    public  static void StartHome(){
        Home HomeStart = new Home();
        HomeStart.setVisible(true);
    }
    
    public  static void StartMisajour(){
        Misajour StartMisajour = new Misajour();
        StartMisajour.setVisible(true);
    }
    
    public  static void StartMoveStock(){
        MoveStock MoveStockStart = new MoveStock();
        MoveStockStart.setVisible(true);
    }
    
    public  static void StartUserGestion(){
        UserGestion UserGestionStart = new UserGestion();
        UserGestionStart.setVisible(true);
    }
    
    public  static void StartLogin(){
        Login LoginStart = new Login();
        LoginStart.setVisible(true);
    }
    
    public  static void StartSupprime(){
        Supprime SupprimeStart = new Supprime();
        SupprimeStart.setVisible(true);
    }
    

        // Die after October 1, 2010
    public static Calendar  expireDate = Calendar.getInstance();
        
    
    
    
    public static void main(String[] args) {
     /** **/   
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
     /*   */
        // January is 0 (y, m, d)
        expireDate.set(2019, 4, 28);
        
         // Get current date and compare
        if (Calendar.getInstance().after(expireDate)) {
             // Die
            TrialEnd TrialEndStart = new TrialEnd();
            TrialEndStart.setVisible(true);
        }else{
            Login LoginStart = new Login();
            LoginStart.setVisible(true);
        }
    }
    
}
