/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietSanPham;
import repository.CrudfullTable;

/**
 *
 * @author vuhoa
 */
public class ChiTietSanPhamServiceImpl implements CrudfullTable<ChiTietSanPham> {

    @Override
    public List<ChiTietSanPham> listAll() {
        List<ChiTietSanPham> listCTSP = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "select ct.Id_SPCT, sp.MaSP , sp.TenSP ,lsp.TenLoai,nsx.TenNSX,nsx.QuocGia,Anh.img,ct.HSD,ct.SoLuongTon , ct.GiaBan ,ct.GhiChu,ct.TrangThai "
                    + " from ChiTietSanPham as ct "
                    + " join SanPham as sp on ct.Id_SP = sp.Id_SP "
                    + " join LoaiSanPham as lsp  on lsp.Id_LSP = ct.Id_LSP "
                    + " join NhaSanXuat as nsx on nsx.Id_NSX = ct.Id_NSX "
                    + " join Anh  on Anh.id_Anh = ct.Id_Anh";

            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ChiTietSanPham ct = new ChiTietSanPham();
                ct.setId(rs.getInt("Id_SPCT"));
                ct.setMa(rs.getString("MaSP"));
                ct.setTen(rs.getString("TenSP"));
                ct.setLoaiSP(rs.getString("TenLoai"));
                ct.setTenSanXuat(rs.getString("TenNSX"));
                ct.setQuocGia(rs.getString("QuocGia"));
                ct.setAnh(rs.getString("img"));
                ct.sethSD(rs.getDate("HSD"));
                ct.setSoLuongTon(rs.getInt("SoLuongTon"));
                ct.setGiaBan(rs.getFloat("GiaBan"));
                ct.setGhiChu(rs.getString("GhiChu"));
                ct.setTrangThai(rs.getString("TrangThai"));
                listCTSP.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listCTSP;
    }

    @Override
    public String them(ChiTietSanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String Sua(ChiTietSanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String xoa(ChiTietSanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietSanPham> serch(ChiTietSanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
