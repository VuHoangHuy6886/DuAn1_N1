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
import model.SanPham;
import repository.CrudfullTable;
import view.ViewSP;

/**
 *
 * @author vuhoa
 */
public class SanPhamServiceImpl implements CrudfullTable<SanPham> {

    @Override
    public List<SanPham> listAll() {
        List<SanPham> listSP = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "Select * from SanPham";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                SanPham sp = new SanPham();
                sp.setId(rs.getInt("Id_SP"));
                sp.setMa(rs.getString("MaSP"));
                sp.setTen(rs.getString("TenSP"));
                sp.setNgayTao(rs.getDate("NgayTao"));
                listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;
    }

    @Override
    public String them(SanPham t) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " insert into SanPham(MaSP, TenSP, NgayTao) values (?,?,?)";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, t.getMa());
            pre.setString(2, t.getTen());
            pre.setDate(3, t.getNgayTao());
            pre.executeUpdate();
//            while (rs.next()) {
//                SanPham sp = new SanPham();
//                sp.setId(rs.getInt("Id_SP"));
//                sp.setMa(rs.getString("MaSP"));
//                sp.setTen(rs.getString("TenSP"));
//                sp.setGiaVon(rs.getFloat("GiaVon"));
//                sp.setNgayTao(rs.getDate("NgayTao"));
//                sp.setNgaySua(rs.getDate("NgaySua"));
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thanh cong";
    }

    @Override
    public String Sua(SanPham t) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " UPDATE SanPham set MaSP = ? , TenSP = ? , NgayTao = ? WHERE Id_SP = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, t.getMa());
            pre.setString(2, t.getTen());
            pre.setDate(3, t.getNgayTao());
            pre.setInt(4, view.ViewSP.id);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thanh cong";
    }

    @Override
    public String xoa(SanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<SanPham> serch(SanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
