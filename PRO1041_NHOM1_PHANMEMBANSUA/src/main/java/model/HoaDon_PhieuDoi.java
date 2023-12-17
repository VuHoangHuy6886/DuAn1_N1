/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author phtua
 */
public class HoaDon_PhieuDoi {
     private int IdHD;
    private String MaHD;
    private String NgayTao;
    private Float tongTien;
    private int IdKhachHang;
    private int IdNhanVien;

    public HoaDon_PhieuDoi(int IdHD, String MaHD, String NgayTao, Float tongTien, int IdKhachHang, int IdNhanVien) {
        this.IdHD = IdHD;
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.tongTien = tongTien;
        this.IdKhachHang = IdKhachHang;
        this.IdNhanVien = IdNhanVien;
    }

    public HoaDon_PhieuDoi() {
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

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public Float getTongTien() {
        return tongTien;
    }

    public void setTongTien(Float tongTien) {
        this.tongTien = tongTien;
    }

    public int getIdKhachHang() {
        return IdKhachHang;
    }

    public void setIdKhachHang(int IdKhachHang) {
        this.IdKhachHang = IdKhachHang;
    }

    public int getIdNhanVien() {
        return IdNhanVien;
    }

    public void setIdNhanVien(int IdNhanVien) {
        this.IdNhanVien = IdNhanVien;
    }
    
}
