/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controler.ChiTietSanPhamServiceImpl;
import controler.DongSanPhamServiceImpl;
import controler.KhoiLuongSanPhamImpl;
import controler.LoaiSanPhamImpl;
import controler.NSXImpl;
import controler.SanPhamServiceImpl;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSanPham;
import model.DongSanPham;
import model.KhoiLuongSanPham;
import model.LoaiSanPham;
import model.NSX;
import modelView.CTSP;
import repository.ChiTietSanPhamService;
import repository.CrudfullTable;
import repository.DongSanPhamService;
import repository.KhoiLuongService;
import repository.SanPhamService;
import java.io.*;
import java.util.Date;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author vuhoa
 */
public class SanPham extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    ChiTietSanPhamService serviceCTSP = new ChiTietSanPhamServiceImpl();
    List<ChiTietSanPham> ListCTSP = new ArrayList<>();
    List<CTSP> listCTSPView = new ArrayList<>();
    public static int idCTSP;
    // đường dẫn ản 
    private String duongDan = "D:\\DuAn1\\image\\face";
    // chi tiết sp view
    // Bảng Sản phẩm : 
    SanPhamService serviceSanPham = new SanPhamServiceImpl();
    List<model.SanPham> listSanPham = new ArrayList<>();
    // bảng loại sản phẩm : 
    CrudfullTable<LoaiSanPham> serviceLoaiSanPham = new LoaiSanPhamImpl();
    List<LoaiSanPham> listLSP = new ArrayList<>();
    // bảng dòng sản phẩm : 
    DongSanPhamService serviceDongSP = new DongSanPhamServiceImpl();
    List<DongSanPham> listDongSanPham = new ArrayList<>();
    // bảng Nhà Sản xuất 
    CrudfullTable<NSX> serviceNSX = new NSXImpl();
    List<NSX> listsNSX = new ArrayList<>();
    // bảng khối lượng 
    KhoiLuongService serviceKhoiLuong = new KhoiLuongSanPhamImpl();
    List<KhoiLuongSanPham> listKhoiLuong = new ArrayList<>();
    // 

    public SanPham() {
        initComponents();
        // chi tiết sản phẩm 
        dtm = (DefaultTableModel) tbCTSP.getModel();
        //listLSP = serviceCTSP.listChiTietSanPham();

        listCTSPView = serviceCTSP.listChiTietSanPham();
        showTable(listCTSPView);
        // bảng sản phẩm 
        listSanPham = serviceSanPham.listSanPham();
        // bảng loại sản phẩm 
        listLSP = serviceLoaiSanPham.listAll();
        // bảng dòng sản phẩm : 
        listDongSanPham = serviceDongSP.listDongSanPham();
        // bảng Nhà Sản xuất 
        listsNSX = serviceNSX.listAll();
        // bảng khối lượng 
        listKhoiLuong = serviceKhoiLuong.listKhoiLuong();
        // 
    }

    private void showTable(List<CTSP> listCTSPView) {
        dtm.setRowCount(0);
        for (CTSP ctsp : listCTSPView) {
            dtm.addRow(new Object[]{
                ctsp.getMaSPCT(),
                ctsp.getTenSanPham(),
                ctsp.getTenLoaiSP(),
                ctsp.getTenDongSanPham(),
                ctsp.gethSD(),
                ctsp.getXuatSu(),
                ctsp.getSoLuongTon(),
                ctsp.getDonGia(),
                ctsp.getKhoiLuong(),
                ctsp.getDonViTinh(),
                ctsp.getMaQr(),
                ctsp.getGhiChu(),
                ctsp.getAnh(),
                ctsp.getTrangThai() == 1 ? "Hoạt Động" : "Không Hoạt Động",});
        }
    }

