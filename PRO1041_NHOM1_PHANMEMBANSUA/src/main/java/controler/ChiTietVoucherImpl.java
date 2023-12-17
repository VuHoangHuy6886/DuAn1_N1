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
import model.ChiTietVoucher;
import model.Voucher;
import repository.ChiTietVoucherService;

/**
 *
 * @author Thang
 */
public class ChiTietVoucherImpl implements ChiTietVoucherService {

    @Override
    public List<ChiTietVoucher> listAll() {
        List<ChiTietVoucher> listCTVC = new ArrayList<>();

        try {
            Connection conn = Database.JdbcUtil.getConnection();
            String p = "select * from ChiTietVoucher";
            PreparedStatement pre = conn.prepareStatement(p);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                ChiTietVoucher ct = new ChiTietVoucher();
//                ct.setIdHD(rs.getInt("Id_Voucher"));
                ct.setIdHD(rs.getInt("Id_HD"));
                ct.setMaVoucher(rs.getString("MaVoucher"));
                ct.setMaHoadon(rs.getString("MaHD"));
                ct.setPhanTram(rs.getInt("PhanTramGiamGia"));
                ct.setTrangThai(rs.getInt("TrangThai"));
                ct.setNgayBatDau(rs.getDate("NgayBatDau"));
                ct.setNgayKetThuc(rs.getDate("NgayKetThuc"));
                ct.setGhiChu(rs.getString("GhiChu"));
                listCTVC.add(ct);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return listCTVC;
    }

    @Override
    public String them(ChiTietVoucher ct) {
        try {
            Connection conn = Database.JdbcUtil.getConnection();
            String p = "insert into ChiTietVoucher(Id_HD,MaVoucher, PhanTramGiamGia ,TrangThai,MaHD, NgayBatDau, NgayKetThuc,GhiChu) values (?,?,?,?,?,?,?,?) ";
            PreparedStatement pre = conn.prepareStatement(p);
            pre.setInt(1, ct.getIdHD());
            pre.setString(2, ct.getMaVoucher());
            pre.setInt(3, ct.getPhanTram());
            pre.setInt(4, ct.getTrangThai());
            pre.setString(5, ct.getMaHoadon());
            pre.setDate(6, ct.getNgayBatDau());
            pre.setDate(7, ct.getNgayKetThuc());
            pre.setString(8, ct.getGhiChu());
            pre.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return "thanh cong";
    }

    @Override
    public String Sua(ChiTietVoucher ct) {
        try {
            Connection conn = Database.JdbcUtil.getConnection();
            String p = " UPDATE ChiTietVoucher SET Id_HD = ?, MaVoucher = ?, PhanTramGiamGia = ?, TrangThai = ?, MaHD = ?, NgayBatDau = ?, NgayKetThuc = ?, GhiChu = ?  WHERE MaVoucher = ? ";
            PreparedStatement pre = conn.prepareStatement(p);
            pre.setInt(1, ct.getIdHD());
            pre.setString(2, ct.getMaVoucher());
            pre.setInt(3, ct.getPhanTram());
            pre.setInt(4, ct.getTrangThai());
            pre.setString(5, ct.getMaHoadon());
            pre.setDate(6, ct.getNgayBatDau());
            pre.setDate(7, ct.getNgayKetThuc());
            pre.setString(8, ct.getGhiChu());
            pre.setString(9, ct.getMaVoucher());

            pre.executeUpdate(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thanh cong";
    }

    @Override
    public String xoa(ChiTietVoucher ct) {
        try {
            Connection conn = Database.JdbcUtil.getConnection();
            String p = " delete from ChiTietVoucher where MaVoucher = ?  ";
            PreparedStatement pre = conn.prepareStatement(p);
            pre.setInt(1, view.VouCherView.id);
            pre.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Xoa thanh cong";
    }

    @Override
    public List<Voucher> serch(ChiTietVoucher ct) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
