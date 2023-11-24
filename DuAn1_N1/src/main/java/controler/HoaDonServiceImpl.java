/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.HoaDon;
import modelView.HoaDonView;
import repository.CrudfullTable;

/**
 *
 * @author vuhoa
 */
public class HoaDonServiceImpl {

    public List<HoaDon> listAll() {
        List<HoaDon> listHoaDon = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " select Id_HD,MaHD,NgayTao,TrangThai from HoaDon Where TrangThai = ?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, "Chờ thanh toán");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                HoaDon hd = new HoaDon();
                hd.setIdHD(rs.getInt("Id_HD"));
                hd.setMaHD(rs.getString("MaHD"));
                hd.setNgayTao(rs.getDate("NgayTao"));
                hd.setTrangThai(rs.getString("TrangThai"));
                listHoaDon.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    public String them() {

        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " insert into HoaDon(NgayTao,TrangThai)values (?,?) ";
            PreparedStatement pre = con.prepareStatement(sql);
            String trangThai = "Chờ thanh toán";
            java.sql.Date ngayTao = Date.valueOf("2023-02-05");
            pre.setDate(1, ngayTao);
            pre.setString(2, trangThai);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Done";
    }

    public List<HoaDonView> showDanhSachSanPhamInHoaDon(int index) {
        List<HoaDonView> listSPInHD = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " select  SanPham.TenSP,HoaDonChiTiet.SoLuong,HoaDonChiTiet.DonGia from HoaDon "
                    + " join HoaDonChiTiet on HoaDon.Id_HD = HoaDonChiTiet.Id_HD "
                    + " join ChiTietSanPham on HoaDonChiTiet.Id_CTSP = ChiTietSanPham.Id_SPCT "
                    + " join SanPham on ChiTietSanPham.Id_SP = SanPham.Id_SP "
                    + " where  HoaDonChiTiet.Id_HD = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, index);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                HoaDonView hd = new HoaDonView();
                hd.setTenSanPham(rs.getString("TenSP"));
                hd.setSoLuong(rs.getInt("SoLuong"));
                hd.setDonGia(rs.getFloat("DonGia"));
                listSPInHD.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSPInHD;
    }

}
