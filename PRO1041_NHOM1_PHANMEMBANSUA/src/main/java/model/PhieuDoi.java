/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phtua
 */
public class PhieuDoi {
     private String maPD;
    private int idKhachHang;
    private int idNhanVien;
    private int idSanPham;
    private int idHoaDon;
    private int soLuong;
    private String ngayDoi;
    private String lyDoDoi;
    private int idSanPhamMoi;
    private float tienThua;
    private float tienThieu;

    public PhieuDoi(String maPD, int idKhachHang, int idNhanVien, int idSanPham, int idHoaDon, int soLuong, String ngayDoi, String lyDoDoi, int idSanPhamMoi, float tienThua, float tienThieu) {
        this.maPD = maPD;
        this.idKhachHang = idKhachHang;
        this.idNhanVien = idNhanVien;
        this.idSanPham = idSanPham;
        this.idHoaDon = idHoaDon;
        this.soLuong = soLuong;
        this.ngayDoi = ngayDoi;
        this.lyDoDoi = lyDoDoi;
        this.idSanPhamMoi = idSanPhamMoi;
        this.tienThua = tienThua;
        this.tienThieu = tienThieu;
    }

    public PhieuDoi() {
    }

    public String getMaPD() {
        return maPD;
    }

    public void setMaPD(String maPD) {
        this.maPD = maPD;
    }

    public int getIdKhachHang() {
        return idKhachHang;
    }

    public void setIdKhachHang(int idKhachHang) {
        this.idKhachHang = idKhachHang;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdHoaDon() {
        return idHoaDon;
    }

    public void setIdHoaDon(int idHoaDon) {
        this.idHoaDon = idHoaDon;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNgayDoi() {
        return ngayDoi;
    }

    public void setNgayDoi(String ngayDoi) {
        this.ngayDoi = ngayDoi;
    }

    public String getLyDoDoi() {
        return lyDoDoi;
    }

    public void setLyDoDoi(String lyDoDoi) {
        this.lyDoDoi = lyDoDoi;
    }

    public int getIdSanPhamMoi() {
        return idSanPhamMoi;
    }

    public void setIdSanPhamMoi(int idSanPhamMoi) {
        this.idSanPhamMoi = idSanPhamMoi;
    }

    public float getTienThua() {
        return tienThua;
    }

    public void setTienThua(float tienThua) {
        this.tienThua = tienThua;
    }

    public float getTienThieu() {
        return tienThieu;
    }

    public void setTienThieu(float tienThieu) {
        this.tienThieu = tienThieu;
    }

    
    
}
