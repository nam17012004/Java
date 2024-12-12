/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReviewCode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author NAM
 */
public class CodeDeleteButton {
    private CodeFetchData fetchData;
    private CodeClearText clearText;

    // Constructor nhận vào CodeFetchData và CodeClearText
    public CodeDeleteButton(CodeFetchData fetchData, CodeClearText clearText) {
        this.fetchData = fetchData;
        this.clearText = clearText;
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
                fetchData.fetchDataAccountLogin(Data_Accounts); // Cập nhật lại bảng sau khi xóa
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
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
                fetchData.fetchDataCustomers(Data_Customers); // Cập nhật lại bảng sau khi cập nhật

                clearText.ClearTextCustomers(IDCus_field,NameCus_Field,PhoneNum_Field,Email_Field,Address_Field);
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
                fetchData.fetchDataEmployees(Data_Employee); // Cập nhật lại bảng sau khi thêm
                clearText.ClearTextEmployees(IDEmploy_Field,NameEmploy_Field,Position_Field,PhoneNum_Field, Email_Field);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
            fetchData.fetchDataInforBikes(DataTableBikes); 
            JOptionPane.showMessageDialog(null, "Xóa thông tin thành công");
            
            clearText.ClearTextInforBikes(ID_Trans, Name_Trans, Brand_Trans, Style_Trans, Price_Trans, quantity_Trans);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Không xóa được thông tin");
        }
    }
}
