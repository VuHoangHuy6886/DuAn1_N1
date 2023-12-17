/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import controler.XuatXuServiceImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.XuatXu;

/**
 *
 * @author vuhoa
 */
public class ViewXuatXuSanPham extends javax.swing.JFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    XuatXuServiceImpl serviceXuatXu = new XuatXuServiceImpl();
    List<XuatXu> lists = new ArrayList<>();
    public static int idXX;

    public ViewXuatXuSanPham() {
        initComponents();
        dtm = (DefaultTableModel) tbXuatXuSanPham.getModel();
        lists = serviceXuatXu.listXuatXuSanPham();
        showTable(lists);
    }

    public void showTable(List<XuatXu> lists) {
        dtm.setRowCount(0);
        int index = 1;
        for (XuatXu xx : lists) {
            dtm.addRow(new Object[]{
                index,
                xx.getMa(),
                xx.getTen(),
                xx.getTrangThai() == 1 ? "Hoạt Động" : "Không Hoạt Động",});
            index++;
        }
    }

    public XuatXu data() {
        String ma = txtMa.getText();
        if (ma.isEmpty()) {
            JOptionPane.showMessageDialog(this, "mã của bạn không được để trống !");
            return null;
        }
        String ten = txtTen.getText();
        if (ten.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ten của bạn không được để trống !");
            return null;
        }
        int trangThai = 0;
        if (rdHD.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        XuatXu xx = new XuatXu(WIDTH, ma, ten, trangThai);
        return xx;
    }

    public XuatXu showIndex(int index) {
        XuatXu xx = lists.get(index);
        idXX = xx.getId();
        System.out.println(idXX);
        txtMa.setText(xx.getMa());
        txtTen.setText(xx.getTen());
        int trangThai = xx.getTrangThai();
        if (trangThai == 1) {
            rdHD.setSelected(true);
        } else {
            rdKHD.setSelected(true);
        }
        return xx;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btnSua = new javax.swing.JButton();
        txtTen = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbXuatXuSanPham = new javax.swing.JTable();
        btnThem = new javax.swing.JButton();
        rdHD = new javax.swing.JRadioButton();
        rdKHD = new javax.swing.JRadioButton();
        txtMa = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Table Xuất Xứ");

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        jLabel8.setText("Trạng Thái");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel5.setText("Xuất Xứ");

        jLabel7.setText("Tên");

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        tbXuatXuSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã", "Tên", "Quốc Gia"
            }
        ));
        tbXuatXuSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbXuatXuSanPhamMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbXuatXuSanPham);

        btnThem.setText("Thêm");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        rdHD.setText("Hoạt Động");

        rdKHD.setText("Không Hoạt Động");

        jLabel6.setText("Mã ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addComponent(rdHD, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(39, 39, 39)
                                .addComponent(rdKHD, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtMa, javax.swing.GroupLayout.DEFAULT_SIZE, 277, Short.MAX_VALUE)
                                    .addComponent(txtTen))))
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnThem)
                            .addComponent(btnSua)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(219, 219, 219)
                        .addComponent(jLabel5)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem)
                    .addComponent(jLabel6))
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnSua))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdKHD)
                    .addComponent(rdHD)
                    .addComponent(jLabel8))
                .addGap(10, 10, 10)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (data() != null) {
            int chon = JOptionPane.showConfirmDialog(this, "ban co muon them nha xuat xu khong ?");
            if (chon == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, serviceXuatXu.them(data()));
                showTable(lists = serviceXuatXu.listXuatXuSanPham());
            } else {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Thêm Thất bại !");
            return;
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (data() != null) {
            int chon = JOptionPane.showConfirmDialog(this, "ban co muon sửa nha xuat xu khong ?");
            if (chon == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, serviceXuatXu.Sua(data()));
                showTable(lists = serviceXuatXu.listXuatXuSanPham());
            } else {
                return;
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sửa Thất bại !");
            return;
        }

    }//GEN-LAST:event_btnSuaActionPerformed

    private void tbXuatXuSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbXuatXuSanPhamMouseClicked
        int row = tbXuatXuSanPham.getSelectedRow();
        showIndex(row);
    }//GEN-LAST:event_tbXuatXuSanPhamMouseClicked

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
            java.util.logging.Logger.getLogger(ViewXuatXuSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewXuatXuSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewXuatXuSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewXuatXuSanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewXuatXuSanPham().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JRadioButton rdHD;
    private javax.swing.JRadioButton rdKHD;
    private javax.swing.JTable tbXuatXuSanPham;
    private javax.swing.JTextField txtMa;
    private javax.swing.JTextField txtTen;
    // End of variables declaration//GEN-END:variables
}
