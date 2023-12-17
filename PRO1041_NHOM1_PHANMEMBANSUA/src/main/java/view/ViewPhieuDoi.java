/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package view;

import controler.HoaDonChiTietServiceImpl;
import controler.HoaDon_PhieuDoiImpl;
import controler.PhieuDoiImpl;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.HoaDonChiTiet;
import model.HoaDon_PhieuDoi;
import model.PhieuDoi;

/**
 *
 * @author phtua
 */
public class ViewPhieuDoi extends javax.swing.JInternalFrame {

    DefaultTableModel dtm = new DefaultTableModel();
    PhieuDoiImpl dao = new PhieuDoiImpl();

    /**
     * Creates new form ViewPhieuDoi
     */
    public ViewPhieuDoi() {
        initComponents();
        loadDataTable();
        loadDataTableHoaDonLoc();
        loadTBBC();
        text();
    }

    public void text() {
        PhieuDoiImpl phieuDoiImpl = new PhieuDoiImpl();
        List<PhieuDoi> allPhieuDoi = phieuDoiImpl.getAll();

        Map<Integer, Integer> countByNhanVien = phieuDoiImpl.countPhieuDoiByNhanVien(allPhieuDoi);
        Map<Integer, Integer> countBySanPham = phieuDoiImpl.countPhieuDoiBySanPham(allPhieuDoi);

        int minCountNhanVien = Collections.min(countByNhanVien.values());
        int maxCountNhanVien = Collections.max(countByNhanVien.values());

        int minCountSanPham = Collections.min(countBySanPham.values());
        int maxCountSanPham = Collections.max(countBySanPham.values());

        StringBuilder resultTextNhanVien = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : countByNhanVien.entrySet()) {
            int idNhanVien = entry.getKey();
            int count = entry.getValue();
            if (count == minCountNhanVien || count == maxCountNhanVien) {
                resultTextNhanVien.append("Nhân viên có ID ").append(idNhanVien)
                        .append(" có ").append(count).append(" phiếu đổi.\n");
            }
        }

        StringBuilder resultTextSanPham = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : countBySanPham.entrySet()) {
            int idSanPham = entry.getKey();
            int count = entry.getValue();
            if (count == minCountSanPham || count == maxCountSanPham) {
                resultTextSanPham.append("Sản phẩm có ID ").append(idSanPham)
                        .append(" có ").append(count).append(" phiếu đổi.\n");
            }
        }

