/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.awt.Image;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietSanPham;
import model.SanPham;
import modelView.CTSP;
import modelView.HoaDonView;
import repository.ChiTietSanPhamService;
import repository.CrudfullTable;
import repository.SanPhamService;

/**
 *
 * @author vuhoa
 */
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    @Override
    public List<CTSP> listChiTietSanPham(int idSanPham) {
        List<CTSP> listCTSPView = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " select ct.Id_SPCT,ct.MaCTSP,SanPham.TenSP,HuongVi.Ten_HuongVi,ct.NgaySanXuat, "
                    + " ct.HSD,ct.SoLuongTon,ct.DonGia,KhoiLuong.TenKhoiLuong, "
                    + " ct.DVT,ct.MaQR,ct.GhiChu,ct.TrangThai,ct.Anh from ChiTietSanPham as ct "
                    + " join SanPham on SanPham.Id_SP = ct.Id_SP "
                    + " join HuongVi on HuongVi.Id_HuongVi = ct.HuongViSua "
                    + " join KhoiLuong on KhoiLuong.Id_KhoiLuong = ct.Id_KhoiLuong "
                    + " where SanPham.Id_SP = ? ";
            PreparedStatement pre = con.prepareCall(sql);
            pre.setInt(1, idSanPham);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CTSP ctsp = new CTSP();
                ctsp.setId(rs.getInt("Id_SPCT"));
                ctsp.setMaSPCT(rs.getString("MaCTSP"));
                ctsp.setTenSanPham(rs.getString("TenSP"));
                ctsp.setHuongVi(rs.getString("Ten_HuongVi"));
                ctsp.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                ctsp.setHanSuDung(rs.getDate("HSD"));
                ctsp.setSoLuongTon(rs.getInt("SoLuongTon"));
                ctsp.setDonGia(rs.getFloat("DonGia"));
                ctsp.setKhoiLuong(rs.getString("TenKhoiLuong"));
                ctsp.setDonViTinh(rs.getString("DVT"));
                ctsp.setMaQr(rs.getString("MaQR"));
                ctsp.setGhiChu(rs.getString("GhiChu"));
                ctsp.setTrangThai(rs.getInt("TrangThai"));
                ctsp.setAnh(rs.getString("Anh"));
                listCTSPView.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTSPView;
    }

    @Override
    public String themCTSP(ChiTietSanPham sp) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " insert into ChiTietSanPham "
                    + " (MaCTSP,"
                    + " Id_SP,"
                    + " HuongViSua,"
                    + " NgaySanXuat,"
                    + " HSD,"
                    + " SoLuongTon,"
                    + " DonGia,"
                    + " Id_KhoiLuong,"
                    + " DVT,"
                    + " MaQR,"
                    + " GhiChu,"
                    + " TrangThai,"
                    + " Anh) "
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, sp.getMaCTSP());
            pre.setInt(2, sp.getIdSanPham());
            pre.setInt(3, sp.getId_HuongVi());
            pre.setDate(4, sp.getNgaySanXuat());
            pre.setDate(5, sp.getHaSuDung());
            pre.setInt(6, sp.getSoLuongTon());
            pre.setFloat(7, sp.getDonGia());
            pre.setInt(8, sp.getIdKhoiLuong());
            pre.setString(9, sp.getDonViTinh());
            pre.setString(10, sp.getMaQr());
            pre.setString(11, sp.getGhiChu());
            pre.setInt(12, sp.getTrangThai());
            pre.setString(13, sp.getAnh());
            pre.executeUpdate();
            System.out.println("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thêm Chi Tiết Sản phẩm Thành Công";
    }

    @Override
    public String sua(ChiTietSanPham sp) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " Update ChiTietSanPham set "
                    + " MaCTSP = ? ,"
                    + " Id_SP = ? ,"
                    + " HuongViSua = ? ,"
                    + " NgaySanXuat = ?,"
                    + " HSD = ?,"
                    + " SoLuongTon = ?,"
                    + " DonGia = ?,"
                    + " Id_KhoiLuong = ? ,"
                    + " DVT = ? ,"
                    + " MaQR = ? ,"
                    + " GhiChu = ? ,"
                    + " TrangThai = ?,"
                    + " Anh = ? "
                    + " Where Id_SPCT = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, sp.getMaCTSP());
            pre.setInt(2, sp.getIdSanPham());
            pre.setInt(3, sp.getId_HuongVi());
            pre.setDate(4, sp.getNgaySanXuat());
            pre.setDate(5, sp.getHaSuDung());
            pre.setInt(6, sp.getSoLuongTon());
            pre.setFloat(7, sp.getDonGia());
            pre.setInt(8, sp.getIdKhoiLuong());
            pre.setString(9, sp.getDonViTinh());
            pre.setString(10, sp.getMaQr());
            pre.setString(11, sp.getGhiChu());
            pre.setInt(12, sp.getTrangThai());
            pre.setString(13, sp.getAnh());
            pre.setInt(14, view.QuanLySanPhamView.idCTSP);
            System.out.println("sửa sản phẩm thành công ?");
            pre.executeUpdate();
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Sửa Thành công ";
    }

