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
import model.DotGiamGiaFinal;
import repository.DotGiamGiaServiceFinal;

/**
 *
 * @author HungLOL
 */
public class DotGiamGiaImplFinal implements DotGiamGiaServiceFinal {

    @Override
    public List<DotGiamGiaFinal> listDGG() {
        List<DotGiamGiaFinal> listDotGiamGia = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "SELECT Id_DGG, MaDGG, NgayBatDau, NgayKetThuc, ThongTin, DieuKienApDung, TrangThai, Sale FROM DotGiamGia";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                int idDGG = rs.getInt("Id_DGG");
                String maDGG = rs.getString("MaDGG");
                String ngayBatDau = rs.getString("NgayBatDau");
                String ngayKetThuc = rs.getString("NgayKetThuc");
                String thongTin = rs.getString("ThongTin");
                String dieuKien = rs.getString("DieuKienApDung");
                int trangThai = rs.getInt("TrangThai");
                int sale = rs.getInt("Sale");
                DotGiamGiaFinal dgg = new DotGiamGiaFinal(idDGG, maDGG, ngayBatDau, ngayKetThuc, thongTin, dieuKien, trangThai, sale);
                listDotGiamGia.add(dgg);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDotGiamGia;
    }

    @Override
    public void insert(DotGiamGiaFinal dgg) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "INSERT INTO DotGiamGia(MaDGG, NgayBatDau, NgayKetThuc, ThongTin, DieuKienApDung, TrangThai, Sale)" + " values (?,?,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dgg.getMaDGG());
            ps.setString(2, dgg.getNgayBatDau());
            ps.setString(3, dgg.getNgayKetThuc());
            ps.setString(4, dgg.getThongTin());
            ps.setString(5, dgg.getDieuKienApDung());
            ps.setInt(6, dgg.getTrangThai());
            ps.setInt(7, dgg.getSale());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(String id) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "DELETE FROM DotGiamGia WHERE MaDGG = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, id);
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String change(DotGiamGiaFinal dgg) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "UPDATE DotGiamGia SET "
                    + " NgayBatDau = ?,"
                    + " NgayKetThuc = ?, "
                    + " ThongTin = ?, "
                    + " DieuKienApDung = ?, "
                    + " Sale = ?, "
                    + " TrangThai = ? "
                    + " WHERE MaDGG = ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, dgg.getNgayBatDau());
            ps.setString(2, dgg.getNgayKetThuc());
            ps.setString(3, dgg.getThongTin());
            ps.setString(4, dgg.getDieuKienApDung());
            ps.setInt(5, dgg.getSale());
            ps.setInt(6, dgg.getTrangThai());
            ps.setString(7, dgg.getMaDGG());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
            return "Lỗi khi sửa dữ liệu";
        }
        return "Sửa thành công";
    }

    

    
}
