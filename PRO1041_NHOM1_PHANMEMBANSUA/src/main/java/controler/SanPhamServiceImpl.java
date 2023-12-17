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
import model.SanPham;
import modelView.SanPhamViewModel;
import repository.SanPhamService;

/**
 *
 * @author vuhoa
 */
public class SanPhamServiceImpl implements SanPhamService {

    @Override
    public List<SanPhamViewModel> listSanPham(String search) {
        List<SanPhamViewModel> listSP = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " select SanPham.Id_SP,SanPham.MaSP,SanPham.TenSP,NgayTao,th.Ten_ThuongHieu,XuatXu.Ten_XuatXu,SanPham.TrangThai from SanPham  "
                    + " join ThuongHieu as th on SanPham.ThuongHieu = th.Id_ThuongHieu "
                    + " join XuatXu on XuatXu.Id_XuatXu = SanPham.XuatXu "
                    + " Where TenSP like  ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, "%" + search + "%");
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                SanPhamViewModel sp = new SanPhamViewModel();
                sp.setIdSanPhamView(rs.getInt("Id_SP"));
                sp.setMaSanPhamView(rs.getString("MaSP"));
                sp.setTenSanPhamView(rs.getString("TenSP"));
                sp.setTenThuongHieuView(rs.getString("Ten_ThuongHieu"));
                sp.setTenXuatXuView(rs.getString("Ten_XuatXu"));
                sp.setNgayTaoView(rs.getDate("NgayTao"));
                sp.setTrangThai(rs.getInt("TrangThai"));
                listSP.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSP;

    }

    @Override
    public String them(SanPham sp) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " INSERT INTO SanPham (MaSP,TenSP,ThuongHieu,XuatXu,NgayTao,TrangThai) VALUES (?,?,?,?,?,?) ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, sp.getMa());
            pre.setString(2, sp.getTen());
            pre.setInt(3, sp.getId_ThuongHieu());
            pre.setInt(4, sp.getId_XuatXu());
            pre.setDate(5, sp.getNgayTao());
            pre.setInt(6, sp.getTrangThai());
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Thêm thành công";
    }

    @Override
    public String sua(SanPham sp) {
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " update SanPham set MaSP = ? , TenSP = ? , NgayTao = ?, ThuongHieu = ? , XuatXu = ? , TrangThai = ? "
                    + " where Id_SP = ? ";
            PreparedStatement pre = con.prepareStatement(sql);
            pre.setString(1, sp.getMa());
            pre.setString(2, sp.getTen());
            pre.setDate(3, sp.getNgayTao());
            pre.setInt(4, sp.getId_ThuongHieu());
            pre.setInt(5, sp.getId_XuatXu());
            pre.setInt(6, sp.getTrangThai());
            pre.setInt(7, view.QuanLySanPhamView.idSanPham);
            pre.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thanh cong";
    }

    @Override
    public List<SanPhamViewModel> listSanPhamHienThi() {
        List<SanPhamViewModel> listSanPhamView = new ArrayList<>();
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " select SanPham.Id_SP,SanPham.MaSP,SanPham.TenSP,NgayTao,th.Ten_ThuongHieu,XuatXu.Ten_XuatXu,SanPham.TrangThai from SanPham  "
                    + " join ThuongHieu as th on SanPham.ThuongHieu = th.Id_ThuongHieu "
                    + " join XuatXu on XuatXu.Id_XuatXu = SanPham.XuatXu ";
            PreparedStatement pre = con.prepareStatement(sql);
            ResultSet rs = pre.executeQuery();
            while (rs.next()) {
                SanPhamViewModel sp = new SanPhamViewModel();
                sp.setIdSanPhamView(rs.getInt("Id_SP"));
                sp.setMaSanPhamView(rs.getString("MaSP"));
                sp.setTenSanPhamView(rs.getString("TenSP"));
                sp.setTenThuongHieuView(rs.getString("Ten_ThuongHieu"));
                sp.setTenXuatXuView(rs.getString("Ten_XuatXu"));
                sp.setNgayTaoView(rs.getDate("NgayTao"));
                sp.setTrangThai(rs.getInt("TrangThai"));
                listSanPhamView.add(sp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listSanPhamView;
    }
}
