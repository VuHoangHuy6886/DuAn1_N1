/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controler.HoaDonChiTietServiceImpl;
import controler.HoaDonServiceImpl;
import controler.KhachHangServiceImp;
import controler.NhanVienServiceImpl;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.table.DefaultTableModel;
import model.HoaDon;
import model.KhachHang;
import model.NhanVien;
import modelView.HDCT;
import repository.KhachHangService;
import repository.NhanVienService;

/**
 *
 * @author vuhoa
 */
public class HoaDonView extends javax.swing.JInternalFrame {

    DefaultTableModel modelHoaDon = new DefaultTableModel();
    DefaultTableModel modelHoaDonChiTiet = new DefaultTableModel();
    HoaDonServiceImpl serviceHoaDon = new HoaDonServiceImpl();
    HoaDonChiTietServiceImpl serviceHoaDonChiTiet = new HoaDonChiTietServiceImpl();
    KhachHangService serviceKhachHang = new KhachHangServiceImp();
    NhanVienService serviceNhanVien = new NhanVienServiceImpl();
    List<HoaDon> listHoaDon = new ArrayList<>();
    List<HDCT> listHoaDonChiTiet = new ArrayList<>();
    List<KhachHang> listKhachHang = new ArrayList<>();
    List<NhanVien> listNhanVien = new ArrayList<>();

    int idHoaDon;

    public HoaDonView() {
        initComponents();
        // hóa đơn
        modelHoaDon = (DefaultTableModel) tbHoaDon.getModel();
        listHoaDon = serviceHoaDon.listAll();
        // hóa Đơn chi tiết
        modelHoaDonChiTiet = (DefaultTableModel) tbHoaDonChiTiet.getModel();
        showTableHoaDon(listHoaDon.stream().filter(hd -> hd.getTrangThai().equals("Đã thanh toán")).toList());
        // khach hàng 
        listKhachHang = serviceKhachHang.listKhachHang();
        // nhân viên
        listNhanVien = serviceNhanVien.listNhanVien();
    }

    public void showTableHoaDon(List<HoaDon> listHoaDon) {
        modelHoaDon.setRowCount(0);
        int index = 1;
        for (HoaDon hoaDon : listHoaDon) {
            modelHoaDon.addRow(new Object[]{
                index,
                hoaDon.getMaHD(),
                hoaDon.getNgayTao(),
                hoaDon.getTongTien(),
                hoaDon.getTrangThai(),
                hoaDon.getId_KhachHang(),});
            index++;
        }
    }

    public HoaDon showIndex(int index) {
        HoaDon hd = listHoaDon.get(index);
        txtNgayTao.setText(String.valueOf(hd.getNgayTao()));
        txtTongTien.setText(String.valueOf(hd.getTongTien()));
        for (KhachHang kh : listKhachHang) {
            if (hd.getId_KhachHang() == kh.getId()) {
                txtTenKhachHang.setText(kh.getTen());
            } else if (hd.getId_KhachHang() == 0) {
                txtTenKhachHang.setText("");
            }
        }

        for (NhanVien nv : listNhanVien) {
            if (nv.getIdNV() == hd.getId_NhanVien()) {
                txtTenNhanVien.setText(nv.getTenNV());
            } else {
                txtTenNhanVien.setText("");
            }
        }

        return hd;
    }

    public void showTableHoaDonChiTiet(List<HDCT> listHoaDonChiTiet) {
        modelHoaDonChiTiet.setRowCount(0);
        int index = 1;
        for (HDCT hd : listHoaDonChiTiet) {
            modelHoaDonChiTiet.addRow(new Object[]{
                index,
                hd.getTenSanPham(),
                hd.getSoLuongSanPham(),
                hd.getDonGia(),});
            index++;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHoaDonChiTiet = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        txtTenKhachHang = new javax.swing.JTextField();
        txtNgayTao = new javax.swing.JTextField();
        txtTongTien = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        cbbTrangThaiHoaDon = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "MAHD", "NGÀY TẠO", "TỔNG TIỀN", "TRẠNG THÁI"
            }
        ));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        tbHoaDonChiTiet.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "TÊN SẢN PHẨM", "SỐ LƯỢNG ", "ĐƠN GIÁ"
            }
        ));
        jScrollPane2.setViewportView(tbHoaDonChiTiet);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel1.setText("HÓA ĐƠN");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel2.setText("DANH SÁCH HÓA ĐƠN");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel3.setText("HÓA ĐƠN CHI TIẾT");

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "THÔNG TIN HÓA ĐƠN", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N
        jPanel2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel4.setText("TÊN KHÁCH HÀNG :");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel5.setText("TÊN NHÂN VIÊN TẠO :");

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel6.setText("TỔNG TIỀN :");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel7.setText("NGÀY TẠO :");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        cbbTrangThaiHoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đã thanh toán", "Chưa thanh toán" }));
        cbbTrangThaiHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbTrangThaiHoaDonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(276, 276, 276)
                                        .addComponent(cbbTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel3)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1039, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 3, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(500, 500, 500)
                        .addComponent(jLabel1)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(jLabel2)
                        .addGap(34, 34, 34))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cbbTrangThaiHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(81, Short.MAX_VALUE))
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
    }// </editor-fold>//GEN-END:initComponents

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        int row = tbHoaDon.getSelectedRow();
        idHoaDon = listHoaDon.get(row).getIdHD();
        showIndex(row);
        //System.out.println(idHoaDon);
        showTableHoaDonChiTiet(listHoaDonChiTiet = serviceHoaDonChiTiet.listhdView(idHoaDon));
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void cbbTrangThaiHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbTrangThaiHoaDonMouseClicked
        int tt = cbbTrangThaiHoaDon.getSelectedIndex();
        if (tt == 0) {
            listHoaDon = serviceHoaDon.listAll().stream()
                    .filter(hd -> hd.getTrangThai().equals("Đã thanh toán"))
                    .collect(Collectors.toList());
            showTableHoaDon(listHoaDon);
        } else if (tt == 1) {
            listHoaDon = serviceHoaDon.listAll().stream()
                    .filter(hd -> hd.getTrangThai().equals("Chờ thanh toán"))
                    .collect(Collectors.toList());
            showTableHoaDon(listHoaDon);
        }
    }//GEN-LAST:event_cbbTrangThaiHoaDonMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cbbTrangThaiHoaDon;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tbHoaDonChiTiet;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