//    private boolean checkValidate() {
//
//        try {
//            String ma = txtMaCTSP.getText();
//        } catch (Exception e) {
//            return false;
//        }
//        model.SanPham sanPham = listSanPham.get(cbbTenSanPham.getSelectedIndex());
//        String loaiSanPham = String.valueOf(cbbLoaiSanPham.getSelectedIndex());
//        String dongSanPham = String.valueOf(cbbDongSanPham.getSelectedIndex());
//        java.util.Date hsdDate = txtHanSuDung.getDate();
//        java.sql.Date hsdSQL = new java.sql.Date(hsdDate.getTime());
//        String xuatSu = String.valueOf(cbbQuocGia.getSelectedIndex());
//        Integer soLuongTon = (Integer) txtSoLuongTon.getValue();
//        Float donGia = Float.parseFloat(txtDGSPCT.getText());
//        String khoiLuong = String.valueOf(cbbKhoiLuong.getSelectedIndex());
//        String dVT = txtDonViTinh.getText();
//        String qr = txtMaQr.getText();
//        String ghiChu = txtGhiChu.getText();
//        int trangThai;
//
//        return true;
//    }
    private CTSP showIndex(int index) {
        CTSP sp = listCTSPView.get(index);
        idCTSP = sp.getId();
        txtMaCTSP.setText(sp.getMaSPCT());
        cbbTenSanPham.removeAllItems();
        cbbTenSanPham.addItem(sp.getTenSanPham());
        cbbLoaiSanPham.removeAllItems();
        cbbLoaiSanPham.addItem(sp.getTenLoaiSP());
        cbbDongSanPham.removeAllItems();
        cbbDongSanPham.addItem(sp.getTenDongSanPham());
        txtHanSuDung.setDate(sp.gethSD());
        cbbQuocGia.removeAllItems();
        cbbQuocGia.addItem(sp.getXuatSu());
        // txtSoLuongTon.setToolTipText(Integer.parseInt(sp.getSoLuongTon()));
        // Giả sử sp.getSoLuongTon() trả về một chuỗi chứa số lượng tồn
        int soLuongTon = Integer.parseInt(String.valueOf(sp.getSoLuongTon()));
        // Đặt giá trị số lượng tồn vào JSpinner txtSoLuongTon
        txtSoLuongTon.setValue(soLuongTon);

        txtDGSPCT.setText(String.valueOf(sp.getDonGia()));
        cbbKhoiLuong.removeAllItems();
        cbbKhoiLuong.addItem(sp.getKhoiLuong());
        txtDonViTinh.setText(sp.getDonViTinh());
        txtMaQr.setText(sp.getMaQr());

        txtGhiChu.setText(sp.getGhiChu());
        //  ảnh 
        String imagePath = sp.getAnh();
        ImageIcon imageIcon = new ImageIcon(imagePath);
        lbHinhAnh.setIcon(imageIcon);
        // còn trạng thái chưa làm 
        int trangThai = sp.getTrangThai();
        if (trangThai == 1) {
            rdHD.setSelected(true);
        } else {
            rdKHD.setSelected(true);
        }

        return sp;
    }

    private ChiTietSanPham data() {
        String maCTSP = txtMaCTSP.getText();
        if (maCTSP.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Tên không được để trống");
            return null;
        }
        model.SanPham sanPham = listSanPham.get(cbbTenSanPham.getSelectedIndex());
        String loaiSanPham = String.valueOf(cbbLoaiSanPham.getSelectedIndex());
        if (loaiSanPham.isEmpty()) {
            JOptionPane.showMessageDialog(this, " Loại Sản phẩm không được để trống");
            return null;
        }
        String dongSanPham = String.valueOf(cbbDongSanPham.getSelectedIndex());
        if (dongSanPham.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Hương Vị Không Được để trống");
            return null;
        }
        java.util.Date hsdDate = txtHanSuDung.getDate();
//        if (hsdDate == null) {
//            JOptionPane.showMessageDialog(this, " không được để trống hạn sử dụng");
//            return null;
//        }
        java.sql.Date hsdSQL = new java.sql.Date(hsdDate.getTime());
        String xuatSu = String.valueOf(cbbQuocGia.getSelectedIndex());
//        if (xuatSu.isEmpty()) {
//            JOptionPane.showMessageDialog(this, "Xuất sứ không được để trống");
//            return null;
//        }
        Integer soLuongTon = (Integer) txtSoLuongTon.getValue();
//        if (soLuongTon == null) {
//            JOptionPane.showMessageDialog(this, "Số Lượng Tồn không được để trống");
//            return null;
//        }
        Float donGia = Float.parseFloat(txtDGSPCT.getText());
//        if (donGia == null) {
//            JOptionPane.showMessageDialog(this, "Đơn giá không được để trống");
//            return null;
//        }
        String khoiLuong = String.valueOf(cbbKhoiLuong.getSelectedIndex());
        String dVT = txtDonViTinh.getText();
        String qr = txtMaQr.getText();
        String ghiChu = txtGhiChu.getText();
        int trangThai;
        ///////////////////////////////
        ChiTietSanPham sp = new ChiTietSanPham();
        sp.setMaCTSP(maCTSP);
        sp.setIdSanPham(sanPham.getId());
        sp.setIdLoaiSp(listLSP.get(cbbLoaiSanPham.getSelectedIndex()).getId());
        sp.setIdDongSanPham(listDongSanPham.get(cbbDongSanPham.getSelectedIndex()).getId_DSP());
        sp.sethSD(hsdSQL);
        sp.setSoLuongTon(soLuongTon);
        sp.setDonGia(donGia);
        sp.setIdNSX(listsNSX.get(cbbQuocGia.getSelectedIndex()).getId());
        sp.setIdKhoiLuong(listKhoiLuong.get(cbbKhoiLuong.getSelectedIndex()).getIdKL());
        sp.setDonViTinh(dVT);
        sp.setMaQr(qr);
        // anhr 
        sp.setAnh(duongDan);
        sp.setGhiChu(ghiChu);
        //sp.getTrangThai();
        if (rdHD.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        sp.setTrangThai(trangThai);

        return sp;

    }

    // hàm lấy ảnh : 
    public ImageIcon setSizeImg(String imagePath) {
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        // Tạo ảnh mới với kích thước mong muốn
        Image newImg = img.getScaledInstance(lbHinhAnh.getWidth(), lbHinhAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void showComboboxSanPham() {
        // Bảng Sản phẩm 
        cbbTenSanPham.removeAllItems();
        for (model.SanPham sp : listSanPham) {
            cbbTenSanPham.addItem(sp.getTen());
        }
    }

    private void showComboboxLoaiSanPham() {
        cbbLoaiSanPham.removeAllItems();
        for (LoaiSanPham sp : listLSP) {
            cbbLoaiSanPham.addItem(sp.getTen());
        }
    }

    private void showComboboxDongSanPham() {
        cbbDongSanPham.removeAllItems();
        for (DongSanPham sp : listDongSanPham) {
            cbbDongSanPham.addItem(sp.getTenDSP());
        }
    }

    private void showComboboxQG() {
        cbbQuocGia.removeAllItems();
        for (NSX nsx : listsNSX) {
            cbbQuocGia.addItem(nsx.getQuocGia());
        }
    }

    private void showComboboxKhoiLuong() {
        cbbKhoiLuong.removeAllItems();
        for (KhoiLuongSanPham kl : listKhoiLuong) {
            cbbKhoiLuong.addItem(kl.getTenKL());
        }
    }

    private void SerchTen(String tim) {
        tim = txtSerch.getText();
        listCTSPView = serviceCTSP.Serch(tim);
        showTable(listCTSPView);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        javax.swing.JTabbedPane listQuanLySanPham = new javax.swing.JTabbedPane();
        pnSanPhamChiTiet = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaCTSP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cbbTenSanPham = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        cbbLoaiSanPham = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        cbbDongSanPham = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtHanSuDung = new com.toedter.calendar.JDateChooser();
        jLabel6 = new javax.swing.JLabel();
        cbbQuocGia = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        txtDGSPCT = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cbbKhoiLuong = new javax.swing.JComboBox<>();
        jButton5 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtDonViTinh = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtMaQr = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChu = new javax.swing.JTextArea();
        jLabel14 = new javax.swing.JLabel();
        rdHD = new javax.swing.JRadioButton();
        rdKHD = new javax.swing.JRadioButton();
        lbHinhAnh = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        txtSerch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCTSP = new javax.swing.JTable();
        btnloadData = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(1100, 800));

        listQuanLySanPham.setPreferredSize(new java.awt.Dimension(1100, 800));

        pnSanPhamChiTiet.setBackground(new java.awt.Color(51, 204, 255));
        pnSanPhamChiTiet.setPreferredSize(new java.awt.Dimension(1100, 800));

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(730, 300));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel1.setText("Mã sản phẩm chi tiết :");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, -1));
        jPanel1.add(txtMaCTSP, new org.netbeans.lib.awtextra.AbsoluteConstraints(157, 8, 170, -1));

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel2.setText("Tên Sản phẩm :");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 110, -1));

        cbbTenSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbTenSanPhamMouseClicked(evt);
            }
        });
        jPanel1.add(cbbTenSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 48, 200, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel3.setText("Loại Sản Phẩm :");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 110, -1));

        cbbLoaiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbLoaiSanPhamMouseClicked(evt);
            }
        });
        jPanel1.add(cbbLoaiSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 89, 200, -1));

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel4.setText("Hương Vị Sữa :");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jPanel1.add(cbbDongSanPham, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 130, 200, -1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel5.setText("Hạn Sử Dụng :");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 180, 100, -1));

        txtHanSuDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHanSuDungMouseClicked(evt);
            }
        });
        jPanel1.add(txtHanSuDung, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 180, 200, -1));

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel6.setText(" Xuất Sứ :");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 220, 70, -1));

        jPanel1.add(cbbQuocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 220, 200, -1));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel7.setText("Đơn giá :");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 50, 89, -1));
        jPanel1.add(txtSoLuongTon, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 10, 190, -1));

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel8.setText("Số Lượng Tồn :");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 10, 110, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plusmini.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 48, 33, -1));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plusmini.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 89, 33, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plusmini.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 130, 33, -1));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plusmini.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(339, 220, 33, -1));
        jPanel1.add(txtDGSPCT, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, 190, -1));

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel9.setText("Khối Lượng :");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, 89, -1));

        jPanel1.add(cbbKhoiLuong, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 90, 140, -1));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plusmini.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 90, 41, -1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel10.setText("Đơn vị tính :");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 130, 89, -1));
        jPanel1.add(txtDonViTinh, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 130, 190, -1));

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel11.setText("Barcode :");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 170, 70, -1));
        jPanel1.add(txtMaQr, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 170, 190, -1));

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel12.setText("Ghi Chú :");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 210, -1, -1));

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 210, 200, 69));

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel14.setText("Trạng Thái :");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, -1, -1));

        buttonGroup1.add(rdHD);
        rdHD.setText("Đang Hoạt Động");
        jPanel1.add(rdHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 260, -1, -1));

        buttonGroup1.add(rdKHD);
        rdKHD.setText("Không Hoạt Động");
        jPanel1.add(rdKHD, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 260, -1, -1));

        lbHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHinhAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        lbHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHinhAnhMouseClicked(evt);
            }
        });

        btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus_1.png"))); // NOI18N
        btnThem.setText("THÊM");
        btnThem.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        btnCapNhap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/settings.png"))); // NOI18N
        btnCapNhap.setText("CẬP NHẬP");
        btnCapNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCapNhapActionPerformed(evt);
            }
        });

        txtSerch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSerchMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                txtSerchMouseReleased(evt);
            }
        });
        txtSerch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSerchActionPerformed(evt);
            }
        });

        tbCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "MaSPCT", "Tên Sản Phẩm", "Loại sản phẩm", "Hương Vị", "Hạn Sử dụng", "Xuất Sứ", "Số lượng tồn", "Đơn Giá", "khối lượng", "Đơn Vị", "MaQR", "Ghi Chú", "Ảnh", "Trạng Thái"
            }
        ));
        tbCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbCTSP);

        btnloadData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/turning.png"))); // NOI18N
        btnloadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloadDataActionPerformed(evt);
            }
        });

        jLabel13.setText("Tìm Tên SP");

        jButton6.setText("ImportExcel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("ExportExcel");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 30)); // NOI18N
        jLabel15.setText("QUẢN LÝ SẢN PHẨM ");

        javax.swing.GroupLayout pnSanPhamChiTietLayout = new javax.swing.GroupLayout(pnSanPhamChiTiet);
        pnSanPhamChiTiet.setLayout(pnSanPhamChiTietLayout);
        pnSanPhamChiTietLayout.setHorizontalGroup(
            pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnSanPhamChiTietLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addGap(380, 380, 380))
            .addGroup(pnSanPhamChiTietLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1052, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnSanPhamChiTietLayout.createSequentialGroup()
                        .addGroup(pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnSanPhamChiTietLayout.createSequentialGroup()
                                .addComponent(btnloadData)
                                .addGap(20, 20, 20)
                                .addComponent(btnThem)
                                .addGap(18, 18, 18)
                                .addComponent(btnCapNhap)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtSerch, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton6))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 847, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton7)
                            .addComponent(lbHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        pnSanPhamChiTietLayout.setVerticalGroup(
            pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSanPhamChiTietLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addGroup(pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lbHinhAnh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnloadData, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnCapNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnThem)
                        .addComponent(jLabel13)
                        .addComponent(txtSerch)
                        .addComponent(jButton6)
                        .addComponent(jButton7)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40))
        );

        listQuanLySanPham.addTab("Sản Phẩm", pnSanPhamChiTiet);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listQuanLySanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(listQuanLySanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new ViewSP().setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new ViewLSP().setVisible(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        new ViewNSX().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void cbbTenSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbTenSanPhamMouseClicked
        System.out.println(listSanPham.get(cbbTenSanPham.getSelectedIndex()).getId());


    }//GEN-LAST:event_cbbTenSanPhamMouseClicked

    private void tbCTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTSPMouseClicked
        int indexCTSP = tbCTSP.getSelectedRow();
        showIndex(indexCTSP);
    }//GEN-LAST:event_tbCTSPMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (data() != null) {
            int c = JOptionPane.showConfirmDialog(this, " bạn có muốn thêm chi tiết sản phẩm không ?");
            if (c == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, serviceCTSP.themCTSP(data()));
                showTable(listCTSPView = serviceCTSP.listChiTietSanPham());
            } else {
                return;
            }
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnloadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloadDataActionPerformed
        showComboboxSanPham();
        showComboboxLoaiSanPham();
        showComboboxDongSanPham();
        showComboboxQG();
        showComboboxKhoiLuong();
    }//GEN-LAST:event_btnloadDataActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new ViewKhoiLuong().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        new viewDongSanPham().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        JOptionPane.showMessageDialog(this, serviceCTSP.sua(data()));
        showTable(listCTSPView = serviceCTSP.listChiTietSanPham());
    }//GEN-LAST:event_btnCapNhapActionPerformed

    private void cbbLoaiSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbLoaiSanPhamMouseClicked
        // System.out.println(idSP = listLSP.get(cbbLoaiSanPham.getSelectedIndex()).getId());

    }//GEN-LAST:event_cbbLoaiSanPhamMouseClicked

    private void lbHinhAnhMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbHinhAnhMouseClicked
        try {
            // Tạo một cửa sổ chọn tệp
            JFileChooser fileChooser = new JFileChooser("D:\\DuAn1\\image\\face");

            // Đặt tiêu đề cho cửa sổ chọn tệp
            fileChooser.setDialogTitle("Mở file");

            // Hiển thị cửa sổ chọn tệp và chờ người dùng chọn tệp
            int result = fileChooser.showOpenDialog(null);

            // Kiểm tra nếu người dùng đã chọn tệp và không hủy bỏ
            if (result == JFileChooser.APPROVE_OPTION) {
                // Lấy tệp đã chọn
                File selectedFile = fileChooser.getSelectedFile();

                // Lấy đường dẫn tuyệt đối của tệp và lưu vào biến duongDan
                duongDan = selectedFile.getAbsolutePath();

                // Đặt biểu tượng (icon) của JLabel là hình ảnh từ đường dẫn đã chọn
                // (Hàm setSizeImg(duongDan) được giả định là hàm để thiết lập kích thước hình ảnh)
                lbHinhAnh.setIcon(setSizeImg(duongDan)); // Hàm setSizeImg chưa được cung cấp trong đoạn mã này
            } else {
                // Người dùng chưa chọn tệp hoặc đã hủy bỏ
                System.out.println("Chưa chọn ảnh");
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ nếu có lỗi xảy ra trong quá trình chọn tệp
            System.out.println("Đã xảy ra lỗi: " + e.getMessage());
        }
        System.out.println(duongDan);
    }//GEN-LAST:event_lbHinhAnhMouseClicked

    private void txtSerchMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSerchMouseReleased
        SerchTen(title);
    }//GEN-LAST:event_txtSerchMouseReleased

    private void txtSerchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSerchMouseClicked
        SerchTen(title);
    }//GEN-LAST:event_txtSerchMouseClicked

    private void txtHanSuDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHanSuDungMouseClicked

    }//GEN-LAST:event_txtHanSuDungMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        File excelFile;
        FileInputStream excelFis = null;
        BufferedInputStream excelBit = null;
        XSSFWorkbook excelJtableImport = null;
        ChiTietSanPham ct = new ChiTietSanPham();
        String defaultCurrenDirectoryPath = "D:\\Import_Export_Excel";
        // select default path
        JFileChooser excelFileChooser = new JFileChooser(defaultCurrenDirectoryPath);
        int excelChooser = excelFileChooser.showOpenDialog(null);

        // if  open button is click 
        if (excelChooser == JFileChooser.APPROVE_OPTION) {
            try {
                excelFile = excelFileChooser.getSelectedFile();
                excelFis = new FileInputStream(excelFile);
                excelBit = new BufferedInputStream(excelFis);

                excelJtableImport = new XSSFWorkbook(excelBit);
                XSSFSheet excelSheet = excelJtableImport.getSheetAt(0);
                for (int row = 0; row <= excelSheet.getLastRowNum(); row++) {
                    XSSFRow excelRow = excelSheet.getRow(row);
                    XSSFCell exMSPCT = excelRow.getCell(0);
                    XSSFCell exIdSp = excelRow.getCell(1);
                    XSSFCell exIdlsp = excelRow.getCell(2);
                    XSSFCell exIdDSP = excelRow.getCell(3);
                    XSSFCell exHSD = excelRow.getCell(4);
                    XSSFCell exIdNSX = excelRow.getCell(5);
                    XSSFCell exSL = excelRow.getCell(6);
                    XSSFCell exDonGia = excelRow.getCell(7);
                    XSSFCell exIdKL = excelRow.getCell(8);
                    XSSFCell exDVT = excelRow.getCell(9);
                    XSSFCell exMaqr = excelRow.getCell(10);
                    XSSFCell exGhiChu = excelRow.getCell(11);
                    XSSFCell exTrangThai = excelRow.getCell(12);
                    XSSFCell exAnh = excelRow.getCell(13);
                    //ChiTietSanPham ct = new ChiTietSanPham();
//
//                    dtm.addRow(new Object[]{
//                        exMSPCT, exIdSp, exIdlsp, exIdSp, exHSD, exIdNSX, exSL, exDonGia, exIdKL, exDVT, exMaqr, exGhiChu, exTrangThai, exAnh
//                    });

                    ct.setMaCTSP(exMSPCT.getStringCellValue()); //1

                    int idSanPham = (int) exIdSp.getNumericCellValue(); //2
                    ct.setIdSanPham(idSanPham);

                    int idLoaiSp = (int) exIdlsp.getNumericCellValue(); //3
                    ct.setIdLoaiSp(idLoaiSp);

                    int idDongSanPham = (int) exIdDSP.getNumericCellValue(); //4
                    ct.setIdDongSanPham(idDongSanPham);

                    // hạn sử dụng 
                    java.util.Date hsdDate = exHSD.getDateCellValue();
                    java.sql.Date hsd = new java.sql.Date(hsdDate.getTime()); //5
                    ct.sethSD(hsd); 
                            
                    int idNSX = (int) exIdNSX.getNumericCellValue(); //6
                    ct.setIdNSX(idNSX);

                    int soLuong = (int) exSL.getNumericCellValue(); //7
                    ct.setSoLuongTon(soLuong);

                    Float donGia = (float) exDonGia.getNumericCellValue(); //8
                    ct.setDonGia(donGia);

                    int kl = (int) exIdKL.getNumericCellValue(); //9
                    ct.setIdNSX(kl);

                    ct.setDonViTinh(exDVT.getStringCellValue()); // 10
                    ct.setMaQr(exMaqr.getStringCellValue()); //11
                    // anhr 
                    ct.setAnh(exAnh.getStringCellValue()); //12
                    ct.setGhiChu(exGhiChu.getStringCellValue()); //13
                    //sp.getTrangThai();\
                    int trangThai = (int) exTrangThai.getNumericCellValue(); //14
                    ct.setTrangThai(trangThai);
                    System.out.println("doi tuong : " + ct.getMaCTSP() + " - " + ct.getIdSanPham());
                    //                    for (int column = 0; column <= excelRow.getLastCellNum(); column++) {
                    //                        XSSFCell excelCell = excelRow.getCell(column);
                    //                        System.out.println(excelCell);
                    //                    }
                }
//                for (int row = 0; row <= excelSheet.getLastRowNum(); row++) {
//                    XSSFRow excelRow = excelSheet.getRow(row);
//                    if (excelRow != null) {
//                        for (int column = 0; column < excelRow.getLastCellNum(); column++) {
//                            XSSFCell excelCell = excelRow.getCell(column);
//                            if (excelCell != null) {
//                                switch (excelCell.getCellType()) {
//                                    case STRING:
//                                        System.out.println(excelCell.getStringCellValue());
//                                        break;
//                                    case NUMERIC:
//                                        // Xử lý giá trị dạng số ở đây
//                                        System.out.println(excelCell.getNumericCellValue());
//                                        break;
//                                    // Xử lý các kiểu dữ liệu khác nếu cần thiết
//                                    default:
//                                        System.out.println("Unsupported cell type");
//                                }
//                            }
//                        }
//                    }
//                }
                JOptionPane.showMessageDialog(this, serviceCTSP.themCTSP(ct));
                showTable(listCTSPView = serviceCTSP.listChiTietSanPham());
                JOptionPane.showMessageDialog(this, "Import Sucsesfull ?");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void txtSerchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSerchActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSerchActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapNhap;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnloadData;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbbDongSanPham;
    private javax.swing.JComboBox<String> cbbKhoiLuong;
    private javax.swing.JComboBox<String> cbbLoaiSanPham;
    private javax.swing.JComboBox<String> cbbQuocGia;
    private javax.swing.JComboBox<String> cbbTenSanPham;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JLabel lbHinhAnh;
    private javax.swing.JPanel pnSanPhamChiTiet;
    private javax.swing.JRadioButton rdHD;
    private javax.swing.JRadioButton rdKHD;
    private javax.swing.JTable tbCTSP;
    private javax.swing.JTextField txtDGSPCT;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextArea txtGhiChu;
    private com.toedter.calendar.JDateChooser txtHanSuDung;
    private javax.swing.JTextField txtMaCTSP;
    private javax.swing.JTextField txtMaQr;
    private javax.swing.JTextField txtSerch;
    private javax.swing.JSpinner txtSoLuongTon;
    // End of variables declaration//GEN-END:variables
}
