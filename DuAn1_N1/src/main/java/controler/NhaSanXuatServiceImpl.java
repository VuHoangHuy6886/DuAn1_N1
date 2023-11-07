/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.Connection;
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
    public List<NhaSanXuat> NSX() {
        List<NhaSanXuat> lists = new ArrayList<>();
        try (Connection connect = Database.JdbcUtil.getConnection()) {
            String sql = "select * from NhaSanXuat";
        } catch (Exception e) {
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
