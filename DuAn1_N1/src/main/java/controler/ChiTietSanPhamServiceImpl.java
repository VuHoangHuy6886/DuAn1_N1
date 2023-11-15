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
import repository.ChiTietSanPhamService;
import repository.CrudfullTable;
import repository.SanPhamService;

/**
 *
 * @author vuhoa
 */
public class ChiTietSanPhamServiceImpl implements ChiTietSanPhamService {

    @Override
    public List<ChiTietSanPham> listChiTietSanPham() {
        List<ChiTietSanPham> listCTSP = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " select ct.MaCTSP,SanPham.TenSP,lsp.TenLoai,dsp.TenDSP, "
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
                ChiTietSanPham ctsp = new ChiTietSanPham();
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
                listCTSP.add(ctsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTSP;
    }
}
