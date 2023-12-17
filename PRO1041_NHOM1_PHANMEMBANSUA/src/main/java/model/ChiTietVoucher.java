/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Date;

/**
 *
 * @author Thang
 */
public class ChiTietVoucher {

    //private int idVoucher;
    private int idHD;
    private String maVoucher;
    private String maHoadon;
    private int phanTram;
    private int trangThai;
    private Date ngayBatDau;
    private Date ngayKetThuc;
    private String ghiChu; 

    public ChiTietVoucher() {
    }

    public ChiTietVoucher(int idHD, String maVoucher, String maHoadon, int phanTram, int trangThai, Date ngayBatDau, Date ngayKetThuc, String ghiChu) {
        this.idHD = idHD;
        this.maVoucher = maVoucher;
        this.maHoadon = maHoadon;
        this.phanTram = phanTram;
        this.trangThai = trangThai;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.ghiChu = ghiChu;
    }

    public int getIdHD() {
        return idHD;
    }

    public void setIdHD(int idHD) {
        this.idHD = idHD;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public String getMaHoadon() {
        return maHoadon;
    }

    public void setMaHoadon(String maHoadon) {
        this.maHoadon = maHoadon;
    }

    public int getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(int phanTram) {
        this.phanTram = phanTram;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public Date getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(Date ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public Date getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(Date ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

   

   
}
