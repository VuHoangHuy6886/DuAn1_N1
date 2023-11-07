/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author vuhoa
 */
public class NhaSanXuat {

    private int idNSX;
    private String maNSX;
    private String tenNSX;
    private String quocGia;

    public NhaSanXuat() {
    }

    public NhaSanXuat(int idNSX, String maNSX, String tenNSX, String quocGia) {
        this.idNSX = idNSX;
        this.maNSX = maNSX;
        this.tenNSX = tenNSX;
        this.quocGia = quocGia;
    }

    public int getIdNSX() {
        return idNSX;
    }

    public void setIdNSX(int idNSX) {
        this.idNSX = idNSX;
    }

    public String getMaNSX() {
        return maNSX;
    }

    public void setMaNSX(String maNSX) {
        this.maNSX = maNSX;
    }

    public String getTenNSX() {
        return tenNSX;
    }

    public void setTenNSX(String tenNSX) {
        this.tenNSX = tenNSX;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

}
