/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vuhoa
 */
public class DongSanPham {

    private int id_DSP;
    private String MaDSP;
    private String TenDSP;

    public DongSanPham() {
    }

    public DongSanPham(int id_DSP, String MaDSP, String TenDSP) {
        this.id_DSP = id_DSP;
        this.MaDSP = MaDSP;
        this.TenDSP = TenDSP;
    }

    public int getId_DSP() {
        return id_DSP;
    }

    public void setId_DSP(int id_DSP) {
        this.id_DSP = id_DSP;
    }

    public String getMaDSP() {
        return MaDSP;
    }

    public void setMaDSP(String MaDSP) {
        this.MaDSP = MaDSP;
    }

    public String getTenDSP() {
        return TenDSP;
    }

    public void setTenDSP(String TenDSP) {
        this.TenDSP = TenDSP;
    }

}
