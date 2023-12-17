package controler;

import Database.JdbcUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import model.NhanVien;
import model.SanPham;
import repository.LoginService;
import repository.NhanVienService;

public class NhanVienServiceImpl implements NhanVienService, LoginService {

    private Connection conn;

    public NhanVienServiceImpl() {
        try {
            conn = Database.JdbcUtil.getConnection();
        } catch (Exception e) {
        }
    }

    @Override
    public List<NhanVien> listNhanVien() {
        ArrayList<NhanVien> list = new ArrayList<>();
        try {
            String q = "select * from NhanVien";
            PreparedStatement ps = conn.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id_nv = rs.getInt("Id_NV");
                String MaNV = rs.getString("MaNV");
                String TenNV = rs.getString("TenNV");
                int GioiTinh = rs.getInt("GioiTinh");
                Date ngaySinh = rs.getDate("NgaySinh");
                String SDT = rs.getString("SDT");
                String email = rs.getString("email");
                String DiaChi = rs.getString("DiaChi");
                String matKhau = rs.getString("MatKhau");
                int ChucVu = rs.getInt("ChucVu");
                NhanVien nv = new NhanVien(id_nv, MaNV, TenNV, GioiTinh, ngaySinh, SDT, email, DiaChi, matKhau, ChucVu);
                list.add(nv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Boolean them(NhanVien nv) {
        try {
            String sql = "INSERT INTO NhanVien (MANV, TenNV, GioiTinh, NgaySinh, SDT, DiaChi, MatKhau, ChucVu, email)  VALUES (?, ?, ?, ?, ?, ?, ?, ?,?); ";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getTenNV());
            ps.setInt(3, nv.getGioiTinh());
            ps.setDate(4, nv.getNgaySinh());
            ps.setString(5, nv.getSDT());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getMatKhau());
            ps.setInt(8, nv.getChucVu());
            ps.setString(9, nv.getEmail());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;

    }

    @Override
    public String sua(NhanVien nv, int id) {
        System.out.println(nv.getMaNV());
        System.out.println(id);
        try (Connection con = Database.JdbcUtil.getConnection()) {
            String sql = " UPDATE NhanVien SET MaNV = ? , TenNV = ? , GioiTinh = ?, NgaySinh = ?, SDT = ?, DiaChi = ?, MatKhau = ?, ChucVu = ? , email = ? WHERE Id_NV= ? ";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nv.getMaNV());
            ps.setString(2, nv.getTenNV());
            ps.setInt(3, nv.getGioiTinh());
            ps.setDate(4, nv.getNgaySinh());
            ps.setString(5, nv.getSDT());
            ps.setString(6, nv.getDiaChi());
            ps.setString(7, nv.getMatKhau());
            ps.setInt(8, nv.getChucVu());
            ps.setString(9, nv.getEmail());
            ps.setInt(10, id);
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "thanh cong";
    }

//    public Boolean xoa(int id) {
//        Integer row = null;
//        try {
//            String sql = "delete from NhanVien where Id_NV = ?";
//            PreparedStatement ps = this.conn.prepareStatement(sql);
//            ps.setInt(1, id);
//            ps.execute();
//            row = ps.getUpdateCount();
//            System.out.println(row);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return row > 0;
//    }
//    @Override
//    public Boolean checkLogin(String email, String matKhau, int chucVu) {
//        List<NhanVien> listCheck = new ArrayList<>();
//        try (Connection con = Database.JdbcUtil.getConnection()) {
//            String sql = " select email,MatKhau,ChucVu from NhanVien ";
//            PreparedStatement ps = con.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                NhanVien nv = new NhanVien();
//                nv.setEmail(rs.getString("email"));
//                nv.setMatKhau(rs.getString("MatKhau"));
//                nv.setChucVu(rs.getInt("ChucVu"));
//                listCheck.add(nv);
//            }
//            if(email == listCheck.get(chucVu))
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return true;
//    }
}

//public ArrayList<NhanVien> timKiem(int ma) {
//        ArrayList<NhanVien> listNV = new ArrayList<>();
//        try {
//            String sql = "select * from NhanVien where MaNV LIKE '%" + ma + "%'";
//            PreparedStatement ps = conn.prepareStatement(sql);
//            ps.execute();
//            ResultSet rs = ps.getResultSet();
//            while (rs.next()) {
//                int ID = rs.getInt("Id_NV");
//                String maNV = rs.getString("MaNV");
//                String ten = rs.getString("ten");
//                Date ngaySinh = rs.getDate("NgaySinh");
//                String gioiTinh = rs.getString("GioiTinh");
//                String SDT = rs.getString("SDT");
//                String DiaChi = rs.getString("DiaChi");
//                String MatKhau = rs.getString("MatKhau");
//                int ChucVu = rs.getInt("ChucVu");
//
//                NhanVien nv = new NhanVien(ID, maNV, ten, gioiTinh, ngaySinh, SDT, DiaChi, MatKhau, ChucVu);
//                listNV.add(nv);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return listNV;
//    }

