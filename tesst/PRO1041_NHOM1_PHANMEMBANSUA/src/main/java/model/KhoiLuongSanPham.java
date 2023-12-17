/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vuhoa
 */
public class KhoiLuongSanPham {

    private int idKL;
    private String MaKL;
    private String TenKL;

    public KhoiLuongSanPham() {
    }

    public KhoiLuongSanPham(int idKL, String MaKL, String TenKL) {
        this.idKL = idKL;
        this.MaKL = MaKL;
        this.TenKL = TenKL;
    }

    public int getIdKL() {
        return idKL;
    }

    public void setIdKL(int idKL) {
        this.idKL = idKL;
    }

    public String getMaKL() {
        return MaKL;
    }

    public void setMaKL(String MaKL) {
        this.MaKL = MaKL;
    }

    public String getTenKL() {
        return TenKL;
    }

    public void setTenKL(String TenKL) {
        this.TenKL = TenKL;
    }

}
