/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package qlchxd;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FrmLogin extends javax.swing.JPanel {

    private String userRole;
    
    public FrmLogin() {
        initComponents();
        setupPlaceholderBehavior();
    }

    public class DatabaseConnection {
        private static final String URL = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true"; 
        private static final String USER = "sa"; // Tên người dùng SQL Server
        private static final String PASSWORD = "123456789"; // Mật khẩu SQL Server

        public static Connection getConnection() throws SQLException {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        }
    }

    private void setupPlaceholderBehavior() {
        Username_Field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (Username_Field.getText().equals("Username")) {
                    Username_Field.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (Username_Field.getText().isEmpty()) {
                    Username_Field.setText("Username");
                }
            }
        });

        Password_Field.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(Password_Field.getPassword()).equals("jPasswordField1")) {
                    Password_Field.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(Password_Field.getPassword()).isEmpty()) {
                    Password_Field.setText("jPasswordField1");
                }
            }
        });
    }

    private void onLoginButtonClicked() {
        String username = Username_Field.getText();
        String password = String.valueOf(Password_Field.getPassword());

        if (isValidLogin(username, password)) {
            userRole = getUserRole(username);
            JOptionPane.showMessageDialog(this, "Đăng nhập thành công! Bạn là: " + userRole);

            // Sử dụng constructor mới để truyền userRole
            Home_Page home = new Home_Page(username, userRole);
            home.setVisible(true);
            this.setVisible(false);
        } else {
            JOptionPane.showMessageDialog(this, "Tên người dùng hoặc mật khẩu không hợp lệ.");
        }
    }

    private boolean isValidLogin(String username, String password) {
    try (Connection connection = DatabaseConnection.getConnection()) {
        String query = "SELECT PASS FROM DangNhap WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                // Lấy mật khẩu từ cơ sở dữ liệu
                String passwordFromDB = resultSet.getString("PASS");

                // So sánh mật khẩu người dùng nhập với mật khẩu từ DB
                return password.equals(passwordFromDB);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false; // Trả về false nếu không tìm thấy người dùng
}

//===========================================Xu ly Password dạng băm===================================================//
//    private boolean isValidLogin(String username, String password) {
//        try (Connection connection = DatabaseConnection.getConnection()) {
//            String query = "SELECT PASS FROM DangNhap WHERE ID = ?";
//            try (PreparedStatement statement = connection.prepareStatement(query)) {
//                statement.setString(1, username);
//
//                ResultSet resultSet = statement.executeQuery();
//                if (resultSet.next()) {
//                    // Lấy mật khẩu đã băm từ cơ sở dữ liệu
//                    byte[] hashedPasswordFromDB = resultSet.getBytes("PASS");
//
//                    // Băm mật khẩu người dùng nhập
//                    byte[] hashedInputPassword = hashPassword(password);
//
//                    // So sánh mật khẩu đã băm
//                    return java.util.Arrays.equals(hashedPasswordFromDB, hashedInputPassword);
//                }
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return false; // Trả về false nếu không tìm thấy người dùng
//    }
//
//    private byte[] hashPassword(String password) {
//        try {
//            java.security.MessageDigest digest = java.security.MessageDigest.getInstance("SHA-256");
//            return digest.digest(password.getBytes("UTF-8"));
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
    
    private String getUserRole(String username) {
        String role = null;
        try (Connection connection = DatabaseConnection.getConnection()) {
            String sql = "SELECT ROLE FROM DangNhap WHERE ID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                role = resultSet.getString("ROLE");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return role;
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Panel_DangNhap = new javax.swing.JPanel();
        Username_Field = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Login_btn = new javax.swing.JButton();
        Password_Field = new javax.swing.JPasswordField();
        Label_DangNhap = new java.awt.Label();
        Label_MatKhau = new java.awt.Label();
        Label_TaiKhoan = new java.awt.Label();
        Label_SignUp = new java.awt.Label();
        SignUp_btn = new javax.swing.JButton();
        CheckBox_ShowPass = new javax.swing.JCheckBox();
        Panel_Logo = new javax.swing.JPanel();
        Logo = new javax.swing.JLabel();
        Label_Logo = new java.awt.Label();
        Label_Slogan = new java.awt.Label();

        Panel_DangNhap.setBackground(new java.awt.Color(255, 255, 255));
        Panel_DangNhap.setPreferredSize(new java.awt.Dimension(500, 500));

        Username_Field.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        Username_Field.setForeground(new java.awt.Color(0, 102, 51));
        Username_Field.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, new java.awt.Color(0, 51, 51)));
        Username_Field.setPreferredSize(new java.awt.Dimension(80, 30));
        Username_Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Username_FieldActionPerformed(evt);
            }
        });

        Login_btn.setBackground(new java.awt.Color(0, 149, 118));
        Login_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        Login_btn.setForeground(new java.awt.Color(255, 255, 255));
        Login_btn.setText("ĐĂNG NHẬP");
        Login_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Login_btnActionPerformed(evt);
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
        Label_DangNhap.setText("ĐĂNG NHẬP");

        Label_MatKhau.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        Label_MatKhau.setText("Mật khẩu");

        Label_TaiKhoan.setFont(new java.awt.Font("Courier New", 1, 18)); // NOI18N
        Label_TaiKhoan.setText("Tài khoản");

        Label_SignUp.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        Label_SignUp.setText("Chưa có tài khoản ?");

        SignUp_btn.setBackground(new java.awt.Color(0, 149, 118));
        SignUp_btn.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        SignUp_btn.setForeground(new java.awt.Color(255, 255, 255));
        SignUp_btn.setText("ĐĂNG KÝ");
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

        javax.swing.GroupLayout Panel_DangNhapLayout = new javax.swing.GroupLayout(Panel_DangNhap);
        Panel_DangNhap.setLayout(Panel_DangNhapLayout);
        Panel_DangNhapLayout.setHorizontalGroup(
            Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                        .addGap(114, 114, 114)
                        .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Label_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(Username_Field, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                                    .addGap(10, 10, 10)
                                    .addComponent(Label_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(Password_Field, javax.swing.GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE))))
                    .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                        .addGap(124, 124, 124)
                        .addComponent(Label_SignUp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SignUp_btn))
                    .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addComponent(Login_btn)))
                .addContainerGap(116, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_DangNhapLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(CheckBox_ShowPass)
                .addGap(39, 39, 39))
            .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                    .addGap(124, 124, 124)
                    .addComponent(Label_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(273, Short.MAX_VALUE)))
        );
        Panel_DangNhapLayout.setVerticalGroup(
            Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(Label_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(75, 75, 75)
                .addComponent(Username_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_MatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(Password_Field, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CheckBox_ShowPass)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(Login_btn)
                .addGap(18, 18, 18)
                .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SignUp_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Label_SignUp, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29))
            .addGroup(Panel_DangNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(Panel_DangNhapLayout.createSequentialGroup()
                    .addGap(136, 136, 136)
                    .addComponent(Label_TaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(339, Short.MAX_VALUE)))
        );

        Panel_Logo.setBackground(new java.awt.Color(0, 102, 102));
        Panel_Logo.setPreferredSize(new java.awt.Dimension(500, 500));

        Logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo3.png"))); // NOI18N

        Label_Logo.setFont(new java.awt.Font("Algerian", 1, 48)); // NOI18N
        Label_Logo.setForeground(new java.awt.Color(255, 255, 255));
        Label_Logo.setText("HUY NAM");

        Label_Slogan.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        Label_Slogan.setForeground(new java.awt.Color(255, 255, 255));
        Label_Slogan.setText("THƯƠNG HIỆU UY TÍN HÀNG ĐẦU VIỆT NAM");

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
                        .addGap(92, 92, 92)
                        .addComponent(Label_Slogan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        Panel_LogoLayout.setVerticalGroup(
            Panel_LogoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_LogoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Logo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Slogan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(151, 151, 151))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Panel_Logo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(Panel_DangNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_DangNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(Panel_Logo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void Username_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Username_FieldActionPerformed

    }//GEN-LAST:event_Username_FieldActionPerformed

    private void Login_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Login_btnActionPerformed
        onLoginButtonClicked();
    }//GEN-LAST:event_Login_btnActionPerformed

    private void SignUp_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SignUp_btnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SignUp_btnActionPerformed
   
    private void CheckBox_ShowPassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CheckBox_ShowPassActionPerformed
        if (CheckBox_ShowPass.isSelected()) {
        // Nếu checkbox được chọn, hiển thị mật khẩu
        Password_Field.setEchoChar((char) 0); // Hiển thị mật khẩu
        } else {
            // Nếu checkbox không được chọn, ẩn mật khẩu
            Password_Field.setEchoChar('●'); // Đặt lại ký tự ẩn
        }
    }//GEN-LAST:event_CheckBox_ShowPassActionPerformed

    private void Password_FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Password_FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Password_FieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox CheckBox_ShowPass;
    private java.awt.Label Label_DangNhap;
    private java.awt.Label Label_Logo;
    private java.awt.Label Label_MatKhau;
    private java.awt.Label Label_SignUp;
    private java.awt.Label Label_Slogan;
    private java.awt.Label Label_TaiKhoan;
    private javax.swing.JButton Login_btn;
    private javax.swing.JLabel Logo;
    private javax.swing.JPanel Panel_DangNhap;
    private javax.swing.JPanel Panel_Logo;
    private javax.swing.JPasswordField Password_Field;
    private javax.swing.JButton SignUp_btn;
    private javax.swing.JTextField Username_Field;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
