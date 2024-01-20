/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.attendance_manager;

import SysExceptions.InvalidEmailException;
import javax.swing.border.MatteBorder;
import login.Login;
import database.databaseConnection;
import functionality.*;
import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;




/**
 *
 * @author prath
 */
public class Admin extends javax.swing.JFrame {
    
    String username;
    String password;
  

    /**
     * Creates new form Admin
     */
    
    public  void setVisibilityPanel()
    {
          teacherpanel.setVisible(false);
          dashboardpanel.setVisible(true);
//                  addteacherpanel.setVisible(false);
//                    deletedetailspanel.setVisible(false);
//                  displayteacherpanel.setVisible(false);
//                 updatedetailspanel.setVisible(false);
                 logoutpanel.setVisible(false);
          assignpanel.setVisible(false);
          studentpanel.setVisible(false);
          subjectpanel.setVisible(false);
          classpanel.setVisible(false);
          logoutpanel.setVisible(false);
    }
    
    public void setMenuClicked(){
        db.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 6, 0, 0, new java.awt.Color(255, 255, 255)));
        teacherbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        assignbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        profile1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
    }
    
    public Admin() throws SQLException {
        
        initComponents();
        setVisibilityPanel();
        setMenuClicked();
        dashboardData();
//          displayteacherpanel.setVisible(false);
    }
    
    public Admin(String username,String password) throws SQLException {
        initComponents();
        setVisibilityPanel();
        dashboardData();
      //  fillCombobox();
        this.username=username;
        this.password=password;
        
    }
    
    
    
    
    public void dashboardData() throws SQLException
    {
        Connection conn = databaseConnection.connection();
            Statement stmt = conn.createStatement();
            ResultSet rs;
         try
        {
            stmt = conn.createStatement();
         
            String sql = "SELECT count(student_name) FROM attendance.student";                                                                                                 
            rs = stmt.executeQuery(sql);            
              
            if(rs.next()){
                 noOfStuds.setText(rs.getString("count(student_name)"));
             }  
            else{
               JOptionPane.showMessageDialog(null, "Record Not Found");
            }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
                                
//to count total number of teachers in database                         
        try
        {
            stmt = conn.createStatement();
            
            String sql = "SELECT count(teacher_name) FROM attendance.teacher";                                                                                                 
            rs = stmt.executeQuery(sql);
    
            if(rs.next()){
                 noOfTechs.setText(rs.getString("count(teacher_name)")); 
             }  
            else{
               JOptionPane.showMessageDialog(null, "Record Not Found");
            }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
                

//to count total number of classes in database                         
        try
        {
            stmt = conn.createStatement();
            
            String sql = "SELECT count(class_code) FROM attendance.class";                                                                                                 
            rs = stmt.executeQuery(sql);
    
            if(rs.next()){
                 noOfclasses.setText(rs.getString("count(class_code)")); 
             }  
            else{
               JOptionPane.showMessageDialog(null, "Record Not Found");
            }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }
        
        conn.close();
        
        
    }
   public void fillCombobox() throws SQLException 
   {
            
            Connection conn = databaseConnection.connection();
            Statement st = conn.createStatement();
        
            ResultSet rr=st.executeQuery("select class_code from attendance.class");
            bcodel.removeAllItems();
 while (rr.next()) {  

     String cd = rr.getString("class_code");
     bcodel.addItem(cd);
     
     
 }
 
 
      conn.close();
   }
   
   public void fillComboboxInStudentDisplay() throws SQLException 
   {
            
            Connection conn = databaseConnection.connection();
            Statement st = conn.createStatement();
        
            ResultSet rr=st.executeQuery("select class_code from attendance.class");
            cc.removeAllItems();
 while (rr.next()) {  

     String cd = rr.getString("class_code");
     cc.addItem(cd);
     
     
 }
 
 
      conn.close();
   }
   
   
   
   public void fillTeacher() throws SQLException 
   {
            
           Connection conn = databaseConnection.connection();
            Statement st = conn.createStatement();
 
  ResultSet rr1=st.executeQuery("select teacher_id from  teacher");
            techarid.removeAllItems();
 while (rr1.next()) {  

     String ccd = rr1.getString("teacher_id");
     techarid.addItem(ccd);
     
     
 }
 
 
  
   }
   
   public void fillclass() throws SQLException
   { Connection conn = databaseConnection.connection();
            Statement st = conn.createStatement();
        
         ResultSet rr=st.executeQuery("select class_code from attendance.class");
         classcode.removeAllItems();
 while (rr.next()) 
 {  

     String cd = rr.getString("class_code");
     classcode.addItem(cd);
     
     
 }
 conn.close();
   }
   
   
   public void fillSubject() throws SQLException
   {
       Connection conn = databaseConnection.connection();
            Statement st = conn.createStatement();
       
       ResultSet rr2=st.executeQuery("select subject_id from subject");
       subjectcode.removeAllItems();
 while (rr2.next()) {  

     String cdd = rr2.getString("subject_id");
     subjectcode.addItem(cdd);
     
     
 }
 
 
      conn.close();
   }
   
    
//    public Menu(String s1, String s2, String s3, String s4){
//        initComponents();
//        accx=s1;
//        passx=s2;
//        namex=s3;
//        idx=s4;
//        
//        Calender();
//        showdetails();
//        
//    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        assignbutton = new rojeru_san.RSButton();
        teacherbutton = new rojeru_san.RSButton();
        rSButton3 = new rojeru_san.RSButton();
        rSButton4 = new rojeru_san.RSButton();
        rSButton2 = new rojeru_san.RSButton();
        profile1 = new rojeru_san.RSButton();
        db = new rojeru_san.RSButton();
        teacherpanel = new javax.swing.JPanel();
        displayteacherlabel = new javax.swing.JLabel();
        addteacherlabel = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        addteacherpanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        teacher_name_input = new javax.swing.JTextField();
        teacher_address_input = new javax.swing.JTextField();
        teacher_phone_input = new javax.swing.JTextField();
        save_button = new javax.swing.JButton();
        teacher_gender_input = new javax.swing.JComboBox<>();
        jLabel41 = new javax.swing.JLabel();
        teacher_id_input = new javax.swing.JTextField();
        jLabel44 = new javax.swing.JLabel();
        teacher_password_input = new javax.swing.JTextField();
        teacher_email_input1 = new javax.swing.JTextField();
        jLabel32 = new javax.swing.JLabel();
        resetaddteacher = new javax.swing.JButton();
        displayteacherpanel = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        showTeacher = new rojerusan.RSTableMetro();
        updatedetailspanel = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        u_teacher_name_input = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        u_teacher_address_input = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        u_teacher_phone_input = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        update_button = new javax.swing.JButton();
        search_button = new javax.swing.JButton();
        search_teacher_input = new javax.swing.JTextField();
        teacher_id_input1 = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        u_teacher_email_input = new javax.swing.JTextField();
        jLabel43 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        teacherupdatereset = new javax.swing.JButton();
        u_teacher_gender_input = new javax.swing.JTextField();
        deletedetailslabel = new javax.swing.JLabel();
        updatedetailslabel2 = new javax.swing.JLabel();
        deletedetailspanel = new javax.swing.JPanel();
        jLabel45 = new javax.swing.JLabel();
        teacher_id_input_delete = new javax.swing.JTextField();
        DeleteTeacher = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        LogOut = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        subjectpanel = new javax.swing.JPanel();
        addsubjectlabel = new javax.swing.JLabel();
        displaysubjectlabel = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        addsubject = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        namet = new javax.swing.JTextField();
        jLabel29 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        dt = new javax.swing.JTextArea();
        jButton10 = new javax.swing.JButton();
        idt = new javax.swing.JTextField();
        jLabel31 = new javax.swing.JLabel();
        subjectreset = new javax.swing.JButton();
        displaysubject = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        showSubject = new rojerusan.RSTableMetro();
        classpanel = new javax.swing.JPanel();
        addbatchlabel = new javax.swing.JLabel();
        displaybatchlabel = new javax.swing.JLabel();
        updatebatchlabel = new javax.swing.JLabel();
        addbatchpanel = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        ac_class_code = new javax.swing.JTextField();
        ac_save = new javax.swing.JButton();
        addclassreset = new javax.swing.JButton();
        jSeparator5 = new javax.swing.JSeparator();
        displaybatch = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        showClass = new rojerusan.RSTableMetro();
        updatebatch = new javax.swing.JPanel();
        jLabel35 = new javax.swing.JLabel();
        uClassCode2 = new javax.swing.JTextField();
        uUpdateButton = new javax.swing.JButton();
        uClassCode1 = new javax.swing.JTextField();
        ucSearchButton = new javax.swing.JButton();
        updatebatchreset = new javax.swing.JButton();
        deletebatch = new javax.swing.JButton();
        jLabel36 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        logoutpanel = new javax.swing.JPanel();
        logout = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        logout_no_button = new javax.swing.JButton();
        logout_yes_button = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        assignpanel = new javax.swing.JPanel();
        assignlabel = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        addassign = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        techarid = new javax.swing.JComboBox<>();
        classcode = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        subjectcode = new javax.swing.JComboBox<>();
        assignb = new javax.swing.JButton();
        assigndisplaylabel = new javax.swing.JLabel();
        assigndisplay = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        assigntable = new rojerusan.RSTableMetro();
        dashboardpanel = new javax.swing.JPanel();
        jSeparator9 = new javax.swing.JSeparator();
        dashboardlabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        noOfStuds = new javax.swing.JLabel();
        ttStuds = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        noOfTechs = new javax.swing.JLabel();
        ttTechs = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        noOfclasses = new javax.swing.JLabel();
        ttClasses = new javax.swing.JLabel();
        studentpanel = new javax.swing.JPanel();
        displaystudentlabel = new javax.swing.JLabel();
        addstudentlabel = new javax.swing.JLabel();
        updatedetailslabelstudent = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        addstudentpanel = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        emaill = new javax.swing.JTextField();
        snamel = new javax.swing.JTextField();
        enroll = new javax.swing.JTextField();
        genderl = new javax.swing.JComboBox<>();
        bcodel = new javax.swing.JComboBox<>();
        dobl = new com.toedter.calendar.JDateChooser();
        addstudentreset = new javax.swing.JButton();
        displaystudentpanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        cc = new javax.swing.JComboBox<>();
        jScrollPane11 = new javax.swing.JScrollPane();
        jTable2 = new rojerusan.RSTableMetro();
        updatedetailspanelstudent = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        searchid = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        enrol = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        updatestudent = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        sname = new javax.swing.JTextField();
        jButton8 = new javax.swing.JButton();
        dobbb = new com.toedter.calendar.JDateChooser();
        gen = new javax.swing.JTextField();
        bcode = new javax.swing.JTextField();
        updatestudentreset = new javax.swing.JButton();
        deletestudentlabel = new javax.swing.JLabel();
        studentdeletepanel = new javax.swing.JPanel();
        enroll_delete = new javax.swing.JTextField();
        jLabel33 = new javax.swing.JLabel();
        deletestudentb = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(1255, 680));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(31, 46, 85));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assignbutton.setBackground(new java.awt.Color(31, 46, 85));
        assignbutton.setText("ASSIGN");
        assignbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(assignbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, -1, 50));

        teacherbutton.setBackground(new java.awt.Color(31, 46, 85));
        teacherbutton.setText("TEACHER");
        teacherbutton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                teacherbuttonMouseClicked(evt);
            }
        });
        teacherbutton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherbuttonActionPerformed(evt);
            }
        });
        jPanel1.add(teacherbutton, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, 50));

        rSButton3.setBackground(new java.awt.Color(31, 46, 85));
        rSButton3.setText("STUDENT");
        rSButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, -1, 50));

        rSButton4.setBackground(new java.awt.Color(31, 46, 85));
        rSButton4.setText("SUBJECT");
        rSButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, -1, 50));

        rSButton2.setBackground(new java.awt.Color(31, 46, 85));
        rSButton2.setText("CLASS");
        rSButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rSButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(rSButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, -1, 50));

        profile1.setBackground(new java.awt.Color(153, 153, 153));
        profile1.setText("User Profile ");
        profile1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profile1ActionPerformed(evt);
            }
        });
        jPanel1.add(profile1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 640, -1, 40));

        db.setBackground(new java.awt.Color(31, 46, 85));
        db.setText("DASHBOARD");
        db.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dbActionPerformed(evt);
            }
        });
        jPanel1.add(db, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, -1, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 200, 690));

        teacherpanel.setBackground(new java.awt.Color(255, 255, 255));
        teacherpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        displayteacherlabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        displayteacherlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displayteacherlabel.setText("Display");
        displayteacherlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayteacherlabelMouseClicked(evt);
            }
        });
        teacherpanel.add(displayteacherlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 130, 40));

        addteacherlabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        addteacherlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addteacherlabel.setText("Add Teacher");
        addteacherlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addteacherlabelMouseClicked(evt);
            }
        });
        teacherpanel.add(addteacherlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 40));

        jSeparator1.setBackground(new java.awt.Color(153, 153, 153));
        teacherpanel.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1050, 30));

        addteacherpanel.setBackground(new java.awt.Color(255, 255, 255));
        addteacherpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel20.setText("Teacher Name");
        addteacherpanel.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 100, -1, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel21.setText("Address");
        addteacherpanel.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 160, -1, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel22.setText("Phone");
        addteacherpanel.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, -1, 30));

        jLabel23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel23.setText("Password");
        addteacherpanel.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 160, 100, 30));

        teacher_name_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        teacher_name_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(31, 46, 85)));
        addteacherpanel.add(teacher_name_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 100, 210, 30));

        teacher_address_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        teacher_address_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(31, 46, 85)));
        addteacherpanel.add(teacher_address_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 160, 210, 30));

        teacher_phone_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        teacher_phone_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(31, 46, 85)));
        addteacherpanel.add(teacher_phone_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 220, 210, 30));

        save_button.setBackground(new java.awt.Color(31, 46, 85));
        save_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        save_button.setForeground(new java.awt.Color(255, 255, 255));
        save_button.setText("SAVE");
        save_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                save_buttonActionPerformed(evt);
            }
        });
        addteacherpanel.add(save_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 280, 100, 40));

        teacher_gender_input.setBackground(new java.awt.Color(240, 240, 240));
        teacher_gender_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        teacher_gender_input.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "MALE", "FEMALE" }));
        addteacherpanel.add(teacher_gender_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, 210, 30));

        jLabel41.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel41.setText("Teacher ID");
        addteacherpanel.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 30));

        teacher_id_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        teacher_id_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(31, 46, 85)));
        addteacherpanel.add(teacher_id_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, 210, 30));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setText("Email");
        addteacherpanel.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, -1, 30));

        teacher_password_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        teacher_password_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(31, 46, 85)));
        addteacherpanel.add(teacher_password_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 160, 210, 30));

        teacher_email_input1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        teacher_email_input1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(31, 46, 85)));
        addteacherpanel.add(teacher_email_input1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 40, 210, 30));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Gender");
        addteacherpanel.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, 30));

        resetaddteacher.setBackground(new java.awt.Color(31, 46, 85));
        resetaddteacher.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        resetaddteacher.setForeground(new java.awt.Color(255, 255, 255));
        resetaddteacher.setText("RESET");
        resetaddteacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetaddteacherActionPerformed(evt);
            }
        });
        addteacherpanel.add(resetaddteacher, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 280, 90, 40));

        teacherpanel.add(addteacherpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1010, 520));

        displayteacherpanel.setBackground(new java.awt.Color(255, 255, 255));
        displayteacherpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showTeacher.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        showTeacher.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        showTeacher.setColorBackgoundHead(new java.awt.Color(31, 46, 85));
        showTeacher.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        showTeacher.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        showTeacher.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        showTeacher.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showTeacher.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showTeacher.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showTeacher.setRowHeight(30);
        showTeacher.setShowGrid(false);
        jScrollPane9.setViewportView(showTeacher);

        displayteacherpanel.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 970, 480));

        teacherpanel.add(displayteacherpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1010, 520));

        updatedetailspanel.setBackground(new java.awt.Color(255, 255, 255));
        updatedetailspanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel24.setText("Teacher Name");
        updatedetailspanel.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, -1, 30));

        u_teacher_name_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        u_teacher_name_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(31, 46, 85)));
        updatedetailspanel.add(u_teacher_name_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 280, 210, 30));

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel25.setText("Address");
        updatedetailspanel.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 340, -1, 30));

        u_teacher_address_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        u_teacher_address_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(31, 46, 85)));
        updatedetailspanel.add(u_teacher_address_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 340, 210, 30));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel26.setText("Phone");
        updatedetailspanel.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 220, -1, 30));

        u_teacher_phone_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        u_teacher_phone_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(31, 46, 85)));
        updatedetailspanel.add(u_teacher_phone_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 220, 210, 30));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel27.setText("Gender");
        updatedetailspanel.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 340, -1, 30));

        update_button.setBackground(new java.awt.Color(31, 46, 85));
        update_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        update_button.setForeground(new java.awt.Color(255, 255, 255));
        update_button.setText("Update");
        update_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                update_buttonActionPerformed(evt);
            }
        });
        updatedetailspanel.add(update_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 440, 100, 40));

        search_button.setBackground(new java.awt.Color(31, 46, 85));
        search_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        search_button.setForeground(new java.awt.Color(255, 255, 255));
        search_button.setText("Search");
        search_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                search_buttonActionPerformed(evt);
            }
        });
        updatedetailspanel.add(search_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 100, 100, 40));

        search_teacher_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        search_teacher_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(31, 46, 85)));
        updatedetailspanel.add(search_teacher_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 210, 30));

        teacher_id_input1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        teacher_id_input1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(31, 46, 85)));
        updatedetailspanel.add(teacher_id_input1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 210, 30));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setText("Search with ID");
        updatedetailspanel.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 30));

        u_teacher_email_input.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        u_teacher_email_input.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(31, 46, 85)));
        updatedetailspanel.add(u_teacher_email_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 280, 210, 30));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setText("Email");
        updatedetailspanel.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 280, -1, 30));

        jLabel47.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel47.setText("Teacher ID");
        updatedetailspanel.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, -1, 30));

        teacherupdatereset.setBackground(new java.awt.Color(31, 46, 85));
        teacherupdatereset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        teacherupdatereset.setForeground(new java.awt.Color(255, 255, 255));
        teacherupdatereset.setText("reset");
        teacherupdatereset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                teacherupdateresetActionPerformed(evt);
            }
        });
        updatedetailspanel.add(teacherupdatereset, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 440, 100, 40));
        updatedetailspanel.add(u_teacher_gender_input, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 350, 140, -1));

        teacherpanel.add(updatedetailspanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1010, 520));

        deletedetailslabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        deletedetailslabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        deletedetailslabel.setText("Delete Details");
        deletedetailslabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletedetailslabelMouseClicked(evt);
            }
        });
        teacherpanel.add(deletedetailslabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 130, 40));

        updatedetailslabel2.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        updatedetailslabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updatedetailslabel2.setText("Update Details");
        updatedetailslabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatedetailslabel2MouseClicked(evt);
            }
        });
        teacherpanel.add(updatedetailslabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 130, 40));

        deletedetailspanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Teacher ID");

        teacher_id_input_delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        teacher_id_input_delete.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        DeleteTeacher.setBackground(new java.awt.Color(31, 45, 81));
        DeleteTeacher.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DeleteTeacher.setForeground(new java.awt.Color(255, 255, 255));
        DeleteTeacher.setText("Delete Record");
        DeleteTeacher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteTeacherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout deletedetailspanelLayout = new javax.swing.GroupLayout(deletedetailspanel);
        deletedetailspanel.setLayout(deletedetailspanelLayout);
        deletedetailspanelLayout.setHorizontalGroup(
            deletedetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletedetailspanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(deletedetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(DeleteTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(deletedetailspanelLayout.createSequentialGroup()
                        .addComponent(jLabel45)
                        .addGap(32, 32, 32)
                        .addComponent(teacher_id_input_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(646, Short.MAX_VALUE))
        );
        deletedetailspanelLayout.setVerticalGroup(
            deletedetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(deletedetailspanelLayout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(deletedetailspanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(teacher_id_input_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addComponent(DeleteTeacher, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(332, Short.MAX_VALUE))
        );

        teacherpanel.add(deletedetailspanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1010, 520));

        getContentPane().add(teacherpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 1070, 690));

        header.setBackground(new java.awt.Color(31, 148, 251));
        header.setForeground(new java.awt.Color(255, 255, 255));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(16, 16, 16));
        jLabel9.setText("MarkitUp -");
        header.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 90, 30));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(16, 16, 16));
        jLabel8.setText("•  Admin");
        header.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 70, 30));

        jLabel1.setBackground(new java.awt.Color(240, 255, 255));
        jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(16, 16, 16));
        jLabel1.setText("X");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1240, 0, -1, 30));

        LogOut.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        LogOut.setForeground(new java.awt.Color(16, 16, 16));
        LogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        LogOut.setText("Logout");
        LogOut.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                LogOutMouseClicked(evt);
            }
        });
        header.add(LogOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 0, 80, 30));

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(16, 16, 16));
        jLabel34.setText(" Attendance Manager");
        header.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 0, 170, 30));

        getContentPane().add(header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1270, 30));

        subjectpanel.setBackground(new java.awt.Color(255, 255, 255));
        subjectpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addsubjectlabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        addsubjectlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addsubjectlabel.setText("Add Subject");
        addsubjectlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addsubjectlabelMouseClicked(evt);
            }
        });
        subjectpanel.add(addsubjectlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 40));

        displaysubjectlabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        displaysubjectlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displaysubjectlabel.setText("Display");
        displaysubjectlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaysubjectlabelMouseClicked(evt);
            }
        });
        subjectpanel.add(displaysubjectlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 130, 40));

        jSeparator4.setBackground(new java.awt.Color(153, 153, 153));
        subjectpanel.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1050, 30));

        addsubject.setBackground(new java.awt.Color(255, 255, 255));
        addsubject.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel28.setText("Subject Name :");
        addsubject.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, 115, 30));

        namet.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        namet.setPreferredSize(new java.awt.Dimension(62, 21));
        addsubject.add(namet, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 210, 30));

        jLabel29.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel29.setText("Description :");
        addsubject.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 98, 30));

        dt.setColumns(20);
        dt.setRows(5);
        dt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(dt);

        addsubject.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 210, 148));

        jButton10.setBackground(new java.awt.Color(31, 46, 85));
        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setForeground(new java.awt.Color(255, 255, 255));
        jButton10.setText("SAVE");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        addsubject.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 370, 111, 40));

        idt.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        idt.setPreferredSize(new java.awt.Dimension(62, 21));
        addsubject.add(idt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 210, 30));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Subject ID :");
        addsubject.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 80, 30));

        subjectreset.setBackground(new java.awt.Color(31, 46, 85));
        subjectreset.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        subjectreset.setForeground(new java.awt.Color(255, 255, 255));
        subjectreset.setText("reset");
        subjectreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                subjectresetActionPerformed(evt);
            }
        });
        addsubject.add(subjectreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, 110, 40));

        subjectpanel.add(addsubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 131, 1048, 528));

        displaysubject.setBackground(new java.awt.Color(255, 255, 255));
        displaysubject.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showSubject.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        showSubject.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        showSubject.setColorBackgoundHead(new java.awt.Color(31, 46, 85));
        showSubject.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        showSubject.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        showSubject.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        showSubject.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showSubject.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showSubject.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showSubject.setRowHeight(30);
        showSubject.setShowGrid(false);
        jScrollPane8.setViewportView(showSubject);

        displaysubject.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 970, 480));

        subjectpanel.add(displaysubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 128, 1033, 520));

        getContentPane().add(subjectpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 1070, 680));

        classpanel.setBackground(new java.awt.Color(255, 255, 255));
        classpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        addbatchlabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        addbatchlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addbatchlabel.setText("Add Class");
        addbatchlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addbatchlabelMouseClicked(evt);
            }
        });
        classpanel.add(addbatchlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 40));

        displaybatchlabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        displaybatchlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displaybatchlabel.setText("Display");
        displaybatchlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaybatchlabelMouseClicked(evt);
            }
        });
        classpanel.add(displaybatchlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 130, 40));

        updatebatchlabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        updatebatchlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updatebatchlabel.setText("Update Details");
        updatebatchlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatebatchlabelMouseClicked(evt);
            }
        });
        classpanel.add(updatebatchlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 130, 40));

        addbatchpanel.setBackground(new java.awt.Color(255, 255, 255));
        addbatchpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Class code :");
        addbatchpanel.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(36, 46, 100, 40));

        ac_class_code.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        ac_class_code.setPreferredSize(new java.awt.Dimension(62, 21));
        addbatchpanel.add(ac_class_code, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 260, 34));

        ac_save.setBackground(new java.awt.Color(31, 46, 85));
        ac_save.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ac_save.setForeground(new java.awt.Color(255, 255, 255));
        ac_save.setText("Save");
        ac_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ac_saveActionPerformed(evt);
            }
        });
        addbatchpanel.add(ac_save, new org.netbeans.lib.awtextra.AbsoluteConstraints(329, 150, 110, 40));

        addclassreset.setBackground(new java.awt.Color(31, 46, 85));
        addclassreset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addclassreset.setForeground(new java.awt.Color(255, 255, 255));
        addclassreset.setText("reset");
        addclassreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addclassresetActionPerformed(evt);
            }
        });
        addbatchpanel.add(addclassreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 90, 40));

        jSeparator5.setBackground(new java.awt.Color(153, 153, 153));
        addbatchpanel.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, -20, 1050, 30));

        classpanel.add(addbatchpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1050, 540));

        displaybatch.setBackground(new java.awt.Color(255, 255, 255));
        displaybatch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        showClass.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        showClass.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        showClass.setColorBackgoundHead(new java.awt.Color(31, 46, 85));
        showClass.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        showClass.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        showClass.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        showClass.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showClass.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showClass.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        showClass.setRowHeight(30);
        showClass.setShowGrid(false);
        jScrollPane10.setViewportView(showClass);

        displaybatch.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 180, 480));

        classpanel.add(displaybatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1050, 540));

        updatebatch.setBackground(new java.awt.Color(255, 255, 255));
        updatebatch.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Class code :");
        updatebatch.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 100, 30));

        uClassCode2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uClassCode2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        uClassCode2.setPreferredSize(new java.awt.Dimension(62, 21));
        updatebatch.add(uClassCode2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 210, 30));

        uUpdateButton.setBackground(new java.awt.Color(31, 46, 85));
        uUpdateButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uUpdateButton.setForeground(new java.awt.Color(255, 255, 255));
        uUpdateButton.setText("Update");
        uUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uUpdateButtonActionPerformed(evt);
            }
        });
        updatebatch.add(uUpdateButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 290, 90, 40));

        uClassCode1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        uClassCode1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        uClassCode1.setPreferredSize(new java.awt.Dimension(61, 21));
        uClassCode1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uClassCode1ActionPerformed(evt);
            }
        });
        updatebatch.add(uClassCode1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 70, 210, 30));

        ucSearchButton.setBackground(new java.awt.Color(31, 46, 85));
        ucSearchButton.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        ucSearchButton.setForeground(new java.awt.Color(255, 255, 255));
        ucSearchButton.setText("Search");
        ucSearchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ucSearchButtonActionPerformed(evt);
            }
        });
        updatebatch.add(ucSearchButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 130, 109, 40));

        updatebatchreset.setBackground(new java.awt.Color(31, 46, 85));
        updatebatchreset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updatebatchreset.setForeground(new java.awt.Color(255, 255, 255));
        updatebatchreset.setText("Reset");
        updatebatchreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatebatchresetActionPerformed(evt);
            }
        });
        updatebatch.add(updatebatchreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 290, -1, 40));

        deletebatch.setBackground(new java.awt.Color(31, 46, 85));
        deletebatch.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deletebatch.setForeground(new java.awt.Color(255, 255, 255));
        deletebatch.setText("Delete");
        deletebatch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletebatchActionPerformed(evt);
            }
        });
        updatebatch.add(deletebatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, 80, 40));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel36.setText("Class code :");
        updatebatch.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 220, 100, 40));

        classpanel.add(updatebatch, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, 1050, 540));

        jSeparator10.setBackground(new java.awt.Color(153, 153, 153));
        classpanel.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1050, 30));

        getContentPane().add(classpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 1070, 680));

        logoutpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout.setBackground(new java.awt.Color(16, 16, 16));
        logout.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(4, 4, 4, 4, new java.awt.Color(0, 102, 255)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        logout_no_button.setBackground(new java.awt.Color(31, 46, 85));
        logout_no_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logout_no_button.setForeground(new java.awt.Color(255, 255, 255));
        logout_no_button.setText("No");
        logout_no_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_no_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(logout_no_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 130, 50));

        logout_yes_button.setBackground(new java.awt.Color(31, 46, 85));
        logout_yes_button.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        logout_yes_button.setForeground(new java.awt.Color(255, 255, 255));
        logout_yes_button.setText("Yes");
        logout_yes_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logout_yes_buttonActionPerformed(evt);
            }
        });
        jPanel2.add(logout_yes_button, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 160, 130, 50));

        jLabel46.setBackground(new java.awt.Color(31, 46, 85));
        jLabel46.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(31, 46, 85));
        jLabel46.setText("Do you really want to Logout ?");
        jPanel2.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(84, 70, 310, 30));

        logout.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 220, 470, 260));

        logoutpanel.add(logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        getContentPane().add(logoutpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 0, 1280, 720));

        assignpanel.setBackground(new java.awt.Color(255, 255, 255));
        assignpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assignlabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        assignlabel.setText("Assign");
        assignlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assignlabelMouseClicked(evt);
            }
        });
        assignpanel.add(assignlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 60, 40));

        jSeparator7.setBackground(new java.awt.Color(153, 153, 153));
        assignpanel.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 1050, 30));

        addassign.setBackground(new java.awt.Color(255, 255, 255));
        addassign.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("Teacher ID");
        addassign.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 30));

        techarid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        techarid.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                techaridMouseClicked(evt);
            }
        });
        addassign.add(techarid, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 180, 30));

        classcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addassign.add(classcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 180, 30));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Class Code ");
        addassign.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 120, -1, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Subject Code");
        addassign.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, -1, 30));

        subjectcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addassign.add(subjectcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 180, 30));

        assignb.setBackground(new java.awt.Color(31, 46, 85));
        assignb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        assignb.setForeground(new java.awt.Color(255, 255, 255));
        assignb.setText("Submit");
        assignb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                assignbActionPerformed(evt);
            }
        });
        addassign.add(assignb, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 300, 100, 40));

        assignpanel.add(addassign, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1050, 560));

        assigndisplaylabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        assigndisplaylabel.setText("Display Details");
        assigndisplaylabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                assigndisplaylabelMouseClicked(evt);
            }
        });
        assignpanel.add(assigndisplaylabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 30, 120, 40));

        assigndisplay.setBackground(new java.awt.Color(255, 255, 255));
        assigndisplay.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        assigntable.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        assigntable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        assigntable.setColorBackgoundHead(new java.awt.Color(31, 46, 85));
        assigntable.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        assigntable.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        assigntable.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        assigntable.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        assigntable.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        assigntable.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        assigntable.setRowHeight(30);
        assigntable.setShowGrid(false);
        jScrollPane12.setViewportView(assigntable);

        assigndisplay.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 970, 440));

        assignpanel.add(assigndisplay, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1050, 570));

        getContentPane().add(assignpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 1070, 680));

        dashboardpanel.setBackground(new java.awt.Color(255, 255, 255));
        dashboardpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator9.setBackground(new java.awt.Color(153, 153, 153));
        dashboardpanel.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1050, 30));

        dashboardlabel.setBackground(new java.awt.Color(255, 255, 255));
        dashboardlabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        dashboardlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dashboardlabel.setText("Dashboard");
        dashboardlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        dashboardlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardlabelMouseClicked(evt);
            }
        });
        dashboardpanel.add(dashboardlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 40));

        jPanel3.setBackground(new java.awt.Color(31, 46, 85));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(new java.awt.Color(31, 148, 251));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        noOfStuds.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        noOfStuds.setForeground(new java.awt.Color(255, 255, 255));
        noOfStuds.setText("00");
        jPanel4.add(noOfStuds, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jPanel3.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 90));

        ttStuds.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ttStuds.setForeground(new java.awt.Color(255, 255, 255));
        ttStuds.setText("Total Students");
        jPanel3.add(ttStuds, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        dashboardpanel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, 240, 140));

        jPanel5.setBackground(new java.awt.Color(31, 46, 85));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setBackground(new java.awt.Color(31, 148, 251));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        noOfTechs.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        noOfTechs.setForeground(new java.awt.Color(255, 255, 255));
        noOfTechs.setText("00");
        jPanel6.add(noOfTechs, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 50, -1));

        jPanel5.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 90));

        ttTechs.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ttTechs.setForeground(new java.awt.Color(255, 255, 255));
        ttTechs.setText("Total Teachers");
        jPanel5.add(ttTechs, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, -1));

        dashboardpanel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 160, 240, 140));

        jPanel7.setBackground(new java.awt.Color(31, 46, 85));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel8.setBackground(new java.awt.Color(31, 148, 251));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        noOfclasses.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        noOfclasses.setForeground(new java.awt.Color(255, 255, 255));
        noOfclasses.setText("00");
        jPanel8.add(noOfclasses, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jPanel7.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 240, 90));

        ttClasses.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ttClasses.setForeground(new java.awt.Color(255, 255, 255));
        ttClasses.setText("Total Classes");
        jPanel7.add(ttClasses, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, -1, -1));

        dashboardpanel.add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 240, 140));

        getContentPane().add(dashboardpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 1070, 690));

        studentpanel.setBackground(new java.awt.Color(255, 255, 255));
        studentpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        displaystudentlabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        displaystudentlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        displaystudentlabel.setText("Display");
        displaystudentlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaystudentlabelMouseClicked(evt);
            }
        });
        studentpanel.add(displaystudentlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 130, 40));

        addstudentlabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        addstudentlabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        addstudentlabel.setText("Add student");
        addstudentlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addstudentlabelMouseClicked(evt);
            }
        });
        studentpanel.add(addstudentlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 130, 40));

        updatedetailslabelstudent.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        updatedetailslabelstudent.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        updatedetailslabelstudent.setText("Update Details");
        updatedetailslabelstudent.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updatedetailslabelstudentMouseClicked(evt);
            }
        });
        studentpanel.add(updatedetailslabelstudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 50, 130, 40));

        jSeparator2.setBackground(new java.awt.Color(153, 153, 153));
        studentpanel.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 1050, 30));

        addstudentpanel.setBackground(new java.awt.Color(255, 255, 255));
        addstudentpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton4.setBackground(new java.awt.Color(31, 46, 85));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setForeground(new java.awt.Color(255, 255, 255));
        jButton4.setText("Save");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        addstudentpanel.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 300, 100, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Date of Birth :");
        addstudentpanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 100, 30));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Student Name :");
        addstudentpanel.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 100, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Email :");
        addstudentpanel.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 100, 30));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Batch Code :");
        addstudentpanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 190, 100, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Gender :");
        addstudentpanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 50, 100, 30));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Enrollment No :");
        addstudentpanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 120, 100, 30));

        emaill.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emaill.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        emaill.setPreferredSize(new java.awt.Dimension(62, 21));
        emaill.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emaillActionPerformed(evt);
            }
        });
        addstudentpanel.add(emaill, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 120, 210, 30));

        snamel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        snamel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        snamel.setPreferredSize(new java.awt.Dimension(62, 21));
        addstudentpanel.add(snamel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 50, 210, 30));

        enroll.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enroll.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        enroll.setPreferredSize(new java.awt.Dimension(62, 21));
        addstudentpanel.add(enroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 120, 210, 30));

        genderl.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        genderl.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "male", "female" }));
        genderl.setPreferredSize(new java.awt.Dimension(62, 21));
        addstudentpanel.add(genderl, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 210, 30));

        bcodel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bcodel.setPreferredSize(new java.awt.Dimension(62, 21));
        bcodel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                bcodelItemStateChanged(evt);
            }
        });
        bcodel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                bcodelMouseClicked(evt);
            }
        });
        addstudentpanel.add(bcodel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 210, 30));

        dobl.setBackground(new java.awt.Color(255, 255, 255));
        dobl.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        addstudentpanel.add(dobl, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 210, 30));

        addstudentreset.setBackground(new java.awt.Color(31, 46, 85));
        addstudentreset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        addstudentreset.setForeground(new java.awt.Color(255, 255, 255));
        addstudentreset.setText("Reset");
        addstudentreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addstudentresetActionPerformed(evt);
            }
        });
        addstudentpanel.add(addstudentreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 300, 100, 40));

        studentpanel.add(addstudentpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1010, 520));

        displaystudentpanel.setBackground(new java.awt.Color(255, 255, 255));
        displaystudentpanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Class Code :");
        displaystudentpanel.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 90, -1));

        cc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ccActionPerformed(evt);
            }
        });
        displaystudentpanel.add(cc, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 15, 110, 30));

        jTable2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable2.setColorBackgoundHead(new java.awt.Color(31, 46, 85));
        jTable2.setColorBordeFilas(new java.awt.Color(255, 255, 255));
        jTable2.setColorFilasForeground1(new java.awt.Color(0, 0, 0));
        jTable2.setColorFilasForeground2(new java.awt.Color(0, 0, 0));
        jTable2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setFuenteFilas(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setFuenteFilasSelect(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jTable2.setRowHeight(30);
        jTable2.setShowGrid(false);
        jScrollPane11.setViewportView(jTable2);

        displaystudentpanel.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 970, 440));

        studentpanel.add(displaystudentpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1010, 520));

        updatedetailspanelstudent.setBackground(new java.awt.Color(255, 255, 255));
        updatedetailspanelstudent.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Student Name :");
        updatedetailspanelstudent.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 100, 30));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setText("Batch Code :");
        updatedetailspanelstudent.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 190, 100, 30));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Gender :");
        updatedetailspanelstudent.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, 100, 30));

        searchid.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchid.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        searchid.setPreferredSize(new java.awt.Dimension(62, 21));
        updatedetailspanelstudent.add(searchid, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, 230, 30));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Enrollment No :");
        updatedetailspanelstudent.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 100, 30));

        email.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        email.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        email.setPreferredSize(new java.awt.Dimension(62, 21));
        updatedetailspanelstudent.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 210, 30));

        enrol.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enrol.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        enrol.setPreferredSize(new java.awt.Dimension(62, 21));
        updatedetailspanelstudent.add(enrol, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 210, 30));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setText("Date of Birth :");
        updatedetailspanelstudent.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 130, 100, 30));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setText("Email :");
        updatedetailspanelstudent.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 190, 50, 30));

        updatestudent.setBackground(new java.awt.Color(31, 46, 85));
        updatestudent.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updatestudent.setForeground(new java.awt.Color(255, 255, 255));
        updatestudent.setText("Update");
        updatestudent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatestudentActionPerformed(evt);
            }
        });
        updatedetailspanelstudent.add(updatestudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 340, 100, 40));

        jSeparator3.setForeground(new java.awt.Color(0, 0, 0));
        updatedetailspanelstudent.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 1114, 20));

        sname.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        sname.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        sname.setPreferredSize(new java.awt.Dimension(62, 21));
        sname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                snameActionPerformed(evt);
            }
        });
        updatedetailspanelstudent.add(sname, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 210, 30));

        jButton8.setBackground(new java.awt.Color(31, 46, 85));
        jButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Search");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        updatedetailspanelstudent.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, 90, 34));
        updatedetailspanelstudent.add(dobbb, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 130, 210, 30));

        gen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        gen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        updatedetailspanelstudent.add(gen, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 210, 30));

        bcode.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        bcode.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        updatedetailspanelstudent.add(bcode, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 190, 210, 30));

        updatestudentreset.setBackground(new java.awt.Color(31, 46, 85));
        updatestudentreset.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updatestudentreset.setForeground(new java.awt.Color(255, 255, 255));
        updatestudentreset.setText("Reset");
        updatestudentreset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updatestudentresetActionPerformed(evt);
            }
        });
        updatedetailspanelstudent.add(updatestudentreset, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, 100, 40));

        studentpanel.add(updatedetailspanelstudent, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1010, 520));

        deletestudentlabel.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        deletestudentlabel.setText("     Delete Details");
        deletestudentlabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deletestudentlabelMouseClicked(evt);
            }
        });
        studentpanel.add(deletestudentlabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 150, 40));

        studentdeletepanel.setBackground(new java.awt.Color(255, 255, 255));
        studentdeletepanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        enroll_delete.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        enroll_delete.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        enroll_delete.setPreferredSize(new java.awt.Dimension(62, 21));
        studentdeletepanel.add(enroll_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 40, 210, 30));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel33.setText("Enrollment No :");
        studentdeletepanel.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, -1, 30));

        deletestudentb.setBackground(new java.awt.Color(31, 46, 85));
        deletestudentb.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        deletestudentb.setForeground(new java.awt.Color(255, 255, 255));
        deletestudentb.setText("Delete");
        deletestudentb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deletestudentbActionPerformed(evt);
            }
        });
        studentdeletepanel.add(deletestudentb, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 120, 110, 43));

        studentpanel.add(studentdeletepanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 1010, 520));

        getContentPane().add(studentpanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, 1070, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void assignbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignbuttonActionPerformed

        db.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        teacherbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        assignbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 6, 0, 0, new java.awt.Color(255, 255, 255)));
        profile1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));




        try {
            classpanel.setVisible(false);
            teacherpanel.setVisible(false);
            dashboardpanel.setVisible(false);
            studentpanel.setVisible(false);
            subjectpanel.setVisible(false);
            logoutpanel.setVisible(false);
            assignpanel.setVisible(true);
            addassign.setVisible(true);
            assigndisplay.setVisible(false);
            fillTeacher();
            fillclass();
            fillSubject();
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, ex);
        }
        
        
        
        
        
        
        
         
    }//GEN-LAST:event_assignbuttonActionPerformed

    private void teacherbuttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherbuttonActionPerformed
        // TODO add your handling code here:
        
        db.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        teacherbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 6, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        assignbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        profile1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));

        
        
        addteacherlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        teacherpanel.setVisible(true);
        dashboardpanel.setVisible(false);
                studentpanel.setVisible(false);
                subjectpanel.setVisible(false);
                classpanel.setVisible(false);
                assignpanel.setVisible(false);
                 addteacherpanel.setVisible(true);
                  displayteacherpanel.setVisible(false);
                 updatedetailspanel.setVisible(false);
                 deletedetailspanel.setVisible(false);
                 logoutpanel.setVisible(false);
                 
        
    }//GEN-LAST:event_teacherbuttonActionPerformed

    private void rSButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton3ActionPerformed
        // TODO add your handling code here:

        db.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        teacherbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 6, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        assignbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        profile1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));



        addstudentlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        teacherpanel.setVisible(false);
        dashboardpanel.setVisible(false);
                studentpanel.setVisible(true);
                subjectpanel.setVisible(false);
                classpanel.setVisible(false);
        assignpanel.setVisible(false);
        addstudentpanel.setVisible(true);
        displaystudentpanel.setVisible(false);
        updatedetailspanelstudent.setVisible(false);
        studentdeletepanel.setVisible(false);
        logoutpanel.setVisible(false);
        
        try {
            fillCombobox();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rSButton3ActionPerformed

    private void rSButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton4ActionPerformed
//        

        db.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        teacherbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 6, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        assignbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        profile1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));



addsubjectlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

                teacherpanel.setVisible(false);
                studentpanel.setVisible(false);
                subjectpanel.setVisible(true);
                dashboardpanel.setVisible(false);
                classpanel.setVisible(false);
                assignpanel.setVisible(false);
                addsubject.setVisible(true);
                displaysubject.setVisible(false);
                logoutpanel.setVisible(false);
        
    }//GEN-LAST:event_rSButton4ActionPerformed

    private void teacherbuttonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_teacherbuttonMouseClicked
        // TODO add your handling code here:
       
    }//GEN-LAST:event_teacherbuttonMouseClicked

    private void LogOutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_LogOutMouseClicked
        // TODO add your handling code here:
                jPanel1.setVisible(false);
                classpanel.setVisible(false);
                 teacherpanel.setVisible(false);
                 studentpanel.setVisible(false);
                 subjectpanel.setVisible(false);
                 assignpanel.setVisible(false);
                 logoutpanel.setVisible(true);
                logout.setVisible(true);
         
    }//GEN-LAST:event_LogOutMouseClicked

    private void displaystudentlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displaystudentlabelMouseClicked
        // TODO add your handling code here:
         addstudentlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        displaystudentlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        updatedetailslabelstudent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
deletestudentlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        studentdeletepanel.setVisible(false);
        addstudentpanel.setVisible(false);
        displaystudentpanel.setVisible(true);
        updatedetailspanelstudent.setVisible(false);
        
        try {
            fillComboboxInStudentDisplay();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }//GEN-LAST:event_displaystudentlabelMouseClicked

    private void addstudentlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addstudentlabelMouseClicked
        // TODO add your handling code here:
        addstudentlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        displaystudentlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        updatedetailslabelstudent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
deletestudentlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        studentdeletepanel.setVisible(false);
        addstudentpanel.setVisible(true);
        displaystudentpanel.setVisible(false);
        updatedetailspanelstudent.setVisible(false);
    }//GEN-LAST:event_addstudentlabelMouseClicked

    private void updatedetailslabelstudentMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedetailslabelstudentMouseClicked
        // TODO add your handling code here:
          addstudentlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        displaystudentlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        updatedetailslabelstudent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
deletestudentlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        studentdeletepanel.setVisible(false);
        addstudentpanel.setVisible(false);
        displaystudentpanel.setVisible(false);
        updatedetailspanelstudent.setVisible(true);
    }//GEN-LAST:event_updatedetailslabelstudentMouseClicked

    private void save_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_save_buttonActionPerformed
        // TODO add your handling code here:
        String tId =  teacher_id_input.getText();
                String tName =  teacher_name_input.getText();
                String tAddress =  teacher_address_input.getText();
                long tPhone =  Long.parseLong(teacher_phone_input.getText());
                String tEmail =  teacher_email_input1.getText();
                String tGender =  (String) teacher_gender_input.getSelectedItem();
                String tPassword =  teacher_password_input.getText();
                
                functionality.Teacher t1 = new functionality.Teacher();
                t1.insertTeacher(tId,tName,tAddress,tPhone,tEmail,tGender,tPassword);        
    }//GEN-LAST:event_save_buttonActionPerformed

    private void update_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_update_buttonActionPerformed
        // TODO add your handling code here:
           String tId1 =  teacher_id_input1.getText();
                String tName1 =  u_teacher_name_input.getText();
                String tAddress1 =  u_teacher_address_input.getText();
                long tPhone1 =  Long.parseLong(u_teacher_phone_input.getText());
                String tEmail1 =  u_teacher_email_input.getText();
                String tGender1 =  (String) u_teacher_gender_input.getText();
