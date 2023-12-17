/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controler.ChiTietSanPhamServiceImpl;
import controler.ChiTietVoucherImpl;
import controler.VoucherServicerImpl;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSanPham;
import model.ChiTietVoucher;
import model.Voucher;
import repository.ChiTietVoucherService;
import repository.CrudfullTable;
import repository.VoucherService;

/**
 *
 * @author Thang
 */
public class VouCherView extends javax.swing.JInternalFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<Voucher> listVc = new ArrayList<>();
    private VoucherService vcSerVice = new VoucherServicerImpl();

    public static int id;
    private List<ChiTietVoucher> listCTVC = new ArrayList<>();
    private ChiTietVoucherService ctvcService = new ChiTietVoucherImpl();

    public VouCherView() {
        initComponents();

        listVc = vcSerVice.listAll();
        listCTVC = ctvcService.listAll();

        showTable(listVc);
        //showTable02(listCTVC);

    }

    public void showTable(List<Voucher> listVc) {
        dtm = (DefaultTableModel) TB.getModel();
        dtm.setRowCount(0);
        for (model.Voucher vc : listVc) {
            dtm.addRow(new Object[]{
                vc.getMaVoucher(),
                vc.getPhanTram(),
                vc.getNgayTao(),
                vc.getNgaySua(),
                vc.getTrangThai() == 1 ? "Hoạt động" : "Không hoạt động",
                vc.getGhiChu()
            });
        }
    }

//    private void showTable02(List<ChiTietVoucher> listCTVC) {
//        dtm = (DefaultTableModel) TableCTVC.getModel();
//        dtm.setRowCount(0);
//        for (ChiTietVoucher x : listCTVC) {
//            dtm.addRow(new Object[]{
//                x.getIdHD(),
//                x.getMaVoucher(),
//                x.getPhanTram(),
//                x.getTrangThai() == 1 ? "Hoạt động" : "Không hoạt động",
//                //                x.getTrangThai(),
//                x.getIdHD(),
//                x.getNgayBatDau(),
//                x.getNgayKetThuc(),
//                x.getGhiChu(),});
//        }
//    }

    private Voucher showIndex(int index) {
        Voucher vc = listVc.get(index);
        id = vc.getId();
        System.out.println(id);
        txtMaVoucher.setText(vc.getMaVoucher());
        cbbPhanTram.setSelectedItem(vc.getPhanTram());
        txtNgayTao.setText(String.valueOf(vc.getNgayTao()));
        txtNgaySua.setText(String.valueOf(vc.getNgaySua()));
        int trangThai = vc.getTrangThai();
        if (trangThai == 1) {
            rd1.setSelected(true);
        } else {
            rd2.setSelected(true);
        }
        txtGhiChu.setText(vc.getGhiChu());
        return vc;
    }

