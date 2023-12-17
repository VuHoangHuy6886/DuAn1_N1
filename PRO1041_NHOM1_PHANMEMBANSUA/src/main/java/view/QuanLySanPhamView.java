/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controler.ChiTietSanPhamServiceImpl;
import controler.HuongViServiceImpl;
import controler.KhoiLuongSanPhamImpl;
import controler.SanPhamServiceImpl;
import controler.ThuongHieuServiceImpl;
import controler.XuatXuServiceImpl;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.ChiTietSanPham;
import model.KhoiLuongSanPham;
import modelView.CTSP;
import repository.ChiTietSanPhamService;
import repository.KhoiLuongService;
import repository.SanPhamService;
import java.io.*;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Map;
import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.NumberFormatter;
import model.HuongVi;
//import java.sql.Date;
import model.SanPham;
import model.ThuongHieu;
import model.XuatXu;
import modelView.SanPhamViewModel;
import org.apache.commons.math3.stat.descriptive.summary.Product;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import static org.apache.poi.ss.usermodel.TableStyleType.headerRow;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.*;

/**
 *
 * @author vuhoa
 */
public class QuanLySanPhamView extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    DefaultTableModel modelSanPhamNew = new DefaultTableModel();
    // Danh Sách service 
    ChiTietSanPhamService serviceCTSP = new ChiTietSanPhamServiceImpl();
    SanPhamService serviceSanPham = new SanPhamServiceImpl();
    ThuongHieuServiceImpl serviceThuongHieuSanPham = new ThuongHieuServiceImpl();
    XuatXuServiceImpl serviceXuatXuSanPham = new XuatXuServiceImpl();
    KhoiLuongService serviceKhoiLuong = new KhoiLuongSanPhamImpl();
    HuongViServiceImpl serviceHuongViSua = new HuongViServiceImpl();
    // Danh Sách list 
    // list Chi tiết sản phẩm thêm 
    List<ChiTietSanPham> ListCTSP = new ArrayList<>();
    // list Chi tiết sản phẩm hiển thị 
    List<CTSP> listCTSPView = new ArrayList<>();
    // list Của sản phẩm hiển thị 
    List<SanPhamViewModel> listSanPhamNew = new ArrayList<>();
    // list Thương hiệu sản phẩm 
    List<ThuongHieu> listThuongHieuSanPham = new ArrayList<>();
    // list Xuất Xứ Sản phẩm 
    List<XuatXu> listXuatXuSanPham = new ArrayList<>();
    // list khối lượng 
    List<KhoiLuongSanPham> listKhoiLuong = new ArrayList<>();
    // list hương vị 
    List<HuongVi> listHuongViSua = new ArrayList<>();
    public static int idCTSP;
    public static int idSanPham;
    // đường dẫn ản 
    private String duongDan = "D:\\DuAn1\\image\\face";
    // chi tiết sp view
    // Bảng Sản phẩm : 
    // bảng khối lượng 

    // ////////////////////////////////////////
    public QuanLySanPhamView() {
        initComponents();
        // chi tiết sản phẩm 
        dtm = (DefaultTableModel) tbCTSP.getModel();
        //listCTSPView = serviceCTSP.listChiTietSanPham();
//        showTable(listCTSPView);
        // bảng sản phẩm 
        // bảng khối lượng 
//        listKhoiLuong = serviceKhoiLuong.listKhoiLuong();
        // 
        // show dữ liệu cho table sản phẩm 
        listSanPhamNew = serviceSanPham.listSanPhamHienThi();
        // show dữ liệu len table sản phẩm

        //showTableSanPhamNew(listSanPhamNew.stream().filter(sp -> sp.getTrangThai() == 1).toList());
        // show Dữ liệu cho combobox Thương hiệu 
        listThuongHieuSanPham = serviceThuongHieuSanPham.listThuongHieuSanPham();
        // show dữ liệu cho combobox Xuat Xứ 
        listXuatXuSanPham = serviceXuatXuSanPham.listXuatXuSanPham();
        // show dữ liệu cho hương vị sữa 
        listHuongViSua = serviceHuongViSua.listHuongViSua();
        // show dữ liệu cho khối lượng 
        listKhoiLuong = serviceKhoiLuong.listKhoiLuong();
        showComboboxThuongHieu();
        showComBoBoxXuatXu();
        showTableSanPhamNew(listSanPhamNew);
    }

    // show Dữ liệu cho table sản phẩm 
    public void showTableSanPhamNew(List<SanPhamViewModel> listSanPhamNew) {
        modelSanPhamNew = (DefaultTableModel) tbSanPhamNew.getModel();
        modelSanPhamNew.setRowCount(0);
        int index = 1;
        for (SanPhamViewModel sp : listSanPhamNew) {
            modelSanPhamNew.addRow(new Object[]{
                index,
                sp.getMaSanPhamView(),
                sp.getTenSanPhamView(),
                sp.getTenThuongHieuView(),
                sp.getTenXuatXuView(),
                sp.getNgayTaoView(),
                sp.getTrangThai() == 1 ? "Đang kinh doanh" : "Ngừng kinh doanh",});
            index++;
        }
    }

    // show dữ liệu lên combobox Thương hiệu 
    public void showComboboxThuongHieu() {
        cbbThuongHieuNew.removeAllItems();
        cbbLocThuongHieuSanPhamNew.removeAll();
        for (ThuongHieu th : listThuongHieuSanPham) {
            //th.getTen();
            cbbThuongHieuNew.addItem(th.getTen());
            cbbLocThuongHieuSanPhamNew.addItem(th.getTen());
        }
    }

    // show dữ liệu lên combobox Xuất Xứ 
    public void showComBoBoxXuatXu() {
        cbbLocXuatXuSanPhamNew.removeAllItems();
        cbbXuatXuNew.removeAllItems();
        for (XuatXu xx : listXuatXuSanPham) {
            cbbXuatXuNew.addItem(xx.getTen());
            cbbLocXuatXuSanPhamNew.addItem(xx.getTen());
        }
    }

    // show vị trí cho sản phẩm 
    public SanPhamViewModel showIndexSanPham(int index) {
//        listSanPhamNew.stream().filter(sp -> sp.getTrangThai() ==1).toList();
        SanPhamViewModel sp = listSanPhamNew.get(index);
        idSanPham = sp.getIdSanPhamView();
        txtMaSanPhamNew.setText(sp.getMaSanPhamView());
        txtTenSanPhamNew.setText(sp.getTenSanPhamView());
        cbbThuongHieuNew.removeAllItems();
        cbbThuongHieuNew.addItem(sp.getTenThuongHieuView());
        cbbXuatXuNew.removeAllItems();
        cbbXuatXuNew.addItem(sp.getTenXuatXuView());
        JdateNgayTao.setDate(sp.getNgayTaoView());
        int trangThai = sp.getTrangThai();
        if (trangThai == 1) {
            rdSanPhamDangKinhDoanh.setSelected(true);
        } else {
            rdSanPhamDangNgungKinhDoanh.setSelected(true);
        }
        return sp;
    }

    //  thêm sản phẩm 
    public SanPham dataSanPham() {
        SanPham sp = new SanPham();
        String maSanPham = txtMaSanPhamNew.getText();
        if (maSanPham.isEmpty()) {
            JOptionPane.showMessageDialog(this, "vui lòng nhập mã");
            return null;
        }
        String tenSanPham = txtTenSanPhamNew.getText();
        if (tenSanPham.isEmpty()) {
            JOptionPane.showMessageDialog(this, "vui lòng nhập Tên ");
            return null;
        }
        int checkThuongHieu = cbbThuongHieuNew.getSelectedIndex();
        if (checkThuongHieu >= 0) {
            int idThuongHieu = listThuongHieuSanPham.get(checkThuongHieu).getId();
            sp.setId_ThuongHieu(idThuongHieu);
        } else {
            JOptionPane.showMessageDialog(this, "Thương Hiệu Không Được Để Trống !");
            return null;
        }
        int checkXuatXu = cbbXuatXuNew.getSelectedIndex();
        if (checkXuatXu >= 0) {
            int idXuatxu = listXuatXuSanPham.get(checkXuatXu).getId();
            sp.setId_XuatXu(idXuatxu);
        } else {
            JOptionPane.showMessageDialog(this, "Xuất Xứ Không Được Để Trống !");
            return null;
        }

        // Khởi tạo đối tượng sản phẩm và thiết lập các thông tin cơ bản
        sp.setMa(maSanPham);
        sp.setTen(tenSanPham);
        int trangThai = rdSanPhamDangKinhDoanh.isSelected() ? 1 : 0;
        sp.setTrangThai(trangThai);
        // Lấy ngày hiện tại và thiết lập cho sản phẩm
        java.sql.Date ngaySQL = new java.sql.Date(System.currentTimeMillis());
        if (ngaySQL != null) {
            sp.setNgayTao(ngaySQL);
        } else {
            JOptionPane.showMessageDialog(this, "Ngày tạo không được để trống ");
            return null;
        }

        return sp;
    }

    // show dữ liệu cho chi tiết sản phẩm 
    public void showTableChiTietSanPham(List<CTSP> listCTSPView) {
        dtm.setRowCount(0);
        int index = 1;
        for (CTSP ctsp : listCTSPView) {
            dtm.addRow(new Object[]{
                index,
                ctsp.getMaSPCT(),
                ctsp.getTenSanPham(),
                ctsp.getHuongVi(),
                ctsp.getNgaySanXuat(),
                ctsp.getHanSuDung(),
                ctsp.getSoLuongTon(),
                ctsp.getDonGia(),
                ctsp.getKhoiLuong(),
                ctsp.getDonViTinh(),
                ctsp.getMaQr(),
                ctsp.getGhiChu(),
                ctsp.getAnh(),
                ctsp.getTrangThai() == 1 ? "Hoạt Động" : "Không Hoạt Động",});
            index++;
        }
    }

    private CTSP showIndexChiTietSanPham(int index) {
        CTSP sp = listCTSPView.get(index);
        idCTSP = sp.getId();
        txtMaCTSP.setText(sp.getMaSPCT());
        lbTenSanPham.setText(sp.getTenSanPham());
        cbbHuongViSua.removeAllItems();
        cbbHuongViSua.addItem(sp.getHuongVi());
        txtNgaySanXuat.setDate(sp.getNgaySanXuat());
        txtHanSuDung.setDate(sp.getHanSuDung());
        // txtSoLuongTon.setToolTipText(Integer.parseInt(sp.getSoLuongTon()));
        // Giả sử sp.getSoLuongTon() trả về một chuỗi chứa số lượng tồn
        int soLuongTon = Integer.parseInt(String.valueOf(sp.getSoLuongTon()));
        // Đặt giá trị số lượng tồn vào JSpinner txtSoLuongTon
        txtSoLuongTon.setValue(soLuongTon);
        txtDGSPCT.setText(String.valueOf(sp.getDonGia()));
        //txtDGSPCT.setText(String.valueOf(sp.getDonGia()));
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

    private void showComboboxKhoiLuong() {
        cbbKhoiLuong.removeAllItems();
        for (KhoiLuongSanPham kl : listKhoiLuong) {
            cbbKhoiLuong.addItem(kl.getTenKL());
        }
    }

    public void showComBoBoxHuongViSua() {
        cbbHuongViSua.removeAllItems();
        for (HuongVi hv : listHuongViSua) {
            cbbHuongViSua.addItem(hv.getTen_HuongVi());
        }
    }
//    public boolean checkDataChiTietSanPham(){
//        int soLuong = Integer.parseInt(txtSoLuongTon.getValue());
//        if()
//    }

    private ChiTietSanPham dataChiTietSanPham() {
        String maCTSP = txtMaCTSP.getText();
        if (maCTSP.isEmpty()) {
            JOptionPane.showMessageDialog(this, " vui lòng nhập mã cho sản phẩm chi tiết");
            return null;
        }
        String tenSanPham = lbTenSanPham.getText();
        java.util.Date hanSuDung = txtHanSuDung.getDate();
        java.util.Date ngaySanXuat = txtNgaySanXuat.getDate();

        if (hanSuDung == null || ngaySanXuat == null) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đầy đủ thông tin về ngày.");
            return null;
        }
        java.sql.Date hanSuDungSQL = new java.sql.Date(hanSuDung.getTime());
        java.sql.Date ngaySanXuatSQL = new java.sql.Date(ngaySanXuat.getTime());
        txtSoLuongTon.setEditor(new JSpinner.NumberEditor(txtSoLuongTon, "0")); // Thiết lập số lượng chữ số sau dấu phẩy
        Integer soLuongTon = (Integer) txtSoLuongTon.getValue();
        if (soLuongTon == null || soLuongTon.intValue() == 0) {
            JOptionPane.showMessageDialog(this, "So luong không được để trống hoặc bằng 0");
            return null;
        }

        Float donGia = Float.parseFloat(txtDGSPCT.getText());
        if (donGia == null || donGia.intValue() == 0) {
            JOptionPane.showMessageDialog(this, "Đơn giá không được để trống hoặc bằng 0");
            return null;
        }
        String khoiLuong = String.valueOf(cbbKhoiLuong.getSelectedIndex());
        String dVT = txtDonViTinh.getText();
        if (dVT.isEmpty()) {
            JOptionPane.showMessageDialog(this, "khoi luong Không Được để trống !");
            return null;
        }
        String qr = txtMaQr.getText();
        String ghiChu = txtGhiChu.getText();
        if (ghiChu.isEmpty()) {
            JOptionPane.showMessageDialog(this, "ghi chu  Không Được để trống !");
            return null;
        }
        int trangThai;
        ///////////////////////////////
        ChiTietSanPham sp = new ChiTietSanPham();
        sp.setMaCTSP(maCTSP);
        sp.setIdSanPham(idSanPham);
        sp.setId_HuongVi(listHuongViSua.get(cbbHuongViSua.getSelectedIndex()).getId_HuongVi());
        sp.setNgaySanXuat(ngaySanXuatSQL);
        sp.setHaSuDung(hanSuDungSQL);
        sp.setSoLuongTon(soLuongTon);
        sp.setDonGia(donGia);
        sp.setIdKhoiLuong(listKhoiLuong.get(cbbKhoiLuong.getSelectedIndex()).getIdKL());
        sp.setDonViTinh(dVT);
        sp.setMaQr(qr);
        // anhr 
        sp.setAnh(duongDan);
        sp.setGhiChu(ghiChu);
        sp.getTrangThai();
        if (rdHD.isSelected()) {
            trangThai = 1;
        } else {
            trangThai = 0;
        }
        sp.setTrangThai(trangThai);
        return sp;

    }

    // export excel 
    // hàm lấy ảnh : 
    public ImageIcon setSizeImg(String imagePath) {
        ImageIcon myImage = new ImageIcon(imagePath);
        Image img = myImage.getImage();
        // Tạo ảnh mới với kích thước mong muốn
        Image newImg = img.getScaledInstance(lbHinhAnh.getWidth(), lbHinhAnh.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon image = new ImageIcon(newImg);
        return image;
    }

    private void SerchTen() {
        String tim = txtSerch.getText();
        listCTSPView = serviceCTSP.listChiTietSanPham(idSanPham);
        showTableChiTietSanPham(listCTSPView.stream().filter(ct -> ct.getMaSPCT().equals(tim)).toList());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        pnDanhMucSanPham = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        txtTenSanPhamNew = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        txtMaSanPhamNew = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        cbbThuongHieuNew = new javax.swing.JComboBox<>();
        cbbXuatXuNew = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        btnThemSanPhamNew = new javax.swing.JButton();
        btnSuaSanPhamNew = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        JdateNgayTao = new com.toedter.calendar.JDateChooser();
        jLabel23 = new javax.swing.JLabel();
        btnThemThuongHieuSanPham = new javax.swing.JButton();
        btnThemXuatXuSanPham = new javax.swing.JButton();
        rdSanPhamDangNgungKinhDoanh = new javax.swing.JRadioButton();
        rdSanPhamDangKinhDoanh = new javax.swing.JRadioButton();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        txtTimKiemSanPhamNew = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        cbbLocThuongHieuSanPhamNew = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        jLabel26 = new javax.swing.JLabel();
        cbbLocXuatXuSanPhamNew = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        jLabel27 = new javax.swing.JLabel();
        cbbLocTrangThaiSanPhamNew = new javax.swing.JComboBox<>();
        btnShowDuLieuCacCombobox = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbSanPhamNew = new javax.swing.JTable();
        pnSanPhamChiTiet = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtMaCTSP = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cbbHuongViSua = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        txtHanSuDung = new com.toedter.calendar.JDateChooser();
        jLabel7 = new javax.swing.JLabel();
        txtSoLuongTon = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
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
        jLabel6 = new javax.swing.JLabel();
        txtNgaySanXuat = new com.toedter.calendar.JDateChooser();
        lbTenSanPham = new javax.swing.JLabel();
        lbHinhAnh = new javax.swing.JLabel();
        btnThem = new javax.swing.JButton();
        btnCapNhap = new javax.swing.JButton();
        txtSerch = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbCTSP = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        cbbTrangThaiSanPham = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        btnExportExcel = new javax.swing.JButton();
        btnloadData = new javax.swing.JButton();

        setTitle("Quản Lý Sản phẩm");
        setPreferredSize(new java.awt.Dimension(1100, 800));

        pnDanhMucSanPham.setBackground(new java.awt.Color(0, 204, 255));
        pnDanhMucSanPham.setPreferredSize(new java.awt.Dimension(1000, 800));
        pnDanhMucSanPham.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel17.setText("QUẢN LÝ SẢN PHẨM");
        pnDanhMucSanPham.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, -1, 30));

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel18.setText("Mã Sản Phẩm :");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel19.setText("Tên Sản Phẩm :");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel20.setText("Thương Hiệu :");

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel21.setText("Xuất Xứ :");

        cbbThuongHieuNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbThuongHieuNewMouseClicked(evt);
            }
        });
        cbbThuongHieuNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbThuongHieuNewActionPerformed(evt);
            }
        });

        cbbXuatXuNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbXuatXuNewMouseClicked(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(0, 204, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));

        btnThemSanPhamNew.setBackground(new java.awt.Color(255, 153, 51));
        btnThemSanPhamNew.setText("Thêm");
        btnThemSanPhamNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemSanPhamNewActionPerformed(evt);
            }
        });

        btnSuaSanPhamNew.setBackground(new java.awt.Color(255, 153, 0));
        btnSuaSanPhamNew.setText("Sửa");
        btnSuaSanPhamNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaSanPhamNewActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnSuaSanPhamNew, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemSanPhamNew, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnThemSanPhamNew)
                .addGap(39, 39, 39)
                .addComponent(btnSuaSanPhamNew)
                .addGap(35, 35, 35))
        );

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel22.setText("Ngày Tạo :");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel23.setText("Trạng Thai :");

        btnThemThuongHieuSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plusmini.png"))); // NOI18N
        btnThemThuongHieuSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemThuongHieuSanPhamActionPerformed(evt);
            }
        });

        btnThemXuatXuSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plusmini.png"))); // NOI18N
        btnThemXuatXuSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemXuatXuSanPhamActionPerformed(evt);
            }
        });

        buttonGroup2.add(rdSanPhamDangNgungKinhDoanh);
        rdSanPhamDangNgungKinhDoanh.setText("Ngừng kinh doanh");

        buttonGroup2.add(rdSanPhamDangKinhDoanh);
        rdSanPhamDangKinhDoanh.setText("Đang Kinh Doanh");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel22, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(34, 34, 34)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTenSanPhamNew, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JdateNgayTao, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 150, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel21, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel23, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtMaSanPhamNew, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 139, Short.MAX_VALUE)
                        .addComponent(jLabel20)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(cbbThuongHieuNew, 0, 174, Short.MAX_VALUE)
                            .addComponent(cbbXuatXuNew, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThemThuongHieuSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(btnThemXuatXuSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(rdSanPhamDangKinhDoanh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(rdSanPhamDangNgungKinhDoanh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel21)
                                .addComponent(cbbXuatXuNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel19)
                                .addComponent(txtTenSanPhamNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnThemXuatXuSanPham))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel18)
                                    .addComponent(txtMaSanPhamNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel20)
                                    .addComponent(cbbThuongHieuNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnThemThuongHieuSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(65, 65, 65)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel22)
                                .addComponent(JdateNgayTao, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel23)
                                .addComponent(rdSanPhamDangKinhDoanh)
                                .addComponent(rdSanPhamDangNgungKinhDoanh)))))
                .addGap(24, 24, 24))
        );

        pnDanhMucSanPham.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1090, 230));

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc Sản Phẩm", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(255, 255, 255))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(0, 204, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        txtTimKiemSanPhamNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTimKiemSanPhamNewMouseClicked(evt);
            }
        });

        jLabel24.setText("Tìm Kiếm Sản Phẩm ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel24))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtTimKiemSanPhamNew, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel24)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiemSanPhamNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(0, 204, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel25.setText("Thương Hiệu");

        cbbLocThuongHieuSanPhamNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbLocThuongHieuSanPhamNewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(cbbLocThuongHieuSanPhamNew, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(72, 72, 72)
                        .addComponent(jLabel25)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel25)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbLocThuongHieuSanPhamNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(0, 204, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel26.setText("Xuất Xứ");

        cbbLocXuatXuSanPhamNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbLocXuatXuSanPhamNewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addComponent(jLabel26)
                .addContainerGap(69, Short.MAX_VALUE))
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbLocXuatXuSanPhamNew, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel26)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbLocXuatXuSanPhamNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel9.setBackground(new java.awt.Color(0, 204, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));

        jLabel27.setText("Trạng Thái ");

        cbbLocTrangThaiSanPhamNew.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang kinh doanh", "Ngừng kinh doanh" }));
        cbbLocTrangThaiSanPhamNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbLocTrangThaiSanPhamNewMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addComponent(jLabel27)
                .addContainerGap(59, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(cbbLocTrangThaiSanPhamNew, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel27)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbbLocTrangThaiSanPhamNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btnShowDuLieuCacCombobox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/turning.png"))); // NOI18N
        btnShowDuLieuCacCombobox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnShowDuLieuCacComboboxActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(53, 53, 53)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addComponent(btnShowDuLieuCacCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnShowDuLieuCacCombobox)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pnDanhMucSanPham.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 1090, 130));

        tbSanPhamNew.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Ma", "Tên", "Thương Hiệu", "Xuất Xứ", "Ngày Tạo", "Trạng Thái"
            }
        ));
        tbSanPhamNew.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbSanPhamNewMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbSanPhamNew);

        pnDanhMucSanPham.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 430, 1100, 260));

        jTabbedPane1.addTab("DanhMucSanPham", pnDanhMucSanPham);

        pnSanPhamChiTiet.setBackground(new java.awt.Color(51, 204, 255));
        pnSanPhamChiTiet.setPreferredSize(new java.awt.Dimension(1100, 800));

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(730, 300));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("Mã sản phẩm chi tiết :");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Tên Sản phẩm :");

        jLabel4.setBackground(new java.awt.Color(255, 255, 255));
        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel4.setText("Ngày Sản Xuất :");

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel5.setText("Hạn Sử Dụng :");

        txtHanSuDung.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHanSuDungMouseClicked(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel7.setText("Đơn giá :");

        jLabel8.setBackground(new java.awt.Color(255, 255, 255));
        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel8.setText("Số Lượng Tồn :");

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plusmini.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel9.setBackground(new java.awt.Color(255, 255, 255));
        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel9.setText("Khối Lượng :");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plusmini.png"))); // NOI18N
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel10.setText("Đơn vị tính :");

        jLabel11.setBackground(new java.awt.Color(255, 255, 255));
        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel11.setText("MaQrcode :");

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel12.setText("Ghi Chú :");

        txtGhiChu.setColumns(20);
        txtGhiChu.setRows(5);
        jScrollPane1.setViewportView(txtGhiChu);

        jLabel14.setBackground(new java.awt.Color(255, 255, 255));
        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel14.setText("Trạng Thái :");

        buttonGroup1.add(rdHD);
        rdHD.setText("Đang Hoạt Động");

        buttonGroup1.add(rdKHD);
        rdKHD.setText("Không Hoạt Động");

        jLabel6.setBackground(new java.awt.Color(255, 255, 255));
        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 15)); // NOI18N
        jLabel6.setText("Hương Vị Sữa :");

        lbTenSanPham.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));

        lbHinhAnh.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbHinhAnh.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 2));
        lbHinhAnh.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbHinhAnhMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel12)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(cbbKhoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtDGSPCT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtMaQr, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(74, 74, 74)
                        .addComponent(lbHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1)))
                .addGap(30, 30, 30))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel8))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel6)
                                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cbbHuongViSua, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(txtHanSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel1))
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(15, 15, 15)
                                                .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbTenSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNgaySanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel14)
                                        .addGap(18, 18, 18)
                                        .addComponent(rdHD)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdKHD)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                        .addComponent(jLabel7)))
                .addGap(397, 397, 397))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel8)
                                    .addComponent(txtSoLuongTon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lbTenSanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(txtMaCTSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(txtDGSPCT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(cbbHuongViSua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel6))
                                    .addComponent(jButton3)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton5, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel9)
                                        .addComponent(cbbKhoiLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(txtNgaySanXuat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtHanSuDung, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(rdHD)
                            .addComponent(rdKHD)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(124, 124, 124)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtDonViTinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtMaQr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(19, Short.MAX_VALUE))
        );

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

        tbCTSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "MaSPCT", "Tên Sản Phẩm", "Hương Vị", "Ngày Sản Xuất", "Hạn Sử dụng", "Số lượng tồn", "Đơn Giá", "khối lượng", "Đơn Vị", "MaQR", "Ghi Chú"
            }
        ));
        tbCTSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbCTSPMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbCTSP);

        jLabel13.setText("Tìm Tên SP");

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 20)); // NOI18N
        jLabel15.setText("QUẢN LÝ SẢN PHẨM CHI TIẾT ");

        cbbTrangThaiSanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang kinh doanh", "Ngừng kinh doanh" }));
        cbbTrangThaiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbbTrangThaiSanPhamMouseClicked(evt);
            }
        });

        jLabel16.setText("Trạng Thái");

        jButton6.setText("ImportExcel");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        btnExportExcel.setText("ExportExcel");
        btnExportExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExportExcelActionPerformed(evt);
            }
        });

        btnloadData.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/turning.png"))); // NOI18N
        btnloadData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnloadDataActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnSanPhamChiTietLayout = new javax.swing.GroupLayout(pnSanPhamChiTiet);
        pnSanPhamChiTiet.setLayout(pnSanPhamChiTietLayout);
        pnSanPhamChiTietLayout.setHorizontalGroup(
            pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSanPhamChiTietLayout.createSequentialGroup()
                .addGap(400, 400, 400)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnSanPhamChiTietLayout.createSequentialGroup()
                .addGroup(pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSanPhamChiTietLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnSanPhamChiTietLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel13)
                        .addGap(26, 26, 26)
                        .addComponent(txtSerch, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel16)
                        .addGap(27, 27, 27)
                        .addComponent(cbbTrangThaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(btnloadData)))
                .addGap(18, 18, 18)
                .addGroup(pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSanPhamChiTietLayout.createSequentialGroup()
                        .addComponent(btnThem, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(53, Short.MAX_VALUE))
                    .addGroup(pnSanPhamChiTietLayout.createSequentialGroup()
                        .addGroup(pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnCapNhap)
                            .addGroup(pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE)
                                .addComponent(btnExportExcel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jScrollPane2)
        );
        pnSanPhamChiTietLayout.setVerticalGroup(
            pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnSanPhamChiTietLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jLabel15)
                .addGroup(pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnSanPhamChiTietLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17)
                        .addGroup(pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnloadData, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnSanPhamChiTietLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(txtSerch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel16)
                                .addComponent(cbbTrangThaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnSanPhamChiTietLayout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(btnExportExcel)
                        .addGap(24, 24, 24)
                        .addComponent(btnCapNhap)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnThem)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(172, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Sản Phẩm Chi Tiết", pnSanPhamChiTiet);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tbCTSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbCTSPMouseClicked
        int indexCTSP = tbCTSP.getSelectedRow();
        showIndexChiTietSanPham(indexCTSP);

    }//GEN-LAST:event_tbCTSPMouseClicked

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
        if (dataChiTietSanPham() != null) {
            int c = JOptionPane.showConfirmDialog(this, " bạn có muốn thêm chi tiết sản phẩm không ?");
            if (c == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, serviceCTSP.themCTSP(dataChiTietSanPham()));
                showTableChiTietSanPham(listCTSPView = serviceCTSP.listChiTietSanPham(idSanPham));
            } else {
                return;
            }
        } else {
            return;
        }

    }//GEN-LAST:event_btnThemActionPerformed

    private void btnloadDataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnloadDataActionPerformed
        showComboboxKhoiLuong();
        showComBoBoxHuongViSua();
    }//GEN-LAST:event_btnloadDataActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        new ViewKhoiLuong().setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //new viewDongSanPham().setVisible(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void btnCapNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCapNhapActionPerformed
        int chon = JOptionPane.showConfirmDialog(this, "bạn có muốn sửa không ?");
        if (dataChiTietSanPham() != null) {
            if (chon == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, serviceCTSP.sua(dataChiTietSanPham()));
                showTableChiTietSanPham(listCTSPView = serviceCTSP.listChiTietSanPham(idSanPham));
            } else {
                return;
            }
        } else {
            return;
        }
    }//GEN-LAST:event_btnCapNhapActionPerformed

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

    }//GEN-LAST:event_txtSerchMouseReleased

    private void txtSerchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSerchMouseClicked
        SerchTen();
    }//GEN-LAST:event_txtSerchMouseClicked

    private void txtHanSuDungMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHanSuDungMouseClicked

    }//GEN-LAST:event_txtHanSuDungMouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        File excelFile;
        FileInputStream excelFis = null;
        BufferedInputStream excelBit = null;
        XSSFWorkbook excelJtableImport = null;

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
                for (int row = 1; row <= excelSheet.getLastRowNum(); row++) {
                    ChiTietSanPham ct = new ChiTietSanPham();
                    XSSFRow excelRow = excelSheet.getRow(row);

                    XSSFCell exma = excelRow.getCell(0);
                    XSSFCell exIdSanPham = excelRow.getCell(1);
                    XSSFCell exhuongVi = excelRow.getCell(2);
                    XSSFCell ngaySanXua = excelRow.getCell(3);
                    XSSFCell exhanSuDung = excelRow.getCell(4);
                    XSSFCell exSL = excelRow.getCell(5);
                    XSSFCell exDonGia = excelRow.getCell(6);
                    XSSFCell exIdKL = excelRow.getCell(7);
                    XSSFCell exDVT = excelRow.getCell(8);
                    XSSFCell exMaqr = excelRow.getCell(9);
                    XSSFCell exGhiChu = excelRow.getCell(10);
                    XSSFCell exTrangThai = excelRow.getCell(11);
                    XSSFCell exAnh = excelRow.getCell(12); //Dữ liệu nhận để check           

                    ct.setMaCTSP(exma.getStringCellValue()); //1
                    int idSanPham = (int) exIdSanPham.getNumericCellValue();
                    ct.setIdSanPham(idSanPham);

                    int huongVi = (int) exhuongVi.getNumericCellValue(); //3
                    ct.setId_HuongVi(huongVi);
                    //  ngày sản xuất
                    java.util.Date ngaySanXuat = ngaySanXua.getDateCellValue();
                    java.sql.Date nSX = new java.sql.Date(ngaySanXuat.getTime()); //5
                    ct.setNgaySanXuat(nSX);
                    // hạn sử dụng 
                    java.util.Date hsdDate = exhanSuDung.getDateCellValue();
                    java.sql.Date hsd = new java.sql.Date(hsdDate.getTime()); //5
                    ct.setHaSuDung(hsd);

                    int soLuong = (int) exSL.getNumericCellValue(); //7
                    ct.setSoLuongTon(soLuong);

                    Float donGia = (float) exDonGia.getNumericCellValue(); //8
                    ct.setDonGia(donGia);

                    int kl = (int) exIdKL.getNumericCellValue(); //9
                    ct.setIdKhoiLuong(kl);
//
                    String donViTinh = exDVT.getStringCellValue();
                    ct.setDonViTinh(donViTinh); // 10

                    String maQr = exMaqr.getStringCellValue();
                    ct.setMaQr(maQr); //11
                    System.out.println("1");
                    //anhr 
                    String ghiChu = exGhiChu.getStringCellValue();
                    ct.setGhiChu(ghiChu); //13
                    int trangThai = (int) exTrangThai.getNumericCellValue(); //14
                    ct.setTrangThai(trangThai);
                    if (ct != null) {
                        serviceCTSP.themCTSP(ct);
                    } else {
                        JOptionPane.showMessageDialog(this, "Đối tượng ko có dữ liệu !");
                        return;
                    }

                }
                showTableChiTietSanPham(listCTSPView = serviceCTSP.listChiTietSanPham(idSanPham));
                JOptionPane.showMessageDialog(this, "Import Sucsesfull ?");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void cbbTrangThaiSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbTrangThaiSanPhamMouseClicked
//        cbbTrangThaiSanPham.getSelectedItem();
//        listCTSPView = serviceCTSP.listChiTietSanPham();
//        if (cbbTrangThaiSanPham.getSelectedIndex() == 0) {
//            showTableChiTietSanPham(listCTSPView.stream().filter(sp -> sp.getTrangThai() == 1).toList());
//        } else {
//            showTableChiTietSanPham(listCTSPView.stream().filter(sp -> sp.getTrangThai() == 0).toList());
//        }
    }//GEN-LAST:event_cbbTrangThaiSanPhamMouseClicked

    private void btnShowDuLieuCacComboboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnShowDuLieuCacComboboxActionPerformed
        showComboboxThuongHieu();
        showComBoBoxXuatXu();
    }//GEN-LAST:event_btnShowDuLieuCacComboboxActionPerformed

    private void tbSanPhamNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbSanPhamNewMouseClicked
        int row = tbSanPhamNew.getSelectedRow();
        showIndexSanPham(row);
        if (evt.getButton() == MouseEvent.BUTTON1) {
            showIndexSanPham(row);
            System.out.println("id sản phẩm là : " + idSanPham);
        } else if (evt.getButton() == MouseEvent.BUTTON3) {
            if (row != -1) {
                int index = jTabbedPane1.indexOfComponent(pnSanPhamChiTiet);
                jTabbedPane1.setSelectedIndex(index);
                String tenSp = listSanPhamNew.get(row).getTenSanPhamView();
                lbTenSanPham.setText(tenSp);
                showTableChiTietSanPham((listCTSPView = serviceCTSP.listChiTietSanPham(idSanPham)));
            } else {
                JOptionPane.showMessageDialog(this, "vui long chọn chuột phải vào dòng sản phẩm trước khi muốn xem chi tiết ");
                return;
            }

        }
    }//GEN-LAST:event_tbSanPhamNewMouseClicked

    private void cbbThuongHieuNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbThuongHieuNewMouseClicked
        int selectedIndex = listThuongHieuSanPham.get(cbbThuongHieuNew.getSelectedIndex()).getId();
        System.out.println("vi tri combobox : " + selectedIndex);
    }//GEN-LAST:event_cbbThuongHieuNewMouseClicked

    private void btnThemSanPhamNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemSanPhamNewActionPerformed
        int chon = JOptionPane.showConfirmDialog(this, "bạn có muốn thêm sản phẩm không ?");
        SanPham sp = dataSanPham();
        for (SanPhamViewModel spCheck : listSanPhamNew) {
            if (!spCheck.getTenSanPhamView().equals(sp.getTen()) && !spCheck.getMaSanPhamView().equals(sp.getMa())) {
                if (sp != null) {
                    if (chon == JOptionPane.OK_OPTION) {
                        JOptionPane.showMessageDialog(this, serviceSanPham.them(sp));
                        showTableSanPhamNew(listSanPhamNew = serviceSanPham.listSanPhamHienThi());
                        
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "lỗi do chưa nhập dữ liệu hoặc sai định dạng");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "mã hoặc tên sản phẩm đã tồn tại");
                return;
            }
        }


    }//GEN-LAST:event_btnThemSanPhamNewActionPerformed

    private void cbbXuatXuNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbXuatXuNewMouseClicked
//        int idXX = listXuatXuSanPham.get(cbbXuatXuNew.getSelectedIndex()).getId();
//        System.out.println("id xx : " + idXX);
    }//GEN-LAST:event_cbbXuatXuNewMouseClicked

    private void btnSuaSanPhamNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaSanPhamNewActionPerformed
        if (dataSanPham() != null) {
            int chon = JOptionPane.showConfirmDialog(this, "bạn có muốn sửa sản phẩm không ?");
            if (chon == JOptionPane.OK_OPTION) {
                JOptionPane.showMessageDialog(this, serviceSanPham.sua(dataSanPham()));
                showTableSanPhamNew(listSanPhamNew = serviceSanPham.listSanPhamHienThi());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Sửa Không Thành Công");
            return;
        }
    }//GEN-LAST:event_btnSuaSanPhamNewActionPerformed

    private void cbbThuongHieuNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbThuongHieuNewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbThuongHieuNewActionPerformed

    private void cbbLocXuatXuSanPhamNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbLocXuatXuSanPhamNewMouseClicked
        listXuatXuSanPham = serviceXuatXuSanPham.listXuatXuSanPham();
        showTableSanPhamNew(listSanPhamNew.stream().filter(sp -> sp.getTenXuatXuView().equals(cbbLocXuatXuSanPhamNew.getSelectedItem().toString())).toList());
    }//GEN-LAST:event_cbbLocXuatXuSanPhamNewMouseClicked

    private void cbbLocThuongHieuSanPhamNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbLocThuongHieuSanPhamNewMouseClicked
        listSanPhamNew = serviceSanPham.listSanPhamHienThi();
        showTableSanPhamNew(listSanPhamNew.stream().filter(sp -> sp.getTenThuongHieuView().equals(cbbLocThuongHieuSanPhamNew.getSelectedItem().toString())).toList());
    }//GEN-LAST:event_cbbLocThuongHieuSanPhamNewMouseClicked

    private void cbbLocTrangThaiSanPhamNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbbLocTrangThaiSanPhamNewMouseClicked
        int trangThai = 0;
        if (cbbLocTrangThaiSanPhamNew.getSelectedIndex() == 1) {
            listSanPhamNew = serviceSanPham.listSanPhamHienThi();
            showTableSanPhamNew(listSanPhamNew.stream().filter(sp -> sp.getTrangThai() == 0).toList());
        } else if (cbbLocTrangThaiSanPhamNew.getSelectedIndex() == 0) {
            listSanPhamNew = serviceSanPham.listSanPhamHienThi();
            showTableSanPhamNew(listSanPhamNew.stream().filter(sp -> sp.getTrangThai() == 1).toList());
        }

    }//GEN-LAST:event_cbbLocTrangThaiSanPhamNewMouseClicked

    private void txtTimKiemSanPhamNewMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTimKiemSanPhamNewMouseClicked
        String timKiem = txtTimKiemSanPhamNew.getText();
        listSanPhamNew = serviceSanPham.listSanPham(timKiem);
        showTableSanPhamNew(listSanPhamNew);
    }//GEN-LAST:event_txtTimKiemSanPhamNewMouseClicked

    private void btnThemThuongHieuSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemThuongHieuSanPhamActionPerformed
        ViewThuongHieuSanPham th = new ViewThuongHieuSanPham();
        th.setVisible(true);
    }//GEN-LAST:event_btnThemThuongHieuSanPhamActionPerformed

    private void btnThemXuatXuSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemXuatXuSanPhamActionPerformed
        ViewXuatXuSanPham xx = new ViewXuatXuSanPham();
        xx.setVisible(true);
    }//GEN-LAST:event_btnThemXuatXuSanPhamActionPerformed

    private void btnExportExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExportExcelActionPerformed

    }//GEN-LAST:event_btnExportExcelActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.toedter.calendar.JDateChooser JdateNgayTao;
    private javax.swing.JButton btnCapNhap;
    private javax.swing.JButton btnExportExcel;
    private javax.swing.JButton btnShowDuLieuCacCombobox;
    private javax.swing.JButton btnSuaSanPhamNew;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnThemSanPhamNew;
    private javax.swing.JButton btnThemThuongHieuSanPham;
    private javax.swing.JButton btnThemXuatXuSanPham;
    private javax.swing.JButton btnloadData;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> cbbHuongViSua;
    private javax.swing.JComboBox<String> cbbKhoiLuong;
    private javax.swing.JComboBox<String> cbbLocThuongHieuSanPhamNew;
    private javax.swing.JComboBox<String> cbbLocTrangThaiSanPhamNew;
    private javax.swing.JComboBox<String> cbbLocXuatXuSanPhamNew;
    private javax.swing.JComboBox<String> cbbThuongHieuNew;
    private javax.swing.JComboBox<String> cbbTrangThaiSanPham;
    private javax.swing.JComboBox<String> cbbXuatXuNew;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
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
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel lbHinhAnh;
    private javax.swing.JLabel lbTenSanPham;
    private javax.swing.JPanel pnDanhMucSanPham;
    private javax.swing.JPanel pnSanPhamChiTiet;
    private javax.swing.JRadioButton rdHD;
    private javax.swing.JRadioButton rdKHD;
    private javax.swing.JRadioButton rdSanPhamDangKinhDoanh;
    private javax.swing.JRadioButton rdSanPhamDangNgungKinhDoanh;
    private javax.swing.JTable tbCTSP;
    private javax.swing.JTable tbSanPhamNew;
    private javax.swing.JTextField txtDGSPCT;
    private javax.swing.JTextField txtDonViTinh;
    private javax.swing.JTextArea txtGhiChu;
    private com.toedter.calendar.JDateChooser txtHanSuDung;
    private javax.swing.JTextField txtMaCTSP;
    private javax.swing.JTextField txtMaQr;
    private javax.swing.JTextField txtMaSanPhamNew;
    private com.toedter.calendar.JDateChooser txtNgaySanXuat;
    private javax.swing.JTextField txtSerch;
    private javax.swing.JSpinner txtSoLuongTon;
    private javax.swing.JTextField txtTenSanPhamNew;
    private javax.swing.JTextField txtTimKiemSanPhamNew;
    // End of variables declaration//GEN-END:variables

}