//                String tPassword =  teacher_password_input.getText();
                
                functionality.Teacher t2 = new functionality.Teacher();
                t2.updateTeacher(tId1,tName1,tAddress1,tPhone1,tEmail1,tGender1);  
    }//GEN-LAST:event_update_buttonActionPerformed

    private void addsubjectlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addsubjectlabelMouseClicked
        
         addsubjectlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        displaysubjectlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        
        displaysubject.setVisible(false);
        addsubject.setVisible(true);
    }//GEN-LAST:event_addsubjectlabelMouseClicked

    private void displaysubjectlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displaysubjectlabelMouseClicked
        addsubjectlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        displaysubjectlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        
        displaysubject.setVisible(true);
        addsubject.setVisible(false);
        
           try
        {
            Connection conn = databaseConnection.connection();
            Statement stmt=null;
            stmt= conn.createStatement();
            
            String sql ="SELECT * FROM SUBJECT ";
            ResultSet res = stmt.executeQuery(sql);
            
            showSubject.setModel(DbUtils.resultSetToTableModel(res));
            
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null,e); }
    }//GEN-LAST:event_displaysubjectlabelMouseClicked

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        // TODO add your handling code here:
        
        String sid = (String)idt.getText();
        String sname = (String) namet.getText();
        String des = (String) dt.getText();
            
        new Subject().addSubject(sid,sname,des);
        
    }//GEN-LAST:event_jButton10ActionPerformed

    private void addbatchlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addbatchlabelMouseClicked
      addbatchlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        displaybatchlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        updatebatchlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
      //  deletebatchlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        addbatchpanel.setVisible(true);
        updatebatch.setVisible(false);
        displaybatch.setVisible(false);
       // deletebatch.setVisible(false);
    }//GEN-LAST:event_addbatchlabelMouseClicked

    private void displaybatchlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displaybatchlabelMouseClicked
        addbatchlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        displaybatchlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        updatebatchlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
       // deletebatchlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        addbatchpanel.setVisible(false);
        updatebatch.setVisible(false);
        displaybatch.setVisible(true);
        //deletebatch.setVisible(false);
        
         try
        {
            Connection conn = databaseConnection.connection();
            Statement stmt=null;
            stmt= conn.createStatement();
            
            String sql ="SELECT * FROM class ";
            ResultSet res = stmt.executeQuery(sql);
            
            showClass.setModel(DbUtils.resultSetToTableModel(res));
            
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null,e); }
        
        
    }//GEN-LAST:event_displaybatchlabelMouseClicked

    private void updatebatchlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatebatchlabelMouseClicked
        addbatchlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        displaybatchlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        updatebatchlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
      //  deletebatchlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));

        addbatchpanel.setVisible(false);
        updatebatch.setVisible(true);
        displaybatch.setVisible(false);
       // deletebatch.setVisible(false);
    }//GEN-LAST:event_updatebatchlabelMouseClicked

    private void rSButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rSButton2ActionPerformed

        
        db.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        teacherbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 6, 0, 0, new java.awt.Color(255, 255, 255)));
        assignbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        profile1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        
        
        
                addbatchlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));

        classpanel.setVisible(true);
                 teacherpanel.setVisible(false);
                 studentpanel.setVisible(false);
                 subjectpanel.setVisible(false);
                assignpanel.setVisible(false);
                addbatchpanel.setVisible(true);
                dashboardpanel.setVisible(false);
                displaybatch.setVisible(false);
                updatebatch.setVisible(false);
              
                logoutpanel.setVisible(false);
    }//GEN-LAST:event_rSButton2ActionPerformed

    private void search_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_search_buttonActionPerformed
        // TODO add your handling code here:
        
         try
        {
            Connection conn = databaseConnection.connection();
            Statement stmt = conn.createStatement();
            ResultSet rs=null;
            
            String searchTeacherIp = search_teacher_input.getText();
            String sql = "SELECT * FROM attendance.teacher WHERE teacher_id='"+searchTeacherIp+"'";                                                                                                 
            rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                 teacher_id_input1.setText(rs.getString("teacher_id"));
                 u_teacher_name_input.setText(rs.getString("teacher_name"));
                 u_teacher_address_input.setText(rs.getString("address"));
                 u_teacher_phone_input.setText(rs.getString("phone"));
                 u_teacher_email_input.setText(rs.getString("email"));
                 u_teacher_gender_input.setText(rs.getString("gender"));  
             }  
            else{
               JOptionPane.showMessageDialog(null, "Record Not Found");
            }
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }  
    }//GEN-LAST:event_search_buttonActionPerformed

    private void emaillActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emaillActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emaillActionPerformed

    private void snameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_snameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_snameActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        
        String sname= snamel.getText();
       
      
        String email= emaill.getText();
        String bcode= (String)bcodel.getSelectedItem();
        String gender = (String)genderl.getSelectedItem();
        String enrol = enroll.getText();
        
        boolean v =Validator.isValid(email);
        if(v !=true)
        {
           
            try {
                throw  new InvalidEmailException();
            } catch (InvalidEmailException ex) {
                
            }
           
        }
        else
        {
    
        SimpleDateFormat  d = new SimpleDateFormat("yyyy-MM-DD");
        String theDate = d.format(dobl.getDate());
        
       
        try {
            new Student().addStudent(sname,email,bcode,gender,theDate,enrol);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void uClassCode1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uClassCode1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_uClassCode1ActionPerformed

    private void addteacherlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addteacherlabelMouseClicked
        // TODO add your handling code here:

        addteacherlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        displayteacherlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
       updatedetailslabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        deletedetailslabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        deletedetailspanel.setVisible(false);
        addteacherpanel.setVisible(true);
        displayteacherpanel.setVisible(false);
        updatedetailspanel.setVisible(false);
    }//GEN-LAST:event_addteacherlabelMouseClicked

    private void deletedetailslabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletedetailslabelMouseClicked
        // TODO add your handling code here:
        addteacherlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        displayteacherlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        updatedetailslabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        deletedetailslabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        deletedetailspanel.setVisible(true);
        addteacherpanel.setVisible(false);
        displayteacherpanel.setVisible(false);
        updatedetailspanel.setVisible(false);
    }//GEN-LAST:event_deletedetailslabelMouseClicked

    private void displayteacherlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayteacherlabelMouseClicked
        addteacherlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        displayteacherlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        updatedetailslabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        deletedetailslabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        deletedetailspanel.setVisible(false);
        addteacherpanel.setVisible(false);
        displayteacherpanel.setVisible(true);
        updatedetailspanel.setVisible(false);
        
         try
        {
            Connection conn = databaseConnection.connection();
            Statement stmt=null;
            stmt= conn.createStatement();
            
            String sql ="SELECT * FROM TEACHER ";
            ResultSet res = stmt.executeQuery(sql);
            
            //showTeacher1.setModel(DbUtils.resultSetToTableModel(res));
            showTeacher.setModel(DbUtils.resultSetToTableModel(res));

        }
        catch(Exception e){ JOptionPane.showMessageDialog(null,e); }
        
        
    }//GEN-LAST:event_displayteacherlabelMouseClicked

    private void logout_no_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_no_buttonActionPerformed
        // TODO add your handling code here:
        
        logoutpanel.setVisible(false);
        jPanel1.setVisible(true);
        teacherpanel.setVisible(true);
          assignpanel.setVisible(false);
                  addteacherpanel.setVisible(true);
                  displayteacherpanel.setVisible(false);
                 updatedetailspanel.setVisible(false);
                 logoutpanel.setVisible(false);
          
          studentpanel.setVisible(false);
          subjectpanel.setVisible(false);
          classpanel.setVisible(false);
          logoutpanel.setVisible(false);
    }//GEN-LAST:event_logout_no_buttonActionPerformed

    private void logout_yes_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logout_yes_buttonActionPerformed
        // TODO add your handling code here:
        logoutpanel.setVisible(false);
        setVisible(false);
        this.dispose();
        Login lg=new Login();
        lg.setVisible(true);
    }//GEN-LAST:event_logout_yes_buttonActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        try {
            // TODO add your handling code here:
            Connection conn=null;
            ResultSet rs=null;
            Statement stmt=null;
            conn = databaseConnection.connection();
            stmt = conn.createStatement();
            
            String sid = (searchid.getText());
            
            String sql = "SELECT * FROM student WHERE enrollment_no ='"+sid+"'";
            
            rs = stmt.executeQuery(sql);
            
            if(rs.next())
            {
                sname.setText(rs.getString("student_name"));
                email.setText(rs.getString("email"));
                enrol.setText(rs.getString("enrollment_no"));
                gen.setText(rs.getString("gender"));
               
                
                java.util.Date d1 = new SimpleDateFormat("yyyy-MM-DD").parse(rs.getString("dob"));
                dobbb.setDate(d1);
                bcode.setText(rs.getString("class_code"));
               
                
                
                
            }
            else
            {JOptionPane.showMessageDialog(null, "RECORD NOT FOUND !!");}
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }//GEN-LAST:event_jButton8ActionPerformed

    private void updatestudentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatestudentActionPerformed
        // TODO add your handling code here:
          String snae= sname.getText();
       
      
        String em= email.getText();
        String bcod= (String)bcode.getText();
        String genn = (String)gen.getText();
        String enrol = enroll.getText();
        SimpleDateFormat  d = new SimpleDateFormat("yyyy-MM-DD");
        String theDate = d.format(dobl.getDate());
        
        
       
                  try {
         new Student().updateStudent(snae,em,bcod,genn,theDate,enrol);
     } catch (SQLException ex) {
         Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
      }
    }//GEN-LAST:event_updatestudentActionPerformed

    private void bcodelItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_bcodelItemStateChanged
   
    }//GEN-LAST:event_bcodelItemStateChanged

    private void bcodelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_bcodelMouseClicked
        // TODO add your handling code here:
