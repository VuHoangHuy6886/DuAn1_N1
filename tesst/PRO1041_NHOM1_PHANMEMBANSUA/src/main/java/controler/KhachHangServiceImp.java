/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import Database.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.KhachHang;

/**
 *
 * @author admin
 */
public class KhachHangServiceImp implements repository.KhachHangService {

    @Override
    public List<KhachHang> listKhachHang() {
        List<KhachHang> listKhachhang = new ArrayList<>();
        try (Connection conn = Database.JdbcUtil.getConnection()) {
            String sql = "SELECT * FROM KhachHang";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                KhachHang kh = new KhachHang();
                kh.setId(rs.getInt("Id_KH"));
                kh.setMa(rs.getString("MaKH"));
                kh.setTen(rs.getString("TenKH"));
                kh.setGioiTinh(rs.getString("GioiTinh"));
                kh.setNgaySinh(rs.getDate("NgaySinh"));
                kh.setSdt(rs.getString("SDT"));
                kh.setDiaChi(rs.getString("DiaChi"));
                listKhachhang.add(kh);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachhang;
    }

    @Override
    public String themKhachHang(KhachHang kh) {
        try (Connection conn = JdbcUtil.getConnection()) {
            String sql = "INSERT INTO KhachHang (MaKH,TenKH,GioiTinh,NgaySinh,SDT,DiaChi) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getGioiTinh());
            ps.setDate(4, kh.getNgaySinh());
            ps.setString(5, kh.getSdt());
            ps.setString(6, kh.getDiaChi());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thanh cong";
    }

    @Override
    public String sua(KhachHang kh) {
        try (Connection conn = Database.JdbcUtil.getConnection()) {
            String sql = " UPDATE KhachHang SET MaKH = ? , TenKH = ? , GioiTinh = ? ,NgaySinh = ? ,SDT = ?,DiaChi = ? WHERE Id_SP = ? ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, kh.getMa());
            ps.setString(2, kh.getTen());
            ps.setString(3, kh.getGioiTinh());
            ps.setDate(4, kh.getNgaySinh());
            ps.setString(5, kh.getSdt());
            ps.setString(6, kh.getDiaChi());
            ps.executeUpdate();
        } catch (Exception e) {
            return "loi ne hihi";
        }
        return "thanh cong";
    }

    @Override
    public List<KhachHang> Serch(String kh) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String xoaKhachHang(KhachHang kh) {
        try (Connection conn = JdbcUtil.getConnection()) {
            String sql = " Delete   from KhachHang WHERE Id_KH = ?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, view.KhachHangv.id);
            System.out.println(kh.getId());
//            int khxoa = ps.executeUpdate();
//            if (khxoa > 0) {
//                return "xoa thanh cong";
//            } else {
//                return "xoa that bai ";
//            }
            ps.executeUpdate();
        } catch (Exception e) {
            return "loi ne hihi";
        }
        return "Xoa thanh cong";
    }
}
