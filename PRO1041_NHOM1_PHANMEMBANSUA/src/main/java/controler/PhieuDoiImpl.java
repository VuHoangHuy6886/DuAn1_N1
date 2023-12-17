/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.PhieuDoi;
import repository.PhieuDoiService;

/**
 *
 * @author phtua
 */
public class PhieuDoiImpl implements PhieuDoiService {

    private Connection conn;

    public PhieuDoiImpl() {
        try {
            conn = Database.JdbcUtil.getConnection();
        } catch (Exception e) {
        }
    }

    @Override
    public List<PhieuDoi> getAll() {
        ArrayList<PhieuDoi> list = new ArrayList<>();
        try {
            String q = "select Ma_PD, IDkhachHang,Id_NV, IDSanPham, IDHoaDon, SoLuong, NgayDoi, LyDoDoi ,IDSPMoi,tienThua,tienThieu from PhieuDoi";
            PreparedStatement prm = conn.prepareStatement(q);
            prm.execute();
            ResultSet rs = prm.getResultSet();
            while (rs.next()) {
                String MaPhieuDoi = rs.getString("Ma_PD");
                int IDkhachHang = rs.getInt("IDkhachHang");
                int IdNhanVien = rs.getInt("Id_NV");
                int IDSanPham = rs.getInt("IDSanPham");
                int IDHoaDon = rs.getInt("IDHoaDon");
                int SoLuong = rs.getInt("SoLuong");
                String NgayDoi = rs.getString("NgayDoi");
                String LyDoDoi = rs.getString("LyDoDoi");
                int IDSanPhamMoi = rs.getInt("IDSPMoi");
                float tienThua = rs.getFloat("tienThua");
                float TienThieu = rs.getFloat("tienThieu");
                PhieuDoi pt = new PhieuDoi(MaPhieuDoi, IDkhachHang, IdNhanVien, IDSanPham, IDHoaDon, SoLuong, NgayDoi, LyDoDoi, IDSanPhamMoi, tienThua, TienThieu);
                list.add(pt);
            }
        } catch (Exception e) {
            // Xử lý ngoại lệ
        }
        return list;
    }

    @Override
    public boolean them(PhieuDoi phieutra) {
        try {
            String sql = "INSERT INTO PhieuDoi (Ma_PD, IDkhachHang, IDSanPham, IDHoaDon, "
                    + "SoLuong, NgayDoi, LyDoDoi, IDSPMoi, tienThua, tienThieu) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, phieutra.getMaPD());
            ps.setInt(2, phieutra.getIdKhachHang());
            ps.setInt(3, phieutra.getIdSanPham());
            ps.setInt(4, phieutra.getIdHoaDon());
            ps.setInt(5, phieutra.getSoLuong());
            ps.setString(6, phieutra.getNgayDoi());
            ps.setString(7, phieutra.getLyDoDoi());
            ps.setInt(8, phieutra.getIdSanPhamMoi());
            ps.setFloat(9, phieutra.getTienThua());
            ps.setFloat(10, phieutra.getTienThieu());
            int rowAffected = ps.executeUpdate();
            return rowAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    @Override
    public boolean xoaSanPham(int idCTSP, int SoLuong) {
        Integer row = null;
        try {
            String xoaSP = "{CALL DoiSanPhamQuaHan(?, ?)}";
            PreparedStatement ps = conn.prepareStatement(xoaSP);
            ps.setInt(1, idCTSP);
            ps.setInt(2, SoLuong);
            ps.execute();
            row = ps.getUpdateCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return row > 0;
    }

    @Override
    public Map<Integer, Integer> countPhieuDoiByNhanVien(List<PhieuDoi> phieuDoiList) {
         Map<Integer, Integer> countMap = new HashMap<>();
        for (PhieuDoi phieuDoi : phieuDoiList) {
            int idNhanVien = phieuDoi.getIdNhanVien();
            countMap.put(idNhanVien, countMap.getOrDefault(idNhanVien, 0) + 1);
        }
        return countMap;
    }

    @Override
    public Map<Integer, Integer> countPhieuDoiBySanPham(List<PhieuDoi> phieuDoiList) {
         Map<Integer, Integer> countMap = new HashMap<>();
        for (PhieuDoi phieuDoi : phieuDoiList) {
            int idSanPham = phieuDoi.getIdSanPham();
            countMap.put(idSanPham, countMap.getOrDefault(idSanPham, 0) + 1);
        }
        return countMap;
    }
}
