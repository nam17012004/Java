/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlchxd;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.ResultSet; 

/**
 *
 * @author Admin
 */
public class FrmSignUp extends javax.swing.JFrame {

    /**
     * Creates new form FrmSignUp
     */
    public FrmSignUp() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Logo_Panel = new javax.swing.JPanel();
        Form_Panel = new javax.swing.JPanel();
        Panel_DangNhap = new javax.swing.JPanel();
        UserAcc_Field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Password_Field = new javax.swing.JPasswordField();
        Label_DangNhap = new java.awt.Label();
        Label_MatKhau = new java.awt.Label();
        Label_TaiKhoan = new java.awt.Label();
        SignUp_btn = new javax.swing.JButton();
        CheckBox_ShowPass = new javax.swing.JCheckBox();
        Password_Field1 = new javax.swing.JPasswordField();
        Label_MatKhau1 = new java.awt.Label();
        jLabel3 = new javax.swing.JLabel();
        PhoneNum_Field = new javax.swing.JTextField();
        Label_SDT = new java.awt.Label();
        UserName_Field = new javax.swing.JTextField();
        Label_HoTen = new java.awt.Label();
        SignIn_Label = new javax.swing.JLabel();
        Back_Label = new javax.swing.JLabel();
        Panel_Logo = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Label_Logo = new java.awt.Label();
        Label_Slogan = new java.awt.Label();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Đăng ký");

        Panel_DangNhap.setBackground(new java.awt.Color(255, 255, 255));
        Panel_DangNhap.setPreferredSize(new java.awt.Dimension(500, 500));

