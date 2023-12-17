/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controler.ChiTietSanPhamServiceImpl;
import controler.HoaDonChiTietServiceImpl;
import controler.HoaDonServiceImpl;
import controler.KhachHangServiceImp;
import controler.VoucherServicerImpl;
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
import model.KhachHang;
import model.Voucher;
import modelView.CTSP;
import modelView.HDCT;
import repository.ChiTietSanPhamService;
import repository.KhachHangService;
import repository.VoucherService;

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
    VoucherService servicrVouCher = new VoucherServicerImpl();
    List<CTSP> listSP = new ArrayList<>();
    // hàm insert hoa đon chi tiét
    HoaDonChiTietServiceImpl serviceHDCT = new HoaDonChiTietServiceImpl();
    public static int idHD;
    // Khởi tạo biến tổng tiền ban đầu là 0
    float tongTien = 0;
    float tienThanhToan = 0;
    // show giỏ hàng 
    HoaDonServiceImpl serviceHDV = new HoaDonServiceImpl();
    private Map<Integer, List<CTSP>> dbDem = new HashMap<>();
    // Show khách hàng
    KhachHangService serviceKhachHang = new KhachHangServiceImp();
    List<KhachHang> listKhachHang = new ArrayList<>();
    List<Voucher> listVouCher = new ArrayList<>();

    public BanHang() {
        initComponents();
        listSP = serviceSanPham.listSanPhamInBill();
        listHD = serviceHD.listAll();
        //.stream().filter(hd -> hd.getTrangThai().trim().equals("Chờ thanh toán")).toList();
        showTableSanPham(listSP);
        dtmHD = (DefaultTableModel) tbHoaDon.getModel();
        // gan giỏ hàng
        txtTenKhachHang.setText("Khách lẻ");
    }

    private void showTableHoaDon(List<HoaDon> listHD) {
        dtmHD.setRowCount(0);
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
        // txtNgayTao.setText(String.valueOf(ngayTao));
        tongTien = 0;
        tienThanhToan = 0;
        String inputGiamGia = txtGiamGia.getText();
        int phanTramGiam = 0;
        if (inputGiamGia.isEmpty()) {
            phanTramGiam = 0;
        } else if (inputGiamGia != null) {
            phanTramGiam = Integer.parseInt(inputGiamGia);
        }

        for (CTSP ctsp : listHDCT) {
            // Cộng giá trị thanhTien() của từng phần tử vào tổng
            tongTien += ctsp.thanhTien();

        }
        tienThanhToan = tongTien - (tongTien * phanTramGiam / 100);
        System.out.println("id hóa đơn là : " + idHD);
        System.out.println("Tổng tiền = " + tongTien); // In ra tổng của các giá trị thanhTien()
        txtTongTien.setText(String.valueOf(tongTien));
        txtTienCanThanhToan.setText(String.valueOf(tienThanhToan));
        return hd;
    }

    private HoaDon data() {
        String trangThai = "Đã thanh toán";
        int id_vouCher = 0;
        int id_KhachHang = 0;
        String voucher = txtVouCher.getText();
        String sdt = txtSDTKhachHang.getText();
        HoaDon hd = new HoaDon();
        hd.setNgayTao(new Date(new java.util.Date().getTime()));
        hd.setTrangThai(trangThai);
        String tienThanhToan = txtTienCanThanhToan.getText();
        hd.setTongTien(Float.parseFloat(tienThanhToan));
        System.out.println("tien can thanh toan = " + tienThanhToan);
        hd.setId_KhachHang(view.KhachHangInHoaDon.idKhachHang);
        if (voucher.isEmpty()) {
            id_vouCher = 0;
        } else {
            hd.setId_VouCher(view.VouCherView.id);
        }
        return hd;
    }

    private void showTableSanPham(List<CTSP> listSP) {
        dtmSanPham = (DefaultTableModel) tbDanhSachSanPham.getModel();
        dtmSanPham.setRowCount(0);
        int index = 1;
        for (CTSP ct : listSP) {
            dtmSanPham.addRow(new Object[]{
                index,
                ct.getMaSPCT(),
                ct.getTenSanPham(),
                ct.getHuongVi(),
                ct.getHanSuDung(),
                ct.getDonViTinh(),
                ct.getKhoiLuong(),
                ct.getDonGia(),
                ct.getSoLuongTon(),});
            index++;
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

    public boolean thanhToan() {
        String inputTienKhachDua = txtTienKhachDua.getText();
        Float tienKhachDua = 0f;
        Float tienThua = 0f;
        int pttt = cbbPTTT.getSelectedIndex();
        if (pttt == 0) {
            if (inputTienKhachDua.matches("[a-zA-Z]+")) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số !");
                return false;
            } else if (inputTienKhachDua.isEmpty()) {
                tienKhachDua = 0f;
                txtTienKhachDua.setText(String.valueOf(tienKhachDua));
                return false;
            } else if (!inputTienKhachDua.isEmpty()) {
                tienKhachDua = Float.parseFloat(inputTienKhachDua);
                if (tienKhachDua < tienThanhToan) {
                    JOptionPane.showMessageDialog(this, "Tiền Khách Đưa Không Đủ !");
                    return false;
                } else if (tienKhachDua > tienThanhToan) {
                    tienThua = 0f;
                    tienThua = tienKhachDua - tienThanhToan;
                    txtTienThuaTraKhach.setText(String.valueOf(tienThua));
                    return true;
                } else if (tienKhachDua == tienThanhToan) {
                    tienThua = 0f;
                    txtTienThuaTraKhach.setText(String.valueOf(tienThua));
                    return true;
                }
                return true;
            }
        } else if (pttt == 1) {
            tienThua = 0f;
            tienKhachDua = 0f;
            txtTienThuaTraKhach.setText(String.valueOf(tienThua));
            txtTienThuaTraKhach.setText(String.valueOf(tienThua));
            return true;
        }

        return true;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jTextField2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        rdHDCTT = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbGioHang = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtSerchSanPham = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDanhSachSanPham = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtSDTKhachHang = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtTenKhachHang = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMaHD = new javax.swing.JTextField();
        btnThanhToan = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtGiamGia = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtTienCanThanhToan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtTienKhachDua = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtTienThuaTraKhach = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        cbbPTTT = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        txtVouCher = new javax.swing.JTextField();
        btnChonVouCher = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jTextField2.setText("jTextField2");

        jLabel12.setText("jLabel12");

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
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 222, Short.MAX_VALUE)
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
                    .addComponent(rdHDCTT))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(51, 204, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Hóa Đơn Chi Tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

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
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(51, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh Sách Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel1.setText("Tìm Kiếm");

        txtSerchSanPham.setBackground(new java.awt.Color(0, 204, 255));
        txtSerchSanPham.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtSerchSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSerchSanPhamMouseClicked(evt);
            }
        });

        tbDanhSachSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã CTSP", "Tên Sản phẩm", "Hương Vị", "Hạn Sử Dụng", "Quy Cách", "Khối Lượng", "Đơn Giá", "Số Lượng"
            }
        ));
        tbDanhSachSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDanhSachSanPhamMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbDanhSachSanPham);
        if (tbDanhSachSanPham.getColumnModel().getColumnCount() > 0) {
            tbDanhSachSanPham.getColumnModel().getColumn(6).setResizable(false);
        }

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(txtSerchSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane3)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtSerchSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel5.setBackground(new java.awt.Color(51, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Đơn Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(0, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin  Khách Hàng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel8.setText("Số Điện Thoại :");

        jLabel9.setText("Tên Khách Hàng :");

        jButton2.setText("Chọn");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Thay Đổi");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(txtSDTKhachHang, javax.swing.GroupLayout.DEFAULT_SIZE, 118, Short.MAX_VALUE)
                    .addComponent(txtTenKhachHang))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtSDTKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtTenKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel2.setText("Mã Hóa Đơn :");

        txtMaHD.setBackground(new java.awt.Color(0, 204, 255));
        txtMaHD.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        btnThanhToan.setBackground(new java.awt.Color(255, 153, 51));
        btnThanhToan.setText("THANH TOÁN");
        btnThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThanhToanActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel3.setText("Tổng Tiền :");

        txtTongTien.setBackground(new java.awt.Color(0, 204, 255));
        txtTongTien.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel4.setText("Giảm Giá :");

        txtGiamGia.setBackground(new java.awt.Color(0, 204, 255));
        txtGiamGia.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel5.setText("Thanh Toán :");

        txtTienCanThanhToan.setBackground(new java.awt.Color(0, 204, 255));
        txtTienCanThanhToan.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel6.setText("Tiền Khách Đưa :");

        txtTienKhachDua.setBackground(new java.awt.Color(0, 204, 255));
        txtTienKhachDua.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtTienKhachDua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTienKhachDuaMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel7.setText("Tiền Thừa Trả Khách :");

        txtTienThuaTraKhach.setBackground(new java.awt.Color(0, 204, 255));
        txtTienThuaTraKhach.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel10.setText("Hình Thức Thanh Toán :");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel11.setText("Ghi Chú :");

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane4.setViewportView(jTextArea1);

        cbbPTTT.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tiền Mặt", "Chuyển Khoản" }));
        cbbPTTT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbPTTTMouseClicked(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel13.setText("VouCher :");

        txtVouCher.setBackground(new java.awt.Color(0, 204, 255));
        txtVouCher.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        txtVouCher.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtVouCherMouseClicked(evt);
            }
        });

        btnChonVouCher.setText("Áp Dụng");
        btnChonVouCher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonVouCherActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel2)
                                            .addComponent(jLabel3))
                                        .addGap(86, 86, 86)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel5Layout.createSequentialGroup()
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(jLabel5)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel7))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtGiamGia, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                                    .addComponent(txtTienCanThanhToan, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                                                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
                                                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtTienThuaTraKhach)
                                                    .addComponent(cbbPTTT, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                            .addGroup(jPanel5Layout.createSequentialGroup()
                                                .addComponent(txtVouCher, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(btnChonVouCher))))
                                    .addComponent(jLabel11)))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel13)))
                        .addGap(0, 10, Short.MAX_VALUE))
                    .addComponent(jScrollPane4))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtVouCher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnChonVouCher))
                .addGap(24, 24, 24)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGiamGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTienCanThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTienKhachDua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTienThuaTraKhach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cbbPTTT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32)
                .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jButton4.setText("Làm mới");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton4)
                        .addGap(35, 35, 35)))
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
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
        int soLuongCheckValidate = listSP.get(row).getSoLuongTon();
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
            if (soLuongConvert < soLuongCheckValidate && soLuongConvert > 0) {
                for (int i = 0; i < listHDCT.size(); i++) {
                    CTSP el = listHDCT.get(i);
                    if (el.getId() == sanPhamSelected.getId()) {
                        check = false;
                        viTriCheck = i;
                        break;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(this, "So luong sản phẩm không đủ hoặc bạn nhập sai số lượng");
                return;
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
        showTableSanPham(listSP);
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
        System.out.println(listHD.get(index).getIdHD());
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void tbGioHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbGioHangMouseClicked
        int row = tbGioHang.getSelectedRow();
        int soLuongChon = 0;
        int soLuongUpdate = 0;
        int soLuongCheck = listHDCT.get(row).getSoLuongTon();
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
            soLuongChon = Integer.parseInt(input);
            if (input != null && !input.isEmpty()) {
            } else {
                return;
            }
            if (soLuongChon <= soLuongCheck) {
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
                showTableSanPham(listSP);
            } else {
                JOptionPane.showMessageDialog(this, "vui lòng nhập số lượng không lơn hơn số lượng trong giỏ hàng");
            }
        } else {
            // Xử lý logic nếu không có hàng nào được chọn trong giỏ hàng
            System.out.println("Chọn sản phẩm trong giỏ hàng trước khi thực hiện hành động này");
        }
    }//GEN-LAST:event_tbGioHangMouseClicked

    private void btnThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThanhToanActionPerformed
        int idSP = 0;
        if (tbHoaDon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn hóa đơn trước khi thêm sản phẩm");
            return;
        }
        if (thanhToan() == true) {
            HoaDon hd = listHD.get(tbHoaDon.getSelectedRow());
            System.out.println("HD trong thanh toán : " + hd.getIdHD());
            for (CTSP el : dbDem.get(hd.getIdHD())) {
                HoaDonChiTiet hdct = new HoaDonChiTiet();
                idSP = el.getId();
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
            JOptionPane.showMessageDialog(this, "thanh toán thành công");
        } else {
            JOptionPane.showMessageDialog(this, "thanh toán thất bại");
        }


    }//GEN-LAST:event_btnThanhToanActionPerformed

    private void rdHDCTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rdHDCTTActionPerformed
        listHD = serviceHD.listAll().stream().filter(hd -> hd.getTrangThai().trim().equals("Chờ thanh toán")).toList();
        showTableHoaDon(listHD);
    }//GEN-LAST:event_rdHDCTTActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tbHoaDon.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Bạn phải chọn hóa đơn trước khi thêm Hóa Đơn Trước Khi Thêm Khách Hàng ");
            return;
        }
        new KhachHangInHoaDon().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        listKhachHang = serviceKhachHang.listKhachHang();
        int idKh = view.KhachHangInHoaDon.idKhachHang;
        for (KhachHang kh : listKhachHang) {
            if (kh.getId() == idKh) {
                txtSDTKhachHang.setText(kh.getTen());
                txtTenKhachHang.setText(kh.getSdt());
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnChonVouCherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonVouCherActionPerformed
        listVouCher = servicrVouCher.listAll();
        int idVouCher = view.VouCherInHoaDon.idVouCher;
        for (Voucher vc : listVouCher) {
            if (vc.getId() == idVouCher) {
                txtVouCher.setText(vc.getMaVoucher());
                txtGiamGia.setText(String.valueOf(vc.getPhanTram()));
            }
        }
        showViTri(idHD = tbHoaDon.getSelectedRow());
    }//GEN-LAST:event_btnChonVouCherActionPerformed

    private void txtVouCherMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtVouCherMouseClicked
        if (tbHoaDon.getSelectedRow() != -1) {
            VouCherInHoaDon vouCher = new VouCherInHoaDon();
            vouCher.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "vui lòng chọn hóa đơn trước khi chọn voucher");
            return;
        }

    }//GEN-LAST:event_txtVouCherMouseClicked

    private void txtSerchSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSerchSanPhamMouseClicked
        listSP = serviceSanPham.listSanPhamInBill();
        String timSP = txtSerchSanPham.getText();
        showTableSanPham(listSP.stream().filter(sp -> sp.getTenSanPham().equals(timSP) || sp.getHuongVi().equals(timSP)).toList());
    }//GEN-LAST:event_txtSerchSanPhamMouseClicked

    private void txtTienKhachDuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTienKhachDuaMouseClicked
        thanhToan();
    }//GEN-LAST:event_txtTienKhachDuaMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        for (int i = 0; i < listHDCT.size(); i++) {
            CTSP spHDCT = listHDCT.get(i);
            for (CTSP spListSP : listSP) {
                if (spHDCT.getId() == spListSP.getId()) {
                    int soLuongGioHang = spHDCT.getSoLuongTon();
                    int soLuongSanPham = spListSP.getSoLuongTon();
                    int tong = soLuongGioHang + soLuongSanPham;
                    System.out.println("Tổng = " + tong);

                    // Cập nhật giá trị số lượng trong listSP
                    spListSP.setSoLuongTon(tong);
                    break; // Dừng vòng lặp sau khi cập nhật giá trị
                }
            }

            // Xóa đối tượng khỏi listHDCT
            listHDCT.remove(i);
            i--; // Giảm chỉ số để kiểm soát vị trí sau khi xóa
        }
        // Hiển thị danh sách sản phẩm sau khi cập nhật
        showGioHang(listSP);
        showTableSanPham(listSP);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbbPTTTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbPTTTMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbPTTTMouseClicked

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
    private javax.swing.JButton btnChonVouCher;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbPTTT;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JRadioButton rdHDCTT;
    private javax.swing.JTable tbDanhSachSanPham;
    private javax.swing.JTable tbGioHang;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTextField txtGiamGia;
    private javax.swing.JTextField txtMaHD;
    private javax.swing.JTextField txtSDTKhachHang;
    private javax.swing.JTextField txtSerchSanPham;
    private javax.swing.JTextField txtTenKhachHang;
    private javax.swing.JTextField txtTienCanThanhToan;
    private javax.swing.JTextField txtTienKhachDua;
    private javax.swing.JTextField txtTienThuaTraKhach;
    private javax.swing.JTextField txtTongTien;
    private javax.swing.JTextField txtVouCher;
    // End of variables declaration//GEN-END:variables
}
