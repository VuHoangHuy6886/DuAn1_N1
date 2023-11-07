/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vuhoa
 */
public class LoaiSanPham {

    private int idLoaiSanPham;
    private String maLoaiSanPham;
    private String tenLoaiSanPham;

    public LoaiSanPham() {
    }

    public LoaiSanPham(int idLoaiSanPham, String maLoaiSanPham, String tenLoaiSanPham) {
        this.idLoaiSanPham = idLoaiSanPham;
        this.maLoaiSanPham = maLoaiSanPham;
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

    public int getIdLoaiSanPham() {
        return idLoaiSanPham;
    }

    public void setIdLoaiSanPham(int idLoaiSanPham) {
        this.idLoaiSanPham = idLoaiSanPham;
    }

    public String getMaLoaiSanPham() {
        return maLoaiSanPham;
    }

    public void setMaLoaiSanPham(String maLoaiSanPham) {
        this.maLoaiSanPham = maLoaiSanPham;
    }

    public String getTenLoaiSanPham() {
        return tenLoaiSanPham;
    }

    public void setTenLoaiSanPham(String tenLoaiSanPham) {
        this.tenLoaiSanPham = tenLoaiSanPham;
    }

}
