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
import model.HoaDon;
import repository.CrudfullTable;

public class HoaDonImpl implements CrudfullTable<HoaDon> {

    @Override
    public List<HoaDon> listAll() {
        List<HoaDon> listAllHoaDon = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "SELECT * FROM HoaDon";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setId(rs.getInt("Id_HD"));
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayTao(rs.getTimestamp("NgayTao").toLocalDateTime().toLocalDate());
                hd.setNgaySua(rs.getTimestamp("NgaySua").toLocalDateTime().toLocalDate());
                hd.setIdKH(rs.getInt("Id_KH"));
                hd.setTongTienHang(rs.getFloat("TongTienHang"));
                hd.setIdNhanVien(rs.getInt("ID_NV"));

                listAllHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAllHoaDon;
    }

    @Override
    public String them(HoaDon hd) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "  INSERT INTO [dbo].[HoaDon](MaHD,NgayTao,NgaySua,TongTienHang) values (?,?,?,?) ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, hd.getMaHD());
            ps.setDate(2, java.sql.Date.valueOf(hd.getNgayTao()));
            ps.setDate(3, java.sql.Date.valueOf(hd.getNgaySua()));
            ps.setFloat(4, hd.getTongTienHang());

            ps.executeUpdate();
        } catch (Exception e) {
            return "Loi them du lieu";
        }
        return "Thanh cong";
    }

    @Override
    public String Sua(HoaDon t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String xoa(HoaDon hd) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "DELETE FROM HoaDon WHERE Id_HD = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, hd.getId());

            int hdxoa = ps.executeUpdate();
            if (hdxoa > 0) {
                return "Xóa hóa đơn thành công";
            } else {
                return "Hóa đơn không tồn tại";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Lỗi khi xóa hóa đơn";
        }
    }

    @Override
    public List<HoaDon> serch(HoaDon t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