//    @Override
//    public List<CTSP> Serch(String sp) {
//        List<CTSP> listCTSPView = new ArrayList<>();
//        try (Connection con = Database.JdbcUtil.getConnection()) {
//            String sql = " select ct.Id_SPCT, ct.MaCTSP,SanPham.TenSP,lsp.TenLoai,dsp.TenDSP, "
//                    + " ct.HSD,nsx.QuocGia,ct.SoLuongTon,ct.DonGia,KhoiLuong.TenKhoiLuong, "
//                    + " ct.DVT,ct.MaQR,ct.GhiChu,ct.TrangThai,ct.Anh "
//                    + " from ChiTietSanPham as ct join SanPham  "
//                    + " on ct.Id_SP = SanPham.Id_SP "
//                    + " join LoaiSanPham as lsp on ct.Id_LSP = lsp.Id_LSP "
//                    + " join DongSanPham as dsp on ct.Id_DSP = dsp.Id_DongSanPham "
//                    + " join NhaSanXuat as nsx on ct.Id_NSX = nsx.Id_NSX "
//                    + " join KhoiLuong on ct.Id_KhoiLuong = KhoiLuong.Id_KhoiLuong "
//                    + "  Where SanPham.TenSP LIKE CONCAT (N'%' , ? , '%' )";
//            PreparedStatement pre = con.prepareCall(sql);
//            pre.setString(1, sp);
//            ResultSet rs = pre.executeQuery();
//            while (rs.next()) {
//                CTSP ctsp = new CTSP();
//                ctsp.setId(rs.getInt("Id_SPCT"));
//                ctsp.setMaSPCT(rs.getString("MaCTSP"));
//                ctsp.setTenSanPham(rs.getString("TenSP"));
//                ctsp.setTenLoaiSP(rs.getString("TenLoai"));
//                ctsp.setTenDongSanPham(rs.getString("TenDSP"));
//                ctsp.sethSD(rs.getDate("HSD"));
//                ctsp.setXuatSu(rs.getString("QuocGia"));
//                ctsp.setSoLuongTon(rs.getInt("SoLuongTon"));
//                ctsp.setDonGia(rs.getFloat("DonGia"));
//                ctsp.setKhoiLuong(rs.getString("TenKhoiLuong"));
//                ctsp.setDonViTinh(rs.getString("DVT"));
//                ctsp.setMaQr(rs.getString("MaQR"));
//                ctsp.setGhiChu(rs.getString("GhiChu"));
//                ctsp.setTrangThai(rs.getInt("TrangThai"));
//                ctsp.setAnh(rs.getString("Anh"));
//                listCTSPView.add(ctsp);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listCTSPView;
//    }
    @Override
    public List<CTSP> getSanPhamInHoaDon(int index) {
        List<CTSP> listSPInHoaDon = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " select  ChiTietSanPham.Id_SPCT,SanPham.TenSP,HoaDonChiTiet.SoLuong,HoaDonChiTiet.DonGia from HoaDon "
                    + " join HoaDonChiTiet on HoaDon.Id_HD = HoaDonChiTiet.Id_HD "
                    + " join ChiTietSanPham on HoaDonChiTiet.Id_CTSP = ChiTietSanPham.Id_SPCT "
                    + " join SanPham on ChiTietSanPham.Id_SP = SanPham.Id_SP "
                    + " where  HoaDonChiTiet.Id_HD = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, index);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CTSP ct = new CTSP();
                ct.setId(rs.getInt("Id_SPCT"));
                ct.setTenSanPham(rs.getString("TenSP"));
                ct.setSoLuongTon(rs.getInt("SoLuong"));
                ct.setDonGia(rs.getFloat("DonGia"));
                listSPInHoaDon.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSPInHoaDon;
    }

    @Override
    public String updateCTSPInGioHang(ChiTietSanPham sp) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "UPDATE ChiTietSanPham SET SoLuongTon = ? WHERE Id_SPCT = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, sp.getSoLuongTon());
            pre.setInt(2, sp.getIdCTSP());
            int rowsAffected = pre.executeUpdate();

            // Commit thay đổi vào cơ sở dữ liệu
            con.commit();

            System.out.println("Số dòng được cập nhật: " + rowsAffected);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    @Override
    public List<CTSP> listSanPhamInBill() {
        List<CTSP> listChiTietSanPhamView = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " select ct.Id_SPCT,ct.MaCTSP,SanPham.TenSP,HuongVi.Ten_HuongVi,ct.NgaySanXuat, "
                    + " ct.HSD,ct.SoLuongTon,ct.DonGia,KhoiLuong.TenKhoiLuong, "
                    + " ct.DVT,ct.MaQR,ct.GhiChu,ct.TrangThai,ct.Anh from ChiTietSanPham as ct "
                    + " join SanPham on SanPham.Id_SP = ct.Id_SP "
                    + " join HuongVi on HuongVi.Id_HuongVi = ct.HuongViSua "
                    + " join KhoiLuong on KhoiLuong.Id_KhoiLuong = ct.Id_KhoiLuong ";
            PreparedStatement pre = con.prepareCall(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CTSP ctsp = new CTSP();
                ctsp.setId(rs.getInt("Id_SPCT"));
                ctsp.setMaSPCT(rs.getString("MaCTSP"));
                ctsp.setTenSanPham(rs.getString("TenSP"));
                ctsp.setHuongVi(rs.getString("Ten_HuongVi"));
                ctsp.setNgaySanXuat(rs.getDate("NgaySanXuat"));
                ctsp.setHanSuDung(rs.getDate("HSD"));
                ctsp.setSoLuongTon(rs.getInt("SoLuongTon"));
                ctsp.setDonGia(rs.getFloat("DonGia"));
                ctsp.setKhoiLuong(rs.getString("TenKhoiLuong"));
                ctsp.setDonViTinh(rs.getString("DVT"));
                ctsp.setMaQr(rs.getString("MaQR"));
                ctsp.setGhiChu(rs.getString("GhiChu"));
                ctsp.setTrangThai(rs.getInt("TrangThai"));
                ctsp.setAnh(rs.getString("Anh"));
                listChiTietSanPhamView.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChiTietSanPhamView;
    }
}
