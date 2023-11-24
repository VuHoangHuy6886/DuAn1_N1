/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import model.HoaDonChiTiet;

/**
 *
 * @author vuhoa
 */
public class HoaDonChiTietServiceImpl {

    public String them(HoaDonChiTiet hdct) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " Insert into HoaDonChiTiet (Id_HD,Id_CTSP,SoLuong,DonGia)  values (?,?,?,?) ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, hdct.getiDHD());
            pre.setInt(2, hdct.getiDCTSP());
            pre.setInt(3, hdct.getSoLuong());
            pre.setFloat(4, hdct.getDonGia());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thành công";
    }
}