//         Hiển thị kết quả
        txtNVnn.setText(resultTextNhanVien.toString());
        txtSPnn.setText(resultTextSanPham.toString());
    }

    public void loadTBBC() {
        ArrayList<PhieuDoi> list = new ArrayList<>();
        dtm = (DefaultTableModel) tbPDBaoCao.getModel();
        list = (ArrayList<PhieuDoi>) dao.getAll();
        dtm.setRowCount(0);
        for (PhieuDoi x : list) {
            dtm.addRow(new Object[]{
                x.getMaPD(), x.getIdKhachHang(), x.getIdNhanVien(), x.getIdSanPham(), x.getIdSanPhamMoi(), x.getIdHoaDon(), x.getSoLuong(), x.getNgayDoi(), x.getLyDoDoi(),
                x.getTienThua(), x.getTienThieu()
            });
        }
    }

    public void loadDataTable() {
        ArrayList<PhieuDoi> list = new ArrayList<>();
        dtm = (DefaultTableModel) tbPhieuDoi.getModel();
        list = (ArrayList<PhieuDoi>) dao.getAll();
        dtm.setRowCount(0);
        for (PhieuDoi x : list) {
            dtm.addRow(new Object[]{
                x.getMaPD(), x.getIdKhachHang(), x.getIdNhanVien(), x.getIdSanPham(), x.getIdSanPhamMoi(), x.getIdHoaDon(), x.getSoLuong(), x.getNgayDoi(), x.getLyDoDoi(),
                x.getTienThua(), x.getTienThieu()
            });
        }
    }

    public void loadDataTableHoaDonLoc() {
        HoaDon_PhieuDoiImpl hd_pd = new HoaDon_PhieuDoiImpl();
        List<HoaDon_PhieuDoi> listHoaDon_pd = hd_pd.listAll();
        DefaultTableModel dtmHoaDon = (DefaultTableModel) tbHoaDon.getModel();
        dtmHoaDon.setRowCount(0);

        PhieuDoiImpl phieuDoiImpl = new PhieuDoiImpl();
        List<PhieuDoi> listPhieuDoi = phieuDoiImpl.getAll();

        for (HoaDon_PhieuDoi hoaDon : listHoaDon_pd) {
            String trangThai = "chưa đổi";

            for (PhieuDoi phieuDoi : listPhieuDoi) {
                // So sánh ID hóa đơn sử dụng equals
                if (Objects.equals(hoaDon.getIdHD(), phieuDoi.getIdHoaDon())) {
                    trangThai = "đã đổi";
                    break;
                }
            }

            Object[] rowData = {
                hoaDon.getIdHD(),
                hoaDon.getMaHD(),
                hoaDon.getNgayTao(),
                hoaDon.getIdKhachHang(),
                hoaDon.getTongTien(),
                hoaDon.getIdNhanVien(),
                trangThai
            };
            dtmHoaDon.addRow(rowData);
        }
    }

    public void loadDataTableHoaDon() {
        HoaDon_PhieuDoiImpl hd_pd = new HoaDon_PhieuDoiImpl();
        List<HoaDon_PhieuDoi> listHoaDon_pd = new ArrayList<>();
        dtm = (DefaultTableModel) tbHoaDon.getModel();
        listHoaDon_pd = hd_pd.listAll();
        dtm.setRowCount(0);
        for (HoaDon_PhieuDoi x : listHoaDon_pd) {
            dtm.addRow(new Object[]{
                x.getIdHD(), x.getMaHD(), x.getNgayTao(), x.getIdKhachHang(), x.getTongTien(), x.getIdNhanVien()
            });
        }
    }

    public void loadDataTableHoaDonCT(int id) {
        HoaDonChiTietServiceImpl hoadonCT = new HoaDonChiTietServiceImpl();
        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
        dtm = (DefaultTableModel) tbHDCT.getModel();
        list = (ArrayList<HoaDonChiTiet>) hoadonCT.listAll(id);
        dtm.setRowCount(0);

        PhieuDoiImpl phieuDoiImpl = new PhieuDoiImpl();
        List<PhieuDoi> listPhieuDoi = phieuDoiImpl.getAll();

        for (HoaDonChiTiet x : list) {
            String trangThai = "chưa đổi";

            for (PhieuDoi phieuDoi : listPhieuDoi) {
                // So sánh ID hóa đơn và ID sản phẩm sử dụng equals
                if (Objects.equals(x.getiDHD(), phieuDoi.getIdHoaDon()) && Objects.equals(x.getiDCTSP(), phieuDoi.getIdSanPham())) {
                    trangThai = "đã đổi";
                    break;
                }
            }
            dtm.addRow(new Object[]{
                x.getiDHD(), x.getiDCTSP(), x.getSoLuong(), x.getDonGia(), trangThai
            });
        }

//        HoaDonChiTietServiceImpl hoadonCT = new HoaDonChiTietServiceImpl();
//        ArrayList<HoaDonChiTiet> list = new ArrayList<>();
//        dtm = (DefaultTableModel) tbHDCT.getModel();
//        list = (ArrayList<HoaDonChiTiet>) hoadonCT.listAll(id);
//        dtm.setRowCount(0);
//        for (HoaDonChiTiet x : list) {
//            dtm.addRow(new Object[]{
//                x.getiDHD(), x.getiDCTSP(), x.getSoLuong(), x.getDonGia(),"chưa đổi"
//            });
//        }
    }

    public PhieuDoi getDataForm() {
        LocalDate currentDate = LocalDate.now();
        int rowHD = tbHoaDon.getSelectedRow();
        int rowHDCT = tbHDCT.getSelectedRow();
        String maPD = UUID.randomUUID().toString().trim();
        int idKH = Integer.parseInt(tbHoaDon.getValueAt(rowHD, 3).toString());
        int idNV = Integer.parseInt(tbHoaDon.getValueAt(rowHD, 5).toString());
        int idSPC = Integer.parseInt(tbHDCT.getValueAt(rowHDCT, 1).toString());
        int idSPM = Integer.parseInt(txtIdsanPhamMoi.getText());
        int idHD = Integer.parseInt(tbHDCT.getValueAt(rowHDCT, 0).toString());
        int soluong = Integer.parseInt(txtSoLuong.getText());
        String ngaydoi = currentDate.toString();
        String lyDodoi = cbbLyDoDoi.getSelectedItem().toString();
        float tienThua = Float.parseFloat(txtTienThua.getText());
        float tienThieu = Float.parseFloat(txtTienThieu.getText());
        PhieuDoi pd = new PhieuDoi(maPD, idKH, idNV, idSPM, idHD,
                soluong, ngaydoi, lyDodoi, idSPM, tienThua, tienThieu);
        return pd;
    }

    public void TinhTien() {
        int rowHD = tbHoaDon.getSelectedRow();
        if (rowHD == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn Hóa đơn để tính tiền");
            return;
        }
        int row = tbHDCT.getSelectedRow();
// Check if a row is selected
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Bạn chưa chọn sản phẩm để tính tiền");
            return;
        }

        String soLuongText = txtSoLuong.getText().trim();

