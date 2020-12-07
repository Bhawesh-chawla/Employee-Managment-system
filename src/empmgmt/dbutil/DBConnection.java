/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package empmgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DBConnection {
    private static Connection conn;
    static {
        try{
        Class.forName("oracle.jdbc.OracleDriver");
        conn=DriverManager.getConnection("jdbc:oracle:thin:@//DESKTOP-376511D:1521/xe", "sca", "sca"); //lsnrctl services
        JOptionPane.showMessageDialog(null,"Connection done Successfully!");
        }
        catch(ClassNotFoundException cnfe){
        JOptionPane.showMessageDialog(null,"Cannot Load Driver!"+cnfe);  
        cnfe.printStackTrace();
        }
        catch(SQLException sqlex){
    JOptionPane.showMessageDialog(null,"Problem in DB!"+sqlex);
    sqlex.printStackTrace();
    }
    }
    public static Connection getConnetion(){
        return conn;
    }
    public static void closeConnection(){
        try{
            if(conn!=null){
            conn.close();
        JOptionPane.showMessageDialog(null,"Connection Closed Successfully!");
        }
        }
        catch(SQLException sqlex){
            JOptionPane.showMessageDialog(null,"Problem In closing connection!"+sqlex);
                sqlex.printStackTrace();
        }
    }   
}
