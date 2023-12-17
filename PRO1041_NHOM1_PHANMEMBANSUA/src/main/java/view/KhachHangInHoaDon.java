/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controler.KhachHangServiceImp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.KhachHang;
import repository.KhachHangService;

/**
 *
 * @author vuhoa
 */
public class KhachHangInHoaDon extends javax.swing.JFrame {
    
    DefaultTableModel modelKhachHang = new DefaultTableModel();
    DefaultTableModel dtm = new DefaultTableModel();
    List<KhachHang> listKhachHang = new ArrayList<>();
    KhachHangService serviceKhachHang = new KhachHangServiceImp();
    public static int idKhachHang;
    
    public KhachHangInHoaDon() {
        initComponents();
        dtm = (DefaultTableModel) tbKhachHangThem.getModel();
        modelKhachHang = (DefaultTableModel) tbKhachHang.getModel();
        listKhachHang = serviceKhachHang.listKhachHang();
        showTableKhachHang(listKhachHang);
        showTableKhachHang2(listKhachHang);
    }
    
    public void showTableKhachHang(List<KhachHang> listKhachHang) {
        modelKhachHang.setRowCount(0);
        int index = 1;
        for (KhachHang kh : listKhachHang) {
            modelKhachHang.addRow(new Object[]{
                index,
                kh.getMa(),
                kh.getTen(),
                kh.getSdt(),
                kh.getEmail(),
                kh.getDiaChi(),});
            index++;
        }
    }
    
    public void showTableKhachHang2(List<KhachHang> listKhachHang) {
        dtm.setRowCount(0);
        int index = 1;
        for (KhachHang kh : listKhachHang) {
            dtm.addRow(new Object[]{
                index,
                kh.getMa(),
                kh.getTen(),
                kh.getSdt(),
                kh.getEmail(),
                kh.getDiaChi(),});
            index++;
        }
    }
    
    public boolean checkValidate() {
        String hoTen = txtHoTen.getText();
        if (hoTen.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ten không được trống");
            return false;
        }
        
        String diaChi = txtDiaChi.getText();
        if (diaChi.isEmpty()) {
            JOptionPane.showMessageDialog(this, "địa chỉ không được trống");
            return false;
        }
        
        String sdt = txtSDT.getText();
        if (sdt.isEmpty()) {
            JOptionPane.showMessageDialog(this, "số điện thoại không được trống");
            return false;
        } else if (sdt.matches("[a-zA-Z]+")) {
            JOptionPane.showMessageDialog(this, "số điện thoại không được trống và phải là số ");
            return false;
        }
        
        return true;
    }
    
    public KhachHang dataKH() {
        KhachHang kh = new KhachHang();
        kh.setMa(txtMKH.getText());
        kh.setTen(txtHoTen.getText());
        kh.setEmail(txtEmail.getText());
        kh.setDiaChi(txtDiaChi.getText());
        kh.setSdt(txtSDT.getText());
        return kh;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        DanhSachKhachHang = new javax.swing.JPanel();
        txtTenTim = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbKhachHang = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbKhachHangThem = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnChon = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        txtMKH = new javax.swing.JTextField();

        setTitle("Khách Hàng");

        DanhSachKhachHang.setBackground(new java.awt.Color(0, 204, 255));

        txtTenTim.setBackground(new java.awt.Color(0, 204, 255));
        txtTenTim.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtTenTim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTenTimMouseClicked(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel1.setText("Tìm Khách Hàng :");

        tbKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã", "TÊN", "SDT", "EMAIL"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbKhachHangMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbKhachHang);

        jButton1.setText("tìm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout DanhSachKhachHangLayout = new javax.swing.GroupLayout(DanhSachKhachHang);
        DanhSachKhachHang.setLayout(DanhSachKhachHangLayout);
        DanhSachKhachHangLayout.setHorizontalGroup(
            DanhSachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhSachKhachHangLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtTenTim, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(31, 31, 31))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
        );
        DanhSachKhachHangLayout.setVerticalGroup(
            DanhSachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DanhSachKhachHangLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(DanhSachKhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(29, 29, 29)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 259, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh Sách Khách Hàng", DanhSachKhachHang);

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        tbKhachHangThem.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "SDT", "TÊN", "EMAIL", "SDT", "ĐỊA CHỈ"
            }
        ));
        jScrollPane2.setViewportView(tbKhachHangThem);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel2.setText("Họ Tên :");

        txtHoTen.setBackground(new java.awt.Color(0, 204, 255));
        txtHoTen.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel3.setText("Email :");

        txtEmail.setBackground(new java.awt.Color(0, 204, 255));
        txtEmail.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel4.setText("SDT :");

        txtSDT.setBackground(new java.awt.Color(0, 204, 255));
        txtSDT.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel5.setText("Địa Chỉ :");

        txtDiaChi.setBackground(new java.awt.Color(0, 204, 255));
        txtDiaChi.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnChon.setText("Chọn");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel6.setText("Mã Khách Hàng :");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel6))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE)
                            .addComponent(txtEmail))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtMKH, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem)
                        .addGap(18, 18, 18)
                        .addComponent(btnChon)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem)
                    .addComponent(btnChon)
                    .addComponent(jLabel6)
                    .addComponent(txtMKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jTabbedPane1.addTab("Thêm Khách Hàng", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtTenTimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTenTimMouseClicked
        String tenSearch = txtTenTim.getText();
        showTableKhachHang(listKhachHang = serviceKhachHang.listKhachHangSearch(tenSearch));
    }//GEN-LAST:event_txtTenTimMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String tenSearch = txtTenTim.getText();
        listKhachHang = serviceKhachHang.listKhachHangSearch(tenSearch);
        showTableKhachHang(listKhachHang);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbKhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbKhachHangMouseClicked
        int row = tbKhachHang.getSelectedRow();
        int viTri = listKhachHang.get(row).getId();
        idKhachHang = viTri;
        System.out.println("id là : " + idKhachHang);
    }//GEN-LAST:event_tbKhachHangMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (checkValidate() == true) {
            int c = JOptionPane.showConfirmDialog(this, "bạn có muốn thêm không !");
            if (c == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, serviceKhachHang.themKhachHang(dataKH()));
                showTableKhachHang2(listKhachHang = serviceKhachHang.listKhachHang());
            }
        } else {
            JOptionPane.showMessageDialog(this, checkValidate());
        }
    }//GEN-LAST:event_btnThemActionPerformed

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
            java.util.logging.Logger.getLogger(KhachHangInHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(KhachHangInHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(KhachHangInHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(KhachHangInHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new KhachHangInHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DanhSachKhachHang;
    private javax.swing.JButton btnChon;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbKhachHang;
    private javax.swing.JTable tbKhachHangThem;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtMKH;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTenTim;
    // End of variables declaration//GEN-END:variables
}
