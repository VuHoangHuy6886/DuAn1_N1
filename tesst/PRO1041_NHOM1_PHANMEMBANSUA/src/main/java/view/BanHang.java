/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controler.ChiTietSanPhamServiceImpl;
import controler.HoaDonChiTietServiceImpl;
import controler.HoaDonServiceImpl;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSanPham;
import model.HoaDon;
import model.HoaDonChiTiet;
import modelView.CTSP;
import modelView.HDCT;
import repository.ChiTietSanPhamService;

/**
 *
 * @author vuhoa
 */
public class BanHang extends javax.swing.JInternalFrame {

    DefaultTableModel dtmHD = new DefaultTableModel();
    HoaDonServiceImpl serviceHD = new HoaDonServiceImpl();
    List<HoaDon> listHD = new ArrayList<>();
    DefaultTableModel modelGioHang = new DefaultTableModel();
    List<CTSP> listHDCT = new ArrayList<>();
    DefaultTableModel dtmSanPham = new DefaultTableModel();
    ChiTietSanPhamService serviceSanPham = new ChiTietSanPhamServiceImpl();
    List<CTSP> listSP = new ArrayList<>();
    // hàm insert hoa đon chi tiét
    HoaDonChiTietServiceImpl serviceHDCT = new HoaDonChiTietServiceImpl();
    public static int idHD;
    // Khởi tạo biến tổng tiền ban đầu là 0
    float tongTien = 0;
    // show giỏ hàng 
    HoaDonServiceImpl serviceHDV = new HoaDonServiceImpl();
    private Map<Integer, List<CTSP>> dbDem = new HashMap<>();

    public BanHang() {
        initComponents();
        listSP = serviceSanPham.listChiTietSanPham();
        listHD = serviceHD.listAll();
        //.stream().filter(hd -> hd.getTrangThai().trim().equals("Chờ thanh toán")).toList();
        showTableSanPham();
        dtmHD = (DefaultTableModel) tbHoaDon.getModel();
        // gan giỏ hàng
    }

    private void showTableHoaDon(List<HoaDon> listHD) {
        dtmHD.setRowCount(0);
        //  listHD = serviceHD.listAll().stream().filter(hd -> hd.getTrangThai().trim().equals("Chờ thanh toán")).toList();
        //listHD = serviceHD.listAll().stream().filter(hd -> hd.getTrangThai().trim().equals("Chờ thanh toán")).toList();
        for (HoaDon hd : listHD) {
            dtmHD.addRow(new Object[]{
                hd.getMaHD(), hd.getNgayTao(), hd.getTrangThai()
            });
        }
    }

    private HoaDon showViTri(int index) {
        HoaDon hd = listHD.get(index);
        idHD = hd.getIdHD();
        txtMaHD.setText(hd.getMaHD());
        Date ngayTao = hd.getNgayTao();
        txtNgayTao.setText(String.valueOf(ngayTao));
        tongTien = 0;
        for (CTSP ctsp : listHDCT) {
            tongTien += ctsp.thanhTien(); // Cộng giá trị thanhTien() của từng phần tử vào tổng
        }
        System.out.println("id hóa đơn là : " + idHD);
        System.out.println("Tổng tiền = " + tongTien); // In ra tổng của các giá trị thanhTien()
        txtTongTien.setText(String.valueOf(tongTien));
        return hd;
    }

    private HoaDon data() {
        String trangThai = "Đã thanh toán";
        HoaDon hd = new HoaDon();
        hd.setNgayTao(new Date(new java.util.Date().getTime()));
        hd.setTrangThai(trangThai);
        hd.setTongTien(tongTien);
        return hd;
    }

    private void showTableSanPham() {
        dtmSanPham = (DefaultTableModel) tbDanhSachSanPham.getModel();
        dtmSanPham.setRowCount(0);
        for (CTSP ct : listSP) {
            dtmSanPham.addRow(new Object[]{
                ct.getTenSanPham(),
                ct.getTenLoaiSP(),
                ct.getTenDongSanPham(),
                ct.getXuatSu(),
                ct.gethSD(),
                ct.getDonViTinh(),
                ct.getDonGia(),
                ct.getSoLuongTon(),});
        }

    }

