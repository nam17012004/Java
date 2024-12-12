/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ReviewCode;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author NAM
 */
public class DataMouseClick {
    public void Data_AccountsMouseClicked(JTable Data_Accounts,JTextField Name_Field,JTextField PhoneNum_Field,JTextField Acc_Field,JTextField Pass_Field,JComboBox ComboBox_Position){
        int i = Data_Accounts.getSelectedRow();
        Name_Field.setText(Data_Accounts.getValueAt(i, 0).toString());
        PhoneNum_Field.setText(Data_Accounts.getValueAt(i, 1).toString());       
        Acc_Field.setText(Data_Accounts.getValueAt(i, 2).toString());
        Pass_Field.setText(Data_Accounts.getValueAt(i, 3).toString());
        ComboBox_Position.setSelectedItem(Data_Accounts.getValueAt(i, 4).toString());
    }
    
    public void CustomersMouseClicked(JTable Data_Customers,JTextField IDCus_field,JTextField NameCus_Field,JTextField Email_Field,JTextField Address_Field,JTextField PhoneNum_Field){
        int i = Data_Customers.getSelectedRow();
        IDCus_field.setText(Data_Customers.getValueAt(i, 0).toString());
        NameCus_Field.setText(Data_Customers.getValueAt(i, 1).toString());
        PhoneNum_Field.setText(Data_Customers.getValueAt(i, 2).toString());
        Email_Field.setText(Data_Customers.getValueAt(i, 3).toString());
        Address_Field.setText(Data_Customers.getValueAt(i, 4).toString());
                                              
    }
    
    public void EmployeesMouseClicked(JTable Data_Employee,JTextField IDEmploy_Field,JTextField NameEmploy_Field,JTextField Position_Field,JTextField Email_Field,JTextField PhoneNum_Field){
    int i = Data_Employee.getSelectedRow();
        IDEmploy_Field.setText(Data_Employee.getValueAt(i, 0).toString());
        NameEmploy_Field.setText(Data_Employee.getValueAt(i, 1).toString());
        Position_Field.setText(Data_Employee.getValueAt(i, 2).toString());
        PhoneNum_Field.setText(Data_Employee.getValueAt(i, 3).toString());
        Email_Field.setText(Data_Employee.getValueAt(i, 4).toString());
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
}
