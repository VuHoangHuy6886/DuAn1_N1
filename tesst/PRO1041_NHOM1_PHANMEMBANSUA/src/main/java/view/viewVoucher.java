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
public class viewVoucher extends javax.swing.JInternalFrame {

    private DefaultTableModel dtm = new DefaultTableModel();
    private List<Voucher> listVc = new ArrayList<>();
    private VoucherService vcSerVice = new VoucherServicerImpl();

    public static int id;
    private List<ChiTietVoucher> listCTVC = new ArrayList<>();
    private ChiTietVoucherService ctvcService = new ChiTietVoucherImpl();

    public viewVoucher() {
        initComponents();

        listVc = vcSerVice.listAll();
        listCTVC = ctvcService.listAll();

        showTable(listVc);
        showTable02(listCTVC);

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

    private void showTable02(List<ChiTietVoucher> listCTVC) {
        dtm = (DefaultTableModel) TableCTVC.getModel();
        dtm.setRowCount(0);
        for (ChiTietVoucher x : listCTVC) {
            dtm.addRow(new Object[]{
                x.getIdHD(),
                x.getMaVoucher(),
                x.getPhanTram(),
                x.getTrangThai() == 1 ? "Hoạt động" : "Không hoạt động",
                //                x.getTrangThai(),
                x.getIdHD(),
                x.getNgayBatDau(),
                x.getNgayKetThuc(),
                x.getGhiChu(),});
        }
    }

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

    private ChiTietVoucher ShowIndex02(int index) {
        ChiTietVoucher x = listCTVC.get(index);

        id = x.getIdHD();
        System.out.println(id);
        txtIDHD02.setText(TableCTVC.getValueAt(index, 0).toString());
        txtMaVoucher02.setText(x.getMaVoucher());
        cbbPhanTram02.setSelectedItem(x.getPhanTram());
        int trangThai = x.getTrangThai();
        if (trangThai == 1) {
            rd01.setSelected(true);
        } else {
            rd02.setSelected(true);
        }
        txtMaHD02.setText(String.valueOf(x.getMaHoadon()));
        txtNgayBatDau02.setText(String.valueOf(x.getNgayBatDau()));
        txtNgayKetThuc02.setText(String.valueOf(x.getNgayKetThuc()));
        txtGhiChu02.setText(x.getGhiChu());

        return x;
    }

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

    public ChiTietVoucher data02() {
//        int idHD = Integer.parseInt(txtIDHD.getText());
        int idHD = Integer.parseInt(txtIDHD02.getText());
        String maVoucher02 = txtMaVoucher02.getText();
        String phanTram02 = cbbPhanTram02.getSelectedItem().toString();
        String maHoaDon02 = txtMaHD02.getText();
        String ngayBatDau02 = txtNgayBatDau02.getText();
        String ngayKetThuc02 = txtNgayKetThuc02.getText();
        String ghiChu02 = txtGhiChu02.getText();
        int trangThai02;
        if (rd01.isSelected()) {
            trangThai02 = 1;
        } else {
            trangThai02 = 0;
        }

        ChiTietVoucher ct = new ChiTietVoucher();

        ct.setIdHD(idHD);
        ct.setMaVoucher(maVoucher02);
        ct.setPhanTram(Integer.parseInt(phanTram02));
        ct.setTrangThai(trangThai02);
        ct.setMaHoadon(maHoaDon02);
        ct.setNgayBatDau(Date.valueOf(ngayBatDau02));
        ct.setNgayKetThuc(Date.valueOf(ngayKetThuc02));
        ct.setGhiChu(ghiChu02);

        return ct;

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        rd01 = new javax.swing.JRadioButton();
        rd02 = new javax.swing.JRadioButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TableCTVC = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jTextField2 = new javax.swing.JTextField();
        btnThem02 = new javax.swing.JButton();
        btnSua02 = new javax.swing.JButton();
        btnXoa02 = new javax.swing.JButton();
        txtMaVoucher02 = new javax.swing.JTextField();
        txtMaHD02 = new javax.swing.JTextField();
        txtNgayBatDau02 = new javax.swing.JTextField();
        txtNgayKetThuc02 = new javax.swing.JTextField();
        txtGhiChu02 = new javax.swing.JTextField();
        cbbPhanTram02 = new javax.swing.JComboBox<>();
        jLabel18 = new javax.swing.JLabel();
        txtIDHD02 = new javax.swing.JTextField();
        VouCher = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
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
        btnXoa = new javax.swing.JButton();
        txtGhiChu = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TB = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        cbbPhanTram = new javax.swing.JComboBox<>();

        setPreferredSize(new java.awt.Dimension(1200, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(1100, 800));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 800));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel10.setText("Voucher chi tiết ");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 410, 110));

        jLabel11.setText("Mã Voucher");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, -1, -1));

        jLabel12.setText("Phần trăm");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, -1, -1));

        jLabel13.setText("Trạng thái");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 270, -1, -1));

        jLabel14.setText("Mã HD");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, -1, -1));

        jLabel15.setText("Ngày bắt đầu ");
        jPanel1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, -1, -1));

        jLabel16.setText("Ngày kết thúc ");
        jPanel1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 420, -1, -1));

        jLabel17.setText("Ghi chú");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, -1, -1));

        buttonGroup1.add(rd01);
        rd01.setText("Hoạt động");
        jPanel1.add(rd01, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 270, -1, -1));

        buttonGroup1.add(rd02);
        rd02.setText("Không hoạt động");
        jPanel1.add(rd02, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 270, -1, -1));

        TableCTVC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id_HD", "Mã Voucher", "Phần trăm(%)", "Trạng thái", "Mã HD", "Ngày bắt đầu", "Ngày kết thúc", "Ghi chú"
            }
        ));
        TableCTVC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableCTVCMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(TableCTVC);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 180, 540, -1));

        jButton2.setText("Tìm kiếm");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 130, -1, -1));
        jPanel1.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 130, 180, -1));

        btnThem02.setText("Tạo mới");
        btnThem02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem02ActionPerformed(evt);
            }
        });
        jPanel1.add(btnThem02, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 570, -1, -1));

        btnSua02.setText("Sửa");
        btnSua02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua02ActionPerformed(evt);
            }
        });
        jPanel1.add(btnSua02, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 570, -1, -1));

        btnXoa02.setText("Xóa");
        btnXoa02.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa02ActionPerformed(evt);
            }
        });
        jPanel1.add(btnXoa02, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 570, -1, -1));
        jPanel1.add(txtMaVoucher02, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 180, 220, -1));
        jPanel1.add(txtMaHD02, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 210, -1));
        jPanel1.add(txtNgayBatDau02, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 370, 210, -1));
        jPanel1.add(txtNgayKetThuc02, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 420, 210, -1));
        jPanel1.add(txtGhiChu02, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, 240, 70));

        cbbPhanTram02.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "30", "40", "50", "60", "70", "80" }));
        jPanel1.add(cbbPhanTram02, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 220, 190, -1));

        jLabel18.setText("Id_HD");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 100, -1));
        jPanel1.add(txtIDHD02, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 140, 220, -1));

        jTabbedPane1.addTab("Chi Tiết Voucher", jPanel1);

        VouCher.setBackground(new java.awt.Color(204, 204, 204));
        VouCher.setPreferredSize(new java.awt.Dimension(1100, 800));
        VouCher.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        jLabel1.setText("VouCher");
        VouCher.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 220, 120));

        jLabel2.setText("ID_");
        VouCher.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 110, -1));

        jLabel3.setText("Mã Voucher");
        VouCher.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 230, 90, -1));

        jLabel4.setText("Phần trăm ");
        VouCher.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, 80, -1));

        jLabel5.setText("Ngày tạo");
        VouCher.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, 80, -1));

        jLabel6.setText("Ngày sửa ");
        VouCher.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 80, -1));

        jLabel7.setText("Trạng thái");
        VouCher.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 60, -1));

        jLabel8.setText("Ghi chú");
        VouCher.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 470, 70, -1));
        VouCher.add(txtMaVoucher, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 230, 240, -1));
        VouCher.add(txtNgayTao, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 330, 240, -1));
        VouCher.add(txtNgaySua, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 240, -1));

        buttonGroup1.add(rd1);
        rd1.setText("Hoạt động ");
        VouCher.add(rd1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, -1, -1));

        buttonGroup1.add(rd2);
        rd2.setText("Không hoạt động");
        VouCher.add(rd2, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 420, -1, -1));

        btnThem.setText("Tạo mới");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });
        VouCher.add(btnThem, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 560, -1, -1));

        btnSua.setText("Sủa ");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });
        VouCher.add(btnSua, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 560, -1, -1));

        btnXoa.setText("Xoá");
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });
        VouCher.add(btnXoa, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 560, -1, -1));
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

        VouCher.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(472, 190, 500, 410));

        jButton1.setText("Tìm kiếm");
        VouCher.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(890, 120, -1, -1));

        jLabel9.setText("Danh sách voucher");
        VouCher.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 160, 140, -1));
        VouCher.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 120, 190, -1));

        cbbPhanTram.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "10", "20", "30", "40", "50", "60", "70", "80" }));
        VouCher.add(cbbPhanTram, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 190, -1));

        jTabbedPane1.addTab("VouCher", VouCher);

        getContentPane().add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 4, 988, 760));

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

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        JOptionPane.showMessageDialog(this, vcSerVice.xoa(data()));
        showTable(listVc = vcSerVice.listAll());
    }//GEN-LAST:event_btnXoaActionPerformed

    private void TableCTVCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableCTVCMouseClicked
        int row = TableCTVC.getSelectedRow();
        ShowIndex02(row);
    }//GEN-LAST:event_TableCTVCMouseClicked

    private void btnThem02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem02ActionPerformed
        try {
            int c = JOptionPane.showConfirmDialog(this, "Ban co muon them ko?");
            if (c == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, ctvcService.them(data02()));
                showTable02(listCTVC = ctvcService.listAll());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Loi themm");
        }
    }//GEN-LAST:event_btnThem02ActionPerformed

    private void btnXoa02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa02ActionPerformed

        JOptionPane.showMessageDialog(this, ctvcService.xoa(data02()));
        showTable02(listCTVC = ctvcService.listAll());
    }//GEN-LAST:event_btnXoa02ActionPerformed

    private void btnSua02ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua02ActionPerformed

        JOptionPane.showMessageDialog(this, ctvcService.Sua(data02()));
        showTable02(listCTVC = ctvcService.listAll());
    }//GEN-LAST:event_btnSua02ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TB;
    private javax.swing.JTable TableCTVC;
    private javax.swing.JPanel VouCher;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnSua02;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThem02;
    private javax.swing.JButton btnXoa;
    private javax.swing.JButton btnXoa02;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbPhanTram;
    private javax.swing.JComboBox<String> cbbPhanTram02;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButton rd01;
    private javax.swing.JRadioButton rd02;
    private javax.swing.JRadioButton rd1;
    private javax.swing.JRadioButton rd2;
    private javax.swing.JTextField txtGhiChu;
    private javax.swing.JTextField txtGhiChu02;
    private javax.swing.JTextField txtIDHD02;
    private javax.swing.JTextField txtMaHD02;
    private javax.swing.JTextField txtMaVoucher;
    private javax.swing.JTextField txtMaVoucher02;
    private javax.swing.JTextField txtNgayBatDau02;
    private javax.swing.JTextField txtNgayKetThuc02;
    private javax.swing.JTextField txtNgaySua;
    private javax.swing.JTextField txtNgayTao;
    // End of variables declaration//GEN-END:variables
}
