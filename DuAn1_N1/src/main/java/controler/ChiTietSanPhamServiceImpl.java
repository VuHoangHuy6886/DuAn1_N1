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
    public List<CTSP> listChiTietSanPham() {
        List<CTSP> listCTSPView = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " select ct.Id_SPCT, ct.MaCTSP,SanPham.TenSP,lsp.TenLoai,dsp.TenDSP, "
                    + " ct.HSD,nsx.QuocGia,ct.SoLuongTon,ct.DonGia,KhoiLuong.TenKhoiLuong, "
                    + " ct.DVT,ct.MaQR,ct.GhiChu,ct.TrangThai,ct.Anh "
                    + " from ChiTietSanPham as ct join SanPham  "
                    + " on ct.Id_SP = SanPham.Id_SP "
                    + " join LoaiSanPham as lsp on ct.Id_LSP = lsp.Id_LSP "
                    + " join DongSanPham as dsp on ct.Id_DSP = dsp.Id_DongSanPham "
                    + " join NhaSanXuat as nsx on ct.Id_NSX = nsx.Id_NSX "
                    + " join KhoiLuong on ct.Id_KhoiLuong = KhoiLuong.Id_KhoiLuong ";
            PreparedStatement pre = con.prepareCall(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CTSP ctsp = new CTSP();
                ctsp.setId(rs.getInt("Id_SPCT"));
                ctsp.setMaSPCT(rs.getString("MaCTSP"));
                ctsp.setTenSanPham(rs.getString("TenSP"));
                ctsp.setTenLoaiSP(rs.getString("TenLoai"));
                ctsp.setTenDongSanPham(rs.getString("TenDSP"));
                ctsp.sethSD(rs.getDate("HSD"));
                ctsp.setXuatSu(rs.getString("QuocGia"));
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
            String sql = "INSERT INTO ChiTietSanPham ("
                    + " MaCTSP, "
                    + " Id_SP, "
                    + " Id_LSP, "
                    + " Id_DSP, "
                    + " HSD, "
                    + " Id_NSX, "
                    + " SoLuongTon, "
                    + " DonGia, "
                    + " Id_KhoiLuong, "
                    + " DVT, "
                    + " MaQR, "
                    + " GhiChu, "
                    + " TrangThai, "
                    + " Anh )"
                    + " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, sp.getMaCTSP());
            pre.setInt(2, sp.getIdSanPham());
            pre.setInt(3, sp.getIdLoaiSp());
            pre.setInt(4, sp.getIdDongSanPham());
            pre.setDate(5, sp.gethSD());
            pre.setInt(6, sp.getIdNSX());
            pre.setInt(7, sp.getSoLuongTon());
            pre.setFloat(8, sp.getDonGia());
            pre.setInt(9, sp.getIdKhoiLuong());
            pre.setString(10, sp.getDonViTinh());
            pre.setString(11, sp.getMaQr());
            pre.setString(12, sp.getGhiChu());
            pre.setInt(13, sp.getTrangThai());
            pre.setString(14, sp.getAnh());
            pre.executeUpdate();
            System.out.println("1");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thành Công";
    }

    @Override
    public String sua(ChiTietSanPham sp) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "UPDATE ChiTietSanPham SET "
                    + " MaCTSP = ? ,"
                    + " Id_SP = ?, "
                    + " Id_LSP = ?, "
                    + " Id_DSP = ?, "
                    + " HSD = ?, "
                    + " Id_NSX = ?, "
                    + " SoLuongTon = ?, "
                    + " DonGia = ?, "
                    + " Id_KhoiLuong = ?, "
                    + " DVT = ?, "
                    + " MaQR = ?, "
                    + " GhiChu = ?, "
                    + " TrangThai = ?, "
                    + " Anh = ? "
                    + " WHERE Id_SPCT = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, sp.getMaCTSP());
            pre.setInt(2, sp.getIdSanPham());
            pre.setInt(3, sp.getIdLoaiSp());
            pre.setInt(4, sp.getIdDongSanPham());
            pre.setDate(5, sp.gethSD());
            pre.setInt(6, sp.getIdNSX());
            pre.setInt(7, sp.getSoLuongTon());
            pre.setFloat(8, sp.getDonGia());
            pre.setInt(9, sp.getIdKhoiLuong());
            pre.setString(10, sp.getDonViTinh());
            pre.setString(11, sp.getMaQr());
            pre.setString(12, sp.getGhiChu());
            pre.setInt(13, sp.getTrangThai());
            pre.setString(14, sp.getAnh());
            pre.setInt(15, view.SanPham.idCTSP);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Sửa Thành công ";
    }

    @Override
    public List<CTSP> Serch(String sp) {
        List<CTSP> listCTSPView = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " select ct.Id_SPCT, ct.MaCTSP,SanPham.TenSP,lsp.TenLoai,dsp.TenDSP, "
                    + " ct.HSD,nsx.QuocGia,ct.SoLuongTon,ct.DonGia,KhoiLuong.TenKhoiLuong, "
                    + " ct.DVT,ct.MaQR,ct.GhiChu,ct.TrangThai,ct.Anh "
                    + " from ChiTietSanPham as ct join SanPham  "
                    + " on ct.Id_SP = SanPham.Id_SP "
                    + " join LoaiSanPham as lsp on ct.Id_LSP = lsp.Id_LSP "
                    + " join DongSanPham as dsp on ct.Id_DSP = dsp.Id_DongSanPham "
                    + " join NhaSanXuat as nsx on ct.Id_NSX = nsx.Id_NSX "
                    + " join KhoiLuong on ct.Id_KhoiLuong = KhoiLuong.Id_KhoiLuong "
                    + "  Where SanPham.TenSP LIKE CONCAT (N'%' , ? , '%' )";
            PreparedStatement pre = con.prepareCall(sql);
            pre.setString(1, sp);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CTSP ctsp = new CTSP();
                ctsp.setId(rs.getInt("Id_SPCT"));
                ctsp.setMaSPCT(rs.getString("MaCTSP"));
                ctsp.setTenSanPham(rs.getString("TenSP"));
                ctsp.setTenLoaiSP(rs.getString("TenLoai"));
                ctsp.setTenDongSanPham(rs.getString("TenDSP"));
                ctsp.sethSD(rs.getDate("HSD"));
                ctsp.setXuatSu(rs.getString("QuocGia"));
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
    public List<CTSP> getSanPhamInHoaDon(int index) {
        List<CTSP> listSPInHoaDon = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " select  SanPham.TenSP,HoaDonChiTiet.SoLuong,HoaDonChiTiet.DonGia from HoaDon "
                    + " join HoaDonChiTiet on HoaDon.Id_HD = HoaDonChiTiet.Id_HD "
                    + " join ChiTietSanPham on HoaDonChiTiet.Id_CTSP = ChiTietSanPham.Id_SPCT "
                    + " join SanPham on ChiTietSanPham.Id_SP = SanPham.Id_SP "
                    + " where  HoaDonChiTiet.Id_HD = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, index);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                CTSP ct = new CTSP();
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
}
