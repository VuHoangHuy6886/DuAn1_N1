/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author Admin
 */ 
public class ChiTietHoaDonAndHoaDon {
    private int Id_HD;
    private int Id_CTSP;
    private int soLuong;
    private float donGia;
    private float tongTien;
    private LocalDate ngayMua;
    private int Id_Voucher;
    private int id;
    private String maHD;
    private LocalDate ngayTao;
    private LocalDate ngaySua;
    private int idKH;
    private float tongTienHang;
    private int idNhanVien;

    public ChiTietHoaDonAndHoaDon() {
    }

    public ChiTietHoaDonAndHoaDon(int Id_HD, int Id_CTSP, int soLuong, float donGia, float tongTien, LocalDate ngayMua, int Id_Voucher, int id, String maHD, LocalDate ngayTao, LocalDate ngaySua, int idKH, float tongTienHang, int idNhanVien) {
        this.Id_HD = Id_HD;
        this.Id_CTSP = Id_CTSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.tongTien = tongTien;
        this.ngayMua = ngayMua;
        this.Id_Voucher = Id_Voucher;
        this.id = id;
        this.maHD = maHD;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.idKH = idKH;
        this.tongTienHang = tongTienHang;
        this.idNhanVien = idNhanVien;
    }

    public int getId_HD() {
        return Id_HD;
    }

    public void setId_HD(int Id_HD) {
        this.Id_HD = Id_HD;
    }

    public int getId_CTSP() {
        return Id_CTSP;
    }

    public void setId_CTSP(int Id_CTSP) {
        this.Id_CTSP = Id_CTSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public float getTongTien() {
        return tongTien;
    }

    public void setTongTien(float tongTien) {
        this.tongTien = tongTien;
    }

    public LocalDate getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(LocalDate ngayMua) {
        this.ngayMua = ngayMua;
    }

    public int getId_Voucher() {
        return Id_Voucher;
    }

    public void setId_Voucher(int Id_Voucher) {
        this.Id_Voucher = Id_Voucher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaHD() {
        return maHD;
    }

    public void setMaHD(String maHD) {
        this.maHD = maHD;
    }

    public LocalDate getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(LocalDate ngayTao) {
        this.ngayTao = ngayTao;
    }

    public LocalDate getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(LocalDate ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getIdKH() {
        return idKH;
    }

    public void setIdKH(int idKH) {
        this.idKH = idKH;
    }

    public float getTongTienHang() {
        return tongTienHang;
    }

    public void setTongTienHang(float tongTienHang) {
        this.tongTienHang = tongTienHang;
    }

    public int getIdNhanVien() {
        return idNhanVien;
    }

    public void setIdNhanVien(int idNhanVien) {
        this.idNhanVien = idNhanVien;
    }
    
}
