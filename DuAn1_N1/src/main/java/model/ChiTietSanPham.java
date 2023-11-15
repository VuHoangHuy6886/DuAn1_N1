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
public class ChiTietSanPham {

    private int id;
    private String ma;
    private String ten;
    private String loaiSP;
    private String tenSanXuat;
    private String quocGia;
    private String anh;
    private Date hSD;
    private int soLuongTon;
    private float giaVon;
    private float giaBan;
    private String ghiChu;
    private String maQR;
    private String trangThai;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(int id, String ma, String ten, String loaiSP, String tenSanXuat, String quocGia, String anh, Date hSD, int soLuongTon, float giaVon, float giaBan, String ghiChu, String maQR, String trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.loaiSP = loaiSP;
        this.tenSanXuat = tenSanXuat;
        this.quocGia = quocGia;
        this.anh = anh;
        this.hSD = hSD;
        this.soLuongTon = soLuongTon;
        this.giaVon = giaVon;
        this.giaBan = giaBan;
        this.ghiChu = ghiChu;
        this.maQR = maQR;
        this.trangThai = trangThai;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getLoaiSP() {
        return loaiSP;
    }

    public void setLoaiSP(String loaiSP) {
        this.loaiSP = loaiSP;
    }

    public String getTenSanXuat() {
        return tenSanXuat;
    }

    public void setTenSanXuat(String tenSanXuat) {
        this.tenSanXuat = tenSanXuat;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

    public Date gethSD() {
        return hSD;
    }

    public void sethSD(Date hSD) {
        this.hSD = hSD;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public float getGiaVon() {
        return giaVon;
    }

    public void setGiaVon(float giaVon) {
        this.giaVon = giaVon;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public String getMaQR() {
        return maQR;
    }

    public void setMaQR(String maQR) {
        this.maQR = maQR;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }
}
