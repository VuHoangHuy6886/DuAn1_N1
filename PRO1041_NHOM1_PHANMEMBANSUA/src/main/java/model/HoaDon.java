/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author vuhoa
 */
public class HoaDon {

    private int IdHD;
    private String MaHD;
    private Date NgayTao;
    private Float tongTien;
    private String trangThai;
    private int id_KhachHang;
    private int id_VouCher;
    private int id_NhanVien;

    public HoaDon() {
    }

    public HoaDon(int IdHD, String MaHD, Date NgayTao, Float tongTien, String trangThai, int id_KhachHang, int id_VouCher, int id_NhanVien) {
        this.IdHD = IdHD;
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.tongTien = tongTien;
        this.trangThai = trangThai;
        this.id_KhachHang = id_KhachHang;
        this.id_VouCher = id_VouCher;
        this.id_NhanVien = id_NhanVien;
    }

    public int getIdHD() {
        return IdHD;
    }

    public void setIdHD(int IdHD) {
        this.IdHD = IdHD;
    }

    public String getMaHD() {
        return MaHD;
    }

    public void setMaHD(String MaHD) {
        this.MaHD = MaHD;
    }

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

    public int getId_KhachHang() {
        return id_KhachHang;
    }

    public void setId_KhachHang(int id_KhachHang) {
        this.id_KhachHang = id_KhachHang;
    }

    public int getId_VouCher() {
        return id_VouCher;
    }

    public void setId_VouCher(int id_VouCher) {
        this.id_VouCher = id_VouCher;
    }

    public int getId_NhanVien() {
        return id_NhanVien;
    }

    public void setId_NhanVien(int id_NhanVien) {
        this.id_NhanVien = id_NhanVien;
    }

}
