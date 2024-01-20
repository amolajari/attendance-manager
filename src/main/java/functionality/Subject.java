/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functionality;
import database.databaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author prathmesh
 */
public class Subject 
{
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pat=null;
    Statement stmt=null;
    
 
    
    public Subject()
    {
       
         conn = databaseConnection.connection();
    }
    
    public void addSubject(String sid,String subnamee,String desce)
    {
        try {
            
            
          stmt = conn.createStatement();
            
            String sql="INSERT INTO ATTENDANCE.SUBJECT (subject_id,subject_name,description)values( '"+sid+"' , '"+subnamee+"','"+desce+"' )";

                stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Record  is Inserted ");
        } catch (SQLException ex)
        {
             JOptionPane.showMessageDialog(null, ex);
        }
            
        
        
        
    }
    
    
    
}
