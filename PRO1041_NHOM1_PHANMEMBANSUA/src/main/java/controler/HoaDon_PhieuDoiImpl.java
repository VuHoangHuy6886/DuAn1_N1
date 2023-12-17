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
import model.HoaDon_PhieuDoi;

/**
 *
 * @author phtua
 */
public class HoaDon_PhieuDoiImpl {
    public List<HoaDon_PhieuDoi> listAll() {
        List<HoaDon_PhieuDoi> listHoaDon_pd = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " select Id_HD , MaHD ,NgayTao ,id_KH, TongTienHang, ID_NV from HoaDon ";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                HoaDon_PhieuDoi pd = new HoaDon_PhieuDoi();
                pd.setIdHD(rs.getInt("Id_HD"));
                pd.setMaHD(rs.getString("MaHD"));
                pd.setNgayTao(rs.getString("NgayTao"));
                pd.setIdKhachHang(rs.getInt("id_KH"));
                pd.setTongTien(rs.getFloat("TongTienHang"));
                pd.setIdNhanVien(rs.getInt("ID_NV"));
                listHoaDon_pd.add(pd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon_pd;
    }
}
