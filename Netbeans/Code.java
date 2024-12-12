/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package qlchxd;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Color;

/**
 *
 * @author NAM
 */
public class Code {
    public void fetchDataAccountLogin(JTable Data_Accounts) {
        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; // Thay bằng username của bạn
        String password = "123456789"; // Thay bằng password của bạn

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "SELECT HoTen, SoDienThoai, ID, PASS, ROLE FROM DangNhap";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Tạo mô hình cho JTable
            DefaultTableModel model = (DefaultTableModel) Data_Accounts.getModel();
            model.setRowCount(0); // Xóa hết dữ liệu cũ

            // Thêm dữ liệu vào JTable
            while (rs.next()) {
                Object[] row = {
                    rs.getString("HoTen"), 
                    rs.getString("SoDienThoai"),
                    rs.getString("ID"), 
                    rs.getString("PASS"),
                    rs.getString("ROLE"),           
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void SearchDataAccountLogin(JTable Data_Accounts,JTextField Search_field ) {
        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; // Thay bằng username của bạn
        String password = "123456789"; // Thay bằng password của bạn

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "SELECT HoTen, SoDienThoai, ID, PASS, ROLE FROM DangNhap WHERE ID LIKE N'%"+Search_field.getText()+"%' or PASS LIKE N'%"+Search_field.getText()+"%' or HoTen LIKE N'%"+Search_field.getText()+"%'";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Tạo mô hình cho JTable
            DefaultTableModel model = (DefaultTableModel) Data_Accounts.getModel();
            model.setRowCount(0); // Xóa hết dữ liệu cũ

            // Thêm dữ liệu vào JTable
            while (rs.next()) {
                Object[] row = {
                    rs.getString("HoTen"), 
                    rs.getString("SoDienThoai"),
                    rs.getString("ID"), 
                    rs.getString("PASS"),
                    rs.getString("ROLE"),             
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void AddButtonAccountLogin(JTextField Name_Field,JTextField PhoneNum_Field,JTextField Acc_Field,JTextField Pass_Field,JComboBox ComboBox_Position,JTable Data_Accounts){
        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; // Thay bằng username của bạn
        String password = "123456789"; // Thay bằng password của bạn

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "INSERT INTO DangNhap (HoTen, SoDienThoai, ID, PASS, ROLE) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, Name_Field.getText()); 
            pstmt.setString(2, PhoneNum_Field.getText()); 
            pstmt.setString(3, Acc_Field.getText()); 
            pstmt.setString(4, Pass_Field.getText()); 
  
            pstmt.setString(5, ComboBox_Position.getSelectedItem().toString()); 
           
            pstmt.executeUpdate(); // Thực thi truy vấn
            fetchDataAccountLogin(Data_Accounts); // Cập nhật lại dữ liệu hiển thị

            ClearTextAccountLogin(Name_Field,PhoneNum_Field,Acc_Field,Pass_Field);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ClearTextAccountLogin(JTextField Name_Field,JTextField PhoneNum_Field,JTextField Acc_Field,JTextField Pass_Field) {
        Name_Field.setText("");
        PhoneNum_Field.setText("");
        Acc_Field.setText("");
        Pass_Field.setText("");
    }
    
    public void DeleteButtonAccountLogin(JTextField Acc_Field,JTable Data_Accounts){
    String ID = Acc_Field.getText();

        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa";
        String password = "123456789";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "DELETE FROM DangNhap WHERE ID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, ID);
                pstmt.executeUpdate();
                fetchDataAccountLogin(Data_Accounts); // Cập nhật lại bảng sau khi xóa
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
        public void UpdateButtonAccountLogin(JTextField Name_Field,JTextField PhoneNum_Field,JTextField Acc_Field,JTextField Pass_Field,JComboBox ComboBox_Position,JTable Data_Accounts){
            String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; // Thay bằng username của bạn
        String password = "123456789"; // Thay bằng password của bạn

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "UPDATE DangNhap SET HoTen = ?, SoDienThoai = ?, PASS = ?, ROLE = ? WHERE ID = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
           
            pstmt.setString(1, Name_Field.getText()); 
            pstmt.setString(2, PhoneNum_Field.getText()); 
            pstmt.setString(3, Pass_Field.getText());  
            pstmt.setString(4, ComboBox_Position.getSelectedItem().toString()); 
            pstmt.setString(5, Acc_Field.getText()); 
           

            pstmt.executeUpdate(); // Thực thi truy vấn
            fetchDataAccountLogin(Data_Accounts); // Cập nhật lại dữ liệu hiển thị
            ClearTextAccountLogin(Name_Field,PhoneNum_Field,Acc_Field,Pass_Field);
        } catch (Exception e) {
            e.printStackTrace();
        }

        }
    
    public void Data_AccountsMouseClicked(JTable Data_Accounts,JTextField Name_Field,JTextField PhoneNum_Field,JTextField Acc_Field,JTextField Pass_Field,JComboBox ComboBox_Position){
        int i = Data_Accounts.getSelectedRow();
        Name_Field.setText(Data_Accounts.getValueAt(i, 0).toString());
        PhoneNum_Field.setText(Data_Accounts.getValueAt(i, 1).toString());       
        Acc_Field.setText(Data_Accounts.getValueAt(i, 2).toString());
        Pass_Field.setText(Data_Accounts.getValueAt(i, 3).toString());
        ComboBox_Position.setSelectedItem(Data_Accounts.getValueAt(i, 4).toString());
    }
        
     public void Panel_DuLieuMouseClicked(JPanel Panel_ThongTin,JPanel Panel_ChucNang,JPanel Panel_DuLieu ){
         boolean isVisible = Panel_ThongTin.isVisible() && Panel_ChucNang.isVisible();

        // Đổi trạng thái hiển thị của các panel
        Panel_ThongTin.setVisible(!isVisible);
        Panel_ChucNang.setVisible(!isVisible);

        // Điều chỉnh kích thước của Panel_DuLieu dựa trên trạng thái hiển thị
        if (isVisible) {
            Panel_DuLieu.setPreferredSize(new java.awt.Dimension(1000, 600)); // Phóng to 
        } else {
            Panel_DuLieu.setPreferredSize(new java.awt.Dimension(500, 600));  // Trả về 
        }

        // Làm mới lại layout
        Panel_DuLieu.revalidate();
        Panel_DuLieu.repaint();
     }   

     //CUSTOMERS-CODE-----------------------------------------------------------------------------------------
     
        public void fetchDataCustomers(JTable Data_Customers) {
        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; // Thay bằng username của bạn
        String password = "123456789"; // Thay bằng password của bạn

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "SELECT MaKH, HoTen, SoDienThoai, Email, DiaChi FROM KhachHang";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Tạo mô hình cho JTable
            DefaultTableModel model = (DefaultTableModel) Data_Customers.getModel();
            model.setRowCount(0); // Xóa hết dữ liệu cũ

            // Thêm dữ liệu vào JTable
            while (rs.next()) {
                Object[] row = {
                    rs.getString("MaKH"), 
                    rs.getString("HoTen"),
                    rs.getString("SoDienThoai"),
                    rs.getString("Email"),
                    rs.getString("DiaChi"),
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    public void SearchDataCustomers(JTable Data_Customers,JTextField Search_field) {
        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa";
        String password = "123456789"; 

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "SELECT MaKH, HoTen, SoDienThoai, Email, DiaChi FROM KhachHang WHERE MaKH LIKE N'%"+Search_field.getText()+"%' or HoTen LIKE N'%"+Search_field.getText()+"%' or SoDienThoai LIKE N'%"+Search_field.getText()+"%' or Email LIKE N'%"+Search_field.getText()+"%' or DiaChi LIKE N'%"+Search_field.getText()+"%' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Tạo mô hình cho JTable
            DefaultTableModel model = (DefaultTableModel) Data_Customers.getModel();
            model.setRowCount(0); // Xóa hết dữ liệu cũ

            // Thêm dữ liệu vào JTable
            while (rs.next()) {
                Object[] row = {
                    rs.getString("MaKH"), 
                    rs.getString("HoTen"),
                    rs.getString("SoDienThoai"),
                    rs.getString("Email"),
                    rs.getString("DiaChi"),
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void UpdateButtonCustomers(JTextField IDCus_field,JTextField NameCus_Field,JTextField PhoneNum_Field,JTextField Email_Field,JTextField Address_Field ,JComboBox ComboBox_Position,JTable Data_Customers){
        String maKH = IDCus_field.getText();
        String tenKH = NameCus_Field.getText();
        String soDienThoai = PhoneNum_Field.getText();
        String email = Email_Field.getText();
        String diaChi = Address_Field.getText();

        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa";
        String password = "123456789";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "UPDATE KhachHang SET HoTen = ?, SoDienThoai = ?, Email = ?, DiaChi = ? WHERE MaKH = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, tenKH);
                pstmt.setString(2, soDienThoai);
                pstmt.setString(3, email);
                pstmt.setString(4, diaChi);
                pstmt.setString(5, maKH);
                pstmt.executeUpdate();
                fetchDataCustomers(Data_Customers); // Cập nhật lại bảng sau khi cập nhật

                ClearTextCustomers(IDCus_field,NameCus_Field,PhoneNum_Field,Email_Field,Address_Field);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void ClearTextCustomers(JTextField IDCus_field,JTextField NameCus_Field,JTextField PhoneNum_Field,JTextField Email_Field,JTextField Address_Field) {
        IDCus_field.setText("");
        NameCus_Field.setText("");
        PhoneNum_Field.setText("");
        Email_Field.setText("");
        Address_Field.setText("");
    }

        public void DeleteButtonCustomers(JTextField IDCus_field,JTextField NameCus_Field,JTextField PhoneNum_Field,JTextField Email_Field,JTextField Address_Field ,JTable Data_Customers){
         // Xóa khách hàng
        String maKH = IDCus_field.getText();

        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa";
        String password = "123456789";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "DELETE FROM KhachHang WHERE MaKH = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, maKH);
                pstmt.executeUpdate();
                fetchDataCustomers(Data_Customers); // Cập nhật lại bảng sau khi cập nhật

                ClearTextCustomers(IDCus_field,NameCus_Field,PhoneNum_Field,Email_Field,Address_Field);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }   
    }
    
        public void AddButtonCustomers(JTextField IDCus_field,JTextField NameCus_Field,JTextField PhoneNum_Field,JTextField Email_Field,JTextField Address_Field ,JComboBox ComboBox_Position,JTable Data_Customers){
        // Thêm khách hàng
        String maKH = IDCus_field.getText();
        String tenKH = NameCus_Field.getText();
        String soDienThoai = PhoneNum_Field.getText();
        String email = Email_Field.getText();
        String diaChi = Address_Field.getText();

        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa";
        String password = "123456789";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "INSERT INTO KhachHang (MaKH, HoTen, SoDienThoai, Email, DiaChi) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, maKH);
                pstmt.setString(2, tenKH);
                pstmt.setString(3, soDienThoai);
                pstmt.setString(4, email);
                pstmt.setString(5, diaChi);
                
                pstmt.executeUpdate();
                fetchDataCustomers(Data_Customers); // Cập nhật lại bảng sau khi cập nhật

                ClearTextCustomers(IDCus_field,NameCus_Field,PhoneNum_Field,Email_Field,Address_Field);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }    
    
    }
    
    public void CustomersMouseClicked(JTable Data_Customers,JTextField IDCus_field,JTextField NameCus_Field,JTextField Email_Field,JTextField Address_Field,JTextField PhoneNum_Field){
        int i = Data_Customers.getSelectedRow();
        IDCus_field.setText(Data_Customers.getValueAt(i, 0).toString());
        NameCus_Field.setText(Data_Customers.getValueAt(i, 1).toString());
        PhoneNum_Field.setText(Data_Customers.getValueAt(i, 2).toString());
        Email_Field.setText(Data_Customers.getValueAt(i, 3).toString());
        Address_Field.setText(Data_Customers.getValueAt(i, 4).toString());
                                              
    }
    //EMPLOYEES-CODE--------------------------------------------------------------------------------------------------------
    
    public void fetchDataEmployees(JTable Data_Employee) {
        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; 
        String password = "123456789"; 

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "SELECT MaNV, HoTen, ChucVu, SoDienThoai, Email FROM NhanVien";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Tạo mô hình cho JTable
            DefaultTableModel model = (DefaultTableModel) Data_Employee.getModel();
            model.setRowCount(0); 

            // Thêm dữ liệu vào JTable
            while (rs.next()) {
                Object[] row = {
                    rs.getString("MaNV"), 
                    rs.getString("HoTen"),
                    rs.getString("ChucVu"),
                    rs.getString("SoDienThoai"),
                    rs.getString("Email"),
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    public void SearchDataEmployees(JTable Data_Employee,JTextField Search_field) {
        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; 
        String password = "123456789"; 

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "SELECT MaNV, HoTen, ChucVu, SoDienThoai, Email FROM NhanVien WHERE MaNV LIKE N'%"+Search_field.getText()+"%' or HoTen LIKE N'%"+Search_field.getText()+"%' or ChucVu LIKE N'%"+Search_field.getText()+"%' or SoDienThoai LIKE N'%"+Search_field.getText()+"%' or Email LIKE N'%"+Search_field.getText()+"%' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Tạo mô hình cho JTable
            DefaultTableModel model = (DefaultTableModel) Data_Employee.getModel();
            model.setRowCount(0); 

            // Thêm dữ liệu vào JTable
            while (rs.next()) {
                Object[] row = {
                    rs.getString("MaNV"), 
                    rs.getString("HoTen"),
                    rs.getString("ChucVu"),
                    rs.getString("SoDienThoai"),
                    rs.getString("Email"),
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    public void ClearTextEmployees(JTextField IDEmploy_Field,JTextField NameEmploy_Field,JTextField Position_Field,JTextField PhoneNum_Field,JTextField Email_Field) {
        IDEmploy_Field.setText("");
        NameEmploy_Field.setText("");
        Position_Field.setText("");
        PhoneNum_Field.setText("");
        Email_Field.setText("");
    }
    
    public void AddButtonEmployees(JTextField IDEmploy_Field,JTextField NameEmploy_Field,JTextField Position_Field,JTextField PhoneNum_Field,JTextField Email_Field,JTable Data_Employee){
        String maNV = IDEmploy_Field.getText();
        String hoTen = NameEmploy_Field.getText();
        String chucVu = Position_Field.getText();
        String SoDienThoai = PhoneNum_Field.getText();
        String Email = Email_Field.getText();

        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; 
        String password = "123456789";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "INSERT INTO NhanVien (MaNV, HoTen, ChucVu, SoDienThoai, Email) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, maNV);
                pstmt.setString(2, hoTen);
                pstmt.setString(3, chucVu );
                pstmt.setString(4, SoDienThoai);
                pstmt.setString(5, Email);
                pstmt.executeUpdate();
                fetchDataEmployees(Data_Employee); // Cập nhật lại bảng sau khi thêm
                ClearTextEmployees(IDEmploy_Field,NameEmploy_Field,Position_Field,PhoneNum_Field, Email_Field);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void DeleteButtonEmployees(JTextField IDEmploy_Field,JTextField NameEmploy_Field,JTextField Position_Field,JTextField PhoneNum_Field,JTextField Email_Field,JTable Data_Employee){
         String maNV = IDEmploy_Field.getText();

        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa";
        String password = "123456789";

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "DELETE FROM NhanVien WHERE MaNV = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, maNV);
                pstmt.executeUpdate();
                fetchDataEmployees(Data_Employee); // Cập nhật lại bảng sau khi thêm
                ClearTextEmployees(IDEmploy_Field,NameEmploy_Field,Position_Field,PhoneNum_Field, Email_Field);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    
    public void UpdateButtonEmployees(JTextField IDEmploy_Field,JTextField NameEmploy_Field,JTextField Position_Field,JTextField PhoneNum_Field,JTextField Email_Field,JTable Data_Employee){
        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; // Thay bằng username của bạn
        String password = "123456789"; // Thay bằng password của bạn

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "UPDATE NhanVien SET HoTen = ?, ChucVu = ?, SoDienThoai = ?, Email = ? WHERE MaNV = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, NameEmploy_Field.getText());              
            pstmt.setString(2, Position_Field.getText());                
            pstmt.setString(3,  PhoneNum_Field.getText());                
            pstmt.setString(4, Email_Field.getText()); 
            pstmt.setInt(5, Integer.parseInt( IDEmploy_Field.getText()));   

            pstmt.executeUpdate(); // Thực thi truy vấn
            fetchDataEmployees(Data_Employee); // Cập nhật lại bảng sau khi thêm
            ClearTextEmployees(IDEmploy_Field,NameEmploy_Field,Position_Field,PhoneNum_Field, Email_Field);
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
    public void EmployeesMouseClicked(JTable Data_Employee,JTextField IDEmploy_Field,JTextField NameEmploy_Field,JTextField Position_Field,JTextField Email_Field,JTextField PhoneNum_Field){
    int i = Data_Employee.getSelectedRow();
        IDEmploy_Field.setText(Data_Employee.getValueAt(i, 0).toString());
        NameEmploy_Field.setText(Data_Employee.getValueAt(i, 1).toString());
        Position_Field.setText(Data_Employee.getValueAt(i, 2).toString());
        PhoneNum_Field.setText(Data_Employee.getValueAt(i, 3).toString());
        Email_Field.setText(Data_Employee.getValueAt(i, 4).toString());
    }
    
//INFOR_BIKES-CODE--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------    
    
    
    public void fetchDataInforBikes(JTable DataTableBikes) {
        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; 
        String password = "123456789"; 

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "SELECT MaXe, TenXe, HangXe, LoaiXe, GiaBan, SoLuongTonKho FROM ThongTinXeDap ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

           
            DefaultTableModel model = (DefaultTableModel) DataTableBikes.getModel();
            model.setRowCount(0); 

         
            while (rs.next()) {
                Object[] row = {
                    rs.getString("MaXe"),              
                    rs.getString("TenXe"),         
                    rs.getString("HangXe"),       
                    rs.getString("LoaiXe"),         
                    rs.getFloat("GiaBan"),          
                    rs.getInt("SoLuongTonKho")      
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void SearchDataInforBikes(JTable DataTableBikes, JTextField Search_field) {
        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; 
        String password = "123456789"; 

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "SELECT MaXe, TenXe, HangXe, LoaiXe, GiaBan, SoLuongTonKho FROM ThongTinXeDap WHERE HangXe LIKE N'%"+Search_field.getText()+"%' or TenXe LIKE N'%"+Search_field.getText()+"%' or MaXe LIKE N'%"+Search_field.getText()+"%' or LoaiXe LIKE N'%"+Search_field.getText()+"%' or GiaBan LIKE N'%"+Search_field.getText()+"%' or SoLuongTonKho LIKE N'%"+Search_field.getText()+"%' ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // Tạo mô hình cho JTable
            DefaultTableModel model = (DefaultTableModel) DataTableBikes.getModel();
            model.setRowCount(0); // Xóa hết dữ liệu cũ

            // Thêm dữ liệu vào JTable
            while (rs.next()) {
                Object[] row = {
                    rs.getString("MaXe"),               // MaXe kiểu int
                    rs.getString("TenXe"),           // TenXe kiểu String
                    rs.getString("HangXe"),          // HangXe kiểu String
                    rs.getString("LoaiXe"),          // LoaiXe kiểu String
                    rs.getFloat("GiaBan"),           // GiaBan kiểu float
                    rs.getInt("SoLuongTonKho")      
                };
                model.addRow(row);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void InforBikesMouseClicked(JTable DataTableBikes,JTextField ID_Trans,JTextField Name_Trans,JTextField Brand_Trans,JTextField Style_Trans,JTextField Price_Trans,JTextField quantity_Trans){
        int i = DataTableBikes.getSelectedRow();
        ID_Trans.setText(DataTableBikes.getValueAt(i, 0).toString());
        Name_Trans.setText(DataTableBikes.getValueAt(i, 1).toString());
        Brand_Trans.setText(DataTableBikes.getValueAt(i, 2).toString());
        Style_Trans.setText(DataTableBikes.getValueAt(i, 3).toString());
        Price_Trans.setText(DataTableBikes.getValueAt(i, 4).toString());
        quantity_Trans.setText(DataTableBikes.getValueAt(i, 5).toString());
    }
    
    public void AddButtonInforBikes(JTextField ID_Trans,JTextField Name_Trans,JTextField Brand_Trans,JTextField Style_Trans,JTextField Price_Trans,JTextField quantity_Trans,JTable DataTableBikes){
        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; 
        String password = "123456789"; 

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "INSERT INTO ThongTinXeDap (MaXe, TenXe, HangXe, LoaiXe, GiaBan, SoLuongTonKho) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, ID_Trans.getText());  // MaXe
            pstmt.setString(2, Name_Trans.getText());                // TenXe
            pstmt.setString(3, Brand_Trans.getText());                // HangXe
            pstmt.setString(4, Style_Trans.getText());                // LoaiXe
            pstmt.setFloat(5, Float.parseFloat(Price_Trans.getText())); // GiaBan
            pstmt.setInt(6, Integer.parseInt(quantity_Trans.getText()));  // SoLuongTonKho

            pstmt.executeUpdate(); 
            fetchDataInforBikes(DataTableBikes); 
            JOptionPane.showMessageDialog(null, "Thêm thông tin thành công");
            ClearTextInforBikes(ID_Trans, Name_Trans, Brand_Trans, Style_Trans, Price_Trans, quantity_Trans);

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không thêm được thông tin");
        }
    }
    
    public void ClearTextInforBikes(JTextField ID_Trans,JTextField Name_Trans,JTextField Brand_Trans,JTextField Style_Trans,JTextField Price_Trans,JTextField quantity_Trans) {
        Name_Trans.setText("");
        Brand_Trans.setText("");
        Style_Trans.setText("");
        Price_Trans.setText("");
        quantity_Trans.setText("");
        ID_Trans.setText("");
    }
    
    public void DeleteButtonInforBikes(JTextField ID_Trans,JTextField Name_Trans,JTextField Brand_Trans,JTextField Style_Trans,JTextField Price_Trans,JTextField quantity_Trans,JTable DataTableBikes){
        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; 
        String password = "123456789"; 

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "DELETE FROM ThongTinXeDap WHERE MaXe = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, ID_Trans.getText());  // MaXe

            pstmt.executeUpdate(); 
            fetchDataInforBikes(DataTableBikes); 
            JOptionPane.showMessageDialog(null, "Xóa thông tin thành công");
            
            ClearTextInforBikes(ID_Trans, Name_Trans, Brand_Trans, Style_Trans, Price_Trans, quantity_Trans);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không xóa được thông tin");
        }
    }
    
    public void UpdateButtonInforBikes(JTextField ID_Trans,JTextField Name_Trans,JTextField Brand_Trans,JTextField Style_Trans,JTextField Price_Trans,JTextField quantity_Trans,JTable DataTableBikes){
        String connectionUrl = "jdbc:sqlserver://HOMHINHHA\\SQLEXPRESS:1433;databaseName=QLCHXEDAP;trustServerCertificate=true";
        String user = "sa"; 
        String password = "123456789"; 

        try (Connection conn = DriverManager.getConnection(connectionUrl, user, password)) {
            String sql = "UPDATE ThongTinXeDap SET TenXe = ?, HangXe = ?, LoaiXe = ?, GiaBan = ?, SoLuongTonKho = ? WHERE MaXe = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, Name_Trans.getText());                 // TenXe
            pstmt.setString(2, Brand_Trans.getText());                 // HangXe
            pstmt.setString(3, Style_Trans.getText());                 // LoaiXe
            pstmt.setFloat(4, Float.parseFloat(Price_Trans.getText())); // GiaBan
            pstmt.setInt(5, Integer.parseInt(quantity_Trans.getText()));   // SoLuongTonKho
            pstmt.setString(6, ID_Trans.getText());   // MaXe

            pstmt.executeUpdate(); // Thực thi truy vấn
            fetchDataInforBikes(DataTableBikes); 
            JOptionPane.showMessageDialog(null, "Cập nhật thông tin thành công");
            
            ClearTextInforBikes(ID_Trans, Name_Trans, Brand_Trans, Style_Trans, Price_Trans, quantity_Trans);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không cập nhật được thông tin");
        }
    }
 
    //FrmSignIn-Code-----------------------------------------------------------------------------------------
    
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
    
    //SignUp-CODE-----------------------------------------------------------------------------------------------------
    
    
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



