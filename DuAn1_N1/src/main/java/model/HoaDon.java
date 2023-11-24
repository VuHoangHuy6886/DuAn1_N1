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
public class HoaDon {

    private int IdHD;
    private String MaHD;
    private Date NgayTao;
    private String trangThai;

    public HoaDon() {
    }

    public HoaDon(int IdHD, String MaHD, Date NgayTao, String trangThai) {
        this.IdHD = IdHD;
        this.MaHD = MaHD;
        this.NgayTao = NgayTao;
        this.trangThai = trangThai;
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

    public Date getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(Date NgayTao) {
        this.NgayTao = NgayTao;
    }

    public String getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(String trangThai) {
        this.trangThai = trangThai;
    }

}
