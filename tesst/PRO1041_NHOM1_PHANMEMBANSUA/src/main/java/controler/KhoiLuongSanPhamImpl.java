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
import model.KhoiLuongSanPham;
import repository.KhoiLuongService;

/**
 *
 * @author vuhoa
 */
public class KhoiLuongSanPhamImpl implements KhoiLuongService {

    @Override
    public List<KhoiLuongSanPham> listKhoiLuong() {
        List<KhoiLuongSanPham> listKhoiLuongSanPham = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "Select * from KhoiLuong";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                KhoiLuongSanPham kl = new KhoiLuongSanPham();
                kl.setIdKL(rs.getInt("Id_KhoiLuong"));
                kl.setMaKL(rs.getString("MaKhoiLuong"));
                kl.setTenKL(rs.getString("TenKhoiLuong"));
                listKhoiLuongSanPham.add(kl);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhoiLuongSanPham;
    }

}
