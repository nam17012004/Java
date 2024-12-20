/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package qlchxd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/**
 *
 * @author Admin
 */
public class Home_Page extends javax.swing.JFrame {    
    /**
     * Creates new form MainFrame
     */
    public Home_Page(String username, String userRole, String hoTen, String soDienThoai) {
        initComponents();
        setUserInfo(username, userRole, hoTen, soDienThoai);
        
        if ("Nhan vien".equals(userRole)) {
            Employees_btn.setEnabled(false);  //Vô hiệu háo nút
//            Employees_btn.setVisible(false); //Ẩn nút
            Accounts_btn.setEnabled(false);
//            Accounts_btn.setVisible(false); 
        }
    }

    private void setUserInfo(String username, String userRole, String hoTen, String soDienThoai) {
    // Thiết lập thông tin ban đầu cho nhãn
        Name_label.setText("Họ tên: " + hoTen);
        PhoneNum_label.setText("Số điện thoại: " + soDienThoai);
        Accounts_label.setText("Tài khoản: " + username);
        Position_label.setText("Chức vụ: " + userRole);
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopControl = new javax.swing.JDesktopPane();
        imgPanel1 = new baitap1.imgPanel();
        Label_Main1 = new javax.swing.JLabel();
        Label_Main = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Label_Main2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        Option_Panel = new javax.swing.JPanel();
        Information_btn = new javax.swing.JButton();
        Customers_btn = new javax.swing.JButton();
        Employees_btn = new javax.swing.JButton();
        Bill_btn = new javax.swing.JButton();
        RentBikes_btn = new javax.swing.JButton();
        Accounts_btn = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        LogOut_btn = new javax.swing.JButton();
        Main_label = new javax.swing.JLabel();
        Name_label = new javax.swing.JLabel();
        PhoneNum_label = new javax.swing.JLabel();
        Accounts_label = new javax.swing.JLabel();
        Position_label = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý cửa hàng xe đạp");

        desktopControl.setBackground(new java.awt.Color(153, 255, 255));
        desktopControl.setPreferredSize(new java.awt.Dimension(1200, 700));

        imgPanel1.setBackgroundImage(new javax.swing.ImageIcon(getClass().getResource("/icon/ImgMain.png"))); // NOI18N

        Label_Main1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        Label_Main1.setForeground(new java.awt.Color(255, 255, 255));
        Label_Main1.setText("QUẢN LÝ CỬA HÀNG XE ĐẠP ");

        Label_Main.setFont(new java.awt.Font("Algerian", 1, 48)); // NOI18N
        Label_Main.setForeground(new java.awt.Color(255, 255, 255));
        Label_Main.setText("HUY NAM");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/Logo3.png"))); // NOI18N
        jLabel2.setPreferredSize(new java.awt.Dimension(200, 200));

        Label_Main2.setFont(new java.awt.Font("Algerian", 1, 48)); // NOI18N
        Label_Main2.setForeground(new java.awt.Color(255, 255, 255));
        Label_Main2.setText("HUY NAM");

        jLabel1.setFont(new java.awt.Font("Cambria Math", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("THƯƠNG HIỆU UY TÍN TẠO NÊN ĐẲNG CẤP NGƯỜI DÙNG");

        javax.swing.GroupLayout imgPanel1Layout = new javax.swing.GroupLayout(imgPanel1);
        imgPanel1.setLayout(imgPanel1Layout);
        imgPanel1Layout.setHorizontalGroup(
            imgPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imgPanel1Layout.createSequentialGroup()
                .addContainerGap(261, Short.MAX_VALUE)
                .addGroup(imgPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imgPanel1Layout.createSequentialGroup()
                        .addComponent(Label_Main1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Label_Main))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imgPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(270, 270, 270))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imgPanel1Layout.createSequentialGroup()
                        .addComponent(Label_Main2)
                        .addGap(254, 254, 254))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imgPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(177, 177, 177)))
                .addContainerGap(222, Short.MAX_VALUE))
        );
        imgPanel1Layout.setVerticalGroup(
            imgPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imgPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(imgPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Label_Main)
                    .addComponent(Label_Main1))
                .addGap(139, 139, 139)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addComponent(Label_Main2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addContainerGap(219, Short.MAX_VALUE))
        );

        desktopControl.setLayer(imgPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout desktopControlLayout = new javax.swing.GroupLayout(desktopControl);
        desktopControl.setLayout(desktopControlLayout);
        desktopControlLayout.setHorizontalGroup(
            desktopControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        desktopControlLayout.setVerticalGroup(
            desktopControlLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imgPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        Option_Panel.setBackground(new java.awt.Color(0, 102, 102));
        Option_Panel.setPreferredSize(new java.awt.Dimension(200, 700));

        Information_btn.setText("THÔNG TIN XE ĐẠP");
        Information_btn.setPreferredSize(new java.awt.Dimension(120, 40));
        Information_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Information_btnActionPerformed(evt);
            }
        });

        Customers_btn.setText("QUẢN LÝ KHÁCH HÀNG");
        Customers_btn.setPreferredSize(new java.awt.Dimension(160, 40));
        Customers_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Customers_btnActionPerformed(evt);
            }
        });

        Employees_btn.setText("QUẢN LÝ NHÂN VIÊN");
        Employees_btn.setPreferredSize(new java.awt.Dimension(140, 40));
        Employees_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Employees_btnActionPerformed(evt);
            }
        });

        Bill_btn.setText("QUẢN LÝ BÁN HÀNG");
        Bill_btn.setPreferredSize(new java.awt.Dimension(120, 40));
        Bill_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Bill_btnActionPerformed(evt);
            }
        });

        RentBikes_btn.setText("QUẢN LÝ THUÊ XE");
        RentBikes_btn.setPreferredSize(new java.awt.Dimension(140, 40));
        RentBikes_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RentBikes_btnActionPerformed(evt);
            }
        });

        Accounts_btn.setText("QUẢN LÝ TÀI KHOẢN");
        Accounts_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Accounts_btnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Option_PanelLayout = new javax.swing.GroupLayout(Option_Panel);
        Option_Panel.setLayout(Option_PanelLayout);
        Option_PanelLayout.setHorizontalGroup(
            Option_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Option_PanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(Option_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Customers_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Information_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Employees_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Bill_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RentBikes_btn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Accounts_btn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        Option_PanelLayout.setVerticalGroup(
            Option_PanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Option_PanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Information_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Customers_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Bill_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(RentBikes_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Employees_btn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Accounts_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(255, 255, 0));
        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 51, 51), 2, true));

        LogOut_btn.setFont(new java.awt.Font("Segoe UI", 0, 10)); // NOI18N
        LogOut_btn.setText("Đăng xuất");
        LogOut_btn.setPreferredSize(new java.awt.Dimension(80, 30));
        LogOut_btn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogOut_btnActionPerformed(evt);
            }
        });

        Main_label.setFont(new java.awt.Font("Verdana", 1, 12)); // NOI18N
        Main_label.setText("THÔNG TIN TÀI KHOẢN");

        Name_label.setText("Họ tên:");

        PhoneNum_label.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        PhoneNum_label.setText("SĐT:");

        Accounts_label.setText("Tài khoản:");

        Position_label.setFont(new java.awt.Font("Calibri", 0, 12)); // NOI18N
        Position_label.setText("Chức vụ:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(56, 56, 56)
                        .addComponent(LogOut_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Accounts_label)
                                    .addComponent(Position_label)
                                    .addComponent(PhoneNum_label)
                                    .addComponent(Name_label)))
                            .addComponent(Main_label))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(Main_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Name_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PhoneNum_label)
                .addGap(0, 0, 0)
                .addComponent(Accounts_label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Position_label)
                .addGap(18, 18, 18)
                .addComponent(LogOut_btn, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Option_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(desktopControl, javax.swing.GroupLayout.DEFAULT_SIZE, 1205, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Option_Panel, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE))
            .addComponent(desktopControl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void Information_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Information_btnActionPerformed
        Infor_Bikes Infor = new Infor_Bikes();
        desktopControl.add(Infor);
        Infor.setVisible(true);
        Infor.moveToFront();       
    }//GEN-LAST:event_Information_btnActionPerformed

    private void Customers_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Customers_btnActionPerformed
        Customers custom = new Customers();
        desktopControl.add(custom);
        // Hiển thị cửa sổ đăng nhập
        custom.setVisible(true);
        custom.moveToFront();
    }//GEN-LAST:event_Customers_btnActionPerformed

    private void Bill_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Bill_btnActionPerformed
        Payments pay= new Payments();
        desktopControl.add(pay);
        pay.setVisible(true);
        pay.moveToFront();
    }//GEN-LAST:event_Bill_btnActionPerformed

    private void Employees_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Employees_btnActionPerformed
        Employees employee = new Employees();
        desktopControl.add(employee);
        employee.setVisible(true);
        employee.moveToFront();
    }//GEN-LAST:event_Employees_btnActionPerformed

    private void RentBikes_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RentBikes_btnActionPerformed
        Rent_Bikes rent = new Rent_Bikes();
        desktopControl.add(rent);
        rent.setVisible(true);
        rent.moveToFront();
    }//GEN-LAST:event_RentBikes_btnActionPerformed

    private void LogOut_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogOut_btnActionPerformed
        Home_withoutSignIn signin = new Home_withoutSignIn();
 
        signin.setVisible(true);

        this.dispose();

    }//GEN-LAST:event_LogOut_btnActionPerformed

    private void Accounts_btnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Accounts_btnActionPerformed
        AccountLogin acc = new AccountLogin();
        desktopControl.add(acc);
        acc.setVisible(true);
        acc.moveToFront();
    }//GEN-LAST:event_Accounts_btnActionPerformed

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
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home_Page.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new Home_Page().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Accounts_btn;
    private javax.swing.JLabel Accounts_label;
    private javax.swing.JButton Bill_btn;
    private javax.swing.JButton Customers_btn;
    private javax.swing.JButton Employees_btn;
    private javax.swing.JButton Information_btn;
    private javax.swing.JLabel Label_Main;
    private javax.swing.JLabel Label_Main1;
    private javax.swing.JLabel Label_Main2;
    private javax.swing.JButton LogOut_btn;
    private javax.swing.JLabel Main_label;
    private javax.swing.JLabel Name_label;
    private javax.swing.JPanel Option_Panel;
    private javax.swing.JLabel PhoneNum_label;
    private javax.swing.JLabel Position_label;
    private javax.swing.JButton RentBikes_btn;
    private javax.swing.JDesktopPane desktopControl;
    private baitap1.imgPanel imgPanel1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel3;
    // End of variables declaration//GEN-END:variables
}
