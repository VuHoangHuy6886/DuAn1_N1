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
    private int id_ThuongHieu;
    private int id_XuatXu;
    private Date ngayTao;
    private int trangThai;

    public SanPham() {
    }

    public SanPham(int id, String ma, String ten, int id_ThuongHieu, int id_XuatXu, Date ngayTao, int trangThai) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.id_ThuongHieu = id_ThuongHieu;
        this.id_XuatXu = id_XuatXu;
        this.ngayTao = ngayTao;
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

    public int getId_ThuongHieu() {
        return id_ThuongHieu;
    }

    public void setId_ThuongHieu(int id_ThuongHieu) {
        this.id_ThuongHieu = id_ThuongHieu;
    }

    public int getId_XuatXu() {
        return id_XuatXu;
    }

    public void setId_XuatXu(int id_XuatXu) {
        this.id_XuatXu = id_XuatXu;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

}
