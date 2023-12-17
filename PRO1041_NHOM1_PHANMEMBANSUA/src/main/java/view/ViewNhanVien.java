/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controler.NhanVienServiceImpl;
import static java.awt.image.ImageObserver.WIDTH;
import java.util.Date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import static javax.management.Query.GT;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.NhanVien;

/**
 *
 * @author admin
 */
public class ViewNhanVien extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    List<NhanVien> listnViens = new ArrayList<>();
    NhanVienServiceImpl service = new NhanVienServiceImpl();

    public ViewNhanVien() {
        initComponents();
        dtm = (DefaultTableModel) TBNhanVien.getModel();
        listnViens = service.listNhanVien();
        ShowTable(listnViens);
    }

    private void ShowTable(List<NhanVien> listnViens) {
        listnViens = service.listNhanVien();
        dtm.setRowCount(0);
        int index = 1;
        for (NhanVien nv : listnViens) {
            dtm.addRow(new Object[]{
                index,
                nv.getMaNV(),
                nv.getTenNV(),
                nv.getGioiTinh(),
                nv.getNgaySinh(),
                nv.getSDT(),
                nv.getEmail(),
                nv.getDiaChi(),
                nv.getChucVu(),});
            index++;
        }
    }
    public static int ID_nv;

    private void detail(int index) {
        NhanVien nv = listnViens.get(index);
        ID_nv = nv.getIdNV();
        txtMaNV.setText((String) nv.getMaNV());
        txtTenNV.setText(nv.getTenNV());
        int gioiTinh = nv.getGioiTinh();
        if (gioiTinh == 1) {
            rdNam.setSelected(true);
        } else {
            rdNu.setSelected(true);
        }
        int chucVu = nv.getChucVu();
        if (chucVu == 1) {
            cbbChucVu.setSelectedIndex(0);
        } else if (chucVu == 0) {
            cbbChucVu.setSelectedIndex(1);
        }
        txtSDT.setText(nv.getSDT());
        txtDiaChi.setText(nv.getDiaChi());
        txtEmail.setText(nv.getEmail());
        txtMatKhau.setText(nv.getMatKhau());
        // txtNgaySinh
        txtNgaySinh.setDate(nv.getNgaySinh());
    }

    public NhanVien getData() {
        String ma = txtMaNV.getText();
        String ten = txtTenNV.getText();
        int gioiTinh = 0;
        if (rdNam.isSelected()) {
            gioiTinh = 1;
        } else if (rdNu.isSelected()) {
            gioiTinh = 0;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date NgaySinh = txtNgaySinh.getDate();
        java.sql.Date ngaySinh = null;

        if (NgaySinh != null) {
            ngaySinh = new java.sql.Date(NgaySinh.getTime());
        } else {
            ngaySinh = new java.sql.Date(System.currentTimeMillis());
            System.out.println("NgaySinh is null. Setting it to the current date.");
        }

        String SDT = txtSDT.getText();
        String DiaChi = txtDiaChi.getText();
        String MatKhau = txtMatKhau.getText();
        String email = txtEmail.getText();
        //int ChucVu = Integer.parseInt(txtChucVu.getText());
        int chucVu = 0;
        if (cbbChucVu.getSelectedIndex() == 0) {
            chucVu = 1;
        } else if (cbbChucVu.getSelectedIndex() == 1) {
            chucVu = 0;
        }
        //ID, ma, ten, gioiTinh, ngaySinh, SDT, DiaChi, MatKhau, ChucVu
        NhanVien nv = new NhanVien();
        nv.setMaNV(ma);
        nv.setTenNV(ten);
        nv.setGioiTinh(gioiTinh);
        nv.setNgaySinh(ngaySinh);
        nv.setSDT(SDT);
        nv.setDiaChi(DiaChi);
        nv.setMatKhau(MatKhau);
        nv.setEmail(email);
        //System.out.println("email"+nv.getEmail());
        nv.setChucVu(chucVu);
        return nv;
    }

    public boolean checkTrong() {
        if (txtMaNV.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "khong de trong ma");
            txtMaNV.requestFocus();
            return false;
        }
        if (txtTenNV.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "khong de trong ten");
            txtTenNV.requestFocus();
            return false;
        }
        if (!rdNam.isSelected() && !rdNu.isSelected()) {
            JOptionPane.showMessageDialog(this, "chon gioi tinh");
            return false;
        }
//        if (cbbChucVu.getText().trim().isEmpty()) {
//            JOptionPane.showMessageDialog(this, "khong de chuc vu");
//            txtChucVu.requestFocus();
//            return false;
//        }
        if (txtSDT.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "khong de trong so dien thoai");
            txtMaNV.requestFocus();
            return false;
        }
        if (txtDiaChi.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "khong de trong dia chi");
            txtDiaChi.requestFocus();
            return false;
        }
        if (txtEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "khong de trong email");
            txtEmail.requestFocus();
            return false;
        }

        //
        return true;

    }

