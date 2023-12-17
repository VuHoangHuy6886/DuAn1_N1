/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author HungLOL
 */
public class DotGiamGiaFinal {

    public DotGiamGiaFinal() {
    }

    public DotGiamGiaFinal(int Id_DGG, String maDGG, String ngayBatDau, String ngayKetThuc, String thongTin, String dieuKienApDung, int trangThai, int sale) {
        this.Id_DGG = Id_DGG;
        this.maDGG = maDGG;
        this.ngayBatDau = ngayBatDau;
        this.ngayKetThuc = ngayKetThuc;
        this.thongTin = thongTin;
        this.dieuKienApDung = dieuKienApDung;
        this.trangThai = trangThai;
        this.sale = sale;
    }

    public int getId_DGG() {
        return Id_DGG;
    }

    public void setId_DGG(int Id_DGG) {
        this.Id_DGG = Id_DGG;
    }

    public String getMaDGG() {
        return maDGG;
    }

    public void setMaDGG(String maDGG) {
        this.maDGG = maDGG;
    }

    public String getNgayBatDau() {
        return ngayBatDau;
    }

    public void setNgayBatDau(String ngayBatDau) {
        this.ngayBatDau = ngayBatDau;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public String getThongTin() {
        return thongTin;
    }

    public void setThongTin(String thongTin) {
        this.thongTin = thongTin;
    }

    public String getDieuKienApDung() {
        return dieuKienApDung;
    }

    public void setDieuKienApDung(String dieuKienApDung) {
        this.dieuKienApDung = dieuKienApDung;
    }

    public int getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(int trangThai) {
        this.trangThai = trangThai;
    }

    public int getSale() {
        return sale;
    }

    public void setSale(int sale) {
        this.sale = sale;
    }

    private int Id_DGG;
    private String maDGG;
    private String ngayBatDau;
    private String ngayKetThuc;
    private String thongTin;
    private String dieuKienApDung;
    private int trangThai;
    private int sale;

  
}
