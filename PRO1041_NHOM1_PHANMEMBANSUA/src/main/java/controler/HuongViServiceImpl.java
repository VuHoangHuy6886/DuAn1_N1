package controler;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.HuongVi;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vuhoa
 */
public class HuongViServiceImpl {

    public List<HuongVi> listHuongViSua() {
        List<HuongVi> listHuongVi = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "Select * from HuongVi";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                HuongVi hv = new HuongVi();
                hv.setId_HuongVi(rs.getInt("Id_HuongVi"));
                hv.setMa_HuongVi(rs.getString("Ma_HuongVi"));
                hv.setTen_HuongVi(rs.getString("Ten_HuongVi"));
                hv.setTrangThai_HuongVi(rs.getInt("TrangThai"));
                listHuongVi.add(hv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHuongVi;
    }
}
