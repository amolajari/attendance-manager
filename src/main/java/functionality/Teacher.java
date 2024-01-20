/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functionality;

import java.sql.Connection;
import java.sql.Statement;
import database.databaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author amol
 */

public class Teacher {
    
     Connection conn = null;
     Statement stmt = null;
     ResultSet rs = null; 
    
  int tPhone;
  String tId,tName,tAddress,tEmail,tGender,tType="teacher";
  
    public Teacher() {
        conn = databaseConnection.connection();
    }
  
    
  public void insertTeacher(String tId,String tName,String tAddress,long tPhone,String tEmail,String tGender,String tPassword){
        try
        {
            stmt = conn.createStatement();
            String sql = "INSERT INTO attendance.teacher(teacher_id,teacher_name,address,phone,email,gender) values('"+tId+"','"+tName+"' , '"+tAddress+"' , '"+tPhone+"', '"+tEmail+"', '"+tGender+"')";                                                                                                 
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Registeration Successful!!");

            String sql2 = "INSERT INTO attendance.login_creds(username,password,type) values('"+tId+"','"+tPassword+"' , '"+tType+"')";                                                                                                 
            stmt.executeUpdate(sql2);
            
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }                
    }       
 
  public void updateTeacher(String tId1,String tName1,String tAddress1,long tPhone1,String tEmail1,String tGender1){
        try
        {
            stmt = conn.createStatement();
           
            String sql = "UPDATE attendance.teacher SET teacher_id = '"+tId1+"' ,teacher_name = '"+tName1+"' ,address =  '"+tAddress1+"', phone = '"+tPhone1+"', email = '"+tEmail1+"', gender = '"+tGender1+"' WHERE teacher_id='"+tId1+"'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null, "Updation Successful!!");
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
      
  }
  
  public void deleteTeacher(int idd) throws SQLException
  {
  
   stmt = conn.createStatement();
   String sql = "delete from attendance.teacher where teacher_id='"+idd+"'";
     stmt.executeUpdate(sql);
 
  
    String sql1 ="delete from login_creds where username='"+idd+"'";
    stmt.executeUpdate(sql1);
     JOptionPane.showMessageDialog(null, "RECORD DELETED");

  }

}

