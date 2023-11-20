/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.awt.Image;
import java.sql.Date;

/**
 *
 * @author vuhoa
 */
public class ChiTietSanPham {

    private int idCTSP;
    private String maCTSP;
    private int idSanPham;
    private int idLoaiSp;
    private int idDongSanPham;
    private Date hSD;
    private int idNSX;
    private int soLuongTon;
    private float donGia;
    private int idKhoiLuong;
    private String donViTinh;
    private String maQr;
    private String ghiChu;
    private int trangThai;
    private String anh;

    public ChiTietSanPham() {
    }

    public ChiTietSanPham(int idCTSP, String maCTSP, int idSanPham, int idLoaiSp, int idDongSanPham, Date hSD, int idNSX, int soLuongTon, float donGia, int idKhoiLuong, String donViTinh, String maQr, String ghiChu, int trangThai, String anh) {
        this.idCTSP = idCTSP;
        this.maCTSP = maCTSP;
        this.idSanPham = idSanPham;
        this.idLoaiSp = idLoaiSp;
        this.idDongSanPham = idDongSanPham;
        this.hSD = hSD;
        this.idNSX = idNSX;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.idKhoiLuong = idKhoiLuong;
        this.donViTinh = donViTinh;
        this.maQr = maQr;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.anh = anh;
    }

    public int getIdCTSP() {
        return idCTSP;
    }

    public void setIdCTSP(int idCTSP) {
        this.idCTSP = idCTSP;
    }

    public String getMaCTSP() {
        return maCTSP;
    }

    public void setMaCTSP(String maCTSP) {
        this.maCTSP = maCTSP;
    }

    public int getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(int idSanPham) {
        this.idSanPham = idSanPham;
    }

    public int getIdLoaiSp() {
        return idLoaiSp;
    }

    public void setIdLoaiSp(int idLoaiSp) {
        this.idLoaiSp = idLoaiSp;
    }

    public int getIdDongSanPham() {
        return idDongSanPham;
    }

    public void setIdDongSanPham(int idDongSanPham) {
        this.idDongSanPham = idDongSanPham;
    }

    public Date gethSD() {
        return hSD;
    }

    public void sethSD(Date hSD) {
        this.hSD = hSD;
    }

    public int getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(int idNSX) {
        this.idNSX = idNSX;
    }

    public int getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(int soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

    public int getIdKhoiLuong() {
        return idKhoiLuong;
    }

    public void setIdKhoiLuong(int idKhoiLuong) {
        this.idKhoiLuong = idKhoiLuong;
    }

    public String getDonViTinh() {
        return donViTinh;
    }

    public void setDonViTinh(String donViTinh) {
        this.donViTinh = donViTinh;
    }

    public String getMaQr() {
        return maQr;
    }

    public void setMaQr(String maQr) {
        this.maQr = maQr;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getAnh() {
        return anh;
    }

    public void setAnh(String anh) {
        this.anh = anh;
    }

}
