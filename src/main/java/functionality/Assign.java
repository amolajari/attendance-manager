/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functionality;
import database.databaseConnection;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author prathmesh
 */
public class Assign 
{
    Connection conn=null;
    Statement stmt=null;
    
    public Assign()
    {
        conn = databaseConnection.connection();   
    }
    
    public void assignAll(String tt,String ss,String cc) throws SQLException
    {
        stmt=conn.createStatement();
        String sql="INSERT INTO subject_assign(class_code,subject_id,teacher_id) values('"+cc+"' , '"+ss+"' , '"+tt+"')";
        stmt.executeUpdate(sql);
         JOptionPane.showMessageDialog(null, "ASSIGNED !");
        conn.close();
    }
    
}