// Check if the input for quantity is empty
        if (soLuongText.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập số lượng");
            return;
        }

        try {
            int soLuongTxt = Integer.parseInt(soLuongText);
            int soLuongDaMua = Integer.parseInt(tbHDCT.getValueAt(row, 2).toString());

            // Check if the entered quantity is greater than the purchased quantity
            int idspm = Integer.parseInt(txtIdsanPhamMoi.getText());
            int idHienTai = Integer.parseInt(tbHDCT.getValueAt(row, 1).toString());

            // Check if the entered quantity is zero
            if (soLuongTxt == 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
                return;
            }

            if (idspm == idHienTai) {
                // If the product IDs are the same, set the financial values to zero
                txtTienThieu.setText("0");
                txtTienThua.setText("0");
            } else {
                int soluong = Integer.valueOf(txtSoLuong.getText());
                int soluongton = NewChonSP.soLuongTon;
                if (soluong > soluongton) {
                    JOptionPane.showMessageDialog(this, "Lượng tồn không đủ");
                }
                // Calculate financial values
                BigDecimal tienHT = new BigDecimal(soLuongDaMua * Float.parseFloat(tbHDCT.getValueAt(row, 3).toString()));
                BigDecimal tienM = new BigDecimal(NewChonSP.Dongia * soLuongTxt);
                BigDecimal tien = tienM.subtract(tienHT);
                System.out.println("tienht" + tienHT);
                System.out.println("tienm" + tienM);
                System.out.println("tien" + tien);
                int soSanh = tien.compareTo(BigDecimal.ZERO);
                // Display financial values
                if (soSanh > 0) {
                    txtTienThua.setText("0");
                    txtTienThieu.setText(String.valueOf(tien));
                } else if (soSanh < 0) {
                    txtTienThieu.setText("0");
                    txtTienThua.setText(String.valueOf(tien.abs()));
                } else {
                    txtTienThieu.setText("0");
                    txtTienThua.setText("0");
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng không hợp lệ");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbHoaDon = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbHDCT = new javax.swing.JTable();
        btnTimKiem = new javax.swing.JButton();
        txtTimKiem = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPhieuDoi = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtSoLuong = new javax.swing.JTextField();
        txtIdsanPhamMoi = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        cbbLyDoDoi = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtTienThua = new javax.swing.JTextField();
        txtTienThieu = new javax.swing.JTextField();
        bntTinhTien = new javax.swing.JButton();
        btnChonSp = new javax.swing.JButton();
        btnThayThe = new javax.swing.JButton();
        btnDoi = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        cbblydo = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        txtNVnn = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtSPnn = new javax.swing.JTextArea();
        bntlammoi = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbPDBaoCao = new javax.swing.JTable();
        btnApDung = new javax.swing.JButton();
        txtTKBC = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        txtSoLuongDoi = new javax.swing.JTextArea();
        jScrollPane8 = new javax.swing.JScrollPane();
        txtSoLyDoDoi = new javax.swing.JTextArea();
        cbbBCLD = new javax.swing.JComboBox<>();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Quản lý phiếu đổi");

        jTabbedPane1.setBackground(new java.awt.Color(0, 204, 255));
        jTabbedPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 153, 153)));

        jPanel1.setBackground(new java.awt.Color(0, 204, 255));

        tbHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "id hóa đơn", "mã hóa đơn", "ngày tạo", "id khách hàng", "tổng tiền", "id nhan vien", "trạng thái"
            }
        ));
        tbHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHoaDonMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbHoaDon);

        tbHDCT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "id hóa đơn", "id sản pham chi tiết", "số lượng", "đơn giá", "trạng thái"
            }
        ));
        tbHDCT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbHDCTMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tbHDCT);

        btnTimKiem.setText("tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        tbPhieuDoi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã phiếu", "id khách hàng", "id nhân viên", "id sản phẩm", "ID sản phẩm mới", "id hóa đơn", "số lượng", "ngày đổi", "lý do đổi", "tiền thừa", "tiền thiếu"
            }
        ));
        jScrollPane1.setViewportView(tbPhieuDoi);

        jPanel3.setBackground(new java.awt.Color(0, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED)));
        jPanel3.setForeground(new java.awt.Color(0, 255, 204));

        jLabel5.setText("số lượng");

        jLabel6.setText("lý do đổi");

        cbbLyDoDoi.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sản phẩm bị hư hại", "sai san pham" }));

        jLabel2.setText("tiền thừa");

        jLabel7.setText("tiền thiếu");

        bntTinhTien.setText("Tính tiền");
        bntTinhTien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntTinhTienActionPerformed(evt);
            }
        });

        btnChonSp.setText("chọn sản phẩm");
        btnChonSp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChonSpActionPerformed(evt);
            }
        });

        btnThayThe.setText("thay thế");
        btnThayThe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThayTheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(btnChonSp)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnThayThe)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdsanPhamMoi, javax.swing.GroupLayout.DEFAULT_SIZE, 84, Short.MAX_VALUE)
                        .addGap(56, 56, 56))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel7))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTienThua)
                                    .addComponent(txtSoLuong)
                                    .addComponent(txtTienThieu)
                                    .addComponent(cbbLyDoDoi, 0, 1, Short.MAX_VALUE))
                                .addGap(56, 56, 56))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(bntTinhTien)
                                .addGap(0, 0, Short.MAX_VALUE))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnChonSp)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThayThe)
                    .addComponent(txtIdsanPhamMoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbbLyDoDoi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtTienThua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtTienThieu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(bntTinhTien)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        btnDoi.setText("Đổi");
        btnDoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDoiActionPerformed(evt);
            }
        });

        jButton1.setText("làm mới");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        cbblydo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "đã đổi", "chưa đổi" }));
        cbblydo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbblydoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTimKiem)
                        .addGap(26, 26, 26)
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(cbblydo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 658, Short.MAX_VALUE)
                        .addComponent(jScrollPane3)))
                .addGap(95, 95, 95))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnDoi, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTimKiem)
                            .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1)
                            .addComponent(cbblydo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(btnDoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        jTabbedPane1.addTab("quản lý", jPanel1);

        jLabel3.setText("Nhân viên");

        jLabel8.setText("Sản phẩm");

        txtNVnn.setColumns(20);
        txtNVnn.setRows(5);
        jScrollPane4.setViewportView(txtNVnn);

        txtSPnn.setColumns(20);
        txtSPnn.setRows(5);
        jScrollPane5.setViewportView(txtSPnn);

        bntlammoi.setText("làm mới");
        bntlammoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bntlammoiActionPerformed(evt);
            }
        });

        tbPDBaoCao.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "mã ", "id khách hàng", "id Nhân viên", "id sản phẩm", "id sản phẩm mới", "hóa đơn", "số lượng", "ngày đổi", "lý do", "tiền thừa ", "tiền thiếu"
            }
        ));
        jScrollPane6.setViewportView(tbPDBaoCao);

        btnApDung.setText("tìm kiếm");
        btnApDung.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnApDungActionPerformed(evt);
            }
        });

        jLabel4.setText("tìm kiếm");

        jLabel12.setText("tổng số lượng đổi");

        jLabel16.setText("số sản phẩm bị đổi ");

        txtSoLuongDoi.setColumns(20);
        txtSoLuongDoi.setRows(5);
        jScrollPane7.setViewportView(txtSoLuongDoi);

        txtSoLyDoDoi.setColumns(20);
        txtSoLyDoDoi.setRows(5);
        jScrollPane8.setViewportView(txtSoLyDoDoi);

        cbbBCLD.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "sản phẩm bị hư hại", "sai san pham" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(18, 18, 18)
                                .addComponent(txtTKBC, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(cbbBCLD, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(btnApDung)
                                .addGap(30, 30, 30)
                                .addComponent(bntlammoi))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(170, 170, 170)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jLabel8)
                                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 919, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 95, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTKBC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(cbbBCLD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnApDung)
                            .addComponent(bntlammoi))))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(21, 21, 21))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jTabbedPane1.addTab("báo cáo", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(385, 385, 385))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDoiActionPerformed

        int luongton = NewChonSP.soLuongTon;
        int iDSanPham = Integer.parseInt(txtIdsanPhamMoi.getText());
        int soluong = Integer.parseInt(txtSoLuong.getText());
        int row = tbHDCT.getSelectedRow();
        String trangthai = tbHDCT.getValueAt(row, 4).toString();

        if (trangthai.equals("đã đổi")) {
            JOptionPane.showMessageDialog(this, "bạn đã đổi rồi không được đổi nữa");
        } else {
            if (dao.them(getDataForm())) {
                JOptionPane.showMessageDialog(this, "Tạo phiếu thành công");
                loadDataTable();

                // Kiểm tra nếu là sản phẩm bị hư hại, thực hiện xóa sản phẩm
                if (cbbLyDoDoi.getSelectedItem().equals("sản phẩm bị hư hại")) {
                    dao.xoaSanPham(iDSanPham, soluong);
                    JOptionPane.showMessageDialog(this, "Đã xóa sản phẩm bị hư hại");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Tạo phiếu thất bại");
            }
            loadDataTableHoaDonLoc();
        }
    }//GEN-LAST:event_btnDoiActionPerformed

    private void btnThayTheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThayTheActionPerformed
        txtIdsanPhamMoi.setText(String.valueOf(NewChonSP.id));
    }//GEN-LAST:event_btnThayTheActionPerformed

    private void btnChonSpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChonSpActionPerformed
        NewChonSP cnv = new NewChonSP();
        cnv.setVisible(true);
    }//GEN-LAST:event_btnChonSpActionPerformed

    private void bntTinhTienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntTinhTienActionPerformed
        String sl = txtSoLuong.getText();
        try {
            int soLuong = Integer.parseInt(sl);
            if (soLuong < 0) {
                JOptionPane.showMessageDialog(this, "Số lượng phải lớn hơn 0");
            }
            // Tiếp tục xử lý nếu số lượng hợp lệ
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Số lượng phải là số");
        }

        TinhTien();
    }//GEN-LAST:event_bntTinhTienActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        String tk = txtTimKiem.getText();
        HoaDon_PhieuDoiImpl hd_pd = new HoaDon_PhieuDoiImpl();
        List<HoaDon_PhieuDoi> listHoaDon_pd = new ArrayList<>();
        dtm = (DefaultTableModel) tbHoaDon.getModel();
        listHoaDon_pd = hd_pd.listAll();
        dtm.setRowCount(0);
        for (HoaDon_PhieuDoi x : listHoaDon_pd) {
            if (tk.trim().equalsIgnoreCase(String.valueOf(x.getIdHD())) || tk.trim().equalsIgnoreCase(x.getNgayTao())
                    || tk.trim().equalsIgnoreCase(x.getMaHD())) {
                dtm.addRow(new Object[]{
                    x.getIdHD(), x.getMaHD(), x.getNgayTao(), x.getIdKhachHang(), x.getTongTien(), x.getIdNhanVien()
                });
            }
        }
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void tbHDCTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHDCTMouseClicked
        int row = tbHDCT.getSelectedRow();
        txtIdsanPhamMoi.setText(tbHDCT.getValueAt(row, 1).toString());
    }//GEN-LAST:event_tbHDCTMouseClicked

    private void tbHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbHoaDonMouseClicked
        int row = tbHoaDon.getSelectedRow();
        int id = Integer.parseInt(tbHoaDon.getValueAt(row, 0).toString());
        loadDataTableHoaDonCT(id);
    }//GEN-LAST:event_tbHoaDonMouseClicked

    private void bntlammoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bntlammoiActionPerformed
        loadTBBC();
        text();
    }//GEN-LAST:event_bntlammoiActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        loadDataTableHoaDonLoc();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbblydoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbblydoActionPerformed
        String lydodoi = cbblydo.getSelectedItem().toString();
        HoaDon_PhieuDoiImpl hd_pd = new HoaDon_PhieuDoiImpl();
        List<HoaDon_PhieuDoi> listHoaDon_pd = hd_pd.listAll();
        DefaultTableModel dtmHoaDon = (DefaultTableModel) tbHoaDon.getModel();
        dtmHoaDon.setRowCount(0);

        PhieuDoiImpl phieuDoiImpl = new PhieuDoiImpl();
        List<PhieuDoi> listPhieuDoi = phieuDoiImpl.getAll();

        for (HoaDon_PhieuDoi hoaDon : listHoaDon_pd) {
            String trangThai = "chưa đổi";

            for (PhieuDoi phieuDoi : listPhieuDoi) {
                // So sánh ID hóa đơn sử dụng equals
                if (Objects.equals(hoaDon.getIdHD(), phieuDoi.getIdHoaDon())) {
                    trangThai = "đã đổi";
                    break;
                }
            }

            // Nếu trạng thái khớp với lý do đổi được chọn, thêm vào bảng
            if (trangThai.equals(lydodoi)) {
                Object[] rowData = {
                    hoaDon.getIdHD(),
                    hoaDon.getMaHD(),
                    hoaDon.getNgayTao(),
                    hoaDon.getIdKhachHang(),
                    hoaDon.getTongTien(),
                    hoaDon.getIdNhanVien(),
                    trangThai
                };
                dtmHoaDon.addRow(rowData);
            }
        }

    }//GEN-LAST:event_cbblydoActionPerformed

    private void btnApDungActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnApDungActionPerformed
        int count = 0;
        int countQuaHan = 0;
        int countSaiSP = 0;
        String tK = txtTKBC.getText();
        String lydo = String.valueOf(cbbBCLD.getSelectedItem());
        ArrayList<PhieuDoi> list = new ArrayList<>();
        dtm = (DefaultTableModel) tbPDBaoCao.getModel();
        list = (ArrayList<PhieuDoi>) dao.getAll();
        dtm.setRowCount(0);
        for (PhieuDoi x : list) {
            if (!(tK.isEmpty()) && (lydo.equalsIgnoreCase(x.getLyDoDoi()))) {
                if (tK.equalsIgnoreCase(x.getNgayDoi()) || tK.equalsIgnoreCase(x.getMaPD())) {
                    dtm.addRow(new Object[]{
                        x.getMaPD(), x.getIdKhachHang(), x.getIdNhanVien(), x.getIdSanPham(), x.getIdSanPhamMoi(), x.getIdHoaDon(), x.getSoLuong(), x.getNgayDoi(), x.getLyDoDoi(),
                        x.getTienThua(), x.getTienThieu()
                    });
                    count++;
                    if (x.getLyDoDoi().equalsIgnoreCase("sản phẩm bị hư hại")) {
                        countQuaHan++;
                    }
                    if (x.getLyDoDoi().equalsIgnoreCase("sai san pham")) {
                        countSaiSP++;
                    }
                }
            } else {
                if ((lydo.equalsIgnoreCase(x.getLyDoDoi()))) {
                    dtm.addRow(new Object[]{
                        x.getMaPD(), x.getIdKhachHang(), x.getIdNhanVien(), x.getIdSanPham(), x.getIdSanPhamMoi(), x.getIdHoaDon(), x.getSoLuong(), x.getNgayDoi(), x.getLyDoDoi(),
                        x.getTienThua(), x.getTienThieu()
                    });
                    count++;
                    if (x.getLyDoDoi().equalsIgnoreCase("sản phẩm bị hư hại")) {
                        countQuaHan++;
                    }
                    if (x.getLyDoDoi().equalsIgnoreCase("sai san pham")) {
                        countSaiSP++;
                    }
                }
            }

        }
        txtSoLuongDoi.setText("" + count);
        txtSoLyDoDoi.setText("sản phẩm bị hư hại: " + countQuaHan + "  sai sản phẩm : " + countSaiSP);
    }//GEN-LAST:event_btnApDungActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bntTinhTien;
    private javax.swing.JButton bntlammoi;
    private javax.swing.JButton btnApDung;
    private javax.swing.JButton btnChonSp;
    private javax.swing.JButton btnDoi;
    private javax.swing.JButton btnThayThe;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JComboBox<String> cbbBCLD;
    private javax.swing.JComboBox<String> cbbLyDoDoi;
    private javax.swing.JComboBox<String> cbblydo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tbHDCT;
    private javax.swing.JTable tbHoaDon;
    private javax.swing.JTable tbPDBaoCao;
    private javax.swing.JTable tbPhieuDoi;
    private javax.swing.JTextField txtIdsanPhamMoi;
    private javax.swing.JTextArea txtNVnn;
    private javax.swing.JTextArea txtSPnn;
    private javax.swing.JTextField txtSoLuong;
    private javax.swing.JTextArea txtSoLuongDoi;
    private javax.swing.JTextArea txtSoLyDoDoi;
    private javax.swing.JTextField txtTKBC;
    private javax.swing.JTextField txtTienThieu;
    private javax.swing.JTextField txtTienThua;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
