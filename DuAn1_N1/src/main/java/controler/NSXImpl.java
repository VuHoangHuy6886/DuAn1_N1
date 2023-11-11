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
import model.NSX;
import repository.CrudfullTable;

/**
 *
 * @author vuhoa
 */
public class NSXImpl implements CrudfullTable<NSX> {

    @Override
    public List<NSX> listAll() {
        List<NSX> listNSX = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "Select * from NhaSanXuat";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                NSX nsx = new NSX();
                nsx.setId(rs.getInt("Id_NSX"));
                nsx.setMa(rs.getString("MaNSX"));
                nsx.setTen(rs.getString("TenNSX"));
                nsx.setQuocGia(rs.getString("QuocGia"));
                listNSX.add(nsx);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNSX;
    }

    @Override
    public String them(NSX t) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "  INSERT INTO NhaSanXuat(MaNSX,TenNSX,QuocGia) values (?,?,?) ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, t.getMa());
            pre.setString(2, t.getTen());
            pre.setString(3, t.getQuocGia()); 
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thanh cong";
    }

    @Override
    public String Sua(NSX t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String xoa(NSX t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NSX> serch(NSX t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
