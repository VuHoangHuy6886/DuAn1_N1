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
import model.DongSanPham;
import repository.CrudfullTable;
import repository.DongSanPhamService;

/**
 *
 * @author vuhoa
 */
public class DongSanPhamServiceImpl implements DongSanPhamService, CrudfullTable<DongSanPham> {

    @Override
    public List<DongSanPham> listDongSanPham() {
        List<DongSanPham> listDongSanPham = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "Select * from DongSanPham";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                DongSanPham dsp = new DongSanPham();
                dsp.setId_DSP(rs.getInt("Id_DongSanPham"));
                dsp.setMaDSP(rs.getString("MaDSP"));
                dsp.setTenDSP(rs.getString("TenDSP"));
                listDongSanPham.add(dsp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listDongSanPham;
    }

    @Override
    public List<DongSanPham> listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String them(DongSanPham t) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " INSERT INTO DongSanPham(MaDSP,TenDSP)values (?,?) ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, t.getMaDSP());
            pre.setString(2, t.getTenDSP());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thanh cong";
    }

    @Override
    public String Sua(DongSanPham t) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " UPDATE DongSanPham SET MaDSP = ? , TenDSP = ? WHERE Id_DongSanPham = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, t.getMaDSP());
            pre.setString(2, t.getTenDSP());
            pre.setInt(3, view.viewDongSanPham.idDSP);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thanh cong";
    }

    @Override
    public String xoa(DongSanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<DongSanPham> serch(DongSanPham t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
