/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReviewCode;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import qlchxd.FrmSignIn;
import qlchxd.Home_Page;

/**
 *
 * @author NAM
 */
public class CodeSignIn {
    public void setupPlaceholderBehavior(JTextField Username_Field,JPasswordField Password_Field) {
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

    private void onLoginButtonClicked(JTextField Username_Field,JPasswordField Password_Field,JFrame currentFrame) {
        String username = Username_Field.getText();
        String password = String.valueOf(Password_Field.getPassword());

        if (isValidLogin(username, password)) {
            try (Connection connection = FrmSignIn.DatabaseConnection.getConnection()) {
                String query = "SELECT HoTen, SoDienThoai, ID, ROLE FROM DangNhap WHERE ID = ?";
                PreparedStatement statement = connection.prepareStatement(query);
                statement.setString(1, username);

                ResultSet resultSet = statement.executeQuery();
                if (resultSet.next()) {
                    String hoTen = resultSet.getString("HoTen");
                    String soDienThoai = resultSet.getString("SoDienThoai");
                    String role = resultSet.getString("ROLE");

                    JOptionPane.showMessageDialog(currentFrame, "Đăng nhập thành công! Bạn là: " + role);

                    // Tạo instance của Home_Page với đầy đủ thông tin người dùng
                    Home_Page home = new Home_Page(username, role, hoTen, soDienThoai);
                    home.setVisible(true);
                    currentFrame.setVisible(false);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(currentFrame, "Tên người dùng hoặc mật khẩu không hợp lệ.");
        }
    }

    private boolean isValidLogin(String username, String password) {
    try (Connection connection = FrmSignIn.DatabaseConnection.getConnection()) {
        String query = "SELECT PASS FROM DangNhap WHERE ID = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
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
    
    public static String getUserRole(String username) {
        String role = null;
        try (Connection connection = FrmSignIn.DatabaseConnection.getConnection()) {
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
    
    private void CheckBox_ShowPassFrmSignIn(JCheckBox CheckBox_ShowPass,JPasswordField Password_Field){
        if (CheckBox_ShowPass.isSelected()) {
            Password_Field.setEchoChar((char) 0); 
        } else {
            Password_Field.setEchoChar('●'); 
        }
    }
}
