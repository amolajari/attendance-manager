/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functionality;

import database.databaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author amol
 */
public class Classes {
     Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null; 
     
    public Classes(){
        conn = databaseConnection.connection();    
    }
    
    public void addClass(String classCode){
    try{
        stmt = conn.createStatement();
        String sql = "INSERT INTO attendance.class (class_code) values('"+classCode+"')";
        stmt.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Class Added Successful!!");
    }catch(SQLException e){
        JOptionPane.showMessageDialog(null, e);
    }
    }
    
    public void updateClass(String classcode1,String srch){
        try
        {
            stmt = conn.createStatement();
           
            String sql = "UPDATE attendance.class SET class_code = '"+classcode1+"' WHERE class_code='"+srch+"'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Updation Successful!!");
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public void deleteClass(String ii) throws SQLException
    {
         stmt = conn.createStatement();
   String sql = "delete from attendance.class where class_code='"+ii+"'";
            stmt.executeUpdate(sql);
  JOptionPane.showMessageDialog(null, "RECORD DELETED");
    }
}
