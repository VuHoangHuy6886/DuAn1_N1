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
import repository.SanPhamService;

/**
 *
 * @author vuhoa
 */
public class SanPhamServiceImpl implements SanPhamService {

    @Override
    public List<SanPham> listSanPham() {
        List<SanPham> listSP = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "Select * from SanPham ";
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
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thanh cong";
    }

    @Override
    public String sua(SanPham sp) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " UPDATE SanPham SET MaSP = ? , TenSP = ? , NgayTao = ?  WHERE Id_SP = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, sp.getMa());
            pre.setString(2, sp.getTen());
            pre.setDate(3, sp.getNgayTao());
            pre.setInt(4, view.ViewSP.id);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thanh cong";
    }

}
