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
                ctsp.setTrangThai(rs.getString("TrangThai"));
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
            String sql = "insert into ChiTietSanPham  "
                    + " (MaCTSP, Id_SP, Id_LSP, Id_DSP,HSD,Id_NSX,SoLuongTon,DonGia,Id_KhoiLuong,DVT,MaQR,GhiChu,TrangThai,Anh) "
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
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
            pre.setString(13, sp.getTrangThai());
            pre.setString(14, sp.getAnh());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thành Công";
    }

    @Override
    public String sua(ChiTietSanPham sp) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "UPDATE ChiTietSanPham SET MaCTSP = ?, Id_SP = ?, Id_NSX = ?, Id_LSP = ? ,"
                    + " Id_KhoiLuong = ? , Id_DSP = ? , HSD = ? , SoLuongTon = ? ,DVT = ? , DonGia = ? , GhiChu = ? ,TrangThai = ? , Anh = ? "
                    + " WHERE Id_SPCT = ? ;";
            try (PreparedStatement pre = con.prepareStatement(sql)) {
                pre.setString(1, sp.getMaCTSP());
                pre.setInt(2, sp.getIdSanPham());
                pre.setInt(3, sp.getIdNSX());
                pre.setInt(4, sp.getIdLoaiSp());
                pre.setInt(5, sp.getIdKhoiLuong());
                pre.setInt(6, sp.getIdDongSanPham());
                // LLXO 
                pre.setDate(7, sp.gethSD());

                pre.setInt(8, sp.getSoLuongTon());

                pre.setString(9, sp.getDonViTinh());

                pre.setFloat(10, sp.getDonGia());

                pre.setString(11, sp.getGhiChu());
                pre.setString(12, sp.getTrangThai());
                pre.setString(13, sp.getAnh());
                pre.setInt(14, view.SanPham.idCTSP);
                int rowsUpdated = pre.executeUpdate();
                if (rowsUpdated > 0) {
                    return "Sửa thành công";
                } else {
                    return "Không có bản ghi nào được sửa đổi";
                }
            }
        } catch (Exception e) {
            e.printStackTrace(); // hoặc log thông báo lỗi
            return "Có lỗi xảy ra khi sửa đổi";
        }
    }

}
