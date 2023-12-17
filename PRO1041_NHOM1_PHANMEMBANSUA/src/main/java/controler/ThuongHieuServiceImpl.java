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
import model.ThuongHieu;

/**
 *
 * @author vuhoa
 */
public class ThuongHieuServiceImpl {

    public List<ThuongHieu> listThuongHieuSanPham() {
        List<ThuongHieu> listThuongHieu = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "Select * from ThuongHieu";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ThuongHieu th = new ThuongHieu();
                th.setId(rs.getInt("Id_ThuongHieu"));
                th.setMa(rs.getString("Ma_ThuongHieu"));
                th.setTen(rs.getString("Ten_ThuongHieu"));
                th.setTrangThai(rs.getInt("TrangThai"));
                listThuongHieu.add(th);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listThuongHieu;
    }

    public String them(ThuongHieu t) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " INSERT INTO ThuongHieu(Ma_ThuongHieu,Ten_ThuongHieu,TrangThai)values (?,?,?) ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, t.getMa());
            pre.setString(2, t.getTen());
            pre.setInt(3, t.getTrangThai());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thanh cong";
    }

    public String Sua(ThuongHieu t) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " UPDATE ThuongHieu SET Ma_ThuongHieu = ? , Ten_ThuongHieu = ? ,TrangThai = ? WHERE Id_ThuongHieu = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, t.getMa());
            pre.setString(2, t.getTen());
            pre.setInt(3, t.getTrangThai());
            pre.setInt(4, view.ViewThuongHieuSanPham.idTH);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thanh cong";
    }

}