        UserAcc_Field.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        UserAcc_Field.setForeground(new java.awt.Color(0, 102, 51));
        UserAcc_Field.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 51, 51)));
        UserAcc_Field.setPreferredSize(new java.awt.Dimension(80, 30));
        UserAcc_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserAcc_FieldActionPerformed(evt);
            }
        });

        Password_Field.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Password_Field.setForeground(new java.awt.Color(0, 102, 51));
        Password_Field.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 102, 102)));
        Password_Field.setPreferredSize(new java.awt.Dimension(100, 30));
        Password_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Password_FieldActionPerformed(evt);
            }
        });

        Label_DangNhap.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Label_DangNhap.setForeground(new java.awt.Color(0, 102, 102));
        Label_DangNhap.setText("ĐĂNG KÝ");

        Label_MatKhau.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        Label_MatKhau.setText("Nhập mật khẩu");

        Label_TaiKhoan.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        Label_TaiKhoan.setText("Nhập tên tài khoản");

        SignUp_btn.setBackground(new java.awt.Color(0, 149, 118));
        SignUp_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SignUp_btn.setForeground(new java.awt.Color(255, 255, 255));
        SignUp_btn.setText("ĐĂNG KÝ");
        SignUp_btn.setMaximumSize(new java.awt.Dimension(140, 32));
        SignUp_btn.setMinimumSize(new java.awt.Dimension(140, 32));
        SignUp_btn.setPreferredSize(new java.awt.Dimension(140, 30));
        SignUp_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SignUp_btnActionPerformed(evt);
            }
        });

        CheckBox_ShowPass.setText("Hiển thị mật khẩu");
        CheckBox_ShowPass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CheckBox_ShowPassActionPerformed(evt);
            }
        });

        Password_Field1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        Password_Field1.setForeground(new java.awt.Color(0, 102, 51));
        Password_Field1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 102, 102)));
        Password_Field1.setPreferredSize(new java.awt.Dimension(100, 30));
        Password_Field1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Password_Field1ActionPerformed(evt);
            }
        });

        Label_MatKhau1.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        Label_MatKhau1.setText("Nhập lại mật khẩu");

        jLabel3.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        jLabel3.setText("Đã có tài khoản ?");

        PhoneNum_Field.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        PhoneNum_Field.setForeground(new java.awt.Color(0, 102, 51));
        PhoneNum_Field.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 51, 51)));
        PhoneNum_Field.setPreferredSize(new java.awt.Dimension(80, 30));
        PhoneNum_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PhoneNum_FieldActionPerformed(evt);
            }
        });

        Label_SDT.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        Label_SDT.setText("Nhập số điện thoại");

        UserName_Field.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        UserName_Field.setForeground(new java.awt.Color(0, 102, 51));
        UserName_Field.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 51, 51)));
        UserName_Field.setPreferredSize(new java.awt.Dimension(80, 30));
        UserName_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UserName_FieldActionPerformed(evt);
            }
        });

        Label_HoTen.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        Label_HoTen.setText("Nhập họ tên");

        SignIn_Label.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SignIn_Label.setForeground(new java.awt.Color(0, 102, 102));
        SignIn_Label.setText("ĐĂNG NHẬP");
        SignIn_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SignIn_LabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                SignIn_LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                SignIn_LabelMouseExited(evt);
            }
        });

        Back_Label.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Back_Label.setText("<< Trở lại");
        Back_Label.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Back_LabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                Back_LabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                Back_LabelMouseExited(evt);
            }
        });

        javax.swing.GroupLayout Panel_DangNhapLayout = new javax.swing.GroupLayout(Panel_DangNhap);
        Panel_DangNhap.setLayout(Panel_DangNhapLayout);
        Panel_DangNhapLayout.setHorizontalGroup(
            Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                        .addGap(309, 309, 309)
                        .addComponent(CheckBox_ShowPass))
                    .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                        .addGap(126, 126, 126)
                        .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                                .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                                            .addGap(9, 9, 9)
                                            .addComponent(Label_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(UserName_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(Label_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(UserAcc_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(Label_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(Password_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Password_Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(Label_MatKhau1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(Label_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(PhoneNum_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                                .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(SignIn_Label)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_DangNhapLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_DangNhapLayout.createSequentialGroup()
                        .addComponent(Back_Label)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_DangNhapLayout.createSequentialGroup()
                        .addComponent(Label_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(157, 157, 157))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_DangNhapLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(SignUp_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(173, 173, 173))
        );
        Panel_DangNhapLayout.setVerticalGroup(
            Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                        .addComponent(Back_Label)
                        .addGap(188, 188, 188)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_DangNhapLayout.createSequentialGroup()
                        .addGap(0, 25, Short.MAX_VALUE)
                        .addComponent(Label_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(Label_HoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(UserName_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_SDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(PhoneNum_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(UserAcc_Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(Label_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(Password_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_MatKhau1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, 0)
                        .addComponent(Password_Field1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CheckBox_ShowPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(SignUp_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(SignIn_Label))
                .addGap(13, 13, 13))
        );

        Panel_Logo.setBackground(new java.awt.Color(0, 102, 102));
        Panel_Logo.setPreferredSize(new java.awt.Dimension(500, 500));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo3.png"))); // NOI18N

        Label_Logo.setFont(new java.awt.Font("Algerian", 1, 48)); // NOI18N
        Label_Logo.setForeground(new java.awt.Color(255, 255, 255));
        Label_Logo.setText("HUY NAM");

        Label_Slogan.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        Label_Slogan.setForeground(new java.awt.Color(255, 255, 255));
        Label_Slogan.setText("THƯƠNG HIỆU UY TÍN TẠO NÊN ĐẲNG CẤP NGƯỜI DÙNG");

        javax.swing.GroupLayout Panel_LogoLayout = new javax.swing.GroupLayout(Panel_Logo);
        Panel_Logo.setLayout(Panel_LogoLayout);
        Panel_LogoLayout.setHorizontalGroup(
            Panel_LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_LogoLayout.createSequentialGroup()
                .addGroup(Panel_LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_LogoLayout.createSequentialGroup()
                        .addGap(142, 142, 142)
                        .addComponent(Logo))
                    .addGroup(Panel_LogoLayout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(Label_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panel_LogoLayout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(Label_Slogan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(93, Short.MAX_VALUE))
        );
        Panel_LogoLayout.setVerticalGroup(
            Panel_LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_LogoLayout.createSequentialGroup()
                .addContainerGap(128, Short.MAX_VALUE)
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Slogan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );

        javax.swing.GroupLayout Form_PanelLayout = new javax.swing.GroupLayout(Form_Panel);
        Form_Panel.setLayout(Form_PanelLayout);
        Form_PanelLayout.setHorizontalGroup(
            Form_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Form_PanelLayout.createSequentialGroup()
                .addComponent(Panel_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Panel_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        Form_PanelLayout.setVerticalGroup(
            Form_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_Logo, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
            .addComponent(Panel_DangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 531, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout Logo_PanelLayout = new javax.swing.GroupLayout(Logo_Panel);
        Logo_Panel.setLayout(Logo_PanelLayout);
        Logo_PanelLayout.setHorizontalGroup(
            Logo_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(Logo_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Logo_PanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Form_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        Logo_PanelLayout.setVerticalGroup(
            Logo_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
            .addGroup(Logo_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Logo_PanelLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Form_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1000, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Logo_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Logo_Panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void UserAcc_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserAcc_FieldActionPerformed

    }//GEN-LAST:event_UserAcc_FieldActionPerformed

    private void Password_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Password_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Password_FieldActionPerformed

    private void SignUp_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUp_btnActionPerformed
        String name = UserName_Field.getText().trim();
        String phone = PhoneNum_Field.getText().trim();
        String username = UserAcc_Field.getText().trim();
        String password = new String(Password_Field.getPassword());
        String confirmPassword = new String(Password_Field1.getPassword());

        //Kiểm tra xem điền thông tin chưa
        if (name.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Vui lòng điền đầy đủ thông tin!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Kiểm tra xem mật khẩu có khớp không
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Mật khẩu không khớp. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true"; 
        String user = "sa"; // Thay đổi tên người dùng
        String pass = "123456789"; // Thay đổi mật khẩu

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            // Kiểm tra xem tài khoản đã tồn tại
            String checkSql = "SELECT COUNT(*) FROM DangNhap WHERE ID = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setString(1, username);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(this, "Tên tài khoản đã có sẵn, vui lòng dùng tên khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

            // Nếu tài khoản không tồn tại, tiếp tục thực hiện đăng ký
            String sql = "INSERT INTO DangNhap (HoTen, SoDienThoai, ID, PASS, ROLE) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, name);
                pstmt.setString(2, phone);
                pstmt.setString(3, username);
                pstmt.setString(4, password);
                pstmt.setString(5, "user"); 

                int rowsAffected = pstmt.executeUpdate();

                if (rowsAffected > 0) {
                    JOptionPane.showMessageDialog(this, "Đợi xác nhận từ Quản lý", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                    // Xóa thông tin sau khi đăng ký thành công
                    UserName_Field.setText("");
                    PhoneNum_Field.setText("");
                    UserAcc_Field.setText("");
                    Password_Field.setText("");
                    Password_Field1.setText("");

                    FrmSignIn signInFrame = new FrmSignIn(); 
                    signInFrame.setVisible(true); 
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Có lỗi xảy ra. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Có lỗi xảy ra: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_SignUp_btnActionPerformed

    private void CheckBox_ShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBox_ShowPassActionPerformed
        if (CheckBox_ShowPass.isSelected()) {   
            Password_Field.setEchoChar((char) 0); 
            Password_Field1.setEchoChar((char) 0);
        } else {       
            Password_Field.setEchoChar('●');
            Password_Field1.setEchoChar('●');
        }
    }//GEN-LAST:event_CheckBox_ShowPassActionPerformed

    private void Password_Field1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Password_Field1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Password_Field1ActionPerformed

    private void PhoneNum_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PhoneNum_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_PhoneNum_FieldActionPerformed

    private void UserName_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UserName_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_UserName_FieldActionPerformed

    private void SignIn_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignIn_LabelMouseClicked
        FrmSignIn login = new FrmSignIn();
        login.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_SignIn_LabelMouseClicked

    private void Back_LabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Back_LabelMouseClicked
        Home_withoutSignIn Homews = new Home_withoutSignIn();
 
        Homews.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Back_LabelMouseClicked

    private void SignIn_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignIn_LabelMouseEntered
        SignIn_Label.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_SignIn_LabelMouseEntered

    private void SignIn_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SignIn_LabelMouseExited
        SignIn_Label.setForeground(new Color(0, 102, 102));
    }//GEN-LAST:event_SignIn_LabelMouseExited

    private void Back_LabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Back_LabelMouseEntered
        Back_Label.setForeground(Color.LIGHT_GRAY);
    }//GEN-LAST:event_Back_LabelMouseEntered

    private void Back_LabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Back_LabelMouseExited
        Back_Label.setForeground(Color.BLACK);
    }//GEN-LAST:event_Back_LabelMouseExited

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(FrmSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(FrmSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(FrmSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(FrmSignUp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new FrmSignUp().setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Back_Label;
    private javax.swing.JCheckBox CheckBox_ShowPass;
    private javax.swing.JPanel Form_Panel;
    private java.awt.Label Label_DangNhap;
    private java.awt.Label Label_HoTen;
    private java.awt.Label Label_Logo;
    private java.awt.Label Label_MatKhau;
    private java.awt.Label Label_MatKhau1;
    private java.awt.Label Label_SDT;
    private java.awt.Label Label_Slogan;
    private java.awt.Label Label_TaiKhoan;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel Logo_Panel;
    private javax.swing.JPanel Panel_DangNhap;
    private javax.swing.JPanel Panel_Logo;
    private javax.swing.JPasswordField Password_Field;
    private javax.swing.JPasswordField Password_Field1;
    private javax.swing.JTextField PhoneNum_Field;
    private javax.swing.JLabel SignIn_Label;
    private javax.swing.JButton SignUp_btn;
    private javax.swing.JTextField UserAcc_Field;
    private javax.swing.JTextField UserName_Field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables
}