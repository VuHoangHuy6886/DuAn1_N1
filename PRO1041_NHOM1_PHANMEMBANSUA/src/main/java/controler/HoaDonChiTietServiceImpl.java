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
import model.HoaDonChiTiet;
import modelView.HDCT;

/**
 *
 * @author vuhoa
 */
public class HoaDonChiTietServiceImpl {

    public String deleteAllByIdHD(int idHd) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " delete HoaDonChiTiet where Id_HD = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, idHd);
            pre.executeUpdate();
            pre.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thành công";
    }

    public String them(HoaDonChiTiet hdct) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " Insert into HoaDonChiTiet (Id_HD,Id_CTSP,SoLuong,DonGia)  values (?,?,?,?) ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, hdct.getiDHD());
            pre.setInt(2, hdct.getiDCTSP());
            pre.setInt(3, hdct.getSoLuong());
            pre.setFloat(4, hdct.getDonGia());
            pre.executeUpdate();
            pre.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thành công";
    }

//    public String updateTT(HoaDonChiTiet hd) {
//        try (Connection con = Database.JdbcUtil.getConnection()) {
//            String sql = " Insert into HoaDonChiTiet (Id_HD,Id_CTSP,SoLuong,DonGia)  values (?,?,?,?) ";
//            PreparedStatement pre = con.prepareStatement(sql);
//            pre.setInt(1, hd.getiDHD());
//            pre.setInt(2, hd.getiDCTSP());
//            pre.setInt(3, hd.getSoLuong());
//            pre.setFloat(4, hd.getDonGia());
//            pre.executeUpdate();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return "";
//    }
    public List<HoaDonChiTiet> listAll(int id) {
        List<HoaDonChiTiet> listHoaDonCT = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "select Id_HD,Id_CTSP,SoLuong,DonGia from HoaDonChiTiet where id_HD =?";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                HoaDonChiTiet HDCT = new HoaDonChiTiet();
                HDCT.setiDHD(rs.getInt("Id_HD"));
                HDCT.setiDCTSP(rs.getInt("Id_CTSP"));
                HDCT.setSoLuong(rs.getInt("SoLuong"));
                HDCT.setDonGia(rs.getFloat("DonGia"));
                listHoaDonCT.add(HDCT);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonCT;
    }

    public List<HDCT> listhdView(int id) {
        List<HDCT> listHoaDonCTView = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "SELECT SanPham.TenSP ,hdct.SoLuong,hdct.DonGia FROM HoaDonChiTiet as hdct "
                    + " join ChiTietSanPham as ctsp on hdct.Id_CTSP = ctsp.Id_SPCT "
                    + " join SanPham on SanPham.Id_SP = ctsp.Id_SP "
                    + " where Id_HD = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setInt(1, id);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                HDCT hd = new HDCT();
                hd.setTenSanPham(rs.getString("TenSP"));
                hd.setSoLuongSanPham(rs.getInt("SoLuong"));
                hd.setDonGia(rs.getFloat("DonGia"));
                listHoaDonCTView.add(hd);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDonCTView;
    }
}
