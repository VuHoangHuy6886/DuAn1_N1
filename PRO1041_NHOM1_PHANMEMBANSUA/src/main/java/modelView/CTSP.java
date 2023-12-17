/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelView;

import java.sql.Date;

/**
 *
 * @author vuhoa
 */
public class CTSP {

    private int id;
    private String maSPCT;
    private String tenSanPham;
    private String huongVi;
    private Date NgaySanXuat;
    private Date hanSuDung;
    private int soLuongTon;
    private float donGia;
    private String khoiLuong;
    private String donViTinh;
    private String maQr;
    private String ghiChu;
    private int trangThai;
    private String anh;

    public CTSP() {
    }

    public CTSP(int id, String maSPCT, String tenSanPham, String huongVi, Date NgaySanXuat, Date hanSuDung, int soLuongTon, float donGia, String khoiLuong, String donViTinh, String maQr, String ghiChu, int trangThai, String anh) {
        this.id = id;
        this.maSPCT = maSPCT;
        this.tenSanPham = tenSanPham;
        this.huongVi = huongVi;
        this.NgaySanXuat = NgaySanXuat;
        this.hanSuDung = hanSuDung;
        this.soLuongTon = soLuongTon;
        this.donGia = donGia;
        this.khoiLuong = khoiLuong;
        this.donViTinh = donViTinh;
        this.maQr = maQr;
        this.ghiChu = ghiChu;
        this.trangThai = trangThai;
        this.anh = anh;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaSPCT() {
        return maSPCT;
    }

    public void setMaSPCT(String maSPCT) {
        this.maSPCT = maSPCT;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getHuongVi() {
        return huongVi;
    }

    public void setHuongVi(String huongVi) {
        this.huongVi = huongVi;
    }

    public Date getNgaySanXuat() {
        return NgaySanXuat;
    }

    public void setNgaySanXuat(Date NgaySanXuat) {
        this.NgaySanXuat = NgaySanXuat;
    }

    public Date getHanSuDung() {
        return hanSuDung;
    }

    public void setHanSuDung(Date hanSuDung) {
        this.hanSuDung = hanSuDung;
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

    public String getKhoiLuong() {
        return khoiLuong;
    }

    public void setKhoiLuong(String khoiLuong) {
        this.khoiLuong = khoiLuong;
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

    public float thanhTien() {
        return this.donGia * this.soLuongTon;
    }

}
