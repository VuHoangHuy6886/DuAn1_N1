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
public class Voucher {

    int id;
    private String maVoucher;
    private int phanTram;
    private Date ngayTao;
    private Date ngaySua;
    private int trangThai;
    private String ghiChu;

    public Voucher() {
    }

    public Voucher(int id, String maVoucher, int phanTram, Date ngayTao, Date ngaySua, int trangThai, String ghiChu) {
        this.id = id;
        this.maVoucher = maVoucher;
        this.phanTram = phanTram;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
        this.trangThai = trangThai;
        this.ghiChu = ghiChu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaVoucher() {
        return maVoucher;
    }

    public void setMaVoucher(String maVoucher) {
        this.maVoucher = maVoucher;
    }

    public int getPhanTram() {
        return phanTram;
    }

    public void setPhanTram(int phanTram) {
        this.phanTram = phanTram;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgaySua() {
        return ngaySua;
    }

    public void setNgaySua(Date ngaySua) {
        this.ngaySua = ngaySua;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

}
