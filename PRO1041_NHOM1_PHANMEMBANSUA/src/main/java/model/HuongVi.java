/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vuhoa
 */
public class HuongVi {

    private int id_HuongVi;
    private String ma_HuongVi;
    private String ten_HuongVi;
    private int trangThai_HuongVi;

    public HuongVi() {
    }

    public HuongVi(int id_HuongVi, String ma_HuongVi, String ten_HuongVi, int trangThai_HuongVi) {
        this.id_HuongVi = id_HuongVi;
        this.ma_HuongVi = ma_HuongVi;
        this.ten_HuongVi = ten_HuongVi;
        this.trangThai_HuongVi = trangThai_HuongVi;
    }

    public int getId_HuongVi() {
        return id_HuongVi;
    }

    public void setId_HuongVi(int id_HuongVi) {
        this.id_HuongVi = id_HuongVi;
    }

    public String getMa_HuongVi() {
        return ma_HuongVi;
    }

    public void setMa_HuongVi(String ma_HuongVi) {
        this.ma_HuongVi = ma_HuongVi;
    }

    public String getTen_HuongVi() {
        return ten_HuongVi;
    }

    public void setTen_HuongVi(String ten_HuongVi) {
        this.ten_HuongVi = ten_HuongVi;
    }

    public int getTrangThai_HuongVi() {
        return trangThai_HuongVi;
    }

    public void setTrangThai_HuongVi(int trangThai_HuongVi) {
        this.trangThai_HuongVi = trangThai_HuongVi;
    }

}
