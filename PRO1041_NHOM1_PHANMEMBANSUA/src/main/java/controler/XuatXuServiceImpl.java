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
import model.XuatXu;

/**
 *
 * @author vuhoa
 */
public class XuatXuServiceImpl {

    public List<XuatXu> listXuatXuSanPham() {
        List<XuatXu> listXuatXu = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "Select * from XuatXu ";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                XuatXu xx = new XuatXu();
                xx.setId(rs.getInt("Id_XuatXu"));
                xx.setMa(rs.getString("Ma_XuatXu"));
                xx.setTen(rs.getString("Ten_XuatXu"));
                xx.setTrangThai(rs.getInt("TrangThai"));
                listXuatXu.add(xx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listXuatXu;
    }

    public String them(XuatXu t) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "  INSERT INTO XuatXu(Ma_XuatXu,Ten_XuatXu,TrangThai) values (?,?,?) ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, t.getMa());
            pre.setString(2, t.getTen());
            pre.setInt(3, t.getTrangThai());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Them Thanh cong";
    }

    public String Sua(XuatXu t) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "  UPDATE  XuatXu set Ma_XuatXu = ? ,Ten_XuatXu = ? ,TrangThai = ? where Id_XuatXu = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, t.getMa());
            pre.setString(2, t.getTen());
            pre.setInt(3, t.getTrangThai());
            pre.setInt(4, view.ViewXuatXuSanPham.idXX);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Sua Thanh cong";
    }
}
