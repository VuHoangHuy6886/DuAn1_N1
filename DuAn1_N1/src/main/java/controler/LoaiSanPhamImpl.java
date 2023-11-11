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
import model.LoaiSanPham;
import model.NSX;
import repository.CrudfullTable;

/**
 *
 * @author vuhoa
 */
public class LoaiSanPhamImpl implements CrudfullTable<LoaiSanPham> {

    @Override
    public List<LoaiSanPham> listAll() {
        List<LoaiSanPham> listSP = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " Select * from LoaiSanPham ";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                LoaiSanPham sp = new LoaiSanPham();
                sp.setId(rs.getInt("Id_LSP"));
                sp.setMa(rs.getString("MaLoai"));
                sp.setTen(rs.getString("TenLoai"));
                listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    @Override
    public String them(LoaiSanPham t) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "  INSERT INTO LoaiSanPham(MaLoai,TenLoai) values (?,?) ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, t.getMa());
            pre.setString(2, t.getTen());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thanh cong";
    }

    @Override
    public String Sua(LoaiSanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String xoa(LoaiSanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<LoaiSanPham> serch(LoaiSanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