//             try {
//            // TODO add your handling code here:
//            Connection conn = databaseConnection.connection();
//            Statement st = conn.createStatement();
//        
//            ResultSet rr=st.executeQuery("select class_code from attendance.class");
//            
//            while (rr.next()) {
//                
//                String cd = rr.getString("class_code");
//                bcodel.addItem(cd);
//                
//                
//            }
//            
//            
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_bcodelMouseClicked

    private void ac_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ac_saveActionPerformed
        // TODO add your handling code here:
         String classCode = ac_class_code.getText();
        Classes cs = new Classes();
        cs.addClass(classCode);
    }//GEN-LAST:event_ac_saveActionPerformed

    private void ucSearchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ucSearchButtonActionPerformed
        // TODO add your handling code here:
         try
        {
            Connection conn=databaseConnection.connection();
            
            Statement stmt = conn.createStatement();
            
            String searchClass = uClassCode1.getText();
            String sql = "SELECT * FROM attendance.class WHERE class_code='"+searchClass+"'";                                                                                                 
           ResultSet  rs = stmt.executeQuery(sql);
            
            if(rs.next()){
                 uClassCode2.setText(rs.getString("class_code"));
             }  
            else{
               JOptionPane.showMessageDialog(null, "Record Not Found");
            }
            
               conn.close();
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null, e);
        }    
      
    }//GEN-LAST:event_ucSearchButtonActionPerformed

    private void uUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uUpdateButtonActionPerformed
        // TODO add your handling code here:
          String classCode1 =  uClassCode2.getText();
          String srchh = uClassCode1.getText();
        Classes cs1 = new Classes();
        cs1.updateClass(classCode1,srchh);
    }//GEN-LAST:event_uUpdateButtonActionPerformed

    private void profile1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profile1ActionPerformed


        db.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        teacherbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        assignbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        profile1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 6, 0, 0, new java.awt.Color(255, 255, 255)));


        // TODO add your handling code here:
    }//GEN-LAST:event_profile1ActionPerformed

    private void assignbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_assignbActionPerformed
        try {
            // TODO add your handling code here:
            
            String t = (String)techarid.getSelectedItem();
            String s = (String)subjectcode.getSelectedItem();
            String c = (String)classcode.getSelectedItem();
            
            new Assign().assignAll(t, s, c);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        
    }//GEN-LAST:event_assignbActionPerformed

    private void updatedetailslabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updatedetailslabel2MouseClicked
        // TODO add your handling code here:
        addteacherlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        displayteacherlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        updatedetailslabel2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        deletedetailslabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        deletedetailspanel.setVisible(false);
        addteacherpanel.setVisible(false);
        displayteacherpanel.setVisible(false);
        updatedetailspanel.setVisible(true);
    }//GEN-LAST:event_updatedetailslabel2MouseClicked

    private void DeleteTeacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteTeacherActionPerformed
        // TODO add your handling code here:
        int id = Integer.parseInt(teacher_id_input_delete.getText());
        
        try {
            new functionality.Teacher().deleteTeacher(id);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
        
        teacher_id_input_delete.setText("");
        
    }//GEN-LAST:event_DeleteTeacherActionPerformed

    private void deletestudentbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletestudentbActionPerformed
        // TODO add your handling code here:
         int i = Integer.parseInt(enroll_delete.getText());
        
        try {
            new functionality.Student().deleteStudent(i);
        } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null, ex);
        }
        
        enroll_delete.setText("");
    }//GEN-LAST:event_deletestudentbActionPerformed

    private void deletestudentlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deletestudentlabelMouseClicked
        // TODO add your handling code here:
        addstudentlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        displaystudentlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        updatedetailslabelstudent.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
        deletestudentlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
        studentdeletepanel.setVisible(true);
        addstudentpanel.setVisible(false);
        displaystudentpanel.setVisible(false);
        updatedetailspanelstudent.setVisible(false);
    }//GEN-LAST:event_deletestudentlabelMouseClicked

    private void dashboardlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardlabelMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_dashboardlabelMouseClicked

    private void dbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dbActionPerformed
        // TODO add your handling code here:
