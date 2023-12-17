/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controler.ThuongHieuServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ThuongHieu;

/**
 *
 * @author vuhoa
 */
public class ViewThuongHieuSanPham extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ThuongHieuServiceImpl serviceThuongHieu = new ThuongHieuServiceImpl();
    //  CrudfullTable<DongSanPham> serviceCrud = new ThuongHieuServiceImpl();
    List<ThuongHieu> listThuongHieu = new ArrayList<>();

    public static int idTH;

    public ViewThuongHieuSanPham() {
        initComponents();
        dtm = (DefaultTableModel) tbThuongHieuSanPham.getModel();
        listThuongHieu = serviceThuongHieu.listThuongHieuSanPham();
        showTable(listThuongHieu);
    }

    private void showTable(List<ThuongHieu> listThuongHieu) {
        dtm.setRowCount(0);
        int index = 1;
        for (ThuongHieu th : listThuongHieu) {
            dtm.addRow(new Object[]{
                index,
                th.getMa(),
                th.getTen(),
                th.getTrangThai() == 1 ? "Hoạt Động" : "KHÔNG HOẠT ĐỘNG",});
            index++;
        }
    }

    private ThuongHieu data() {
        String ma = txtMa.getText();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "mã không được để trống !");
            return null;
        }
        String ten = txtTen.getText();
        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ten không được để trống !");
            return null;
        }
        int trangThai = 0;
        if (rdHD.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        ThuongHieu th = new ThuongHieu();
        th.setMa(ma);
        th.setTen(ten);
        th.setTrangThai(trangThai);
        return th;
    }

    private ThuongHieu showIndex(int index) {
        ThuongHieu th = listThuongHieu.get(index);
        idTH = th.getId();
        System.out.println(idTH);
        txtMa.setText(th.getMa());
        txtTen.setText(th.getTen());
        int trangThai = th.getTrangThai();
        if (trangThai == 1) {
            rdHD.setSelected(true);
        } else {
            rdKHD.setSelected(true);
        }
        return th;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtMa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTen = new javax.swing.JTextField();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rdKHD = new javax.swing.JRadioButton();
        rdHD = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbThuongHieuSanPham = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Thương Hiệu");

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel1.setText("THƯƠNG HIỆU");

        jLabel2.setText("MÃ");

        jLabel3.setText("TÊN");

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus_1.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/settings.png"))); // NOI18N
        btnSua.setText("SỬA");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        jLabel4.setText("TRẠNG THÁI");

        buttonGroup1.add(rdKHD);
        rdKHD.setText("KHÔNG HOẠT ĐỘNG");

        buttonGroup1.add(rdHD);
        rdHD.setText("HOẠT ĐỘNG");

        tbThuongHieuSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MÃ", "TÊN", "TRẠNG THÁI"
            }
        ));
        tbThuongHieuSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbThuongHieuSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbThuongHieuSanPham);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(27, 27, 27)
                                .addComponent(txtTen))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, 352, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(btnThem))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(22, 22, 22))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(30, 30, 30)
                        .addComponent(rdHD, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(rdKHD)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(198, 198, 198))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem)
                    .addComponent(jLabel2))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(rdKHD)
                    .addComponent(rdHD))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbThuongHieuSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbThuongHieuSanPhamMouseClicked
        int index = tbThuongHieuSanPham.getSelectedRow();
        showIndex(index);
    }//GEN-LAST:event_tbThuongHieuSanPhamMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (data() != null) {
            int c = JOptionPane.showConfirmDialog(this, "bạn có muốn thêm không");
            if (c == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, serviceThuongHieu.them(data()));
                showTable(listThuongHieu = serviceThuongHieu.listThuongHieuSanPham());
            } else {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Thêm thất bại");
            return;
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (data() != null) {
            int c = JOptionPane.showConfirmDialog(this, "bạn có muốn thêm không");
            if (c == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, serviceThuongHieu.Sua(data()));
                showTable(listThuongHieu = serviceThuongHieu.listThuongHieuSanPham());
            } else {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sửa thất bại");
            return;
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewThuongHieuSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdHD;
    private javax.swing.JRadioButton rdKHD;
    private javax.swing.JTable tbThuongHieuSanPham;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
