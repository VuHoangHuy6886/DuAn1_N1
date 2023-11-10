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
public class SanPham {

    private int id;
    private String ma;
    private String ten;
    private float giaVon;
    private Date ngayTao;
    private Date ngaySua;

    public SanPham() {
    }

    public SanPham(int id, String ma, String ten, float giaVon, Date ngayTao, Date ngaySua) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.giaVon = giaVon;
        this.ngayTao = ngayTao;
        this.ngaySua = ngaySua;
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

    public float getGiaVon() {
        return giaVon;
    }

    public void setGiaVon(float giaVon) {
        this.giaVon = giaVon;
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

}
