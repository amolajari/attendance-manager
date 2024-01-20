/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functionality;
import database.databaseConnection;
import functionality.login_implementation;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author prathmesh
 */
public class Student
{
  
    Connection conn=null;
    ResultSet rs=null;
    PreparedStatement pat=null;
    Statement stmt=null;
    
 public  Student()
        {
             conn = databaseConnection.connection();
        }
  
  public void addStudent(String sname,String mail,String batchc,String genderr,String dobb, String enrl) throws SQLException
  {
      
      try
      {
         
        stmt = conn.createStatement();
      String sql="insert into  student(enrollment_no,student_name,email,class_code,gender,dob)   values('"+enrl+"'  , '" +sname+ "'  , '" +mail+ "'    ,    '" +batchc+ "'  ,'" +genderr+ "'  ,  '" +dobb+ "')";
      
      stmt.executeUpdate(sql);
      JOptionPane.showMessageDialog(null, "Record  is Inserted ");
      
      
  }
 catch(Exception e)
      {
          JOptionPane.showMessageDialog(null, e);
      }
}
  
  public void updateStudent(String sname,String mail,String batchc,String genderr,String dobb,String enrl) throws SQLException
  {
      stmt = conn.createStatement();
      
      String sql="UPDATE STUDENT SET student_name='"+sname+"' , enrollment_no= '"+enrl+"', email='"+mail+"', class_code='"+batchc+"', gender='"+genderr+"', dob='"+dobb+"'    ";
      stmt.executeUpdate(sql);
        JOptionPane.showMessageDialog(null, "Record  Updated ");
      
      
  }
  
  public void deleteStudent(int idd) throws SQLException
  {
  
   stmt = conn.createStatement();
   String sql = "delete from attendance.student where enrollment_no='"+idd+"'";
            stmt.executeUpdate(sql);
  JOptionPane.showMessageDialog(null, "RECORD DELETED");
  
  }
}