    private void showGioHang(List<CTSP> listSP) {
        modelGioHang = (DefaultTableModel) tbGioHang.getModel();
        modelGioHang.setRowCount(0);
        for (CTSP g : listHDCT) {
            modelGioHang.addRow(new Object[]{
                g.getTenSanPham(), g.getSoLuongTon(), g.getDonGia(),
                g.thanhTien(),});
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        rdHDAll = new javax.swing.JRadioButton();
        rdHDDTT = new javax.swing.JRadioButton();
        rdHDCTT = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbGioHang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDanhSachSanPham = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtTenNhanVien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        txtGiamGia = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgayTao = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();

        setPreferredSize(new java.awt.Dimension(1100, 800));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 204, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1100, 800));

        jPanel3.setBackground(new java.awt.Color(51, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jButton1.setText("thêm");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdHDAll);
        rdHDAll.setText("Tất cả");
        rdHDAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdHDAllActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdHDDTT);
        rdHDDTT.setText("Đã Thanh Toán");
        rdHDDTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdHDDTTActionPerformed(evt);
            }
        });

        buttonGroup1.add(rdHDCTT);
        rdHDCTT.setText("Chờ Thanh Toán");
        rdHDCTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rdHDCTTActionPerformed(evt);
            }
        });

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "MaHD", "Ngày Tạo", "Trạng Thái"
            }
        ));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbHoaDon);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdHDAll)
                        .addGap(26, 26, 26)
                        .addComponent(rdHDDTT)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                        .addComponent(rdHDCTT))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(rdHDAll)
                    .addComponent(rdHDDTT)
                    .addComponent(rdHDCTT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Hóa Đơn Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        tbGioHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên SP", "Số Lượng", "Đơn Giá ", "Thành Tiền"
            }
        ));
        tbGioHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbGioHangMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbGioHang);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 627, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(51, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setText("Tìm Kiếm");

        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 0, 0)));

        tbDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Tên", "Loại", "Hương Vị", "Xuất Sứ", "Hạn Sử Dụng", "Quy Cách", "Đơn Giá", "Số Lượng"
            }
        ));
        tbDanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDanhSachSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbDanhSachSanPham);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(51, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đơn Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder("Thông Tin  Khách Hàng"));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 275, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 163, Short.MAX_VALUE)
        );

        jLabel2.setText("Mã HD");

        txtMaHD.setBackground(new java.awt.Color(0, 204, 255));
        txtMaHD.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        jLabel3.setText("Tên NV");

        txtTenNhanVien.setBackground(new java.awt.Color(0, 204, 255));
        txtTenNhanVien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        jLabel4.setText("Giảm Giá");

        jLabel6.setText("Tổng Tiền");

        txtTongTien.setBackground(new java.awt.Color(0, 204, 255));
        txtTongTien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        txtGiamGia.setBackground(new java.awt.Color(0, 204, 255));
        txtGiamGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        jLabel7.setText("Ngày Tạo");

        jLabel5.setText("Hình Thức TT ");

        jTextField2.setText("jTextField2");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaHD)
                            .addComponent(txtTenNhanVien, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txtTongTien)
                            .addComponent(txtGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                            .addComponent(txtNgayTao)))
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField2)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTenNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(txtNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(121, 121, 121)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(146, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 770));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int c = JOptionPane.showConfirmDialog(this, "bạn có muốn thêm hóa đơn không");
        if (c == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(this, serviceHD.them());
            showTableHoaDon(listHD = serviceHD.listAll().stream().filter(hd -> hd.getTrangThai().trim().equals("Chờ thanh toán")).toList());
        } else {
            return;
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tbDanhSachSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDanhSachSanPhamMouseClicked
        if (tbHoaDon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn hóa đơn trước khi thêm sản phẩm");
            return;
        }
        HoaDon hd = listHD.get(tbHoaDon.getSelectedRow());
        int row = this.tbDanhSachSanPham.getSelectedRow();
        CTSP sanPhamSelected = listSP.get(row);
        System.out.println(sanPhamSelected.getId());
        CTSP hoaDonSanPhamUpdate = new CTSP();

        hoaDonSanPhamUpdate.setId(sanPhamSelected.getId());
        hoaDonSanPhamUpdate.setTenSanPham(sanPhamSelected.getTenSanPham());
        hoaDonSanPhamUpdate.setDonGia(sanPhamSelected.getDonGia());

        boolean check = true;
        int viTriCheck = -1;

        String soLuongChon = JOptionPane.showInputDialog(this, "Chọn số lượng sản phẩm " + sanPhamSelected.getTenSanPham());
        Integer soLuongConvert = 0;
        Integer soLuongTon = sanPhamSelected.getSoLuongTon();
        try {
            if (soLuongChon.trim().length() == 0) {
                JOptionPane.showMessageDialog(this, "Bạn phải nhập số lượng sản phẩm " + sanPhamSelected.getTenSanPham());
                return;
            }
            try {
                soLuongConvert = Integer.valueOf(soLuongChon);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Bạn phải nhập kiểu số nguyên");
                return;
            }

            for (int i = 0; i < listHDCT.size(); i++) {
                CTSP el = listHDCT.get(i);
                System.out.println(el.getId() + "aaaaaaa");
                if (el.getId() == sanPhamSelected.getId()) {
                    check = false;
                    viTriCheck = i;
                    break;
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "LỖi");
            return;
        }
        // load giỏ hàng
        if (!check) {
            hoaDonSanPhamUpdate.setSoLuongTon(listHDCT.get(viTriCheck).getSoLuongTon() + soLuongConvert);
            listHDCT.set(viTriCheck, hoaDonSanPhamUpdate);
        } else {
            hoaDonSanPhamUpdate.setSoLuongTon(soLuongConvert);
            listHDCT.add(hoaDonSanPhamUpdate);
        }
        showGioHang(listHDCT);
        dbDem.put(hd.getIdHD(), listHDCT);
        // load chi tiết sản phẩm
        soLuongTon = soLuongTon - soLuongConvert;
        sanPhamSelected.setSoLuongTon(soLuongTon);
        listSP.set(row, sanPhamSelected);
        showTableSanPham();
    }//GEN-LAST:event_tbDanhSachSanPhamMouseClicked

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        int index = tbHoaDon.getSelectedRow();
        showViTri(index);
        HoaDon hoaDon = listHD.get(index);
        listHDCT = new ArrayList<>();
        if (dbDem.containsKey(hoaDon.getIdHD())) {
            listHDCT.addAll(dbDem.get(hoaDon.getIdHD()));
        } else {
            listHDCT.addAll(serviceSanPham.getSanPhamInHoaDon(hoaDon.getIdHD()));
            dbDem.put(hoaDon.getIdHD(), listHDCT);
        }
        showGioHang(listHDCT);
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void tbGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGioHangMouseClicked
//        int index = tbGioHang.getSelectedRow();
//        int soLuongSPBanDau = 0;
//        System.out.println(listHDCT.size());
//        if (index >= 0 && index < listHDCT.size()) {
//            // Chỉ thực hiện thao tác khi index hợp lệ
//            System.out.println("ID : " + listHDCT.get(index).getId());
//            System.out.println("sô lượng của sp có trong giỏ hàng : " + listHDCT.get(index).getSoLuongTon());
//            int idsp = listHDCT.get(index).getId();
//            // int soLuongSanPhamInGioHang = listHDCT.get(index).getSoLuongTon();
//            // int soLuongSanPham = tbDanhSachSanPham.getSelectedRow();
//            for (int i = 0; i < listSP.size(); i++) {
//                CTSP el = listSP.get(i);
//                if (el.getId() == idsp) {
//                    soLuongSPBanDau = el.getSoLuongTon();
//                }
//            }
//            System.out.println("so luong trong bảng sp ban đầu là : " + soLuongSPBanDau);
//        } else {
//            System.out.println("Index không hợp lệ!");
//        }
        int row = tbGioHang.getSelectedRow();
        int soLuongChon = 0;
        int soLuongUpdate = 0;

        if (row >= 0 && row < listHDCT.size()) {
            int IDSanPhamTrongGioHang = listHDCT.get(row).getId();
            int soLuongSanPhamTrongGioHang = listHDCT.get(row).getSoLuongTon();

            System.out.println("ID sản phẩm trong giỏ hàng = " + IDSanPhamTrongGioHang);
            System.out.println("Số lượng sản phẩm trong giỏ hàng = " + soLuongSanPhamTrongGioHang);

            String input = JOptionPane.showInputDialog(this, "Vui lòng nhập số lượng bạn muốn xóa");
            if (input != null && !input.isEmpty() && input.matches("\\d+")) {
                // Tiếp tục xử lý
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên dương.");
                return;
            }
            if (input != null && !input.isEmpty()) {
                soLuongChon = Integer.parseInt(input);
                System.out.println("Số lượng bạn nhập vào là = " + soLuongChon);
                soLuongUpdate = soLuongSanPhamTrongGioHang - soLuongChon;
                System.out.println("Tổng số lượng còn lại trong giỏ hàng = " + soLuongUpdate);

                // Lấy đối tượng CTSP từ listHDCT và cập nhật soLuongTon của nó
                CTSP sp = listHDCT.get(row);
                sp.setSoLuongTon(soLuongUpdate);
                listHDCT.set(row, sp); // Cập nhật lại đối tượng CTSP trong danh sách
                showGioHang(listSP);

                // update lại bảng chi tiết sản phẩm số lượng ở bản sản phẩm + với số lượng chọn 
                int soLuongSanPhamTrongKho = listSP.get(row).getSoLuongTon();
                int TongSoLuongUpdate = soLuongSanPhamTrongKho + soLuongChon;
                CTSP spKho = listSP.get(row);
                spKho.setSoLuongTon(TongSoLuongUpdate);
                listSP.set(row, spKho);
                showTableSanPham();
            } else {
                return;
            }
        } else {
            // Xử lý logic nếu không có hàng nào được chọn trong giỏ hàng
            System.out.println("Chọn sản phẩm trong giỏ hàng trước khi thực hiện hành động này");
        }
    }//GEN-LAST:event_tbGioHangMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        if (tbHoaDon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn hóa đơn trước khi thêm sản phẩm");
            return;
        }
        HoaDon hd = listHD.get(tbHoaDon.getSelectedRow());
        System.out.println("HD: " + hd.getIdHD());
        ;
        System.out.println(serviceHDCT.deleteAllByIdHD(hd.getIdHD()));
        for (CTSP el : dbDem.get(hd.getIdHD())) {
            HoaDonChiTiet hdct = new HoaDonChiTiet();
            int idSP = el.getId();
            hdct.setiDHD(hd.getIdHD());
            hdct.setiDCTSP(idSP);
            hdct.setSoLuong(el.getSoLuongTon());
            hdct.setDonGia(el.getDonGia());
            serviceHDCT.them(hdct);
            updateChiTietSanPhamById(el.getId());
        }

        JOptionPane.showMessageDialog(this, serviceHD.updateTrangThaiHoaDon(data()));
        showTableHoaDon(listHD = serviceHD.listAll());
        listHDCT.clear();
        showGioHang(listHDCT);
    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void rdHDCTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdHDCTTActionPerformed
        listHD = serviceHD.listAll().stream().filter(hd -> hd.getTrangThai().trim().equals("Chờ thanh toán")).toList();
        showTableHoaDon(listHD);
    }//GEN-LAST:event_rdHDCTTActionPerformed

    private void rdHDDTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdHDDTTActionPerformed
        listHD = serviceHD.listAll().stream().filter(hd -> hd.getTrangThai().trim().equals("Đã thanh toán")).toList();
        showTableHoaDon(listHD);
    }//GEN-LAST:event_rdHDDTTActionPerformed

    private void rdHDAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdHDAllActionPerformed
        showTableHoaDon(listHD = serviceHD.listAll());
    }//GEN-LAST:event_rdHDAllActionPerformed

    public void updateChiTietSanPhamById(int idsp) {
        for (int i = 0; i < listSP.size(); i++) {
            CTSP el = listSP.get(i);
            if (el.getId() == idsp) {
                ChiTietSanPham chiTietSanPham = new ChiTietSanPham();
                chiTietSanPham.setIdCTSP(el.getId());
                chiTietSanPham.setSoLuongTon(el.getSoLuongTon());
                serviceSanPham.updateCTSPInGioHang(chiTietSanPham);
            }
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButton rdHDAll;
    private javax.swing.JRadioButton rdHDCTT;
    private javax.swing.JRadioButton rdHDDTT;
    private javax.swing.JTable tbDanhSachSanPham;
    private javax.swing.JTable tbGioHang;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtNgayTao;
    private javax.swing.JTextField txtTenNhanVien;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
