/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import model.ChiTietHoaDonAndHoaDon;
import repository.CrudfullTable;

/**
 *
 * @author Admin
 */
public class ChiTietHoaDonAndHoaDonImpl implements CrudfullTable<ChiTietHoaDonAndHoaDon> {

    @Override
    public List<ChiTietHoaDonAndHoaDon> listAll() {
        List<ChiTietHoaDonAndHoaDon> listHoaDon = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = "SELECT HoaDon.Id_HD, HoaDon.MaHD, HoaDon.NgayTao,  HoaDon.NgaySua, HoaDon.Id_KH, HoaDon.TongTienHang, HoaDon.ID_NV, HoaDonChiTiet.Id_CTSP, HoaDonChiTiet.SoLuong, HoaDonChiTiet.DonGia, HoaDonChiTiet.TongTien, HoaDonChiTiet.NgayDatHang, HoaDonChiTiet.Id_VouCher FROM HoaDon INNER JOIN HoaDonChiTiet ON HoaDon.Id_HD = HoaDonChiTiet.Id_HD;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ChiTietHoaDonAndHoaDon t = new ChiTietHoaDonAndHoaDon();
                t.setId_HD(rs.getInt("Id_HD"));
                t.setId_CTSP(rs.getInt("Id_CTSP"));
                t.setSoLuong(rs.getInt("SoLuong"));
                t.setDonGia(rs.getFloat("DonGia"));
                java.sql.Date NgayMuaSql = rs.getDate("NgayDatHang");
                LocalDate NgayMua = (NgayMuaSql != null) ? NgayMuaSql.toLocalDate() : null;
                t.setNgayMua(NgayMua);
                t.setId_Voucher(rs.getInt("Id_VouCher"));
                t.setMaHD(rs.getString("MaHD"));
                java.sql.Date ngayTaoSql = rs.getDate("NgayTao");
                LocalDate ngayTao = (ngayTaoSql != null) ? ngayTaoSql.toLocalDate() : null;
                t.setNgayTao(ngayTao);
                java.sql.Date ngaysuaSql = rs.getDate("NgaySua");
                LocalDate NgaySua = (ngaysuaSql != null) ? ngaysuaSql.toLocalDate() : null;
                t.setNgaySua(NgaySua);
                t.setIdKH(rs.getInt("Id_KH"));
                t.setTongTienHang(rs.getFloat("TongTienHang"));
                t.setIdNhanVien(rs.getInt("ID_NV"));

                listHoaDon.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listHoaDon;
    }

    @Override
    public String them(ChiTietHoaDonAndHoaDon t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String Sua(ChiTietHoaDonAndHoaDon t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String xoa(ChiTietHoaDonAndHoaDon t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ChiTietHoaDonAndHoaDon> serch(ChiTietHoaDonAndHoaDon t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
