/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelView;

/**
 *
 * @author vuhoa
 */
public class HDCT {

    private int IdHD;
    private String tenSanPham;
    private int soLuongSanPham;
    private float donGia;

    public HDCT() {
    }

    public HDCT(int IdHD, String tenSanPham, int soLuongSanPham, float donGia) {
        this.IdHD = IdHD;
        this.tenSanPham = tenSanPham;
        this.soLuongSanPham = soLuongSanPham;
        this.donGia = donGia;
    }

    public int getIdHD() {
        return IdHD;
    }

    public void setIdHD(int IdHD) {
        this.IdHD = IdHD;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public int getSoLuongSanPham() {
        return soLuongSanPham;
    }

    public void setSoLuongSanPham(int soLuongSanPham) {
        this.soLuongSanPham = soLuongSanPham;
    }

    public float getDonGia() {
        return donGia;
    }

    public void setDonGia(float donGia) {
        this.donGia = donGia;
    }

}
