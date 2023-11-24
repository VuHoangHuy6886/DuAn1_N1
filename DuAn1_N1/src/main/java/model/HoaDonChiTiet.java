/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vuhoa
 */
public class HoaDonChiTiet {

    private int iDHD;
    private int iDCTSP;
    private int soLuong;
    private Float donGia;

    public HoaDonChiTiet() {
    }

    public HoaDonChiTiet(int iDHD, int iDCTSP, int soLuong, Float donGia) {
        this.iDHD = iDHD;
        this.iDCTSP = iDCTSP;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public int getiDHD() {
        return iDHD;
    }

    public void setiDHD(int iDHD) {
        this.iDHD = iDHD;
    }

    public int getiDCTSP() {
        return iDCTSP;
    }

    public void setiDCTSP(int iDCTSP) {
        this.iDCTSP = iDCTSP;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public Float getDonGia() {
        return donGia;
    }

    public void setDonGia(Float donGia) {
        this.donGia = donGia;
    }

}