//    private ChiTietVoucher ShowIndex02(int index) {
//        ChiTietVoucher x = listCTVC.get(index);
//
//        id = x.getIdHD();
//        System.out.println(id);
//        txtIDHD02.setText(TableCTVC.getValueAt(index, 0).toString());
//        txtMaVoucher02.setText(x.getMaVoucher());
//        cbbPhanTram02.setSelectedItem(x.getPhanTram());
//        int trangThai = x.getTrangThai();
//        if (trangThai == 1) {
//            rd01.setSelected(true);
//        } else {
//            rd02.setSelected(true);
//        }
//        txtMaHD02.setText(String.valueOf(x.getMaHoadon()));
//        txtNgayBatDau02.setText(String.valueOf(x.getNgayBatDau()));
//        txtNgayKetThuc02.setText(String.valueOf(x.getNgayKetThuc()));
//        txtGhiChu02.setText(x.getGhiChu());
//
//        return x;
//    }

    public Voucher data() {
        String ma = txtMaVoucher.getText();
        String phanTram = cbbPhanTram.getSelectedItem().toString();
        String ngayTaoText = txtNgayTao.getText();
        String ngaySuaText = txtNgaySua.getText();
        int trangThai;
        if (rd1.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        String ghiChuText = txtGhiChu.getText();

        Voucher vc = new Voucher();
        vc.setId(id);
        vc.setMaVoucher(ma);
        vc.setNgaySua(Date.valueOf(ngaySuaText));
        vc.setNgayTao(Date.valueOf(ngayTaoText));
        vc.setPhanTram(Integer.parseInt(phanTram));
        vc.setGhiChu(ghiChuText);
        vc.setTrangThai(trangThai);
        return vc;
    }

//    public ChiTietVoucher data02() {
////        int idHD = Integer.parseInt(txtIDHD.getText());
//        int idHD = Integer.parseInt(txtIDHD02.getText());
//        String maVoucher02 = txtMaVoucher02.getText();
//        String phanTram02 = cbbPhanTram02.getSelectedItem().toString();
//        String maHoaDon02 = txtMaHD02.getText();
//        String ngayBatDau02 = txtNgayBatDau02.getText();
//        String ngayKetThuc02 = txtNgayKetThuc02.getText();
//        String ghiChu02 = txtGhiChu02.getText();
//        int trangThai02;
//        if (rd01.isSelected()) {
//            trangThai02 = 1;
//        } else {
//            trangThai02 = 0;
//        }
//
//        ChiTietVoucher ct = new ChiTietVoucher();
//
//        ct.setIdHD(idHD);
//        ct.setMaVoucher(maVoucher02);
//        ct.setPhanTram(Integer.parseInt(phanTram02));
//        ct.setTrangThai(trangThai02);
//        ct.setMaHoadon(maHoaDon02);
//        ct.setNgayBatDau(Date.valueOf(ngayBatDau02));
//        ct.setNgayKetThuc(Date.valueOf(ngayKetThuc02));
//        ct.setGhiChu(ghiChu02);
//
//        return ct;
//
//    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        VouCher = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtMaVoucher = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtNgaySua = new javax.swing.JTextField();
        rd1 = new javax.swing.JRadioButton();
        rd2 = new javax.swing.JRadioButton();
        btnThem = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        txtGhiChu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB = new javax.swing.JTable();
        cbbPhanTram = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1200, 800));

        VouCher.setBackground(new java.awt.Color(0, 204, 255));
        VouCher.setPreferredSize(new java.awt.Dimension(1100, 800));
        VouCher.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("VouCher");
        VouCher.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 60, 220, 120));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel3.setText("Mã Voucher");
        VouCher.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 90, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel4.setText("Phần trăm ");
        VouCher.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 80, -1));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel5.setText("Ngày tạo");
        VouCher.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 80, -1));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel6.setText("Ngày sửa ");
        VouCher.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 80, -1));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel7.setText("Trạng thái");
        VouCher.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 70, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel8.setText("Ghi chú");
        VouCher.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 70, -1));
        VouCher.add(txtMaVoucher, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 240, -1));
        VouCher.add(txtNgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 240, -1));
        VouCher.add(txtNgaySua, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 240, -1));

        buttonGroup1.add(rd1);
        rd1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        rd1.setText("Hoạt động ");
        VouCher.add(rd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, -1, -1));

        buttonGroup1.add(rd2);
        rd2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        rd2.setText("Không hoạt động");
        VouCher.add(rd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 420, -1, -1));

        btnThem.setText("Tạo mới");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        VouCher.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 570, -1, -1));

        btnSua.setText("Sửa");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        VouCher.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, -1, -1));
        VouCher.add(txtGhiChu, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 470, 280, 70));

        TB.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã Voucher", "Phần trăm(%)", "Ngày tạo", "Ngày sửa", "Trạng thái", "Ghi chú"
            }
        ));
        TB.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TB);
        if (TB.getColumnModel().getColumnCount() > 0) {
            TB.getColumnModel().getColumn(1).setResizable(false);
        }

        VouCher.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 220, 500, 380));

        cbbPhanTram.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "30", "40", "50", "60", "70", "80", "90", "100" }));
        VouCher.add(cbbPhanTram, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 190, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(VouCher, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(VouCher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void TBMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBMouseClicked
        int row = TB.getSelectedRow();
        showIndex(row);
    }//GEN-LAST:event_TBMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        try {
            int c = JOptionPane.showConfirmDialog(this, "ban co muon them ko");
            if (c == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, vcSerVice.them(data()));
                showTable(listVc = vcSerVice.listAll());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "loi them ");
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        JOptionPane.showMessageDialog(this, vcSerVice.Sua(data()));
        showTable(listVc = vcSerVice.listAll());
    }//GEN-LAST:event_btnSuaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TB;
    private javax.swing.JPanel VouCher;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbPhanTram;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rd1;
    private javax.swing.JRadioButton rd2;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtMaVoucher;
    private javax.swing.JTextField txtNgaySua;
    private javax.swing.JTextField txtNgayTao;
    // End of variables declaration//GEN-END:variables
}
