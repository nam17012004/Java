/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReviewCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import qlchxd.FrmSignIn;

/**
 *
 * @author NAM
 */
public class CodeSignUp {
    public void SignUp_btnActionPerformed(JTextField UserName_Field, JTextField PhoneNum_Field, JTextField UserAcc_Field, JPasswordField Password_Field, JPasswordField Password_Field1){
        String name = UserName_Field.getText().trim();
        String phone = PhoneNum_Field.getText().trim();
        String username = UserAcc_Field.getText().trim();
        String password = new String(Password_Field.getPassword());
        String confirmPassword = new String(Password_Field1.getPassword());

        //Kiểm tra xem điền thông tin chưa
        if (name.isEmpty() || phone.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin!", "Cảnh báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        // Kiểm tra xem mật khẩu có khớp không
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(null, "Mật khẩu không khớp. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Kết nối đến cơ sở dữ liệu
        String url = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true"; 
        String user = "sa"; // Thay đổi tên người dùng
        String pass = "123456789"; // Thay đổi mật khẩu

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            // Kiểm tra xem tài khoản đã tồn tại
            String checkSql = "SELECT COUNT(*) FROM DangNhap WHERE ID = ?";
            try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
                checkStmt.setString(1, username);
                ResultSet rs = checkStmt.executeQuery();
                if (rs.next() && rs.getInt(1) > 0) {
                    JOptionPane.showMessageDialog(null, "Tên tài khoản đã có sẵn, vui lòng dùng tên khác.", "Lỗi", JOptionPane.ERROR_MESSAGE);
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
                    JOptionPane.showMessageDialog(null, "Đợi xác nhận từ Quản lý", "Thành công", JOptionPane.INFORMATION_MESSAGE);
                    // Xóa thông tin sau khi đăng ký thành công
                    UserName_Field.setText("");
                    PhoneNum_Field.setText("");
                    UserAcc_Field.setText("");
                    Password_Field.setText("");
                    Password_Field1.setText("");

                    FrmSignIn signInFrame = new FrmSignIn(); 
                    signInFrame.setVisible(true); 
                    signInFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Có lỗi xảy ra. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Có lỗi xảy ra: " + e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void CheckBox_ShowPassFrmSignUp(JCheckBox CheckBox_ShowPass,JPasswordField Password_Field,JPasswordField Password_Field1){
        if (CheckBox_ShowPass.isSelected()) {   
            Password_Field.setEchoChar((char) 0); 
            Password_Field1.setEchoChar((char) 0);
        } else {       
            Password_Field.setEchoChar('●');
            Password_Field1.setEchoChar('●');
        }
    }
}