//    private void loadTimKiem() {
//        try {
//            dtm.setRowCount(0);
//            for (NhanVien nv : service.timKiem(Integer.parseInt(txtSearch.getText()))) {
//                dtm.addRow(new Object[]{
//                    nv.getID(),
//                    nv.getMaNV(),
//                    nv.getTenNV(),
//                    nv.getGioiTinh(),
//                    nv.getNgaySinh(),
//                    nv.getSDT(),
//                    nv.getDiaChi(),
//                    nv.getMatKhau(),
//                    nv.getChucVu()});
//            }
//        } catch (Exception e) {
//        }
//
//    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGT = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaNV = new javax.swing.JTextField();
        txtTenNV = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        btnAdd = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtSDT = new javax.swing.JTextField();
        rdNam = new javax.swing.JRadioButton();
        rdNu = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TBNhanVien = new javax.swing.JTable();
        btnEX = new javax.swing.JButton();
        txtNgaySinh = new com.toedter.calendar.JDateChooser();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        txtMatKhau = new javax.swing.JTextField();
        cbbChucVu = new javax.swing.JComboBox<>();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Quản lý Nhân Viên");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel3.setText("Mã nhân viên");

        btnAdd.setText("Thêm nhân viên");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnGT.add(rdNam);
        rdNam.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        rdNam.setText("Nam");

        btnGT.add(rdNu);
        rdNu.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        rdNu.setText("Nữ");

        TBNhanVien.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        TBNhanVien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã nhân viên", "Tên nhân viên", "Giới tính", "Ngày sinh", "SDT", "email", "Địa chỉ", "Chức vụ"
            }
        ));
        TBNhanVien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBNhanVienMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TBNhanVien);

        btnEX.setText("Exit");
        btnEX.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEXActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel5.setText("Tên nhân viên");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel11.setText("Giới Tính");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel12.setText("SDT");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel13.setText("Ngày Sinh");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel14.setText("Email");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel15.setText("Địa Chỉ");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel16.setText("Chức Vụ");

        jButton1.setText("Tìm Kiếm");

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 16)); // NOI18N
        jLabel17.setText("Mật Khẩu");

        cbbChucVu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Nhân Viên", "Quản Lý" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnAdd)
                        .addGap(301, 301, 301))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel11)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(rdNam, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rdNu, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                    .addComponent(txtNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(68, 68, 68))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(jLabel5))
                                        .addGap(39, 39, 39)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtMaNV, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                                            .addComponent(txtTenNV)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel16)
                                            .addComponent(jLabel17))
                                        .addGap(63, 63, 63)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtDiaChi)
                                            .addComponent(txtEmail)
                                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btnSua)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(btnEX))
                                            .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(33, 65, Short.MAX_VALUE)))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jButton1)
                        .addGap(28, 28, 28))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 658, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(406, 406, 406))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(jLabel1)
                .addGap(69, 69, 69)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenNV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rdNu)
                            .addComponent(rdNam)
                            .addComponent(jLabel11))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel13))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(cbbChucVu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtMatKhau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btnSua)
                            .addComponent(btnEX)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(112, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 760));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TBNhanVienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBNhanVienMouseClicked
        int row = TBNhanVien.getSelectedRow();
        detail(row);

    }//GEN-LAST:event_TBNhanVienMouseClicked

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        int chon = JOptionPane.showConfirmDialog(this, "xac nhan them", "huy", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {
            if (checkTrong()) {
                if (service.them(getData())) {
                    JOptionPane.showMessageDialog(this, "them thanh cong");
                    ShowTable(listnViens = service.listNhanVien());
                } else {
                    JOptionPane.showMessageDialog(this, "them thai bai");
                }
            }
        }
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        int index = TBNhanVien.getSelectedRow();
        if (index < 0) {
            JOptionPane.showMessageDialog(this, "chon dong muon sua");
            return;
        }
        int chon = JOptionPane.showConfirmDialog(this, "xac nhan sua", "huy", JOptionPane.YES_NO_OPTION);
        if (chon == JOptionPane.YES_OPTION) {

            if (service.sua(getData(), ID_nv).equals("thanh cong")) {
                JOptionPane.showMessageDialog(this, "sua thanh cong");
                ShowTable(listnViens = service.listNhanVien());
            } else {
                JOptionPane.showMessageDialog(this, "sua that bai");
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnEXActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEXActionPerformed
        dispose();
    }//GEN-LAST:event_btnEXActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TBNhanVien;
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEX;
    private javax.swing.ButtonGroup btnGT;
    private javax.swing.JButton btnSua;
    private javax.swing.JComboBox<String> cbbChucVu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JRadioButton rdNam;
    private javax.swing.JRadioButton rdNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtMaNV;
    private javax.swing.JTextField txtMatKhau;
    private com.toedter.calendar.JDateChooser txtNgaySinh;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenNV;
    // End of variables declaration//GEN-END:variables

}
