/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package functionality;

import com.mycompany.attendance_manager.Admin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Acer
 */
public class login_implementation {
    
    Connection conn;
    ResultSet rs;
    PreparedStatement pat;
    Statement st;
    
    public void dataBase()
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance?serverTimezone=UTC","root","");
            st=conn.createStatement();
        }
        catch(Exception e)
        {
            
        }
    }
    
    public int loginCode(String username,String password)
    {
        int temp=0,ee=0;
        try{
            dataBase();
            String sql="Select * from login_creds";
            rs=st.executeQuery(sql);
            while(rs.next()){
                String username_check=rs.getString("username");
                String password_check=rs.getString("password");
                String type=rs.getString("type");
                if(username.equals(username_check)&&password.equals(password_check))
                {
                    if(type.equals("admin"))
                    {
                        temp++;
                        ee=1;
                    }
                    if(type.equals("teacher"))
                    {
                        temp++;
                        ee=2;
                    }
                    
                }
                
            }
            if(temp==0){
                ee=0;
            }
            
        }
        catch(Exception e){
            
        }
        return ee;
    }
    
}
