/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.util.List;
import model.Voucher;
import repository.CrudfullTable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import repository.VoucherService;
import view.viewVoucher;

/**
 *
 * @author Thang
 */
public class VoucherServicerImpl implements VoucherService {

    @Override
    public List<Voucher> listAll() {
        List<Voucher> listVC = new ArrayList<>();

        try {
            Connection conn = Database.JdbcUtil.getConnection();
            String p = "select * from Voucher";
            PreparedStatement pre = conn.prepareStatement(p);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                Voucher vc = new Voucher();
                vc.setId(rs.getInt("Id_Voucher"));
                vc.setMaVoucher(rs.getString("MaVoucher"));
                vc.setPhanTram(rs.getInt("PhanTramGiamGia"));
                vc.setNgayTao(rs.getDate("NgayTao"));
                vc.setNgaySua(rs.getDate("NgaySua"));
                vc.setTrangThai(rs.getInt("TrangThai"));
                vc.setGhiChu(rs.getString("GhiChu"));
                listVC.add(vc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listVC;
    }

    @Override
    public String them(Voucher t) {
        try {
            Connection conn = Database.JdbcUtil.getConnection();
            String q = "insert into Voucher(MaVoucher, PhanTramGiamGia,Ngaytao,NgaySua,TrangThai,GhiChu) values (?,?,?,?,?,?)";
            PreparedStatement pre = conn.prepareStatement(q);
            pre.setString(1, t.getMaVoucher());
            pre.setInt(2, t.getPhanTram());
            pre.setDate(3, t.getNgayTao());
            pre.setDate(4, t.getNgaySua());
            pre.setInt(5, t.getTrangThai());
            pre.setString(6, t.getGhiChu());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thanh cong";
    }

    @Override
    public String Sua(Voucher t) {
        try (Connection conn = Database.JdbcUtil.getConnection()) {
            String p = " UPDATE Voucher SET MaVoucher = ? , PhanTramGiamGia = ? , Ngaytao = ? , NgaySua = ? , TrangThai = ? , GhiChu = ? WHERE Id_Voucher = ? ";
            PreparedStatement pre = conn.prepareStatement(p);
            pre.setString(1, t.getMaVoucher());
            pre.setInt(2, t.getPhanTram());
            pre.setDate(3, t.getNgayTao());
            pre.setDate(4, t.getNgaySua());
            pre.setInt(5, t.getTrangThai());
            pre.setString(6, t.getGhiChu());
            pre.setInt(7, view.viewVoucher.id);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thanh cong";
    }

    @Override
    public String xoa(Voucher t) {
        try {
            Connection conn = Database.JdbcUtil.getConnection();
            String p = " DELETE FROM Voucher WHERE Id_Voucher = ? ";
            PreparedStatement pre = conn.prepareStatement(p);
            pre.setInt(1, view.viewVoucher.id);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "xoa thanh cong";
    }

    @Override
    public List<Voucher> serch(Voucher t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
