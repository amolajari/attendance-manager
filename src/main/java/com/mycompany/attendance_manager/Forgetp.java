/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.attendance_manager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;
import login.Login;

/**
 *
 * @author Acer
 */
public class Forgetp extends javax.swing.JFrame {
    String teacher;
    String txt;
    Connection conn;
    ResultSet rs;
    PreparedStatement pat;
    Statement st;
    String idxxx;
    /**
     * Creates new form Forgetp
     */
    
    public void Randomotp(){
        Random ra=new Random();
        txt=String.valueOf(ra.nextInt(100000+1));
        
    }
    
    public Forgetp() {
        initComponents();
        compo();
    }
    
    void compo()
    {
        disp.setVisible(false);
        Label1.setVisible(false);
        otp_input.setVisible(false);
        clear_button.setVisible(false);
        submit_button.setVisible(false);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        Label1 = new javax.swing.JLabel();
        otp_input = new javax.swing.JTextField();
        username_input = new javax.swing.JTextField();
        password_input = new javax.swing.JPasswordField();
        confirm_input = new javax.swing.JPasswordField();
        send_button = new rojeru_san.RSButton();
        clear_button = new rojeru_san.RSButton();
        rSButton3 = new rojeru_san.RSButton();
        jLabel14 = new javax.swing.JLabel();
        submit_button = new rojeru_san.RSButton();
        disp = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBackground(new java.awt.Color(31, 148, 251));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(240, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, -1, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(51, 51, 51));
        jLabel11.setText("MarkitUp -");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 51, 51));
        jLabel34.setText(" Attendance Manager");
        jPanel3.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 170, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("•  Forget Password");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 0, -1, 30));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, -1));

        jPanel4.setBackground(new java.awt.Color(31, 46, 85));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel9.setForeground(java.awt.Color.white);
        jLabel9.setText("Username:");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 150, -1, 40));

        jLabel12.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setText("New Password:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 220, -1, 40));

        Label1.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        Label1.setForeground(java.awt.Color.white);
        Label1.setText("Enter Verification Code:");
        jPanel4.add(Label1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 480, -1, 40));

        otp_input.setBackground(new java.awt.Color(31, 46, 85));
        otp_input.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        otp_input.setForeground(new java.awt.Color(255, 255, 255));
        otp_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel4.add(otp_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 480, 210, 40));

        username_input.setBackground(new java.awt.Color(31, 46, 85));
        username_input.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        username_input.setForeground(new java.awt.Color(255, 255, 255));
        username_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel4.add(username_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 140, 210, 40));

        password_input.setBackground(new java.awt.Color(31, 46, 85));
        password_input.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        password_input.setForeground(new java.awt.Color(255, 255, 255));
        password_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel4.add(password_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 220, 210, 40));

        confirm_input.setBackground(new java.awt.Color(31, 46, 85));
        confirm_input.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        confirm_input.setForeground(new java.awt.Color(255, 255, 255));
        confirm_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        jPanel4.add(confirm_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 290, 210, 40));

        send_button.setBackground(new java.awt.Color(31, 148, 251));
        send_button.setText("Send Code");
        send_button.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        send_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                send_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(send_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 380, 140, 40));

        clear_button.setBackground(new java.awt.Color(31, 148, 251));
        clear_button.setText("Clear");
        clear_button.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        clear_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clear_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(clear_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 590, 118, 40));

        rSButton3.setBackground(new java.awt.Color(31, 148, 251));
        rSButton3.setText(" Back");
        rSButton3.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        rSButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(rSButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 40, 130, 40));

        jLabel14.setFont(new java.awt.Font("Verdana", 0, 16)); // NOI18N
        jLabel14.setForeground(java.awt.Color.white);
        jLabel14.setText("Confirm Password:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 290, -1, 40));

        submit_button.setBackground(new java.awt.Color(31, 148, 251));
        submit_button.setText("Submit");
        submit_button.setFont(new java.awt.Font("Verdana", 1, 15)); // NOI18N
        submit_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submit_buttonActionPerformed(evt);
            }
        });
        jPanel4.add(submit_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 590, 118, 40));

        disp.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        disp.setForeground(java.awt.Color.white);
        disp.setText(".");
        jPanel4.add(disp, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 390, 180, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 1, 24)); // NOI18N
        jLabel2.setForeground(java.awt.Color.white);
        jLabel2.setText("Forget Password");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 40, -1, 40));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1270, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void send_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_send_buttonActionPerformed
        // TODO add your handling code here:
        String username = username_input.getText();
        String password = password_input.getText();
        String confirm = confirm_input.getText();
        
        //////////////////////////////////////////////////////////////////////////////
        
        String from="markitup.business@gmail.com";
        String email;
        String host="localhost";
        int tempx=0;
        int tempxx=0;
        
        String cpass;
        String acc;
        
        if(password.equals(confirm))
        {
            tempx++;
            int temp=0;
        String sql="Select * from teacher";
        //String acc_no=jTextField3.getText();
       // String pass=jPasswordField1.getText();
    
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance?serverTimezone=UTC","root","");
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
           
                String user_mail=rs.getString("email");

                String namexx=rs.getString("teacher_name");
                String idxx=rs.getString("teacher_id");
                
                if(username.equals(idxx)){
                    teacher=idxx;
                    disp.setVisible(true);
                    disp.setText("Password Matched!");
                    tempxx++;
                    Randomotp();
                   
                  Properties p=new Properties();                    
                    p.put("mail.smtp.auth","true");
                    p.put("mail.smtp.starttls.enable","true");
                    p.put("mail.smtp.host","smtp.gmail.com");
                    p.put("mail.smtp.port","587");
                    Session s = Session.getDefaultInstance(p, new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication()
                        {
                            return new PasswordAuthentication("markitup.business@gmail.com","threebots");
                        } 
                    });
                    try{
                        MimeMessage m = new MimeMessage(s);
                        m.setFrom(from);
                        m.addRecipient(Message.RecipientType.TO, new InternetAddress(user_mail));
                        m.setSubject("MarkItUp - Forget Password !!!");
                        m.setText("Dear "+namexx+" as per your Forget Password request,\nYour OTP="+txt);
                        Transport.send(m);
                        JOptionPane.showMessageDialog(this,"Please check your Mail !");
                        Label1.setVisible(true);
                        otp_input.setVisible(true);
                        clear_button.setVisible(true);
                        submit_button.setVisible(true);

                    }
                    catch(Exception e)
                    {
                     e.printStackTrace();
                    }
                    }
            }
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(this,"Login Failed!");
            
        }
        }
        if(tempx==0){
            disp.setText("Not Matched");
        }
        if(tempxx==0){
            JOptionPane.showMessageDialog(this,"Enter Correct Details!");
        }

    }//GEN-LAST:event_send_buttonActionPerformed

    private void clear_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clear_buttonActionPerformed
        // TODO add your handling code here:
        username_input.setText("");
        password_input.setText("");
        confirm_input.setText("");
        otp_input.setText("");

    }//GEN-LAST:event_clear_buttonActionPerformed

    private void rSButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton3ActionPerformed
        // TODO add your handling code here:
        Login lg = new Login();
        lg.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_rSButton3ActionPerformed

    private void submit_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submit_buttonActionPerformed
        // TODO add your handling code here:
        String pass = password_input.getText();
        String usernamexx=null;
        String otpx = otp_input.getText();
                        int tem=0;
        try{
            
                        if(otpx.equals(txt)){
                            tem++;
                             Class.forName("com.mysql.cj.jdbc.Driver");
                             conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/attendance?serverTimezone=UTC","root","");
                             
                             String sql="Select * from login_creds";
                             st=conn.createStatement();
                                rs=st.executeQuery(sql);
                                while(rs.next()){
                                    
                                    usernamexx=rs.getString("username");
                                    String idxx=rs.getString("id");    
                                    if(username_input.getText().toString().equals(usernamexx)){
                                        idxxx=idxx;
                                    }
                                }
                             String sqq=("UPDATE login_creds SET password='"+pass+"' Where id="+idxxx); 
                             pat=conn.prepareStatement(sqq);
                             pat.executeUpdate(sqq);
                             
                                    JOptionPane.showMessageDialog(this,"Password Changed Successfully");
                                    Login lg = new Login();
                                    lg.setVisible(true);
                                    this.dispose();
                        }
                        if(tem==0){
                          JOptionPane.showMessageDialog(this,"Invalid OTP!");  
                        }
        }catch(Exception e){
            e.printStackTrace();
        }
        

    }//GEN-LAST:event_submit_buttonActionPerformed

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

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
            java.util.logging.Logger.getLogger(Forgetp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Forgetp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Forgetp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Forgetp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Forgetp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Label1;
    private rojeru_san.RSButton clear_button;
    private javax.swing.JPasswordField confirm_input;
    private javax.swing.JLabel disp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField otp_input;
    private javax.swing.JPasswordField password_input;
    private rojeru_san.RSButton rSButton3;
    private rojeru_san.RSButton send_button;
    private rojeru_san.RSButton submit_button;
    private javax.swing.JTextField username_input;
    // End of variables declaration//GEN-END:variables
}
