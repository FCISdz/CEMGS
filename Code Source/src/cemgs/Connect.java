/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cemgs;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *  C:\\Users\\ZaHi\\Documents\\NetBeansProjects\\CEMGS\\DataBase
 * @author ZaHi
 */
public class Connect { // C:\\Users\\ZaHi\\Documents\\NetBeansProjects\\CEMGS\\dist\\DataBase\\Stock.db
    final static String dir = System.getProperty("user.dir");
    
    public static String url = dir+"\\DataBase\\Stock.db";

    public static Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.sqlite.JDBC");
            conn = DriverManager.getConnection("jdbc:sqlite:" + url);
          //  JOptionPane.showMessageDialog(null ,url);
            return conn;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Connect.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connect.connect();
    }

}