//        db.setBackground(new java.awt.Color(255, 255, 255));
        db.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 6, 0, 0, new java.awt.Color(255, 255, 255)));
        teacherbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton3.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton4.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        rSButton2.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        assignbutton.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        profile1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(255, 255, 255)));
        
        studentpanel.setVisible(false);
                subjectpanel.setVisible(false);
                classpanel.setVisible(false);
                assignpanel.setVisible(false);
                teacherpanel.setVisible(false);
                dashboardpanel.setVisible(true);
                logoutpanel.setVisible(false);
        try {
            dashboardData();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_dbActionPerformed

    private void techaridMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_techaridMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_techaridMouseClicked

    private void resetaddteacherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetaddteacherActionPerformed
        // TODO add your handling code here:
          teacher_id_input.setText("");
           teacher_name_input.setText("");
                teacher_address_input.setText("");
                teacher_phone_input.setText("");
                 teacher_email_input1.setText("");
                 teacher_password_input.setText("");
        
    }//GEN-LAST:event_resetaddteacherActionPerformed

    private void teacherupdateresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_teacherupdateresetActionPerformed
         teacher_id_input1.setText("");
                  u_teacher_name_input.setText("");
               u_teacher_address_input.setText("");
               u_teacher_phone_input.setText("");
                 u_teacher_email_input.setText("");
              
    }//GEN-LAST:event_teacherupdateresetActionPerformed

    private void addstudentresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addstudentresetActionPerformed
        // TODO add your handling code here:
        snamel.setText("");
        emaill.setText("");
        enroll.setText("");
    }//GEN-LAST:event_addstudentresetActionPerformed

    private void updatestudentresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatestudentresetActionPerformed
        sname.setText("");
        email.setText("");
        bcode.setText("");
        gen.setText("");
       enroll.setText("");
        
        searchid.setText("");
    }//GEN-LAST:event_updatestudentresetActionPerformed

    private void subjectresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_subjectresetActionPerformed
        // TODO add your handling code here:
          idt.setText("");
         namet.setText("");
       dt.setText("");
    }//GEN-LAST:event_subjectresetActionPerformed

    private void addclassresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addclassresetActionPerformed
        // TODO add your handling code here:
        ac_class_code.setText("");
    }//GEN-LAST:event_addclassresetActionPerformed

    private void updatebatchresetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updatebatchresetActionPerformed
        // TODO add your handling code here:
        
            uClassCode2.setText("");
          uClassCode1.setText("");
    }//GEN-LAST:event_updatebatchresetActionPerformed

    private void deletebatchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deletebatchActionPerformed
        try {
            // TODO add your handling code here:
            String i =uClassCode1.getText();
            
            new Classes().deleteClass(i);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_deletebatchActionPerformed

    private void assignlabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assignlabelMouseClicked
        // TODO add your handling code here:
        addassign.setVisible(true);
        assigndisplay.setVisible(false);

            assignlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
             assigndisplaylabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
    }//GEN-LAST:event_assignlabelMouseClicked

    private void assigndisplaylabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_assigndisplaylabelMouseClicked
        // TODO add your handling code here:
         addassign.setVisible(false);
         assigndisplay.setVisible(true);
            assignlabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 0, 0, new java.awt.Color(0, 0, 0)));
             assigndisplaylabel.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(0, 0, 0)));
             
             
             
              try
        {
            Connection conn = databaseConnection.connection();
            Statement stmt=null;
            stmt= conn.createStatement();
            
            String sql ="SELECT * FROM SUBJECT_ASSIGN ";
            ResultSet res = stmt.executeQuery(sql);
            
            assigntable.setModel(DbUtils.resultSetToTableModel(res));
            
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null,e); }
         
        
    }//GEN-LAST:event_assigndisplaylabelMouseClicked

    private void ccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ccActionPerformed
        // TODO add your handling code here:
        String c = (String)cc.getSelectedItem();
         try
        {
            Connection conn = databaseConnection.connection();
            Statement stmt=null;
            stmt= conn.createStatement();
            
            String sql ="SELECT * FROM student where class_code='"+c+"'  ";
            ResultSet res = stmt.executeQuery(sql);
            
            jTable2.setModel(DbUtils.resultSetToTableModel(res));
            
        }
        catch(Exception e){ JOptionPane.showMessageDialog(null,e); }
    }//GEN-LAST:event_ccActionPerformed

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
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new Admin().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteTeacher;
    private javax.swing.JLabel LogOut;
    private javax.swing.JTextField ac_class_code;
    private javax.swing.JButton ac_save;
    private javax.swing.JPanel addassign;
    private javax.swing.JLabel addbatchlabel;
    private javax.swing.JPanel addbatchpanel;
    private javax.swing.JButton addclassreset;
    private javax.swing.JLabel addstudentlabel;
    private javax.swing.JPanel addstudentpanel;
    private javax.swing.JButton addstudentreset;
    private javax.swing.JPanel addsubject;
    private javax.swing.JLabel addsubjectlabel;
    private javax.swing.JLabel addteacherlabel;
    private javax.swing.JPanel addteacherpanel;
    private javax.swing.JButton assignb;
    private rojeru_san.RSButton assignbutton;
    private javax.swing.JPanel assigndisplay;
    private javax.swing.JLabel assigndisplaylabel;
    private javax.swing.JLabel assignlabel;
    private javax.swing.JPanel assignpanel;
    private rojerusan.RSTableMetro assigntable;
    private javax.swing.JTextField bcode;
    public javax.swing.JComboBox<String> bcodel;
    private javax.swing.JComboBox<String> cc;
    private javax.swing.JComboBox<String> classcode;
    private javax.swing.JPanel classpanel;
    private javax.swing.JLabel dashboardlabel;
    private javax.swing.JPanel dashboardpanel;
    private rojeru_san.RSButton db;
    private javax.swing.JButton deletebatch;
    private javax.swing.JLabel deletedetailslabel;
    private javax.swing.JPanel deletedetailspanel;
    private javax.swing.JButton deletestudentb;
    private javax.swing.JLabel deletestudentlabel;
    private javax.swing.JPanel displaybatch;
    private javax.swing.JLabel displaybatchlabel;
    private javax.swing.JLabel displaystudentlabel;
    private javax.swing.JPanel displaystudentpanel;
    private javax.swing.JPanel displaysubject;
    private javax.swing.JLabel displaysubjectlabel;
    private javax.swing.JLabel displayteacherlabel;
    private javax.swing.JPanel displayteacherpanel;
    private com.toedter.calendar.JDateChooser dobbb;
    private com.toedter.calendar.JDateChooser dobl;
    private javax.swing.JTextArea dt;
    private javax.swing.JTextField email;
    private javax.swing.JTextField emaill;
    private javax.swing.JTextField enrol;
    private javax.swing.JTextField enroll;
    private javax.swing.JTextField enroll_delete;
    private javax.swing.JTextField gen;
    private javax.swing.JComboBox<String> genderl;
    private javax.swing.JPanel header;
    private javax.swing.JTextField idt;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator9;
    private rojerusan.RSTableMetro jTable2;
    private javax.swing.JPanel logout;
    private javax.swing.JButton logout_no_button;
    private javax.swing.JButton logout_yes_button;
    private javax.swing.JPanel logoutpanel;
    private javax.swing.JTextField namet;
    private javax.swing.JLabel noOfStuds;
    private javax.swing.JLabel noOfTechs;
    private javax.swing.JLabel noOfclasses;
    private rojeru_san.RSButton profile1;
    private rojeru_san.RSButton rSButton2;
    private rojeru_san.RSButton rSButton3;
    private rojeru_san.RSButton rSButton4;
    private javax.swing.JButton resetaddteacher;
    private javax.swing.JButton save_button;
    private javax.swing.JButton search_button;
    private javax.swing.JTextField search_teacher_input;
    private javax.swing.JTextField searchid;
    private rojerusan.RSTableMetro showClass;
    private rojerusan.RSTableMetro showSubject;
    private rojerusan.RSTableMetro showTeacher;
    private javax.swing.JTextField sname;
    private javax.swing.JTextField snamel;
    private javax.swing.JPanel studentdeletepanel;
    private javax.swing.JPanel studentpanel;
    private javax.swing.JComboBox<String> subjectcode;
    private javax.swing.JPanel subjectpanel;
    private javax.swing.JButton subjectreset;
    private javax.swing.JTextField teacher_address_input;
    private javax.swing.JTextField teacher_email_input1;
    private javax.swing.JComboBox<String> teacher_gender_input;
    private javax.swing.JTextField teacher_id_input;
    private javax.swing.JTextField teacher_id_input1;
    private javax.swing.JTextField teacher_id_input_delete;
    private javax.swing.JTextField teacher_name_input;
    private javax.swing.JTextField teacher_password_input;
    private javax.swing.JTextField teacher_phone_input;
    private rojeru_san.RSButton teacherbutton;
    private javax.swing.JPanel teacherpanel;
    private javax.swing.JButton teacherupdatereset;
    private javax.swing.JComboBox<String> techarid;
    private javax.swing.JLabel ttClasses;
    private javax.swing.JLabel ttStuds;
    private javax.swing.JLabel ttTechs;
    private javax.swing.JTextField uClassCode1;
    private javax.swing.JTextField uClassCode2;
    private javax.swing.JButton uUpdateButton;
    private javax.swing.JTextField u_teacher_address_input;
    private javax.swing.JTextField u_teacher_email_input;
    private javax.swing.JTextField u_teacher_gender_input;
    private javax.swing.JTextField u_teacher_name_input;
    private javax.swing.JTextField u_teacher_phone_input;
    private javax.swing.JButton ucSearchButton;
    private javax.swing.JButton update_button;
    private javax.swing.JPanel updatebatch;
    private javax.swing.JLabel updatebatchlabel;
    private javax.swing.JButton updatebatchreset;
    private javax.swing.JLabel updatedetailslabel2;
    private javax.swing.JLabel updatedetailslabelstudent;
    private javax.swing.JPanel updatedetailspanel;
    private javax.swing.JPanel updatedetailspanelstudent;
    private javax.swing.JButton updatestudent;
    private javax.swing.JButton updatestudentreset;
    // End of variables declaration//GEN-END:variables
}
