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
import model.NhaSanXuat;
import repository.NhaSanXuatService;

/**
 *
 * @author vuhoa
 */
public class NhaSanXuatServiceImpl implements NhaSanXuatService {

    @Override
    public List<NhaSanXuat> listsService() {
        List<NhaSanXuat> lists = new ArrayList<>();
        try (Connection connect = Database.JdbcUtil.getConnection()) {
            String sql = "select * from NhaSanXuat";
            PreparedStatement pre = connect.prepareCall(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                NhaSanXuat nSX = new NhaSanXuat();
                nSX.setIdNSX(rs.getInt("Id_NhaSanXuat"));
                nSX.setMaNSX(rs.getString("Ma_NhaSanXuat"));
                nSX.setTenNSX(rs.getString("Ten_NhaSanXuat"));
                nSX.setQuocGia("QuocGia");
                lists.add(nSX);
                System.out.println("2");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lists;
    }

    @Override
    public String them(NhaSanXuat nsx) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String sua(NhaSanXuat nsx) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String xoa(NhaSanXuat nsx) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<NhaSanXuat> tim(NhaSanXuat nsx) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
