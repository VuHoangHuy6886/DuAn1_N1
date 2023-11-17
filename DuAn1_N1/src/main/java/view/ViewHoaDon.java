/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controler.HoaDonImpl;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import repository.CrudfullTable;

public class ViewHoaDon extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    CrudfullTable<HoaDon> service = new HoaDonImpl();
    List<HoaDon> listHoaDon = new ArrayList<>();

    public ViewHoaDon() {
        initComponents();
        dtm = (DefaultTableModel) tblHoaDon.getModel();
        listHoaDon = service.listAll();
        showTableHoaDon(listHoaDon);
    }

    public void showTableHoaDon(List<HoaDon> lists) {
        dtm.setRowCount(0);
        for (HoaDon hd : lists) {
            dtm.addRow(new Object[]{
                hd.getId(), hd.getMaHD(), hd.getNgayTao(), hd.getNgaySua(), hd.getIdKH(),
                hd.getTongTienHang(), hd.getIdNhanVien()
            });
        }
    }

    public void fillData(int index) {
        HoaDon hd = listHoaDon.get(index);
        lbidHoaDon.setText(hd.getId() + "");
        txtMaHoaDon.setText(hd.getMaHD());
        txtNgayTao.setText(hd.getNgayTao() + "");
        txtNgaySua.setText(hd.getNgaySua() + "");
        lbidKhachHang.setText(hd.getIdKH() + "");
        txtTongTienHang.setText(hd.getTongTienHang() + "");
        lbIdNhanVien.setText(hd.getIdNhanVien() + "");
    }

    public HoaDon data() {
        String maHD = txtMaHoaDon.getText();
        Date ngayTao = Date.valueOf(txtNgayTao.getText());
        Date ngaySua = Date.valueOf(txtNgaySua.getText());
        float tongTienHang = Float.parseFloat(txtTongTienHang.getText());
        HoaDon hd = new HoaDon(WIDTH, maHD, ngayTao, ngaySua, WIDTH, tongTienHang, WIDTH);
        return hd;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbIdNhanVien = new javax.swing.JLabel();
        txtNgaySua = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        txtNgayTao = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnChiTietHoaDon = new javax.swing.JButton();
        txtMaHoaDon = new javax.swing.JTextField();
        lbidHoaDon = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtTongTienHang = new javax.swing.JTextField();
        lbidKhachHang = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnXoa = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblHoaDon = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbIdNhanVien.setForeground(new java.awt.Color(255, 0, 0));
        lbIdNhanVien.setText("_");

        jLabel2.setText("ID hóa đơn");

        jLabel7.setText("Tổng tiền hàng");

        jLabel10.setText("ID nhân viên");

        jLabel6.setText("Ngày sửa");

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 48)); // NOI18N
        jLabel1.setText("Hóa đơn");

        btnChiTietHoaDon.setText("CTHD");
        btnChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChiTietHoaDonActionPerformed(evt);
            }
        });

        txtMaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaHoaDonActionPerformed(evt);
            }
        });

        lbidHoaDon.setForeground(new java.awt.Color(255, 0, 0));
        lbidHoaDon.setText("_");

        jLabel8.setText("ID khách hàng");

        lbidKhachHang.setForeground(new java.awt.Color(255, 0, 0));
        lbidKhachHang.setText("_");

        jLabel5.setText("Ngày tạo");

        jLabel4.setText("Mã hóa đơn");

        btnXoa.setText("Xóa");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(212, 212, 212)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                    .addComponent(txtNgayTao)
                                    .addComponent(txtNgaySua)
                                    .addComponent(txtTongTienHang)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbidHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbidKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbIdNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnThem)
                                        .addGap(23, 23, 23)
                                        .addComponent(btnXoa)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addComponent(btnChiTietHoaDon)))))))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel8)
                    .addComponent(lbidHoaDon)
                    .addComponent(lbidKhachHang)
                    .addComponent(jLabel10)
                    .addComponent(lbIdNhanVien))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem)
                            .addComponent(btnChiTietHoaDon)
                            .addComponent(btnXoa)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNgaySua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtTongTienHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );

        tblHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Id hóa đơn", "Mã hóa đơn", "Ngày tạo", "Ngày sửa", "Id khách hàng", "Tổng tiền hàng", "Id nhân viên"
            }
        ));
        tblHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblHoaDon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 599, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            int c = JOptionPane.showConfirmDialog(this, "Bạn có muốn thêm hóa đơn không ?");
            if (c == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, service.them(data()));
                showTableHoaDon(listHoaDon = service.listAll());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Lỗi không thêm được");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void txtMaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaHoaDonActionPerformed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed

        int selectedRowIndex = tblHoaDon.getSelectedRow();
        if (selectedRowIndex != -1) {
            int idHoaDon = Integer.parseInt(tblHoaDon.getModel().getValueAt(selectedRowIndex, 0).toString());
            HoaDonImpl hoaDonImpl = new HoaDonImpl();
            HoaDon hoaDon = new HoaDon();
            hoaDon.setId(idHoaDon);

            String result = hoaDonImpl.xoa(hoaDon);

            JOptionPane.showMessageDialog(this, result);
            showTableHoaDon(listHoaDon);
            List<HoaDon> lists;

        } else {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn một hóa đơn để xóa");
        }
          
    }//GEN-LAST:event_btnXoaActionPerformed

    private void tblHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDonMouseClicked
        int index = tblHoaDon.getSelectedRow();
        fillData(index);
    }//GEN-LAST:event_tblHoaDonMouseClicked

    private void btnChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChiTietHoaDonActionPerformed
        new ViewCTHD().setVisible(true);
    }//GEN-LAST:event_btnChiTietHoaDonActionPerformed

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
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewHoaDon.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewHoaDon().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnChiTietHoaDon;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbIdNhanVien;
    private javax.swing.JLabel lbidHoaDon;
    private javax.swing.JLabel lbidKhachHang;
    private javax.swing.JTable tblHoaDon;
    private javax.swing.JTextField txtMaHoaDon;
    private javax.swing.JTextField txtNgaySua;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTongTienHang;
    // End of variables declaration//GEN-END:variables
}
